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
    
    public ConsultaEstadoJuego(){        
    }    
    /**
     *
     * @param matriz
     * @return
     */
    public boolean ConsultaEstadoJuego(String [][] matriz){
        imprimeMatriz(matriz);
        if(consultaColumnas(matriz)){
            return true;
        }else if(consultaFilas(matriz)){
            return true;
        }else if(consultaDiagonales(matriz)){
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
    public boolean consultaColumnas(String[][] m){
        //Recorre y compara las columnas de la matriz
        boolean ganado= false;
        for(int i=0; i < m.length; i++){
            for(int j=0; j < m.length; j++){
                if(!"".equals(m[i][j]) && m[i][j]!=null && !"".equals(m[i+1][j]) && m[i+1][i]!=null
                        && !"".equals(m[i+2][j]) && m[i+2][i]!=null){
                    if(m[i][j].equals(m[i+1][i]) && m[i+1][j].equals(m[i+2][i]) && m[i+2][j].equals(m[i][i])){
                        ganado=true;
                    }else{
                        ganado=false;
                    }
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
            for(int j=0; j < m.length; j++){
                if(!"".equals(m[i][j]) && m[i][j]!=null && !"".equals(m[i][j+1]) && m[i][i+1]!=null
                        && !"".equals(m[i][j+2]) && m[i][i+2]!=null){
                    if(m[i][j].equals(m[i][i+1]) && m[i][j+1].equals(m[i][i+2]) && m[i][j+2].equals(m[i][i])){
                        ganado=true;
                    }else{
                        ganado=false;
                    }
                }else{
                    ganado=false;
                }
            }
        }
        return ganado;
    }
    
    public boolean consultaDiagonales(String [][] m){
        
        return true;
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
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        return matriz;
    }
}
