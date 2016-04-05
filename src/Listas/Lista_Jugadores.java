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
 * @author Diego
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
     * Metodo que permite eliminar un nodo de la lista
     * @param nombreJugador
     */
    public void eliminaNodoJugador(String nombreJugador){
        if(!esVacia()){
            Entidad_Jugador anterior=primero;  //Creo un anterior de la clase para usarlo solo aqui
            Entidad_Jugador temporal=primero;  //Creo un temporal en el nodo para usarlo aqui
            //Primero esenario, es si el primero nodo jugador es el que estamos buscando, por lo que lo elimina
            if (nombreJugador.equals(temporal.getJugador()) && primero.siguiente==null){
                primero=null;
                cont=0;
            }else if(nombreJugador.equals(temporal.getJugador()) && primero.siguiente!=null){
                primero=primero.siguiente;
                temporal=null;
                cont--;
            }else{
                while(temporal!=null){
                    anterior=temporal;
                    temporal=temporal.siguiente;
                    if (nombreJugador.equals(temporal.getJugador())){
                        anterior.siguiente=temporal.siguiente;
                        temporal=null;
                        cont--;
                    }
                }
            }
        }
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
    /**
     * Metodo que permite mostrar la lista de los jugadores
     * @param jugador
     * @return 
     */
    public boolean existenciaJugador(String jugador){
        boolean encontrado=false;
        if(!esVacia()){
            Entidad_Jugador temporal=primero;
            while(temporal!=null){
                if(temporal.getJugador().equals(jugador)){
                    encontrado=true;
                    break;
                }else{
                    temporal=temporal.siguiente;
                }
            }
        }
        return encontrado;
    }
}
