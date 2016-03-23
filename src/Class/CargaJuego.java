/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Listas.Lista_Jugadores;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class CargaJuego {
    Lista_Jugadores estadJugadores;
    private String[] listaJugadores;
    public CargaJuego(Lista_Jugadores lista){
        this.estadJugadores=lista;
    }
    /**
     * Despliega en menú de opciones según la selección realizada previamente
     * @param opc
     * @param lista
     * @return
     */
    public Lista_Jugadores menuIngresoJuego(int opc, Lista_Jugadores lista){
        estadJugadores=lista;
        switch(opc){
            case 1:
                //Registra los Jugadores que desean jugar
                estadJugadores.insertaNodoJugador(JOptionPane.showInputDialog("Nombre del primer Jugador: "));
                estadJugadores.insertaNodoJugador(JOptionPane.showInputDialog("Nombre del segundo Jugador: "));
                break;
            case 2:
                
                break;
            case 3:
                listaJugadores=estadJugadores.mostrarListaJugadores();
                JOptionPane.showMessageDialog(null, "Los Jugadores actuales son: \n"
                        + listaJugadores[0] +"\n" +listaJugadores[1]);
                break;
        }
        return estadJugadores;
    }
}
