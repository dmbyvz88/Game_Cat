package Listas;

import Entidades.Entidad_Jugador;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Fecha Inicial Creación 05/03/2016
 * Fecha Finalización Creación 07/04/2016
 * @author Diego Murillo Barrantes
 */
public class Lista_Jugadores {
    public Entidad_Jugador primero;
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
     */
    public void insertaNodoJugador(String nombre){
        Entidad_Jugador nuevoNodo=new Entidad_Jugador(nombre);
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
     * Metodo que permite mostrar la lista de los jugadores
     * @return 
     */
    public String[] mostrarListaJugadores(){
        String [] jugadores = new String[cont];
        int cuenta=0;
        if(!esVacia()){
            Entidad_Jugador temporal=primero;
            while(temporal!=null){
                if(cuenta<cont){
                    jugadores[cuenta]=temporal.getJugador();
                    temporal=temporal.siguiente;
                    cuenta++;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay Jugadores registrados.");
        }
        return jugadores;
    }
}
