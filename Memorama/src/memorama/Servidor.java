package memorama;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author JuanDanielCR
 */
public class Servidor {
    private static final int PUERTO = 7805;
    private static final File imagenesFolder = new File(System.getProperty("user.dir")+"/imagenes");
    private static final String[] extensiones =  new String[]{"jpg","png","gif","bmp"};
    
    private static FilenameFilter imageFilter = (File dir, String name) -> {
        for(String extension: extensiones){
            if(name.endsWith("."+extension)){
                return true;
            }
        }
        return false;
    };
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Creación servidor
        ServerSocket server = new ServerSocket(PUERTO);
        server.setReuseAddress(true);
        System.out.println("Servidor iniciado");
        //Lista imagenes
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        ArrayList<Registro> registros = new ArrayList<>();
      
        for(;;){
            System.out.println("Esperando cliente");
            Socket socket = server.accept();
            //Lectura y tratamiento de imagenes
            if(imagenesFolder.isDirectory()){
                for(File imagen:imagenesFolder.listFiles(imageFilter)){
                    BufferedImage imagenActual = ImageIO.read(imagen);
                    ImageIcon i = new ImageIcon(imagenActual.getScaledInstance(80, 100,  
                            java.awt.Image.SCALE_SMOOTH));
                    imagenes.add(i);
                }
                //Se encontro minimo una imagen
                if(imagenes.size()>0){
                    //Enviando imagenes tratadas
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(imagenes);
                    oos.flush();
                    System.out.println("Imagenes enviadas");
                    //Esperando registro
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    Registro registro = (Registro)ois.readObject();
                    registros.add(registro);
                }
                //Ordenando
                imagenes.clear();
                Collections.sort(registros);
                //Imprimir registros ordenados
                registros.stream().forEach((registro) -> {
                    System.out.println("Tiempo: " + registro +" minutos");
                });
            }else{
                System.err.println("Error directorio");
            }
        }//for cliente
    }
}
