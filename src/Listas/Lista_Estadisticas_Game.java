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
    public Entidad_Estadistica primero;
    int cont;
    /**
     * Metodo que permite identificar si la lista se encuentra vacia o no
     * @return
     */
    public boolean esVacia(){
        if(primero==null){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Metodo que permite recolectar el nombre del jugador
     * @param nombre
     * @param cantGanadas
     * @param cantPerdidas
     * @param cantEmpatadas
     */
    public void insertaNodoJugador(String nombre, int cantGanadas, int cantPerdidas, int cantEmpatadas){
        Entidad_Estadistica nuevoNodo=new Entidad_Estadistica(nombre, cantGanadas, cantPerdidas, cantEmpatadas);
        if(esVacia()){
            primero=nuevoNodo;
        }
        else{
            nuevoNodo.siguiente=primero;
            primero=nuevoNodo;
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
            Entidad_Estadistica temporal=primero;
            while(temporal!=null){
                if(temporal.getJugador().equals(jugador)){
                    cant[0]=temporal.getCantGanado();
                    cant[1]=temporal.getCantPerdido();
                    cant[2]=temporal.getCantEmpatado();
                    temporal=temporal.siguiente;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay Jugadores registrados.");
        }
        return cant;
    }
    /**
     * Metodo que permite modificar por medio del nombre del jugador las cantidades de la estadistica
     * @param nombre
     * @param cantGanadas
     * @param cantPerdidas
     * @param cantEmpatadas
     */
    public void modificarNodoJugador(String nombre, int cantGanadas, int cantPerdidas, int cantEmpatadas){
        if(!esVacia()){
            Entidad_Estadistica temporal=primero;
            while(temporal!=null){
                if(nombre.equals(temporal.getJugador())){
                    temporal.setCantGanado(cantGanadas);
                    temporal.setCantGanado(cantPerdidas);
                    temporal.setCantGanado(cantEmpatadas);
                    temporal=temporal.siguiente;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay Jugadores registrados.");
        }
    }
}
