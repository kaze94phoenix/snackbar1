/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Interface.Adicao;
import Interface.Listar;
import Interface.Pagar;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Item implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			//Seleccionando pedido
			if(e.getSource()==Listar.mesas){
                            
                            String conc="";
                            String  mesa= (String)Listar.mesas.getSelectedItem();
                                for(int i=0;i<mesa.length();i++)
                                    if(Character.isDigit(mesa.charAt(i)))
                                        conc+=String.valueOf(mesa.charAt(i));
                                            int iMesa =Integer.parseInt(conc);
				//int iMesa=Interface.Listar.mesas.getSelectedIndex();
                            try {
                                Interface.Listar.tabela.setModel(Modelos.modeloLista(iMesa));
                            } catch (Exception ex) {
                                Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
                            }
		}
                if(e.getSource()==Pagar.mesas){
                    
                            String conc="";
                            String  mesa= (String)Pagar.mesas.getSelectedItem();
                                for(int i=0;i<mesa.length();i++)
                                    if(Character.isDigit(mesa.charAt(i)))
                                        conc+=String.valueOf(mesa.charAt(i));
                                            int iMesa =Integer.parseInt(conc);
				//int iMesas=Interface.Pagar.mesas.getSelectedIndex();
                            try {
                                Interface.Pagar.tabela.setModel(Modelos.modeloLista(iMesa));
                            } catch (Exception ex) {
                                Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
                            }
		}	
			
	}//Fim do tratementos de eventos de itens
}