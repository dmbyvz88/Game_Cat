/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class Imagen {
    ImageIcon imagen;
    public ImageIcon Imagen(String direcImagen){
        if(!"".equals(direcImagen)){
            return imagen = new ImageIcon(this.getClass().getResource(direcImagen));
        }else{
            return imagen = new ImageIcon(this.getClass().getResource(direcImagen));
        }
    }
}
