package sniffer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;


import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.PcapBpfProgram;


public class Sniffer {
   private static String asString(final byte[] mac) {
    final StringBuilder buf = new StringBuilder();
    for (byte b : mac) {
      if (buf.length() != 0) {
        buf.append(':');
      }
      if (b >= 0 && b < 16) {
        buf.append('0');
      }
      buf.append(Integer.toHexString((b < 0) ? b + 256 : b).toUpperCase());
    }

    return buf.toString();
  }

	public static void main(String[] args) {

            List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with NICs
            StringBuilder errbuf = new StringBuilder(); // For any error msgs

            /***************************************************************************
             * First get a list of devices on this system
             **************************************************************************/
            int r = Pcap.findAllDevs(alldevs, errbuf);
            if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
            	System.err.printf("Can't read list of devices, error is %s", errbuf.toString());
            	return;
            }
            
            System.out.println("Network devices found:");
            int i = 0;
            try{
            for (PcapIf device : alldevs) {
		String description = (device.getDescription() != null) ? device.getDescription():"No description available";
                final byte[] mac = device.getHardwareAddress();
                String dir_mac = (mac==null) ? "No tiene direccion MAC" : asString(mac);
                System.out.printf("#%d: %s [%s] MAC:[%s]\n", i++, device.getName(), description, dir_mac);
	}//for
	
        PcapIf device = alldevs.get(1); // We know we have atleast 1 device
	System.out.printf("\nChoosing '%s' on your behalf:\n",
        (device.getDescription() != null) ? device.getDescription(): device.getName());
        
        /***************************************************************************
         * Second we open up the selected device
         **************************************************************************/
        /*"snaplen" is short for 'snapshot length', as it refers to the amount 
        of actual data captured from each packet passing through the specified network interface.
        64*1024 = 65536 bytes; campo len en Ethernet(16 bits) tam máx de trama */

        int snaplen = 64 * 1024;           // Capture all packets, no trucation
        int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
        int timeout = 10 * 1000;           // 10 seconds in millis
        Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);

        if (pcap == null) {
                System.err.printf("Error while opening device for capture: " + errbuf.toString());
                return;
        }//if

                   /********F I L T R O********/
        PcapBpfProgram filter = new PcapBpfProgram();
        String expression =""; // "port 80";
        int optimize = 0; // 1 means true, 0 means false
        int netmask = 0;
        int r2 = pcap.compile(filter, expression, optimize, netmask);
        if (r2 != Pcap.OK) {
            System.out.println("Filter error: " + pcap.getErr());
        }//if
        pcap.setFilter(filter);

        /***************************************************************************
         * Third we create a packet handler which will receive packets from the
         * libpcap loop.
         **********************************************************************/
        PcapPacketHandler<String> jpacketHandler = (PcapPacket packet, String user) -> {
            System.out.printf("Received packet at %s caplen=%-4d len=%-4d %s\n",
                    new Date(packet.getCaptureHeader().timestampInMillis()),
                    packet.getCaptureHeader().caplen(),  // Length actually captured
                    packet.getCaptureHeader().wirelen(), // Original length
                    user                                 // User supplied object
            );
                /******Desencapsulado********/
                for (int i1 = 0; i1 < packet.size(); i1++) {
                    System.out.printf("%02X ", packet.getUByte(i1));
                    if (i1 % 16 == 15) {
                        System.out.println("");
                    }
                }
                System.out.println("\n\nEncabezado: "+ packet.toHexdump());
                /*---------Practica 2------------*/
                System.out.println("----Trama Ethernet----");
                System.out.print("MACd: ");
                for (int j = 0; j < 6; j++) {
                    System.out.printf("%02X ",packet.getUByte(j));
                }
                System.out.print("\nMACo: ");
                for (int j = 6; j < 12; j++) {
                    System.out.printf("%02X ",packet.getUByte(j));
                }
                // x*256 == x<<8
                if(((packet.getByte(12)*256) + packet.getByte(13)) <= 1500){
                    System.out.println("\nTipo: IEEE802.3");
                }else{
                    System.out.println("\nTipo: Ethernet");
                }
                System.out.println("------------Trama Ethernet---------");
                /*---------Practica 2------------*/
        };
        /***************************************************************************
         * Fourth we enter the loop and tell it to capture 10 packets. The loop
         * method does a mapping of pcap.datalink() DLT value to JProtocol ID, which
         * is needed by JScanner. The scanner scans the packet buffer and decodes
         * the headers. The mapping is done automatically, although a variation on
         * the loop method exists that allows the programmer to sepecify exactly
         * which protocol ID to use as the data link type for this pcap interface.
         **************************************************************************/
        pcap.loop(100, jpacketHandler, "jNetPcap rocks!");

        /***************************************************************************
         * Last thing to do is close the pcap handle
         **************************************************************************/
        pcap.close();
        }catch(IOException e){e.printStackTrace();}
    }
}