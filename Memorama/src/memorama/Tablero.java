package memorama;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author JuanDanielCR
 */
public class Tablero extends javax.swing.JFrame {
    private ImageIcon myPicture = null;
    private ImageIcon card = null;
    private Map<JLabel,Card> baraja = null;
    private Card cartaDestapada = null;
    private int paresFormados = 0;
    
    public Tablero() throws IOException, ClassNotFoundException {
        myPicture = new ImageIcon("card.jpg");
        myPicture = resize(myPicture);
        
        card = new ImageIcon("card.jpg");
        card = resize(card);
        
        baraja = new HashMap<>();
        
        Cliente cliente = new Cliente();
        cliente.conectar();
        ArrayList<Card> cards = cliente.crearBaraja();
        System.out.println("card: "+cards.size());
        /*for(Card c:cards){
            System.out.println("c: "+c.getId()+" rand: "+c.getRandom());
        }*/
        initComponents();
        for(int i = 0; i < cards.size(); i++){
            asociar(i, cards.get(i));
        }
    }
    private ImageIcon resize(ImageIcon imagenOriginal){
        Image image = imagenOriginal.getImage();
        Image imagenFinal = image.getScaledInstance(50, 70,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(imagenFinal);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel17 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Comenzar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
        jLabel1.setIcon((Icon) myPicture);
        jLabel1.setName("Uno");

        jLabel2.setText("");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));
        jLabel2.setIcon((Icon) myPicture);
        jLabel2.setName("DOS");

        jLabel3.setText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));
        jLabel3.setIcon((Icon) myPicture);

        jLabel4.setText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));
        jLabel4.setIcon((Icon) myPicture);

        jLabel5.setText("");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        jLabel5.setIcon((Icon) myPicture);

        jLabel6.setText("");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        jLabel6.setIcon((Icon) myPicture);

        jLabel7.setText("");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));
        jLabel7.setIcon((Icon) myPicture);

        jLabel10.setText("");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 216, -1, -1));
        jLabel10.setIcon((Icon) myPicture);

        jLabel9.setText("");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, -1, -1));
        jLabel9.setIcon((Icon) myPicture);

        jLabel8.setText("");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));
        jLabel8.setIcon((Icon) myPicture);

        jLabel12.setText("");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 216, -1, -1));
        jLabel12.setIcon((Icon) myPicture);

        jLabel15.setText("");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));
        jLabel15.setIcon((Icon) myPicture);

        jLabel16.setText("");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));
        jLabel16.setIcon((Icon) myPicture);

        jLabel20.setText("");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, -1));
        jLabel20.setIcon((Icon) myPicture);

        jLabel11.setText("");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 216, -1, -1));
        jLabel11.setIcon((Icon) myPicture);

        jLabel14.setText("");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));
        jLabel14.setIcon((Icon) myPicture);

        jLabel19.setText("");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));
        jLabel19.setIcon((Icon) myPicture);

        jLabel18.setText("");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));
        jLabel18.setIcon((Icon) myPicture);

        jLabel13.setText("");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        jLabel13.setIcon((Icon) myPicture);

        jLabel17.setText("");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));
        jLabel17.setIcon((Icon) myPicture);

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel1.setIcon(card);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        voltearCarta(jLabel1);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        voltearCarta(jLabel2);
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | 
                InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.
                    getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Tablero().setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    private void voltearCarta(JLabel cartaActual){
        //System.out.println("..."+cartaActual.getName());
        Card cartaAsociada =  baraja.get(cartaActual);
        boolean bocaArriba = false;
        //En juego
        if(cartaAsociada.isIsShown()==false){
            ImageIcon imageIcon = cartaAsociada.getImage();
            cartaActual.setIcon(imageIcon);
            //Boca abajo
            if(bocaArriba==false){
                //No hay otra carta arriba
                if(cartaDestapada == null){
                    cartaDestapada = cartaAsociada;
                }else{
                    //Encontro pareja
                    if(cartaDestapada.getId() == cartaAsociada.getId()){
                        cartaDestapada.setIsShown(true);
                        cartaAsociada.setIsShown(true);
                        paresFormados++;
                    }else{ //Ambas son diferentes volteo ambas
                        cartaActual.setIcon(card);
                        //TODO: VOLTAER 
                        //baraja.get(cartaDestapada);
                        cartaDestapada = null;
                    }
                }
                bocaArriba = true;
            }else{
                jLabel1.setIcon(card);
                cartaDestapada = null;
                bocaArriba = false;
            }
        }
    }
    private void asociar(int i, Card card){
        switch(i){
            case 0: baraja.put(jLabel1, card); break;
            case 1: baraja.put(jLabel2, card); break;
            case 2: baraja.put(jLabel3, card); break;
            case 3: baraja.put(jLabel4, card); break;
            case 4: baraja.put(jLabel5, card); break;
            case 5: baraja.put(jLabel6, card); break;
            case 6: baraja.put(jLabel7, card); break;
            case 7: baraja.put(jLabel8, card); break;
            case 8: baraja.put(jLabel9, card); break;
            case 9: baraja.put(jLabel10, card); break;
            case 10: baraja.put(jLabel11, card); break;
            case 11: baraja.put(jLabel12, card); break;
            case 12: baraja.put(jLabel13, card); break;
            case 13: baraja.put(jLabel14, card); break;
            case 14: baraja.put(jLabel15, card); break;
            case 15: baraja.put(jLabel16, card); break;
            case 16: baraja.put(jLabel17, card); break;
            case 17: baraja.put(jLabel18, card); break;
            case 18: baraja.put(jLabel19, card); break;
            case 19: baraja.put(jLabel20, card); break;
            default: baraja.put(jLabel4, card); break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
