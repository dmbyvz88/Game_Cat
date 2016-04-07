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
    //private Lista_Jugadores LJ;
    private Lista_Estadisticas_Game LEG;
    private Lista_Jugadores LJ;
    /**
     * Metodo que permite obtener la lista de jugadores al los que se les llevará la estadistica
     * @param lista
     * @param LJ
     * @param LEG
     */
    public Acceso_Estadisticas_Jugadores(String [] lista, Lista_Jugadores LJ, Lista_Estadisticas_Game LEG){
        this.jugadoresActuales=lista;
        this.LJ=LJ;
        this.LEG=LEG;
    }
    /**
     * Metodo que ingresa inicialmente los datos estadistico de cada usuario en la lista
     * @param estadoPartida
     * @param jugadorGanador
     * @param jugadorPerdedor
     * @param jugadores
     * @return
     */
    public Lista_Estadisticas_Game menu_Calcula_Estadisticas_Jugadores(String estadoPartida, String jugadorGanador,
            String jugadorPerdedor, String[] jugadores){
        this.jugadoresActuales=jugadores;
        int [] cantidadesJ1;
        int [] cantidadesJ2;
        switch(estadoPartida){
            case "Ganada"://Registra los Jugadores que desean jugar
                cantidadesJ1=LEG.consultaCantidades(jugadores[0]);
                cantidadesJ2=LEG.consultaCantidades(jugadores[1]);
                if(LEG.existenciaJugadorEstadistica(jugadorGanador) 
                        && LEG.existenciaJugadorEstadistica(jugadorPerdedor)){
                    if(jugadorGanador.equals(jugadores[0])){
                        cantidadesJ1[0]=cantidadesJ1[0]+1;
                        cantidadesJ2[1]=cantidadesJ2[1]+1;
                    }else if(jugadorGanador.equals(jugadores[1])){
                        cantidadesJ1[1]=cantidadesJ1[1]+1;
                        cantidadesJ2[0]=cantidadesJ2[0]+1;
                    }
                    LEG.modificarNodoJugador(jugadorGanador, cantidadesJ1);
                    LEG.modificarNodoJugador(jugadorPerdedor, cantidadesJ2);
                }else{
                    cantidadesJ1[0]=cantidadesJ1[0]+1;
                    cantidadesJ2[1]=cantidadesJ2[1]+1;
                    LEG.insertaNodoJugador(jugadorGanador, cantidadesJ1);
                    LEG.insertaNodoJugador(jugadorPerdedor, cantidadesJ2);
                }
                break;
            case "Empatada":
                cantidadesJ1=LEG.consultaCantidades(this.jugadoresActuales[0]);
                cantidadesJ2=LEG.consultaCantidades(jugadores[1]);
                if(LEG.existenciaJugadorEstadistica(jugadorGanador)){
                    cantidadesJ1[0]=cantidadesJ1[2]+1;
                    cantidadesJ2[1]=cantidadesJ2[2]+1;
                    LEG.modificarNodoJugador(jugadorGanador, cantidadesJ1);
                    LEG.modificarNodoJugador(jugadorPerdedor, cantidadesJ2);
                }else{
                    cantidadesJ1[0]=cantidadesJ1[2]+1;
                    cantidadesJ2[1]=cantidadesJ2[2]+1;
                    LEG.insertaNodoJugador(jugadorGanador, cantidadesJ1);
                    LEG.insertaNodoJugador(jugadorPerdedor, cantidadesJ2);
                }
                break;
        }
        return LEG;
    }
}
