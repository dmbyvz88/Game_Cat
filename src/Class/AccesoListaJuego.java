/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import GUI_Game.Principal;
import Listas.Lista_Jugadores;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

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
     * Despliega en menú de opciones según la selección realizada previamente
     * @param lista
     * @return
     */
    public Lista_Jugadores menuIngresoJuego(Lista_Jugadores lista){
        if(lista!=null && YES_OPTION==JOptionPane.showConfirmDialog(null, "¿Desea seleccionar un jugador ya existente?.")){
            lista.insertaNodoJugador(jugadores[0]);
            lista.insertaNodoJugador(jugadores[1]=JOptionPane.showInputDialog("Nombre del segundo Jugador: "));
        }else{
            lista.insertaNodoJugador(jugadores[0]=JOptionPane.showInputDialog("Nombre del primer Jugador: "));
            lista.insertaNodoJugador(jugadores[1]=JOptionPane.showInputDialog("Nombre del segundo Jugador: "));
        }
        Principal.listaJugadores=jugadores;
        return lista;
    }
}
