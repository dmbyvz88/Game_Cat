/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * Fecha Inicial Creación 05/03/2016
 * Fecha Finalización Creación 07/04/2016
 * @author Diego Murillo Barrantes
 */
public class Entidad_Jugador {
    String nombre;
    public Entidad_Jugador siguiente=null;
    public Entidad_Jugador(){}
    /**
     * Método que captura el nombre del jugador
     * @param jugador
     */
    public Entidad_Jugador(String jugador){
        this.nombre=jugador;
    }
    /**
     * Metodo que envia el nombre del jugador
     * @return
     */
    public String getJugador(){
        return this.nombre;
    }
    /**
     * Metodo que recoge el nombre del jugador
     * @param jugador
     */
    public void setJugador(String jugador){
        this.nombre=jugador;
    }
}
