/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Logic;

import GUI_Game.Principal;
import Listas.Lista_Jugadores;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class AccesoListaJuego {
    Lista_Jugadores estadJugadores;
    String [][] matrizJuegoPendiente;
    String [] jugadores = new String[2];
    
    public AccesoListaJuego(Lista_Jugadores lista){
        this.estadJugadores=lista;
    }
    /**
     * Metodo que carga jugadores nuevos a la lista
     * @param lista
     * @return
     */
    public Lista_Jugadores ingresoJugadoresNews(Lista_Jugadores lista){
        lista.insertaNodoJugador(jugadores[0]=JOptionPane.showInputDialog("Nombre del primer Jugador: "));
        lista.insertaNodoJugador(jugadores[1]=JOptionPane.showInputDialog("Nombre del segundo Jugador: "));
        Principal.listaJugadores=jugadores;
        return lista;
    }
}
