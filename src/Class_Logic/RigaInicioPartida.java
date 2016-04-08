/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Logic;

import java.util.Random;

/**
 *
 * Fecha Inicial Creación 05/03/2016
 * Fecha Finalización Creación 07/04/2016
 * @author Diego Murillo Barrantes
 */
public class RigaInicioPartida {
    String jugador1;
    String jugador2;
    int j1=0;
    int j2=0;
    String ganador;
    /**
     * Metodo que permite rifar cual jugador inicia el juego y la asignación de la "X" y "O"
     * @param jugador1
     * @param jugador2
     * @return
     */
    public String RigaInicioPartida(String jugador1, String jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
        rifa();
        return ganador;
    }
    /**
     * Metodo que asigna numero al azar a cada jugador
     */
    private void rifa(){
        Random rando = new Random();
        j1=rando.nextInt(6);
        j2=rando.nextInt(6);
        comparaGanador();
    }
    /**
     * Metodo que compara el valor obtenido por el random, el numero mayor obtenido es quien empieza la partida
     */
    private void comparaGanador(){
        if(j1>j2){
            ganador=jugador1;
        }else{
            ganador=jugador2;
        }
    }
}
