/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import GUI_Game.Principal;
import Listas.Lista_Jugadores;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class CargaJuego {
    Lista_Jugadores estadJugadores;
    String [][] matrizJuegoPendiente;
    String [] jugadores = new String[2];
    public CargaJuego(Lista_Jugadores lista){
        this.estadJugadores=lista;
    }
    /**
     * Despliega en menú de opciones según la selección realizada previamente
     * @param lista
     * @return
     */
    public Lista_Jugadores menuIngresoJuego(Lista_Jugadores lista){
        lista.insertaNodoJugador(jugadores[0]=JOptionPane.showInputDialog("Nombre del primer Jugador: "));
        lista.insertaNodoJugador(jugadores[1]=JOptionPane.showInputDialog("Nombre del segundo Jugador: "));
        Principal.listaJugadores=jugadores;
        return lista;
    }
    /**
     *
     * @param matriz
     * @return
     */
    public boolean validaMatrizJuego(String [][] matriz){
        boolean valido=false;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                if(!"".equals(matriz[i][j])){
                    valido= true;
                }
            }
        }
        return valido;
    }
}
