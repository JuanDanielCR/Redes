package memorama;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author JuanDanielCR
 */
public class Tablero extends javax.swing.JFrame {
    private ImageIcon myPicture = null;
    private ImageIcon card = null;
    private JLabel parActual = null;
    private JLabel[] cartas;
    private Set<JLabel> paresDestapados = null;
    private Map<JLabel,Card> baraja = null;
    private int paresFormados;
    private int pares;
    private Cliente cliente;
    private Timer voltearCartas;
    private Timer tiempoPartida;
    private int tiempo = 0;
    private boolean inicio;

    public Tablero() throws IOException, ClassNotFoundException {
        inicio = false;
        paresFormados = 0;
        cartas = new JLabel[20];
        myPicture = new ImageIcon("card.jpg");
        myPicture = resize(myPicture);
        card = new ImageIcon("card.jpg");
        card = resize(card);
        baraja = new HashMap<>();
        paresDestapados = new HashSet<>();
        cliente = new Cliente();
        cliente.conectar();
        ArrayList<Card> cards = cliente.crearBaraja();
        //pares = cards.size()/2;
        pares=2;
        //System.out.println("card: "+cards.size());
        for(Card c:cards){
            System.out.println("ID_CARTA: "+c.getId()+" rand: "+c.getRandom());
        }
        initComponents();
        for(int i = 0; i < cards.size(); i++){
            asociar(i, cards.get(i));
        }
    }
    private ImageIcon resize(ImageIcon imagenOriginal){
        Image image = imagenOriginal.getImage();
        Image imagenFinal = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(imagenFinal);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel17 = new javax.swing.JPanel();
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
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 153, 51));
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jLabel1.setIcon((Icon) myPicture);
        jLabel1.setName("Uno");

        jLabel2.setText("");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));
        jLabel2.setIcon((Icon) myPicture);
        jLabel2.setName("DOS");

        jLabel3.setText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));
        jLabel3.setIcon((Icon) myPicture);

        jLabel4.setText("");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));
        jLabel4.setIcon((Icon) myPicture);

        jLabel5.setText("");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setFocusable(false);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jLabel5.setIcon((Icon) myPicture);

        jLabel6.setText("");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));
        jLabel6.setIcon((Icon) myPicture);

        jLabel7.setText("");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));
        jLabel7.setIcon((Icon) myPicture);

        jLabel10.setText("");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));
        jLabel10.setIcon((Icon) myPicture);

        jLabel9.setText("");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        jLabel9.setIcon((Icon) myPicture);

        jLabel8.setText("");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));
        jLabel8.setIcon((Icon) myPicture);

        jLabel12.setText("");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));
        jLabel12.setIcon((Icon) myPicture);

        jLabel15.setText("");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));
        jLabel15.setIcon((Icon) myPicture);

        jLabel16.setText("");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));
        jLabel16.setIcon((Icon) myPicture);

        jLabel20.setText("");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, -1));
        jLabel20.setIcon((Icon) myPicture);

        jLabel11.setText("");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));
        jLabel11.setIcon((Icon) myPicture);

        jLabel14.setText("");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));
        jLabel14.setIcon((Icon) myPicture);

        jLabel19.setText("");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));
        jLabel19.setIcon((Icon) myPicture);

        jLabel18.setText("");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));
        jLabel18.setIcon((Icon) myPicture);

        jLabel13.setText("");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));
        jLabel13.setIcon((Icon) myPicture);

        jLabel17.setText("");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));
        jLabel17.setIcon((Icon) myPicture);

        jScrollPane1.setViewportView(jPanel2);

        jLabel21.setFont(new java.awt.Font("SimSun", 0, 11)); // NOI18N
        jLabel21.setText("0 seg");

        jLabel22.setForeground(new java.awt.Color(0, 153, 153));
        jLabel22.setText("Estatus: Listo para jugar");

        jLabel23.setBackground(new java.awt.Color(0, 102, 102));
        jLabel23.setFont(new java.awt.Font("Eurostile Bold", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 153));
        jLabel23.setText("Tiempo:");

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(117, 117, 117)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        voltearCarta(jLabel1);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        voltearCarta(jLabel2);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        voltearCarta(jLabel3);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        voltearCarta(jLabel4);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        voltearCarta(jLabel5);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        voltearCarta(jLabel6);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        voltearCarta(jLabel7);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        voltearCarta(jLabel8);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        voltearCarta(jLabel9);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        voltearCarta(jLabel10);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        voltearCarta(jLabel11);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        voltearCarta(jLabel12);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        voltearCarta(jLabel13);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        voltearCarta(jLabel14);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        voltearCarta(jLabel15);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        voltearCarta(jLabel16);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        voltearCarta(jLabel17);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        voltearCarta(jLabel18);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        voltearCarta(jLabel19);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        voltearCarta(jLabel20);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ActionListener partidaPerformer = (ActionEvent e) -> {
            jLabel21.setText(Integer.toString(tiempo)+" seg");
            tiempo++;
        };
        inicio = true;
        jLabel22.setText("Jugando");
        tiempoPartida = new Timer(1000, partidaPerformer);
        jButton1.setVisible(false);
        tiempoPartida.start();
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
        ActionListener tableroPerformer = (ActionEvent e) -> {
            int i = 0;
            for(JLabel carta: cartas){
                if(!paresDestapados.contains(cartas[i])){
                    baraja.get(cartas[i]).setBocaArriba(false);
                    cartas[i].setIcon(card);
                }
                i++;
            }
        };
        //System.out.println(cartaActual);
        Card cartaAsociada =  baraja.get(cartaActual);
        boolean bocaArriba = cartaAsociada.isBocaArriba();
        //En juego
        if(cartaAsociada.isIsShown()==false && inicio==true){
            //System.out.println("carta: "+cartaActual.getName()+"boca arriba: "+bocaArriba);
            //Boca abajo
            if(bocaArriba==false){
                ImageIcon imageIcon = cartaAsociada.getImage();
                cartaActual.setIcon(imageIcon);
                cartaAsociada.setBocaArriba(true);
                if(parActual != null){
                    //System.out.println("parActual != null");
                    //System.out.println("par: "+baraja.get(parActual).getId()+" actual:"+baraja.get(cartaActual).getId());
                    if(baraja.get(parActual).getId() == baraja.get(cartaActual).getId()){
                        System.out.println("iguales");
                        paresDestapados.add(parActual);
                        paresDestapados.add(cartaActual);
                        paresFormados++;
                        if(paresFormados==pares){
                            jLabel22.setText("Ganaste");
                            cliente.anunciarFin(tiempo);
                            System.out.println("Gano");
                            tiempoPartida.stop();
                        }
                    }else{
                        System.out.println("diferente");
                    }
                    parActual = null; 
                    voltearCartas.start();
                }else{
                    //System.out.println("Nuevo timer");
                    parActual = cartaActual;
                    voltearCartas = new Timer(500, tableroPerformer);
                    voltearCartas.setRepeats(false);
                }
            }
        }else{
            System.out.println("Carta inhabilitada");
        }
    }
    private void asociar(int i, Card card){
        switch(i){
            case 0: baraja.put(jLabel1, card); cartas[i]=jLabel1;
            break;
            case 1: baraja.put(jLabel2, card); cartas[i]=jLabel2;break;
            case 2: baraja.put(jLabel3, card); cartas[i]=jLabel3;break;
            case 3: baraja.put(jLabel4, card); cartas[i]=jLabel4;break;
            case 4: baraja.put(jLabel5, card); cartas[i]=jLabel5;break;
            case 5: baraja.put(jLabel6, card); cartas[i]=jLabel6;break;
            case 6: baraja.put(jLabel7, card); cartas[i]=jLabel7;break;
            case 7: baraja.put(jLabel8, card); cartas[i]=jLabel8;break;
            case 8: baraja.put(jLabel9, card); cartas[i]=jLabel9;break;
            case 9: baraja.put(jLabel10, card); cartas[i]=jLabel10;break;
            case 10: baraja.put(jLabel11, card); cartas[i]=jLabel11;break;
            case 11: baraja.put(jLabel12, card); cartas[i]=jLabel12;break;
            case 12: baraja.put(jLabel13, card); cartas[i]=jLabel13;break;
            case 13: baraja.put(jLabel14, card); cartas[i]=jLabel14;break;
            case 14: baraja.put(jLabel15, card); cartas[i]=jLabel15;break;
            case 15: baraja.put(jLabel16, card); cartas[i]=jLabel16;break;
            case 16: baraja.put(jLabel17, card); cartas[i]=jLabel17;break;
            case 17: baraja.put(jLabel18, card); cartas[i]=jLabel18;break;
            case 18: baraja.put(jLabel19, card); cartas[i]=jLabel19;break;
            case 19: baraja.put(jLabel20, card); cartas[i]=jLabel20;break;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
