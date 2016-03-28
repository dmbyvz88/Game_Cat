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
    /**
     * Metodo que compara los datos de la matriz para identificar si se ha ganado o no el juego
     * @param matriz
     * @return
     */
    public boolean consultaEstadoJuego(String [][] matriz){
        imprimeMatriz(matriz);
        if(consultaColumnas(matriz)){
            return true;
        }else if(consultaFilas(matriz)){
            return true;
        }else if(consultaDiagonalPrincipal(matriz)){
            return true;
        }else if(consultaDiagonalSecundaria(matriz)){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Metodo que permite comparar los valores de las columnas entre si
     * @param m
     * @return
     */
    private boolean consultaColumnas(String[][] m){
        //Recorre y compara las columnas de la matriz
        boolean ganado= false;
        for(int i=0; i < m.length; i++){
            if(!"".equals(m[i][0]) && m[i][0]!=null && !"".equals(m[i][1]) && m[i][1]!=null
                    && !"".equals(m[i][2]) && m[i][2]!=null){
                if(m[i][0].equals(m[i][1]) && m[i][1].equals(m[i][2]) && m[i][2].equals(m[i][0])){
                    ganado=true;
                }else{
                    ganado=false;
                }
            }
        }
        return ganado;
    }
    /**
     * Metodo que permite comparar los valores de las filas entre si
     * @param m
     * @return
     */
    private boolean consultaFilas(String [][] m){
        //Recorre y compara las columnas de la matriz
        boolean ganado= false;
        for(int i=0; i < m.length; i++){
            if(!"".equals(m[0][i]) && m[0][i]!=null && !"".equals(m[1][i]) && m[1][i]!=null
                    && !"".equals(m[2][i]) && m[2][i]!=null){
                if(m[0][i].equals(m[1][i]) && m[1][i].equals(m[2][i]) && m[2][i].equals(m[0][i])){
                    ganado=true;
                }else{
                    ganado=false;
                }
            }else{
                ganado=false;
            }
        }
        return ganado;
    }    
    /**
     * Metodo que permite comparar la diagonal principal de la matriz
     * @param m
     * @return
     */
    private boolean consultaDiagonalPrincipal(String [][] m){
        if(!"".equals(m[0][0]) && m[0][0]!=null && !"".equals(m[1][1]) && m[1][1]!=null
                && !"".equals(m[2][2]) && m[2][2]!=null){
            if(m[0][0].equals(m[1][1]) && m[1][1].equals(m[2][2]) && m[2][2].equals(m[0][0])){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }    
    /**
     * Metodo que permite comparar la diagonal secundaria de la matriz
     * @param m
     * @return
     */
    private boolean consultaDiagonalSecundaria(String [][] m){
        if(!"".equals(m[0][2]) && m[0][2]!=null && !"".equals(m[1][1]) && m[1][1]!=null
                && !"".equals(m[2][0]) && m[2][0]!=null){
            if(m[0][2].equals(m[1][1]) && m[1][1].equals(m[2][0]) && m[2][0].equals(m[0][2])){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    } 
    /**
     * Metodo que permite imprimir todos lo valores correspondientes a la matriz
     * @param matriz
     */
    private void imprimeMatriz(String [][] matriz){
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz.length; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * Metodo que permite limpiar los datos que se encuentran almacenados en la matriz
     * @param matriz
     * @return
     */
    public String[][] limpiaMatriz(String [][] matriz){
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz.length; j++){
                matriz[i][j]=null;
            }
            System.out.println();
        }
        return matriz;
    }
}
