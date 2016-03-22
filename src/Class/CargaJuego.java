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
    Lista_Jugadores estadJugadores = new Lista_Jugadores();
    private String[] listaJugadores;
    /**
     * Despliega en menú de opciones según la selección realizada previamente
     * @param opc
     * @return
     */
    public boolean menuIngresoJuego(int opc){
        boolean valido=false;
        switch(opc){
            case 1:
                //Registra los Jugadores que desean jugar
                estadJugadores.cargaJugadores(JOptionPane.showInputDialog("Nombre del primer Jugador: "), 
                JOptionPane.showInputDialog("Nombre del segundo Jugador: "));
                valido=true;
                break;
            case 2:
                
                valido=true;
                break;
            case 3:
                listaJugadores=estadJugadores.mostrarListaJugadores();
                JOptionPane.showMessageDialog(null, "Los Jugadores actuales son: \n"
                        + listaJugadores[0] +"\n" +listaJugadores[0]);
                valido=true;
                break;
        }
        return valido;
    }
}
