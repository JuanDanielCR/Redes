package Protocolo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;  
import java.util.ArrayList;  
import java.util.Date;
import java.util.Iterator;
import java.util.List;  
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
  
import org.jnetpcap.Pcap;  
import org.jnetpcap.PcapAddr;
import org.jnetpcap.PcapBpfProgram;
import org.jnetpcap.PcapIf;  
import org.jnetpcap.PcapSockAddr;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
  
public class Envia {  
    /*Convertir long a byte[]*/
    public static byte[] asByteArray(long number){
        //long has 8 bytes
        byte bytes[] = new byte[8];
        for(int i = 7; i >= 0;i--){
            //Using an AND in the --last-- byte, that why i decrements 
            byte actualByte = (byte)(number & 0xFF);
            bytes[i] = actualByte;
            //move to the next byte, divide by 2, 8 times
            number >>= 8; //The use of >>= saves us from using an auxiliary variable for number
        }
        return bytes;
    }
  /*Pasa un numero a hexadecimal, en este caso, la dirección MAC*/
  private static String asString(final byte[] mac) {
    final StringBuilder buf = new StringBuilder();
    for (byte b : mac) { //Recorriendo cada byte de la dirección
      if (buf.length() != 0) {
        buf.append(':');
      }
      if (b >= 0 && b < 16) {
        buf.append('0');
      }/*Agrega el numero, si es negativo lo  hace positivo*/
      buf.append(Integer.toHexString((b < 0) ? b + 256 : b).toUpperCase());
    }
    return buf.toString();
  } //ej. entrada[106,23,41,48,117,76]   -> salida [6A:17:29:30:75:B4]
    
  public static void main(String[] args) { 
    List<PcapIf> alldevs = new ArrayList<>(); // Will be filled with NICs  
    StringBuilder errbuf = new StringBuilder(); // For any error msgs  
    String ip_interfaz = "";
   /********************************************
     First get a list of devices on this system
    *********************************************/
    int r = Pcap.findAllDevs(alldevs, errbuf); //r = # of devices
    if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
	System.err.printf("Can't read list of devices, error is %s", errbuf.toString());
	return;
    }
    //Tenemos dispositivos de red, ahora los mostramos
    System.out.println("Dispositivos encontrados:");
    int i = 0;
    try{
        //aldevs: List<> of devs
        for (PcapIf device : alldevs) { //for each device
	String description = (device.getDescription() != null) ? device.getDescription() : "No description available";
        //MAC in bytes
        final byte[] mac = device.getHardwareAddress();
         //Change bytes to HEX with asString: [106,...] -> [6A:...]
	String dir_mac = (mac==null)?"No tiene direccion MAC":asString(mac);
        System.out.printf("\n#%d: %s [%s] MAC:[%s]\n", i++, device.getName(), description, dir_mac);
        
        //Iterator, interface which is equivalent to for each(); direcciones es el iterator
        Iterator<PcapAddr> direcciones = device.getAddresses().iterator();
        //Each device has 1 or more IP addresses, show them using an iterator
        while(direcciones.hasNext()){
            PcapAddr dir = direcciones.next();//dir, familia, mascara,bc
            PcapSockAddr direccion =dir.getAddr(); //Obteniendo direccion IP del objeto acutal del iterator direcciones
            byte[]d_ip = direccion.getData();  //Bytes de la direccion IP
            int familia=direccion.getFamily(); //IPv4 or IPv6
            
            int[]ipv4 = new int[4]; // Arreglo con 4 espacios para IPv4 ej. 198.168.3.4
            
            //Check if IP is IPv4 or IPv6
            if(familia==org.jnetpcap.PcapSockAddr.AF_INET){ 
            //IPv4 fill each value
                ipv4[0]=((int)d_ip[0]<0)?((int)d_ip[0])+256:(int)d_ip[0]; // 198.--.---.---
                ipv4[1]=((int)d_ip[1]<0)?((int)d_ip[1])+256:(int)d_ip[1]; // 198.168.---.---
                ipv4[2]=((int)d_ip[2]<0)?((int)d_ip[2])+256:(int)d_ip[2]; // 198.168.3.-----
                ipv4[3]=((int)d_ip[3]<0)?((int)d_ip[3])+256:(int)d_ip[3]; // 198.168.3.4            
                System.out.println("\nIP4->"+ipv4[0]+"."+ipv4[1]+"."+ipv4[2]+"."+ipv4[3]);
            }else if(familia==org.jnetpcap.PcapSockAddr.AF_INET6){
            //IPv6
                System.out.print("\nIP6-> ");
                for(int z=0;z<d_ip.length;z++)
                    System.out.printf("%02X:",d_ip[z]);
            }//if direction is IPv4 or IPv6
        }//while - get directions of each device
    }//for - get devices
}catch(IOException io){ }//catch
    
