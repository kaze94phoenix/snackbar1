/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author stddmi1
 */
public class Restricao implements KeyListener {
                  /*  String caracteres="0987654321/";
                if(!caracteres.contains(e.getKeyChar()+"")){
                    e.consume(); */

    @Override
    public void keyTyped(KeyEvent e) {
        if((e.getComponent()==AdicionarU.username)||(e.getComponent()==AdicionarU.senha)){
            String caracteres="qwertyuiopasdfghjklçzxcvbnm098765432/";
            if(!caracteres.contains(e.getKeyChar()+""))
            e.consume();
            }
        else{
        String caracteres="0987654321/";
        if(!caracteres.contains(e.getKeyChar()+"")){
            e.consume();
        }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
