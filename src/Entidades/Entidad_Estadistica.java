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
public class Entidad_Estadistica {
    private String jugador;
    private int cantGanado, cantPerdido, cantEmpatado;
    public Entidad_Estadistica siguiente=null;

    /**
     * Metodo principal que recolecta los datos estadisticos del jugador
     * @param jugador
     * @param cantGanado
     * @param cantPerdido
     * @param cantEmpatado
     */
    public Entidad_Estadistica(String jugador, int cantGanado, int cantPerdido, int cantEmpatado){
        this.jugador=jugador;
        this.cantGanado=cantGanado;
        this.cantPerdido=cantPerdido;
        this.cantEmpatado=cantEmpatado;
    }
    /**
     * Metodo que envia el nombre del jugador
     * @return
     */
    public String getJugador(){
        return this.jugador;
    }
    /**
     * Metodo que guarda la cantidad de veces que el jugador a ganado
     * @param jugador
     */
    public void setJugador(String jugador){
        this.jugador=jugador;
    }
    /**
     * Metodo que recoge el nombre del jugador
     * @param cantGanado
     */
    public void setCantGanado(int cantGanado){
        this.cantGanado=cantGanado;
    }
    /**
     * Metodo que envia la cantidad de veces que el jugador a ganado
     * @return
     */
    public int getCantGanado(){
        return this.cantGanado;
    }
    /**
     * Metodo que guarda la cantidad de veces que el jugador a perdido
     * @param cantPerdido
     */
    public void setCantPerdido(int cantPerdido){
        this.cantPerdido=cantPerdido;
    }
    /**
     * Metodo que envia la cantidad de veces que el jugador a perdido
     * @return
     */
    public int getCantPerdido(){
        return this.cantPerdido;
    }
    /**
     * Metodo que guarda la cantidad de veces que el jugador a empatado
     * @param cantEmpatado
     */
    public void setCantEmpatado(int cantEmpatado){
        this.cantEmpatado=cantEmpatado;
    }
    /**
     * Metodo que envia la cantidad de veces que el jugador a empatado
     * @return
     */
    public int getCantEmpatado(){
        return this.cantEmpatado;
    }
}
