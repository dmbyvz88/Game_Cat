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
    public ConsultaEstadoJuego(){        
    }    
    /**
     *
     * @param matriz
     * @return
     */
    public boolean ConsultaEstadoJuego(String [][] matriz){
        imprimeMatriz(matriz);
        //Recorre y compara las filas de la matriz
        for(int i=0; i < matriz.length; i++){
            if(!"".equals(matriz[i][0]) && !"".equals(matriz[i][1]) && !"".equals(matriz[i][2]) 
                    && matriz[i][0]!=null && matriz[i][1]!=null && matriz[i][2]!=null){
                if(matriz[i][0].equals(matriz[i][1]) && matriz[i][0].equals(matriz[i][2])){
                    ganado=true;
                }
                break;
            }
            break;
        }
        //Recorre y compara las columnas de la matriz
        for(int i=0; i < matriz.length; i++){
            if(!"".equals(matriz[0][i]) && !"".equals(matriz[1][i]) && !"".equals(matriz[2][i])
                    && matriz[0][i]!=null && matriz[1][i]!=null && matriz[2][i]!=null){
                if(matriz[0][i].equals(matriz[1][i]) && matriz[0][i].equals(matriz[2][i])){
                    ganado=true;
                }
            }
        }
        //Recorre y compara las columnas de la matriz
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz.length; j++){
                if(i==0 && j==0){
                    if(!"".equals(matriz[i][j]) && !"".equals(matriz[i+1][j+1]) && !"".equals(matriz[i+2][j+2])
                            && matriz[i][j]!=null && matriz[i+1][1+1]!=null && matriz[i+2][i+2]!=null){
                        if(matriz[i][j].equals(matriz[i+1][j+1]) && matriz[i][j].equals(matriz[i+2][j+2])){
                            ganado=true;
                            break;
                        }
                    }
                }else if(i==0 && j==3){
                    if(!"".equals(matriz[i][j]) && !"".equals(matriz[i-1][j-1]) && !"".equals(matriz[i-2][j-2])
                            && matriz[i][j]!=null && matriz[i-1][j-1]!=null && matriz[i-2][j-2]!=null){
                        if(matriz[i][j].equals(matriz[i-1][j-1]) && matriz[i][j].equals(matriz[i-2][j-2])){
                            ganado=true;
                            break;
                        }
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

    /**
     *
     * @param matriz
     * @return
     */
    public String[][] limpiaMatriz(String [][] matriz){
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz.length; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        return matriz;
    }
}
