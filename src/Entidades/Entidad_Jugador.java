/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Diego
 */
public class Entidad_Jugador {
    String jugador;
    public Entidad_Jugador siguiente=null;
    public Entidad_Jugador(){}
    /**
     * Método que captura el nombre del jugador
     * @param jugador
     */
    public Entidad_Jugador(String jugador){
        this.jugador=jugador;
    }
    /**
     * Metodo que envia el nombre del jugador
     * @return
     */
    public String getJugador(){
        return this.jugador;
    }
    /**
     * Metodo que recoge el nombre del jugador
     * @param jugador
     */
    public void setJugador(String jugador){
        this.jugador=jugador;
    }
}
