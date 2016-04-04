/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Logic;

import Listas.Lista_Estadisticas_Game;
import Listas.Lista_Jugadores;

/**
 *
 * @author Diego
 */
public class Acceso_Estadisticas_Jugadores {
    private String [] jugadoresActuales;
    private Lista_Jugadores listaJugadores;
    private Lista_Estadisticas_Game LEG;
    /**
     * Metodo que permite obtener la lista de jugadores al los que se les llevará la estadistica
     * @param lista
     * @param listaJugadores
     * @param LEG
     */
    public Acceso_Estadisticas_Jugadores(String [] lista, Lista_Jugadores listaJugadores, Lista_Estadisticas_Game LEG){
        this.jugadoresActuales=lista;
        this.listaJugadores=listaJugadores;
        this.LEG=LEG;
    }
    /**
     * Metodo que ingresa inicialmente los datos estadistico de cada usuario en la lista
     * @param partida
     * @return
     */
    public Lista_Estadisticas_Game menu_Estadisticas_Jugadores(String partida){
        switch(partida){
            case "Ganada"://Registra los Jugadores que desean jugar
                LEG.insertaNodoJugador(this.jugadoresActuales[0], 0, 0, 0);
                LEG.insertaNodoJugador(this.jugadoresActuales[0], 0, 0, 0);
                break;
            case "Perdida":
                
                break;
            case "Empatada":
                
                break;
        }
        LEG.insertaNodoJugador(this.jugadoresActuales[0], 0, 0, 0);
        LEG.insertaNodoJugador(this.jugadoresActuales[0], 0, 0, 0);
        return LEG;
    }
}
