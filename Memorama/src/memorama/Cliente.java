package memorama;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author JuanDanielCR
 */
public class Cliente {
    private String ruta = "imagenesCliente";
    private Socket cliente = null;
    public Cliente(){
    }
    
    public void conectar() throws IOException, ClassNotFoundException {
        //Conectando al servidor
        cliente = new Socket("127.0.0.1", 7805);
        System.out.println("Obteniendo imagenes");
        //Recibiendo imagenes
        ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
        ArrayList<ImageIcon> imagenes = (ArrayList<ImageIcon>)ois.readObject();
        //Guardando imagenes
        System.out.println("Guardando imagenes");
        File carpeta = new File(ruta);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
        System.out.println(imagenes.size());
        int i = 0;
        for(ImageIcon imagen: imagenes){
            guardarImagen(imagen,i);
            i++;
        }
        //Logica juego
        
    }
    private void guardarImagen(ImageIcon imagen, int numImagen) throws IOException{
        String rutaImagen = ruta +"/"+numImagen+".png";
        Image img = imagen.getImage();
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        File outputfile = new File(rutaImagen);
        ImageIO.write(bimage, "png", outputfile);
    }
    public ArrayList<Card> crearBaraja() throws IOException{
        Random  random = new Random();
        ArrayList<Card> baraja = new ArrayList<>();
        File file = new File(System.getProperty("user.dir")+"/"+ruta);
        byte id = 0;
        if(file.isDirectory()){
            for(File imagen:file.listFiles()){
                BufferedImage imagenActual = ImageIO.read(imagen);
                ImageIcon i = new ImageIcon(imagenActual.getScaledInstance(80, 100,  
                        java.awt.Image.SCALE_SMOOTH));
                Card carta = new Card(i,id,(random.nextInt(10 - 1 + 1) + 1));
                Card cartaPar = new Card(i, id,(random.nextInt(10 - 1 + 1) + 1));
                baraja.add(carta);
                baraja.add(cartaPar);
                id++;
            }
        }
        revolverBaraja(baraja);
        return baraja;
    }
    private void revolverBaraja(ArrayList<Card>baraja){
        Collections.sort(baraja);
    }
}
