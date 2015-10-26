/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.Adicao;
import Interface.Listar;
import Interface.Login;
import Interface.Pagar;
import Modelos.Alimento;
import Modelos.Bebidas;
import Modelos.Pedidos;
import Modelos.RelatorioVenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class TrataVenda implements ActionListener {
static Pedidos p= new Pedidos(); static Pedidos p1;
static ArrayList<Alimento> alimentos=new ArrayList<>();
static ArrayList<Bebidas> bebidas = new ArrayList<>();
static String lista="",lista1="";
public static int num=0; //Indica o tipo do último item adicionado 1-Comida, 2- Bebida nao alcoolica, 2- bebida alcoolica

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==Interface.Adicao.adicionarC){
            Alimento a= new Alimento();
            adicionarAlimento(a);
    }
    
    
        if(e.getSource()==Interface.Adicao.adicionarBA){
            Bebidas b=new Bebidas();
            adicionarBebida(b);

    }
        
        
                if(e.getSource()==Interface.Adicao.adicionarBNA){
                    Bebidas b=new Bebidas();
                    adicionarBebidaNA(b);
         /*   try {
           // Bebidas b=new Bebidas();
            int iBebidaNA=Interface.Adicao.bebidasN.getSelectedIndex();
            int qtdBebidaNA=Integer.parseInt(Interface.Adicao.quantidadeBNA.getText());
            //String lista="";
           
               Bebidas  aux = ConectaBanco.buscaBebida((String) Adicao.bebidasN.getModel().getSelectedItem()); 
           
            //b.setQtd(Integer.parseInt(Adicao.quantidadeBNA.getText()));
            //System.out.println(b.toString()+b.getQtd());
            if(containsBebida(aux))
              bebidas.get(indexBebida(aux)).setQtd(bebidas.get(indexBebida(aux)).getQtd()+aux.getQtd());
            else
            bebidas.add(new Bebidas(aux.isAlcoolica(),aux.getNome(),aux.getPreco(),qtdBebidaNA));
            num=2;
                
            lista="";
            lista1="";
            lista+=alimentos.toString();
            lista1+=bebidas.toString();
             Interface.Adicao.texto.setText(lista+lista1);
              } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
        if(e.getSource()==Adicao.confirmar){
            try{
             String conc="";
             String  mesa= (String)Adicao.mesas.getSelectedItem();
            for(int i=0;i<mesa.length();i++)
            if(Character.isDigit(mesa.charAt(i)))
            conc+=String.valueOf(mesa.charAt(i));
           int iMesa =Integer.parseInt(conc);
        
            
           
           if(Adicao.confirmar.getText().equals("Confirmar")){
            Pedidos p= new Pedidos(alimentos,bebidas,iMesa);            
            new Ficheiro().escreverPedido(p);
            bebidas.clear();
            alimentos.clear();
            System.out.println(p.toString());
            new Auxiliar.Ficheiro().escreveLiv(iMesa);
            new Auxiliar.Ficheiro().escreveMesaOcup(iMesa);            

            } 
            else{
                String conc1="";
             String  mesa1= (String)Adicao.cbMesasOcup.getSelectedItem();
            for(int i=0;i<mesa1.length();i++)
            if(Character.isDigit(mesa1.charAt(i)))
            conc1+=String.valueOf(mesa1.charAt(i));
           int iMesa1 =Integer.parseInt(conc1);
            Pedidos p= new Pedidos(alimentos,bebidas,iMesa1);
            new Ficheiro().escreverPedido(p);
            System.out.println(p.toString());
            //Pagar.mesas.setModel(Controle.Modelos.modeloMesas());
            //Pagar.tabela.setModel(Modelos.modeloLista(0));
            //Listar.tabela.setModel(Modelos.modeloLista(0));
            //Listar.mesas.setModel(Controle.Modelos.mesasOcupadas());
                
            }
            Adicao.mesas.setModel(new Auxiliar.Ficheiro().mesaLivre());
            Listar.mesas.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            Pagar.mesas.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            Adicao.cbMesasOcup.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            Pagar.tabela.setModel(Modelos.modeloLista(0));
            Listar.tabela.setModel(Modelos.modeloLista(0));

           
            }
            
            
            catch (Exception d){
                d.printStackTrace();
            }
        }
        if(e.getSource()==Login.undo){
            if(num==1&&!alimentos.isEmpty()){
            alimentos.remove(alimentos.size()-1);
            Adicao.texto.setText(alimentos.toString());
            }
            else if(num==2&&!bebidas.isEmpty()) {
                bebidas.remove(bebidas.size()-1);
                Adicao.texto.setText(bebidas.toString());
            }
            else
             JOptionPane.showMessageDialog(null, "Nada adicionado");
        }
        if(e.getSource()==Pagar.pagar){
        try {
             String conc1="";
             String  mesa1= (String)Pagar.mesas.getSelectedItem();
            for(int i=0;i<mesa1.length();i++)
            if(Character.isDigit(mesa1.charAt(i)))
            conc1+=String.valueOf(mesa1.charAt(i));
           int iMesa1 =Integer.parseInt(conc1);
           Double total=0.0;
           try{
               total=Double.parseDouble(Pagar.total.getText());
               
           }  
           catch(java.lang.NumberFormatException d){
               JOptionPane.showMessageDialog(null, "Insira algum valor");
               return;
           }
            if(total-Modelos.total<0){
               JOptionPane.showMessageDialog(null, "Valor Insuficiente");
            return;}
            Pagar.trocos.setText(Double.toString(Double.parseDouble(Pagar.total.getText())-Modelos.total));
            Auxiliar.ConectaBanco.fazerRelatVendas(new RelatorioVenda(Botao.lognome, iMesa1, Modelos.total, new Date()));
            Auxiliar.ConectaBanco.escreveVenda(new Ficheiro().buscaPedidoI(iMesa1));
            new  Ficheiro().apagaPedido(iMesa1); 
            new Auxiliar.Ficheiro().escreveMesaOcup(iMesa1);
            new Auxiliar.Ficheiro().escreveLiv(iMesa1);
            
            Adicao.mesas.setModel(new Auxiliar.Ficheiro().mesaLivre());
            Listar.mesas.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            Pagar.mesas.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            Adicao.cbMesasOcup.setModel(new Auxiliar.Ficheiro().mesaOcupada());
            Pagar.tabela.setModel(Modelos.modeloLista(0));
            Listar.tabela.setModel(Modelos.modeloLista(0));
            JOptionPane.showMessageDialog(null, "Pago");
        } catch (Exception ex) {
            Logger.getLogger(TrataVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
//-------------------------------------De celso---------------------------------------------------------//
        
        
        
    }
    
    public boolean containsBebida(Bebidas b){
        boolean achou=false;
        for(Bebidas iter: bebidas)
            if(iter.getNome().equals(b.getNome()))
                return true;
        return achou;
    }
    
    public boolean containsAlimento(Alimento a){
        boolean achou=false;
        for(Alimento iter: alimentos)
            if(iter.getNome().equals(a.getNome()))
                return true;
        return false;
    }
      
    public int indexAlimento(Alimento a){
          int i;
        for(i=0;i<alimentos.size();i++)
          if(alimentos.get(i).getNome().equals(a.getNome()))
              return i;
        return i;
      }
      
    public int indexBebida(Bebidas b){
          int i;
        for(i=0;i<bebidas.size();i++)
          if(bebidas.get(i).getNome().equals(b.getNome()))
              return i;
        return i;
      }
            
    public void adicionarAlimento(Alimento a){
       // alimentos.clear();
                   try {
            a= ConectaBanco.buscaAlimento((String) Adicao.comidas.getModel().getSelectedItem());
            a.setQtd(Integer.parseInt(Adicao.quantidadeC.getText()));
            System.out.println(a.toString()+a.getQtd());
                System.out.println("Contem alimento"+containsAlimento(a));
                if(containsAlimento(a))
                    alimentos.get(indexAlimento(a)).setQtd(alimentos.get(indexAlimento(a)).getQtd()+a.getQtd());
                else
            alimentos.add(a);            
            num=1;
            lista="";
            lista1="";
            lista=alimentos.toString();
            lista1+=bebidas.toString();
              //Interface.Adicao.texto.setText(new Ficheiro().ler().toString());
              Interface.Adicao.texto.setText(lista+lista1);
                 } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
    public void adicionarBebida(Bebidas b){
       // bebidas.clear();
                    try {
                 b= ConectaBanco.buscaBebida((String) Adicao.bebidas.getModel().getSelectedItem());
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            b.setQtd(Integer.parseInt(Adicao.quantidadeBA.getText()));
            System.out.println(b.toString()+b.getQtd());
            if(containsBebida(b))
                bebidas.get(indexBebida(b)).setQtd(bebidas.get(indexBebida(b)).getQtd()+b.getQtd());
            else
            bebidas.add(b);
            num=2;
            lista="";
            lista1="";
            lista+=alimentos.toString();
            lista1+=bebidas.toString();
                    
               Interface.Adicao.texto.setText(lista+lista1);
               
    }
    
 public void adicionarBebidaNA(Bebidas b){
       // bebidas.clear();
                    try {
                 b= ConectaBanco.buscaBebida((String) Adicao.bebidasN.getModel().getSelectedItem());
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            b.setQtd(Integer.parseInt(Adicao.quantidadeBNA.getText()));
            System.out.println(b.toString()+b.getQtd());
            if(containsBebida(b))
                bebidas.get(indexBebida(b)).setQtd(bebidas.get(indexBebida(b)).getQtd()+b.getQtd());
            else
            bebidas.add(b);
            num=2;
            lista="";
            lista1="";
            lista+=alimentos.toString();
            lista1+=bebidas.toString();
                    
               Interface.Adicao.texto.setText(lista+lista1);
               
    }    

}

