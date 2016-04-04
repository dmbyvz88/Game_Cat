/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Game;

import Class_Logic.ConsultaEstadoJuego;
import Class_Logic.RigaInicioPartida;
import Listas.Lista_Estadisticas_Game;
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
    
    /**
     * Creates new form Ven_Juego
     * @param matrizJuego
     * @param jugadores
     * @param jugMoviendo
     * @param LGE
     */
    public Ven_Juego(String [][] matrizJuego, String[] jugadores, String jugMoviendo, Lista_Estadisticas_Game LGE) {
        this.LEG=LGE;
        this.jugadores=jugadores;
        this.matrizJuego=matrizJuego;
        this.jugMoviendo=jugMoviendo;
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
    public void cierreVentana(){
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
    public void envioDatosPrincipal(){
        Principal.matrizJuegoPendiente=matrizJuego;
        Principal.listaJugadores[0]=jugadores[0];
        Principal.listaJugadores[1]=jugadores[1];
        Principal.jugMoviendo=jugMoviendo;
        //Principal.cargaObjetos();
    }
    /**
     *
     */
    public void muestraEstadistica(){
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbJugador2 = new javax.swing.JLabel();
        pEstadisticaJ2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0");

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
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pEstadisticaJ1Layout.setVerticalGroup(
            pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticaJ1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("0");

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
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pEstadisticaJ2Layout.setVerticalGroup(
            pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticaJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticaJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalirPartida)
                    .addComponent(ckVistaEstadisticas))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ckVistaEstadisticas)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalirPartida, javax.swing.GroupLayout.Alignment.TRAILING))
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    public static javax.swing.JLabel lbJugador1;
    public static javax.swing.JLabel lbJugador2;
    private javax.swing.JPanel pEstadisticaJ1;
    private javax.swing.JPanel pEstadisticaJ2;
    // End of variables declaration//GEN-END:variables
}
