/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.Random;

/**
 *
 * @author Diego
 */
public class RigaInicioPartida {
    String [] jugador1=new String[2];
    String [] jugador2=new String[2];
    String ganador;
    public String RigaInicioPartida(String jugador1, String jugador2){
        this.jugador1[0]=jugador1;
        this.jugador2[0]=jugador2;
        rifa();
        return ganador;
    }
    private void rifa(){
        Random rando = new Random();
        jugador1[1]=String.valueOf(rando.nextInt(6));
        jugador2[1]=String.valueOf(rando.nextInt(6));
        comparaGanador();
    }
    private void comparaGanador(){
        if(Integer.parseInt(jugador1[1])>Integer.parseInt(jugador2[1])){
            ganador=jugador1[0];
        }else{
            ganador=jugador2[0];
        }
    }
}