    //Envío y recepción de paquetes
    try{
        //Selección de un dispositivo, de la lista alldevs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nElije la interfaz de red:");
        int interfaz = Integer.parseInt(br.readLine());
        PcapIf device = alldevs.get(interfaz); 
        
        //Mismo proceso que antes para ver las direcciones del device usado
        Iterator<PcapAddr> it1 = device.getAddresses().iterator();
        while(it1.hasNext()){
            PcapAddr dir = it1.next();//dir, familia, mascara,bc
            PcapSockAddr direccion1 =dir.getAddr(); 
            byte[]d_ip = direccion1.getData(); //esta sera la ip origen
            int familia=direccion1.getFamily();
            int[]ipv4_1 = new int[4];
            if(familia==org.jnetpcap.PcapSockAddr.AF_INET){
                ipv4_1[0]=((int)d_ip[0]<0)?((int)d_ip[0])+256:(int)d_ip[0];
                ipv4_1[1]=((int)d_ip[1]<0)?((int)d_ip[1])+256:(int)d_ip[1];
                ipv4_1[2]=((int)d_ip[2]<0)?((int)d_ip[2])+256:(int)d_ip[2];
                ipv4_1[3]=((int)d_ip[3]<0)?((int)d_ip[3])+256:(int)d_ip[3];
                ip_interfaz = ipv4_1[0]+"."+ipv4_1[1]+"."+ipv4_1[2]+"."+ipv4_1[3];  
                System.out.println("\nInterfaz que se usara:" + ip_interfaz);
            }
        }
        
        //Imprimir direccion MAC sin el uso de asString()
        System.out.print("MAC ORIGEN: ");   
        byte[] MACo = device.getHardwareAddress();
        for(int j=0;j<MACo.length;j++)
            System.out.printf("%02X ",MACo[j]); 
        
        /*
        Captura de paquetes:
            El programa envía paquete a la dirección Broadcast,
            por lo que el mensaje recibido será reenviado hacía nosotros,
            y lo recibiremos...
        */
        int snaplen = 64 * 1024;
        int flags = Pcap.MODE_PROMISCUOUS; // capture all packets  
        int timeout = 10 * 1000; // 10 seconds in millis  
        Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);  

        /********F I L T R O*******
        Aplicamos un filtro a la captura de paquetes, solo capturamos el tipo
        0x1601 que es el tipo de nuestro paquete, asi:
        -> No capturamos todo el tráfico, solo lo nuestro */
        
        //Configurando el filtro
        PcapBpfProgram filter = new PcapBpfProgram();
        String expression ="ether proto 0x1601"; // "port 80";
        int optimize = 0; // 1 means true, 0 means false
        int netmask = 0;
        
        //Aplicando el filtro
        int r2 = pcap.compile(filter, expression, optimize, netmask);
        if (r2 != Pcap.OK) {
            System.out.println("Filter error: " + pcap.getErr());
        }
        pcap.setFilter(filter);
        
        //Recibiendo los paquetes
        //Archivo salida
       
        //Ciclo de recepcion de paquetes
        PcapPacketHandler<String> jpacketHandler = (PcapPacket packet, String user) -> {
        System.out.printf("Paquete recibido el %s bytes capturados = %-4d tam original = %-4d %s\n",
                new Date(packet.getCaptureHeader().timestampInMillis()),
                packet.getCaptureHeader().caplen(),  // Length actually captured
                packet.getCaptureHeader().wirelen(), // Original length
                user                                 // User supplied object
        );
        
        /******Desencapsulado un paquete recibido ********/
            System.out.println("MAC destino:");
        //MAC Destino
            for (int i1 = 0; i1 < 6; i1++) {
                System.out.printf("%02X ", packet.getUByte(i1));
            }
            System.out.println("");
            System.out.println("MAC origen:");
        //MAC Origen
            for (int i2 = 6; i2 < 12; i2++) {
                System.out.printf("%02X ", packet.getUByte(i2));
            }
            System.out.println("");
        //Tipo
            System.out.println("Tipo:");
            for (int i3 = 12; i3 < 14; i3++) {
                System.out.printf("%02X ", packet.getUByte(i3));
            }
            int tipo = (packet.getUByte(12)*256)+packet.getUByte(13);
            System.out.printf("Tipo= %d",tipo);
            
            int receivedBytes = packet.getUByte(14);
            System.out.printf("Bytes received = %d",receivedBytes);
       
            if(tipo==5633){ //0x1601
            //Si es un paquete de los nuestros
                System.out.println("\nEste es mi mensaje que mande los datos del mensaje son:");
                //bytes del archivo
                byte[]t = packet.getByteArray(20, 1470); //indice inicial, bits a partir de ahi
            //Impresion seccion data
                for(int k=0;k<t.length;k++)
                    //Bytes - Data
                    System.out.printf("%02X ",t[k]);
                //String - Data
                String datos = new String(t);
                System.out.println("\nData Section: "+datos);
                
            //Impresion mensaje completo como bytes
                System.out.println("Mensaje Completo: ");
                for(int l=0;l<packet.size();l++){
                    System.out.printf("%02X ",packet.getUByte(l));
                    if(l%16==15)
                        System.out.println("");
                }
            //
           }//if type = 0x1601
       };//Recepcion paquetes
        
