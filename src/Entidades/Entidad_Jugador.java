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
    String nombre;
    int cantGanado;
    public Entidad_Jugador siguiente=null;
    public Entidad_Jugador(){}
    /**
     * Método que captura el nombre del jugador
     * @param jugador
     * @param letra
     */
    public Entidad_Jugador(String jugador){
        this.nombre=jugador;
        this.cantGanado=0;
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
    /**
     * Metodo que envia el nombre del jugador
     * @return
     */
    public int getCantGanado(){
        return this.cantGanado;
    }
    /**
     * Metodo que recoge el nombre del jugador
     * @param cant
     */
    public void setCantGanado(int cant){
        this.cantGanado=cant;
    }
}
