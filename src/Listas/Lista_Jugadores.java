package Listas;


import Entidades.Entidad_Jugador;

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
    }
    /**
     * Metodo que permite eliminar un nodo de la lista
     * @param nombreJugador
     */
    public void eliminaNodo(String nombreJugador){
        if(!esVacia()){
            Entidad_Jugador anterior=primero;  //Creo un anterior de la clase para usarlo solo aqui
            Entidad_Jugador temporal=primero;  //Creo un temporal en el nodo para usarlo aqui
            //Primero esenario, es si el primero nodo jugador es el que estamos buscando, por lo que lo elimina
            if (nombreJugador.equals(temporal.getJugador()) && primero.siguiente==null){
                primero=null;
            }else if(nombreJugador.equals(temporal.getJugador()) && primero.siguiente!=null){
                primero=primero.siguiente;
                temporal=null;
            }else{
                while(temporal!=null){
                    
                }
            }
        }
    }
}
