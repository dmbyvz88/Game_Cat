/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Gato;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Diego
 */
public class Panel extends JPanel{
    ImageIcon imagen;
    String nombre;
    public Panel(String direccion){
        this.nombre=direccion;
    }
    @Override
    public void paint(Graphics g){
        Dimension tamaño=getSize();
        imagen=new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(),0,0, tamaño.width, tamaño.height, null);
        setOpaque(true);
        super.paint(g);
    }
}