    /******************************************************* 
     * SEND our packet off using open device 
     *******************************************************/ 
    //División del archivo en x paquetes
        JFileChooser jFile = new JFileChooser(); 
        int f = jFile.showOpenDialog(null);
        long lengthFile = 0;
        String fileName, path;
        File file = null;
        BufferedInputStream fileBuffer = null;
        if(f == JFileChooser.APPROVE_OPTION){
            file = jFile.getSelectedFile();
            fileName  = file.getName();
            lengthFile = file.length();
            path = file.getAbsolutePath();
            
        }
        fileBuffer = new BufferedInputStream(new FileInputStream(file));
       
        
    // Ciclo para enviar 'x' mensajes
        int finish = 0;
    while(finish < lengthFile){
            /*******************************************************
             * Create our crude packet we will transmit out
             * FORMATO DE UNA TRAMA  ETHERNET
             * [MAC D, MAC O, Tipo, Datos, CRC]
             *******************************************************/
        byte fileBytes[] = new byte[1470];
        int readedBytes = fileBuffer.read(fileBytes);
        byte[] trama = new byte[1500]; //Broadcast packet to be sent

    //Agregamos los primeros campos nuestra trama, que serán las dir MAC
        for(int k=0;k<MACo.length;k++){
            trama[k] = (byte) 0xff; //MAC Destino, se llena con FF:FF:FF... para que llegue al Broadcast tipo Ethernet
            trama[k+6]=MACo[k]; //MAC Origen: Es la MAC de nuestro device seleccionado
        }
    //[MAC D,MAC O,tipo,------] agregamos el tipo
        trama[12]= (byte) 0x16; //tipo sin asignar
        trama[13]= (byte) 0x01; //tipo sin asignar rfc 1340
        
    //Nuestro prtocolo
        trama[14]= (byte) readedBytes; //tipo sin asignar
        trama[15]= (byte) 0x00; //tipo sin asignar rfc 1340 
        trama[16]= (byte) 0x00; //tipo sin asignar
        trama[17]= (byte) 0x00; //tipo sin asignar rfc 1340 
        trama[18]= (byte) 0x00; //tipo sin asignar
        trama[19]= (byte) 0x00; //tipo sin asignar rfc 1340 
        trama[20]= (byte) 0x00; //tipo sin asignar

    //[MAC D,MAC O,tipo,msj,---] agregamos el mensaje enviar
        int sizeBuffer = fileBytes.length;
        if( sizeBuffer <= 1470){ //2 last bytes for checksum
            for(int c=0; c < sizeBuffer; c++)
                trama[20+c]=fileBytes[c];
        }else{
            System.out.println("Maximo 50 bytes");
            System.exit(1);
        }  
    //Fin de la seccion mensaje
        
    //Add checksum to our packet
        long check = Checksum.calculateChecksum(trama);
        byte[] checksumBytes = asByteArray(check);
        for(int j = 1; j <= checksumBytes.length; j++){
            int posicionTrama = 1500-j; 
            int indiceChecksum = checksumBytes.length-j;
            trama[posicionTrama] = checksumBytes[indiceChecksum];
        }
    //Agregamos la trama a un buffer de bytes;  
        ByteBuffer b = ByteBuffer.wrap(trama); 
    //Readed bytes from bytes
        finish += readedBytes;
        System.out.println("Finish: "+finish);
    //Enviar mensaje
        if (pcap.sendPacket(trama) != Pcap.OK) {  
          System.err.println(pcap.getErr());  
        }
        System.out.println("Envie un paquete******");
        try{
    //Espera...
            Thread.sleep(500);
        }catch(InterruptedException e){}
    //Loop para rececpcion de mensajes
        pcap.loop(1, jpacketHandler, "");
    }//for envio mensajes
    
    /******************************************************** 
     * Lastly we close 
     ********************************************************/  
    pcap.close();  
    
   }catch(IOException | NumberFormatException e){
   }//catch
  }  
}  