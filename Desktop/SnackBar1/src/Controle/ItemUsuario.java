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
import javax.swing.JOptionPane;

public class ItemUsuario implements ItemListener{
		public void itemStateChanged(ItemEvent e){
	
                        if(e.getStateChange()==ItemEvent.SELECTED){
                            int iUsuario=Interface.AdicionarU.lista.getSelectedIndex();
                            Controle.Modelos.preencheCamposU(iUsuario);
                        }
			
	}//Fim do tratementos de eventos de itens
                
}