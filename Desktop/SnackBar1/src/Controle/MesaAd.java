/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.Adicao;
import Interface.Listar;
import Interface.Pagar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Junior
 */
public class MesaAd implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {
   new Auxiliar.Ficheiro().escreverMesas((Integer) Interface.Gestao.spin.getValue());
            
       //Integer.parseInt((String) Interface.Gestao.spin.getValue())
   if(Interface.Gestao.num<(Integer) Interface.Gestao.spin.getValue())
    new Auxiliar.Ficheiro().escreveLiv((Integer) Interface.Gestao.spin.getValue());
   else
       new Auxiliar.Ficheiro().escreveLiv((Integer) Interface.Gestao.spin.getValue()+1);
                System.out.println("das config"+new Auxiliar.Ficheiro().config().getMesas());
            System.out.println(new Auxiliar.Ficheiro().listaMesas());
            System.out.println("Livres"+ new Auxiliar.Ficheiro().listaMesasLiv());
            System.out.println("Livres"+ new Auxiliar.Ficheiro().listaMesasOcup());
             Interface.Gestao.num=(Integer) Interface.Gestao.spin.getValue();
             Adicao.mesas.setModel(new Auxiliar.Ficheiro().mesaLivre());
            //Listar.mesas.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            //Pagar.mesas.setModel(new Auxiliar.Ficheiro().mesaOcupada());
    
    }
    
}
