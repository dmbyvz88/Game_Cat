/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Game;

import Class.ConsultaEstadoJuego;
import Class.Imagen;
import Class.RigaInicioPartida;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author Diego
 */
public class Ven_Juego extends javax.swing.JInternalFrame {
    public String [][] matrizJuego = new String[3][3];
    RigaInicioPartida ganador = new RigaInicioPartida();
    Imagen imagen;
    public String [] jugadores;
    String jugMoviendo;//Esta variable indica cual jugador tiene que mover en este momento
    ConsultaEstadoJuego estaGame = new ConsultaEstadoJuego();
    
    /**
     * Creates new form Ven_Juego
     * @param matrizJuego
     * @param jugadores
     * @param jugMoviendo
     */
    public Ven_Juego(String [][] matrizJuego, String[] jugadores, String jugMoviendo) {
        this.jugadores=jugadores;
        this.matrizJuego=matrizJuego;
        this.jugMoviendo=jugMoviendo;
        initComponents();
        if(estaGame.validacionMatriz(matrizJuego)){
            cargaJuegoAnterior();
        }else{
            cargaNewJugadores();
        }
    }
    /**
     * Metodo que recorre la matriz del juego para cargar las imagenes en cada label
     */
    public void cargaJuegoAnterior(){
        for(int i=0; i < matrizJuego.length; i++){
            for(int j=0; j < matrizJuego.length; j++){
                if(!"".equals(matrizJuego[i][j]) && matrizJuego[i][j]!=null){
                    asignaImagenes(matrizJuego[i][j], i, j);
                }
            }
        }
        lbJugador1.setText(jugadores[0]);
        lbJugador2.setText(jugadores[1]);
    }
    /**
     * Metodo que asigan
     * @param val
     * @param columna
     * @param fila
     */
    public void asignaImagenes(String val, int columna, int fila){
        switch(consultaPosicion(columna, fila)){
            case "00":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_DEFAULT));
                    lb1.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_DEFAULT));
                    lb1.setIcon(icono);
                }
                break;
            case "01":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb2.getWidth(), lb2.getHeight(), Image.SCALE_DEFAULT));
                    lb2.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb2.getWidth(), lb2.getHeight(), Image.SCALE_DEFAULT));
                    lb2.setIcon(icono);
                }
                break;
            case "02":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb3.getWidth(), lb3.getHeight(), Image.SCALE_DEFAULT));
                    lb3.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb3.getWidth(), lb3.getHeight(), Image.SCALE_DEFAULT));
                    lb3.setIcon(icono);
                }
                break;
            case "10":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb4.getWidth(), lb4.getHeight(), Image.SCALE_DEFAULT));
                    lb4.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb4.getWidth(), lb4.getHeight(), Image.SCALE_DEFAULT));
                    lb4.setIcon(icono);
                }
                break;
            case "11":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb5.getWidth(), lb5.getHeight(), Image.SCALE_DEFAULT));
                    lb5.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb5.getWidth(), lb5.getHeight(), Image.SCALE_DEFAULT));
                    lb5.setIcon(icono);
                }
                break;
            case "12":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb6.getWidth(), lb6.getHeight(), Image.SCALE_DEFAULT));
                    lb6.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb6.getWidth(), lb6.getHeight(), Image.SCALE_DEFAULT));
                    lb6.setIcon(icono);
                }
                break;
            case "20":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb7.getWidth(), lb7.getHeight(), Image.SCALE_DEFAULT));
                    lb7.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb7.getWidth(), lb7.getHeight(), Image.SCALE_DEFAULT));
                    lb7.setIcon(icono);
                }
                break;
            case "21":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb8.getWidth(), lb8.getHeight(), Image.SCALE_DEFAULT));
                    lb8.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb8.getWidth(), lb8.getHeight(), Image.SCALE_DEFAULT));
                    lb8.setIcon(icono);
                }
                break;
            case "22":
                if(!val.equals("X")){
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                            .getImage().getScaledInstance(lb9.getWidth(), lb9.getHeight(), Image.SCALE_DEFAULT));
                    lb9.setIcon(icono);
                }else{
                    Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                            .getImage().getScaledInstance(lb9.getWidth(), lb9.getHeight(), Image.SCALE_DEFAULT));
                    lb9.setIcon(icono);
                }
                break;
        }
    }
    /**
     * Metodo que concatena la columna iy fila
     * @param columna
     * @param fila
     * @return
     */
    public String consultaPosicion(int columna, int fila){
        String opc = String.valueOf(columna)+String.valueOf(fila);
        return opc;
    }
    /**
     * Carga los nombres de los jugadores a los jLabels
     */
    private void cargaNewJugadores(){
        lbJugador1.setText(jugadores[0]);
        lbJugador2.setText(jugadores[1]);
        jugMoviendo=ganador.RigaInicioPartida(lbJugador1.getText(), lbJugador2.getText());
        if(jugMoviendo.equals(lbJugador1.getText())){
            lbJugador1.setForeground(Color.red);
            lbJugador2.setForeground(Color.black);
        }else{
            lbJugador2.setForeground(Color.red);
            lbJugador1.setForeground(Color.black);
        }
        limpiaMatriz();
    }    
    /**
     * Cambia de jugador cada vez que se haiga realizado una jugada
     */
    private void cambioJugador(){
        if(!jugMoviendo.equals(lbJugador1.getText())){
            jugMoviendo=lbJugador1.getText();
            lbJugador1.setForeground(Color.red);
            lbJugador2.setForeground(Color.black);
        }else{
            jugMoviendo=lbJugador2.getText();
            lbJugador1.setForeground(Color.black);
            lbJugador2.setForeground(Color.red);
        }
    }    
    /**
     * Metodo que permite limpiar la matriz
     */
    private void limpiaMatriz(){
        matrizJuego=estaGame.limpiaMatriz(matrizJuego);
    }    
    /**
     * Realiza la comparación entre todas las casilla para identificar si se ah ganado el juego o no
     */
    private void resultadoGame(){
        if(estaGame.consultaEstadoJuego(matrizJuego)){
            if(YES_OPTION==JOptionPane.showConfirmDialog(null, "Juego Ganado \n ¿Desea Jugar nuevamente?.")){
                limpiaMatrizJuego();
            }else{
                limpiaMatrizJuego();
                this.dispose();
            }
        }
    }    
    /**
     * Metodo que permite limpiar los objetos y la matriz del juego
     */
    private void limpiaMatrizJuego(){
        lb1.setIcon(null);
        lb2.setIcon(null);
        lb3.setIcon(null);
        lb4.setIcon(null);
        lb5.setIcon(null);
        lb6.setIcon(null);
        lb7.setIcon(null);
        lb8.setIcon(null);
        lb9.setIcon(null);
        jugMoviendo="";
        limpiaMatriz();
    }
    /**
     * Metodo que permite comprovar si se cerró la ventana y si hay un juego pendiente lo guarda.
     */
    public void cierreVentana(){
        if(!estaGame.consultaEstadoJuego(matrizJuego) && YES_OPTION==JOptionPane.showConfirmDialog(null,"¿Desea guardar la partida actual?")){
            jugadores[0]=lbJugador1.getText();
            jugadores[1]=lbJugador2.getText();
            envioDatosPrincipal();
        }else{
            limpiaMatriz();
            envioDatosPrincipal();
            jugadores[0]="";
            jugadores[1]="";
        }
        Principal.consultaPartidaPendiente();
        this.dispose();
    }
    /**
     * Metodo que envia los datos de la matriz y los jugadores a la ventana principal
     */
    public void envioDatosPrincipal(){
        Principal.matrizJuegoPendiente=matrizJuego;
        Principal.listaJugadores[0]=jugadores[0];
        Principal.listaJugadores[1]=jugadores[1];
        Principal.jugMoviendo=jugMoviendo;
        //Principal.cargaObjetos();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbJugador1 = new javax.swing.JLabel();
        lbJugador2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btSalirPartida = new javax.swing.JButton();

        setTitle("Game");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 204), 2, true));

        lb1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(204, 153, 255)));
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1MouseClicked(evt);
            }
        });

        lb2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(204, 153, 255)));
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
        });

        lb3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(204, 153, 255)));
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3MouseClicked(evt);
            }
        });

        lb4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 2, new java.awt.Color(204, 153, 255)));
        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4MouseClicked(evt);
            }
        });

        lb5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 153, 255)));
        lb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb5MouseClicked(evt);
            }
        });

        lb6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, new java.awt.Color(204, 153, 255)));
        lb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb6MouseClicked(evt);
            }
        });

        lb7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(204, 153, 255)));
        lb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb7MouseClicked(evt);
            }
        });

        lb8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(204, 153, 255)));
        lb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb8MouseClicked(evt);
            }
        });

        lb9.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 0, new java.awt.Color(204, 153, 255)));
        lb9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lb4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lb2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb7, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lb8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 153, 255))));

        lbJugador1.setText("0");

        lbJugador2.setText("1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbJugador1)
                    .addComponent(lbJugador2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("El jugador que se encuentre en color Rojo, es al que le corresponde el tuno.");

        btSalirPartida.setText("Salir");
        btSalirPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSalirPartida)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalirPartida)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_DEFAULT));
            lb1.setIcon(icono);
            matrizJuego[0][0]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb1.getWidth(), lb1.getHeight(), Image.SCALE_DEFAULT));
            lb1.setIcon(icono);
            matrizJuego[0][0]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb1MouseClicked

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb2.getWidth(), lb2.getHeight(), Image.SCALE_DEFAULT));
            lb2.setIcon(icono);
            matrizJuego[0][1]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb2.getWidth(), lb2.getHeight(), Image.SCALE_DEFAULT));
            lb2.setIcon(icono);
            matrizJuego[0][1]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb2MouseClicked

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb3.getWidth(), lb3.getHeight(), Image.SCALE_DEFAULT));
            lb3.setIcon(icono);
            matrizJuego[0][2]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb3.getWidth(), lb3.getHeight(), Image.SCALE_DEFAULT));
            lb3.setIcon(icono);
            matrizJuego[0][2]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb3MouseClicked

    private void lb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb4.getWidth(), lb4.getHeight(), Image.SCALE_DEFAULT));
            lb4.setIcon(icono);
            matrizJuego[1][0]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb4.getWidth(), lb4.getHeight(), Image.SCALE_DEFAULT));
            lb4.setIcon(icono);
            matrizJuego[1][0]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb4MouseClicked

    private void lb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb5MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb5.getWidth(), lb5.getHeight(), Image.SCALE_DEFAULT));
            lb5.setIcon(icono);
            matrizJuego[1][1]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb5.getWidth(), lb5.getHeight(), Image.SCALE_DEFAULT));
            lb5.setIcon(icono);
            matrizJuego[1][1]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb5MouseClicked

    private void lb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb6MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb6.getWidth(), lb6.getHeight(), Image.SCALE_DEFAULT));
            lb6.setIcon(icono);
            matrizJuego[1][2]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb6.getWidth(), lb6.getHeight(), Image.SCALE_DEFAULT));
            lb6.setIcon(icono);
            matrizJuego[1][2]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb6MouseClicked

    private void lb7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb7MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb7.getWidth(), lb7.getHeight(), Image.SCALE_DEFAULT));
            lb7.setIcon(icono);
            matrizJuego[2][0]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb7.getWidth(), lb7.getHeight(), Image.SCALE_DEFAULT));
            lb7.setIcon(icono);
            matrizJuego[2][0]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb7MouseClicked

    private void lb8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb8MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb8.getWidth(), lb8.getHeight(), Image.SCALE_DEFAULT));
            lb8.setIcon(icono);
            matrizJuego[2][1]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb8.getWidth(), lb8.getHeight(), Image.SCALE_DEFAULT));
            lb8.setIcon(icono);
            matrizJuego[2][1]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb8MouseClicked

    private void lb9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb9MouseClicked
        if(!jugMoviendo.equals(lbJugador1.getText())){
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/o64bits.png"))
                    .getImage().getScaledInstance(lb9.getWidth(), lb9.getHeight(), Image.SCALE_DEFAULT));
            lb9.setIcon(icono);
            matrizJuego[2][2]="O";
        }else{
            Icon icono = new ImageIcon(new ImageIcon(getClass().getResource("/Picture/x64bits.png"))
                    .getImage().getScaledInstance(lb9.getWidth(), lb9.getHeight(), Image.SCALE_DEFAULT));
            lb9.setIcon(icono);
            matrizJuego[2][2]="X";
        }
        resultadoGame();
        cambioJugador();
    }//GEN-LAST:event_lb9MouseClicked

    private void btSalirPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirPartidaActionPerformed
        cierreVentana();
    }//GEN-LAST:event_btSalirPartidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalirPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lb1;
    public static javax.swing.JLabel lb2;
    public static javax.swing.JLabel lb3;
    public static javax.swing.JLabel lb4;
    public static javax.swing.JLabel lb5;
    public static javax.swing.JLabel lb6;
    public static javax.swing.JLabel lb7;
    public static javax.swing.JLabel lb8;
    public static javax.swing.JLabel lb9;
    public static javax.swing.JLabel lbJugador1;
    public static javax.swing.JLabel lbJugador2;
    // End of variables declaration//GEN-END:variables
}
