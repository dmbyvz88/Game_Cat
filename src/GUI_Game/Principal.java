/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Game;

import Class_Logic.AccesoListaJuego;
import Class_Logic.Tablero_Estado_Juego;
import Listas.Lista_Estadisticas_Game;
import Listas.Lista_Jugadores;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * Fecha Inicial Creación 05/03/2016
 * Fecha Finalización Creación 07/04/2016
 * @author Diego Murillo Barrantes
 */
public class Principal extends javax.swing.JFrame {
    public static String[] listaJugadores= null;
    public static Lista_Jugadores LJ = new Lista_Jugadores();
    public static Lista_Estadisticas_Game LEG = new Lista_Estadisticas_Game();
    AccesoListaJuego validaInicioJuego = new AccesoListaJuego(LJ);
    static Tablero_Estado_Juego  CEJ=new Tablero_Estado_Juego();
    
    public static String [][] matrizJuegoPendiente = new String [3][3];
    public static String jugMoviendo;//Esta variable indica cual jugador tiene que mover en este momento
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cargaObjetos();
    }
    /**
     * Metodo que valida si hay juego pendiente o si hay jugadores registrados, para habilitar o deshabilitar
     * algunos objetos del menú
     */
    private void cargaObjetos(){
        CEJ.limpiaMatriz(matrizJuegoPendiente);
        if(!CEJ.validacionMatriz(matrizJuegoPendiente)){
            btPendingGame.setEnabled(false);
            if(LJ.esVacia()){
                desactivaObjetos();
            }else{
                activaObjetos();
            }
        }else{
            btPendingGame.setEnabled(true);
            activaObjetos();
        }
    }
    /**
     * Deshabilida algunos objetos del menú
     */
    private void desactivaObjetos(){        
        btListGamer.setEnabled(false);
        btEstadistica.setEnabled(false);
    }
    /**
     * Habilida algunos objetos del menú
     */
    private void activaObjetos(){
        btListGamer.setEnabled(true);
        btEstadistica.setEnabled(true);
    }
    /**
     * Menú opcional de la ventana principal del juego
     * @param opc
     */
    private void menu(int opc){
        switch(opc){
            case 1://Registra los Jugadores que desean jugar
                if(LJ.esVacia()){
                    cargarJugadoresNews();
                }else if(YES_OPTION==JOptionPane.showConfirmDialog(null, "¿Desea seleccionar los jugadores de la "
                        + "lista existente?.")){
                    cargaJDSeleccionadorJugadores();
                    cargaCombosJugadores();
                }else{
                    cargarJugadoresNews();
                }
                cargaObjetos();
                break;
            case 2:
                if(CEJ.validacionMatriz(matrizJuegoPendiente)
                        && YES_OPTION==JOptionPane.showConfirmDialog(null, "¿Desea reanudar el juego anterior?.")){
                        Ven_Juego ven = new Ven_Juego(matrizJuegoPendiente, listaJugadores, jugMoviendo, LEG, LJ);
                        jDesktopPane1.add(ven);
                        ven.setVisible(true);
                        JOptionPane.showMessageDialog(null, "El jugador que se encuentre en color Rojo, "
                    + "\nes al que le corresponde el tuno.");
                }
                break;
            case 3:
                listaJugadores=LJ.mostrarListaJugadores();
                JOptionPane.showMessageDialog(null, "Los Jugadores actuales son: \n"
                        + muestaListaJugadores(listaJugadores));
                break;
            case 4:
                jdListaJugadores.setSize(380,120); 
                jdListaJugadores.setVisible(true);
                jdListaJugadores.setLocationRelativeTo(this);
                cargaListaCombosJugadores();
                break;
        }
    }
    /**
     * Metodo que permite cargar en los combos la lista de jugadores
     */
    private void cargaCombosJugadores(){
        listaJugadores=LJ.mostrarListaJugadores();
        for(int i=0; i<listaJugadores.length;i++){
            cbJugador1.addItem(listaJugadores[i]);
            cbJugador2.addItem(listaJugadores[i]);
        }
    }
    /**
     * Metodo que permite cargar el combo de la estadistica con la lista de jugadores
     */
    private void cargaListaCombosJugadores(){
        JComboBox temp = new JComboBox();
        cbListaJugadores.setModel(temp.getModel());
        listaJugadores=LJ.mostrarListaJugadores();
        for(int i=0; i<listaJugadores.length;i++){
            cbListaJugadores.addItem(listaJugadores[i]);
        }
    }
    /**
     * Metodo que carga los nuevo jugadores
     */
    private void cargarJugadoresNews(){
        LJ=this.validaInicioJuego.ingresoJugadoresNews(LJ);
       // AEJ.
        if(LJ.primero != null && listaJugadores[0]!=null && listaJugadores[1]!=null 
                && !"".equals(listaJugadores[0]) && !"".equals(listaJugadores[1])){
            Ven_Juego ven = new Ven_Juego(matrizJuegoPendiente, listaJugadores, jugMoviendo, LEG, LJ);
            jDesktopPane1.add(ven);
            ven.setVisible(true);
            JOptionPane.showMessageDialog(null, "El jugador que se encuentre en color Rojo, "
                    + "\nes al que le corresponde el tuno.");
        }else{
            JOptionPane.showMessageDialog(null, "No se puede carga el juego por que los jugadores registrados"
                + "\n no está ingresados correctamente, favor verificar su ingreso.");
        }
    }
    /**
     * Metodo que permite cargar la ventana para seleccionar los jugadores de la lista existente
     */
    private void cargaJDSeleccionadorJugadores(){
        jdSelecJugadores.setSize(510,140); 
        jdSelecJugadores.setVisible(true);
    }
    /**
     * Carga lista de jugadores en un string
     */
    private String muestaListaJugadores(String [] lista){
        String jugadores="";
        for(int i=0; i<lista.length;i++){
            jugadores+= lista[i] + "\n";
        }
        return jugadores;
    }
    /**
     * Metodo que permite activar el boton del juego anterior
     */
    public static void consultaPartidaPendiente(){
        if(CEJ.validacionMatriz(matrizJuegoPendiente)){
            btPendingGame.setEnabled(true);
        }else{
            btPendingGame.setEnabled(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdSelecJugadores = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        cbJugador1 = new javax.swing.JComboBox<>();
        btAceptar = new javax.swing.JButton();
        cbJugador2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdListaJugadores = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        cbListaJugadores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btConsultaEstadistica = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btPendingGame = new javax.swing.JButton();
        btListGamer = new javax.swing.JButton();
        btEstadistica = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        jdSelecJugadores.setTitle("Seleccionador de Jugadores");

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador 1");

        jLabel2.setText("Jugador 2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(cbJugador1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbJugador2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAceptar)
                    .addComponent(cbJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdSelecJugadoresLayout = new javax.swing.GroupLayout(jdSelecJugadores.getContentPane());
        jdSelecJugadores.getContentPane().setLayout(jdSelecJugadoresLayout);
        jdSelecJugadoresLayout.setHorizontalGroup(
            jdSelecJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdSelecJugadoresLayout.setVerticalGroup(
            jdSelecJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdListaJugadores.setTitle("Lista de Jugadores");

        jLabel3.setText("Lista de Jugadores:");

        btConsultaEstadistica.setText("Consultar");
        btConsultaEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaEstadisticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btConsultaEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(cbListaJugadores, 0, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbListaJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btConsultaEstadistica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdListaJugadoresLayout = new javax.swing.GroupLayout(jdListaJugadores.getContentPane());
        jdListaJugadores.getContentPane().setLayout(jdListaJugadoresLayout);
        jdListaJugadoresLayout.setHorizontalGroup(
            jdListaJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdListaJugadoresLayout.setVerticalGroup(
            jdListaJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(0, 0, 204)));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153))); // NOI18N

        btNew.setBackground(new java.awt.Color(153, 204, 255));
        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/cat64bits.png"))); // NOI18N
        btNew.setToolTipText("Inicia Juego");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btPendingGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/carpeta-caticon64bits.png"))); // NOI18N
        btPendingGame.setToolTipText("Continua con la partida pendiente.");
        btPendingGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPendingGameActionPerformed(evt);
            }
        });

        btListGamer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/listaJug64bits.png"))); // NOI18N
        btListGamer.setToolTipText("Muestra Lista de Jugadores");
        btListGamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListGamerActionPerformed(evt);
            }
        });

        btEstadistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/bar.png"))); // NOI18N
        btEstadistica.setToolTipText("Muestra las estadisticas de cualquier jugador.");
        btEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstadisticaActionPerformed(evt);
            }
        });

        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/exit.png"))); // NOI18N
        btSalir.setToolTipText("Avandonar el juego");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPendingGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btListGamer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btPendingGame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btListGamer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        menu(1);
    }//GEN-LAST:event_btNewActionPerformed

    private void btPendingGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPendingGameActionPerformed
        menu(2);
    }//GEN-LAST:event_btPendingGameActionPerformed

    private void btListGamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListGamerActionPerformed
        menu(3);
    }//GEN-LAST:event_btListGamerActionPerformed

    private void btEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstadisticaActionPerformed
        menu(4);
    }//GEN-LAST:event_btEstadisticaActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        if (cbJugador1.getSelectedIndex() > -1 && cbJugador2.getSelectedIndex()>-1) {
                if(!cbJugador1.getSelectedItem().toString().equals(cbJugador2.getSelectedItem().toString())){
                    listaJugadores[0]=cbJugador1.getSelectedItem().toString();
                    listaJugadores[1]=cbJugador2.getSelectedItem().toString();
                    Ven_Juego ven = new Ven_Juego(matrizJuegoPendiente, listaJugadores, jugMoviendo, LEG, LJ);
                    jDesktopPane1.add(ven);
                    ven.setVisible(true);
                    jdSelecJugadores.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Debe de elegir jugadores diferentes.");
                }
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btConsultaEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaEstadisticaActionPerformed
        if(!"".equals(cbListaJugadores.getSelectedItem().toString())){
            Ven_Estadistica_Jugador ven = new Ven_Estadistica_Jugador(LEG, 
                    cbListaJugadores.getSelectedItem().toString());
            jdListaJugadores.dispose();
            jDesktopPane1.add(ven);
            ven.setVisible(true);
        }
    }//GEN-LAST:event_btConsultaEstadisticaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btConsultaEstadistica;
    private static javax.swing.JButton btEstadistica;
    private static javax.swing.JButton btListGamer;
    private javax.swing.JButton btNew;
    private static javax.swing.JButton btPendingGame;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<String> cbJugador1;
    private javax.swing.JComboBox<String> cbJugador2;
    private javax.swing.JComboBox<String> cbListaJugadores;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JDialog jdListaJugadores;
    private javax.swing.JDialog jdSelecJugadores;
    // End of variables declaration//GEN-END:variables
}
