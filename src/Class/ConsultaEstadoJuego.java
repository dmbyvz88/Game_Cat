/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Diego
 */
public class ConsultaEstadoJuego {
    boolean ganado= false;
    public boolean ConsultaEstadoJuego(String [][] matriz){
        imprimeMatriz(matriz);
        //Recorre y compara las filas de la matriz
        for(int i=0; i < matriz.length; i++){
            if(matriz[i][0].equals(matriz[i][1]) && matriz[i][0].equals(matriz[i][2])){
                ganado=true;
            }
        }
        //Recorre y compara las columnas de la matriz
        for(int i=0; i < matriz.length; i++){
            if(matriz[0][i].equals(matriz[1][i]) && matriz[0][i].equals(matriz[2][i])){
                ganado=true;
            }
        }
        //Recorre y compara las columnas de la matriz
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz.length; j++){
                if(i==0 && j==0){
                    if(matriz[i][j].equals(matriz[i+1][j+1]) && matriz[i][j].equals(matriz[i+2][j+2])){
                        ganado=true;
                        break;
                    }
                }else if(i==0 && j==3){
                    if(matriz[i][j].equals(matriz[i+1][j-1]) && matriz[i][j].equals(matriz[i+2][j-2])){
                        ganado=true;
                        break;
                    }
                }
            }
        }
        return ganado;
    }
    private void imprimeMatriz(String [][] matriz){
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz.length; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
