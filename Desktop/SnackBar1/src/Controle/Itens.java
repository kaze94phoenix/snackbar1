/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.AdicionarU;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class Itens implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
    if(e.getSource()==Interface.AdicionarP.lista){
      JComboBox c = (JComboBox)e.getSource();
       String t = c.getSelectedItem().toString();
      if(Controle.Botao.num==0){
 int resultado= JOptionPane.showConfirmDialog (null, "Gostaria de remover o item"+c.getSelectedItem(),"Aviso",JOptionPane.YES_NO_OPTION);
 if(resultado==JOptionPane.YES_OPTION){
     //remove o elemento
    // JOptionPane.showMessageDialog(c, "Removido");
 }
      }
      else if(Controle.Botao.num==1){
          try {
              Interface.AdicionarP.poeDadosA(ConectaBanco.buscaAlimento(t));
          } catch (SQLException ex) {
              Logger.getLogger(Itens.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     
      System.out.println(""+t);
    }
    if(e.getSource()==Interface.AdicionarU.lista){        
        System.out.println("lista");
       JComboBox c = (JComboBox)e.getSource();
       String t = c.getSelectedItem().toString(); 
       if(Controle.Botao.num==0){
            int resultado= JOptionPane.showConfirmDialog (null, "Gostaria de remover o item"+c.getSelectedItem(),"Aviso",JOptionPane.YES_NO_OPTION);
            if(resultado==JOptionPane.YES_OPTION){

                try {
                    ConectaBanco.eliminarUsuario(AdicionarU.lista.getSelectedIndex());
                    AdicionarU.lista.setModel(Modelos.listaUsuarios());
                    AdicionarU.tabela.setModel(Modelos.modeloU());
                } catch (Exception ex) {
                    Logger.getLogger(Itens.class.getName()).log(Level.SEVERE, null, ex);
                }
                    // JOptionPane.showMessageDialog(c, "Estah aqui");

     //remove o elemento

 }
        else if(Controle.Botao.num==1){
                  //  Interface.AdicionarU.poeDadosU(ConectaBanco.buscaUsuario(t));
                    int iUsuario=Interface.AdicionarU.lista.getSelectedIndex();
                    Controle.Modelos.preencheCamposU(iUsuario);
                    

      }
    }
    }

    
    }
    
}
