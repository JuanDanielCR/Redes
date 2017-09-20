package memorama;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author JuanDanielCR
 */
public class Cliente {
    private String ruta = "imagenesCliente";
    private Socket cliente;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Registro registro;
            
    public Cliente(){
        this.cliente = null;
        this.ois = null;
        this.oos = null;
        this.registro = null;
    }
    
    public void conectar() throws IOException, ClassNotFoundException {
        //Conectando al servidor
        cliente = new Socket("127.0.0.1", 7800);
        System.out.println("Obteniendo imagenes");
        //Recibiendo imagenes
        ois = new ObjectInputStream(cliente.getInputStream());
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
        registro = new Registro();
        return baraja;
    }
    private void revolverBaraja(ArrayList<Card>baraja){
        Collections.sort(baraja);
    }
    public void anunciarFin(int segundos){
        try {
            Date fin = new Date();
            registro.setFin(fin);
            registro.setMinutos(segundos);
            registro.obtenerMinutos();
            oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(registro);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
