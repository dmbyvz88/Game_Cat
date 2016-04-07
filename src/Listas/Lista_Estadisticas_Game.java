/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import Entidades.Entidad_Estadistica;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Lista_Estadisticas_Game {
    public Entidad_Estadistica primeroEstadistica;
    int cont;
    /**
     * Metodo que permite identificar si la lista se encuentra vacia o no
     * @return
     */
    public boolean esVacia(){
        if(primeroEstadistica==null){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Metodo que permite recolectar el nombre del jugador
     * @param nombre
     * @param cantidades
     */
    public void insertaNodoJugador(String nombre, int [] cantidades){
        Entidad_Estadistica nuevoNodo=new Entidad_Estadistica(nombre, cantidades[0], cantidades[1], cantidades[2]);
        if(esVacia()){
            primeroEstadistica=nuevoNodo;
        }
        else{
            nuevoNodo.siguiente=primeroEstadistica;
            primeroEstadistica=nuevoNodo;
        }
        cont++;
    }
    /**
     * Metodo que permite mostrar los datos esta disticos del jugador deseado, estos datos se retornan en un arreglo
     * @param jugador
     * @return
     */
    public int[] consultaCantidades(String jugador){
        int [] cant= new int[3];
        if(!esVacia()){
            Entidad_Estadistica temporal=primeroEstadistica;
            while(temporal!=null){
                if(temporal.getJugador().equals(jugador)){
                    cant[0]=temporal.getCantGanado();
                    cant[1]=temporal.getCantPerdido();
                    cant[2]=temporal.getCantEmpatado();
                }
                temporal=temporal.siguiente;
            }
        }
        return cant;
    }
    /**
     * Metodo que permite modificar por medio del nombre del jugador las cantidades de la estadistica
     * @param nombre
     * @param cantidades
     */
    public void modificarNodoJugador(String nombre, int [] cantidades){
        if(!esVacia()){
            Entidad_Estadistica temporal=primeroEstadistica;
            while(temporal!=null){
                if(nombre.equals(temporal.getJugador())){
                    temporal.setCantGanado(cantidades[0]);
                    temporal.setCantPerdido(cantidades[1]);
                    temporal.setCantEmpatado(cantidades[2]);
                }
                temporal=temporal.siguiente;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay Jugadores registrados.");
        }
    }
    /**
     * Metodo que consulta si existe o no el jugador
     * @param nomJugador
     * @return
     */
    public boolean existenciaJugadorEstadistica(String nomJugador){
        boolean existencia = false;
        Entidad_Estadistica temporal=primeroEstadistica;
        while(temporal!=null){
            if(nomJugador.equals(temporal.getJugador())){
                existencia=true;
                break;
            }
            temporal=temporal.siguiente;
        }
        return existencia;
    }
}
