/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Junior
 */
public class Mouse implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        b.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
        b.setContentAreaFilled(true);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        b.setContentAreaFilled(false); //To change body of generated methods, choose Tools | Templates.
    }
    
}
