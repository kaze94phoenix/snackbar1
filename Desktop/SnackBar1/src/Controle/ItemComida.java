/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaara-X
 */
public class ItemComida implements ItemListener {
 public void itemStateChanged(ItemEvent e){
			//Seleccionando pedido
			if(e.getStateChange()==ItemEvent.SELECTED){
				int iComida=Interface.AdicionarP.lista.getSelectedIndex();
                           try {
                                
                                Controle.Modelos.preencheCamposC(iComida);
                            } catch (Exception ex) {
                                Logger.getLogger(ItemUsuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
		}
                     
                
}      
}
