/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Game;

import Class_Logic.Acceso_Estadisticas_Jugadores;
import Class_Logic.ConsultaEstadoJuego;
import Class_Logic.RigaInicioPartida;
import Listas.Lista_Estadisticas_Game;
import Listas.Lista_Jugadores;
import java.awt.Color;
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
    public String [] jugadores;
    String jugMoviendo;//Esta variable indica cual jugador tiene que mover en este momento
    ConsultaEstadoJuego estaGame = new ConsultaEstadoJuego();
    Lista_Estadisticas_Game LEG = new Lista_Estadisticas_Game();
    Lista_Jugadores LJ = new Lista_Jugadores();
    Acceso_Estadisticas_Jugadores AEJ = new Acceso_Estadisticas_Jugadores(jugadores, LJ, LEG);
    
    /**
     * Creates new form Ven_Juego
     * @param matrizJuego
     * @param jugadores
     * @param jugMoviendo
     * @param LGE
     * @param listaJugadores
     */
    public Ven_Juego(String [][] matrizJuego, String[] jugadores, String jugMoviendo, Lista_Estadisticas_Game LGE,
            Lista_Jugadores listaJugadores) {
        this.LEG=LGE;
        this.jugadores=jugadores;
        this.matrizJuego=matrizJuego;
        this.jugMoviendo=jugMoviendo;
        this.LJ=listaJugadores;
        initComponents();
        ckVistaEstadisticas.setSelected(true);
        muestraEstadistica();
        if(estaGame.validacionMatriz(matrizJuego)){
            cargaJuegoAnterior();
        }else{
            cargaNewJugadores();
            limpiaMatrizJuego();
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
        String opc=consultaPosicion(columna, fila);
        switch(opc){
            case "00":
                if(!val.equals("X")){
                    lb1.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb1.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "01":
                if(!val.equals("X")){
                    lb2.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb2.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "02":
                if(!val.equals("X")){
                    lb3.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb3.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "10":
                if(!val.equals("X")){
                    lb4.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb4.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "11":
                if(!val.equals("X")){
                    lb5.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb5.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "12":
                if(!val.equals("X")){
                    lb6.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb6.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "20":
                if(!val.equals("X")){
                    lb7.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb7.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "21":
                if(!val.equals("X")){
                    lb8.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb8.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                }
                break;
            case "22":
                if(!val.equals("X")){
                    lb9.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                }else{
                    lb9.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
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
            lbJugador1.setFont(new java.awt.Font("Tahoma", 1, 18));
            lbJugador1.setForeground(Color.red);
            lbJugador2.setFont(new java.awt.Font("Tahoma", 0, 12));
            lbJugador2.setForeground(Color.black);
        }else{
            lbJugador1.setFont(new java.awt.Font("Tahoma", 0, 12));
            lbJugador2.setForeground(Color.red);
            lbJugador2.setFont(new java.awt.Font("Tahoma", 1, 18));
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
            lbJugador1.setFont(new java.awt.Font("Tahoma", 1, 18));
            lbJugador1.setForeground(Color.red);
            lbJugador2.setFont(new java.awt.Font("Tahoma", 0, 12)); 
            lbJugador2.setForeground(Color.black);
        }else{
            jugMoviendo=lbJugador2.getText();
            lbJugador1.setFont(new java.awt.Font("Tahoma", 0, 12));
            lbJugador1.setForeground(Color.black);
            lbJugador2.setFont(new java.awt.Font("Tahoma", 1, 18));
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
        if(estaGame.consultaEstadoMatrizJuego(matrizJuego)){
            if(YES_OPTION==JOptionPane.showConfirmDialog(null, "Juego Ganado\n Felicidades "+jugMoviendo
                    +"\n ¿Desea Jugar nuevamente?.")){
                Principal.LEG=LEG=AEJ.menu_Calcula_Estadisticas_Jugadores("Ganada", jugMoviendo, consultaJugadorPerdedor(jugMoviendo), jugadores);
                limpiaMatrizJuego();
                mostrarEstadistica();
            }else{
                limpiaMatrizJuego();
                this.dispose();
            }
        }else if(isLlenaMatriz()){
                JOptionPane.showMessageDialog(null, "Partida Empatada, no hay ganador.");
        }
    }
    /**
     * Metodo muestra las estadisticas de los jugadores
     */
    private void mostrarEstadistica(){
        int[] cantidadesJ1 = LEG.consultaCantidades(jugadores[0]);
        int[] cantidadesJ2 = LEG.consultaCantidades(jugadores[1]);
        if(lbJugador1.getText().equals(jugadores[0])){
            lbCantGanadasJ1.setText(String.valueOf(cantidadesJ1[0]));
            lbCantPerdidasJ1.setText(String.valueOf(cantidadesJ1[1]));
            lbCantEmpatadasJ1.setText(String.valueOf(cantidadesJ1[2]));
            lbCantGanadasJ2.setText(String.valueOf(cantidadesJ2[0]));
            lbCantPerdidasJ2.setText(String.valueOf(cantidadesJ2[1]));
            lbCantEmpatadasJ2.setText(String.valueOf(cantidadesJ2[2]));
        }
    }
    /**
     * Metodo que permite consultar cual es el jugador que perdio, ya que se necesita en la estadistica
     * @param jugadorGanador
     * @return
     */
    private String consultaJugadorPerdedor(String jugadorGanador){
        String jugadorPerdedor;
        if(!jugMoviendo.equals(lbJugador1.getText())){
            jugadorPerdedor=lbJugador1.getText();
        }else{
            jugadorPerdedor=lbJugador2.getText();
        }
        return jugadorPerdedor;
    }
    /**
     * Metodo que verifica si está o no llena la matríz
     * @return
     */
    private boolean isLlenaMatriz(){
        boolean vacio=false;
        int cont=0;
        for(int i=0; i<matrizJuego.length;i++){
            for(int j=0; j<matrizJuego.length;j++){
                if(!matrizJuego[i][j].equals("")){
                    cont++;
                }
            }
        }
        if(cont>=9){
            vacio=true;
        }
        return vacio;
    }    
    /**
     * Metodo que permite limpiar los objetos y la matriz del juego
     */
    private void limpiaMatrizJuego(){
        lb1.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb2.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb3.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb4.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb5.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb6.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb7.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb8.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        lb9.setIcon(new ImageIcon(getClass().getResource("/Picture/cat-icon128bits.png")));
        jugMoviendo="";
        limpiaMatriz();
    }
    /**
     * Metodo que permite comprovar si se cerró la ventana y si hay un juego pendiente lo guarda.
     */
    private void cierreVentana(){
        if(!estaGame.consultaEstadoMatrizJuego(matrizJuego) && YES_OPTION==JOptionPane.showConfirmDialog(null,"¿Desea guardar la partida actual?")){
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
    private void envioDatosPrincipal(){
        Principal.matrizJuegoPendiente=matrizJuego;
        Principal.listaJugadores[0]=jugadores[0];
        Principal.listaJugadores[1]=jugadores[1];
        Principal.jugMoviendo=jugMoviendo;
        //Principal.cargaObjetos();
    }
    /**
     * Metodo que verifica si el check que muestra la estadisticas esta o no habilitado
     */
    private void muestraEstadistica(){
        if(ckVistaEstadisticas.isSelected()){
            pEstadisticaJ1.setVisible(true);
            pEstadisticaJ2.setVisible(true);
        }else{
            pEstadisticaJ1.setVisible(false);
            pEstadisticaJ2.setVisible(false);
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
        jPanel4 = new javax.swing.JPanel();
        lbJugador1 = new javax.swing.JLabel();
        pEstadisticaJ1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbCantGanadasJ1 = new javax.swing.JLabel();
        lbCantPerdidasJ1 = new javax.swing.JLabel();
        lbCantEmpatadasJ1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbJugador2 = new javax.swing.JLabel();
        pEstadisticaJ2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbCantGanadasJ2 = new javax.swing.JLabel();
        lbCantPerdidasJ2 = new javax.swing.JLabel();
        lbCantEmpatadasJ2 = new javax.swing.JLabel();
        btSalirPartida = new javax.swing.JButton();
        ckVistaEstadisticas = new javax.swing.JCheckBox();

        setTitle("Game");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/pccat-icon64bits.png"))); // NOI18N

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(lb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(lb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb8, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(lb7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 153, 255)), "Estadisticas de los jugadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugador 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lbJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJugador1.setText("0");

        jLabel1.setText("Ganadas:");

        jLabel2.setText("Perdidas:");

        jLabel3.setText("Empatadas:");

        lbCantGanadasJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCantGanadasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantGanadasJ1.setText("0");

        lbCantPerdidasJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCantPerdidasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantPerdidasJ1.setText("0");

        lbCantEmpatadasJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCantEmpatadasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantEmpatadasJ1.setText("0");

        javax.swing.GroupLayout pEstadisticaJ1Layout = new javax.swing.GroupLayout(pEstadisticaJ1);
        pEstadisticaJ1.setLayout(pEstadisticaJ1Layout);
        pEstadisticaJ1Layout.setHorizontalGroup(
            pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticaJ1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCantGanadasJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lbCantPerdidasJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCantEmpatadasJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pEstadisticaJ1Layout.setVerticalGroup(
            pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticaJ1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCantGanadasJ1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbCantPerdidasJ1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbCantEmpatadasJ1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pEstadisticaJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbJugador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pEstadisticaJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugador 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lbJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJugador2.setText("1");

        jLabel7.setText("Ganadas:");

        jLabel8.setText("Perdidas:");

        jLabel9.setText("Empatadas:");

        lbCantGanadasJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCantGanadasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantGanadasJ2.setText("0");

        lbCantPerdidasJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCantPerdidasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantPerdidasJ2.setText("0");

        lbCantEmpatadasJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCantEmpatadasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCantEmpatadasJ2.setText("0");

        javax.swing.GroupLayout pEstadisticaJ2Layout = new javax.swing.GroupLayout(pEstadisticaJ2);
        pEstadisticaJ2.setLayout(pEstadisticaJ2Layout);
        pEstadisticaJ2Layout.setHorizontalGroup(
            pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticaJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCantGanadasJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lbCantPerdidasJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCantEmpatadasJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pEstadisticaJ2Layout.setVerticalGroup(
            pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticaJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbCantGanadasJ2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbCantPerdidasJ2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbCantEmpatadasJ2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pEstadisticaJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbJugador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pEstadisticaJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btSalirPartida.setText("Salir");
        btSalirPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirPartidaActionPerformed(evt);
            }
        });

        ckVistaEstadisticas.setText("Muestra Estadisticas");
        ckVistaEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckVistaEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckVistaEstadisticas)
                    .addComponent(btSalirPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckVistaEstadisticas))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalirPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseClicked
        if("".equals(matrizJuego[0][0])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb1.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[0][0]="O";
            }else{
                lb1.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[0][0]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb1MouseClicked

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
        if("".equals(matrizJuego[0][1])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb2.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[0][1]="O";
            }else{
                lb2.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[0][1]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb2MouseClicked

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseClicked
        if("".equals(matrizJuego[0][2])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb3.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[0][2]="O";
            }else{
                lb3.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[0][2]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb3MouseClicked

    private void lb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseClicked
        if("".equals(matrizJuego[1][0])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb4.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[1][0]="O";
            }else{
                lb4.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[1][0]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb4MouseClicked

    private void lb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb5MouseClicked
        if("".equals(matrizJuego[1][1])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb5.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[1][1]="O";
            }else{
                lb5.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[1][1]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb5MouseClicked

    private void lb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb6MouseClicked
        if("".equals(matrizJuego[1][2])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb6.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[1][2]="O";
            }else{
                lb6.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[1][2]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb6MouseClicked

    private void lb7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb7MouseClicked
        if("".equals(matrizJuego[2][0])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb7.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[2][0]="O";
            }else{
                lb7.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[2][0]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb7MouseClicked

    private void lb8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb8MouseClicked
        if("".equals(matrizJuego[2][1])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb8.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[2][1]="O";
            }else{
                lb8.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[2][1]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb8MouseClicked

    private void lb9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb9MouseClicked
        if("".equals(matrizJuego[2][2])){
            if(!jugMoviendo.equals(lbJugador1.getText())){
                lb9.setIcon(new ImageIcon(getClass().getResource("/Picture/o128bits.png")));
                matrizJuego[2][2]="O";
            }else{
                lb9.setIcon(new ImageIcon(getClass().getResource("/Picture/x128bits.png")));
                matrizJuego[2][2]="X";
            }
            resultadoGame();
            cambioJugador();
        }
    }//GEN-LAST:event_lb9MouseClicked

    private void btSalirPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirPartidaActionPerformed
        cierreVentana();
    }//GEN-LAST:event_btSalirPartidaActionPerformed

    private void ckVistaEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckVistaEstadisticasActionPerformed
        muestraEstadistica();
    }//GEN-LAST:event_ckVistaEstadisticasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalirPartida;
    private javax.swing.JCheckBox ckVistaEstadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JLabel lb1;
    public static javax.swing.JLabel lb2;
    public static javax.swing.JLabel lb3;
    public static javax.swing.JLabel lb4;
    public static javax.swing.JLabel lb5;
    public static javax.swing.JLabel lb6;
    public static javax.swing.JLabel lb7;
    public static javax.swing.JLabel lb8;
    public static javax.swing.JLabel lb9;
    private javax.swing.JLabel lbCantEmpatadasJ1;
    private javax.swing.JLabel lbCantEmpatadasJ2;
    private javax.swing.JLabel lbCantGanadasJ1;
    private javax.swing.JLabel lbCantGanadasJ2;
    private javax.swing.JLabel lbCantPerdidasJ1;
    private javax.swing.JLabel lbCantPerdidasJ2;
    public static javax.swing.JLabel lbJugador1;
    public static javax.swing.JLabel lbJugador2;
    private javax.swing.JPanel pEstadisticaJ1;
    private javax.swing.JPanel pEstadisticaJ2;
    // End of variables declaration//GEN-END:variables
}
