/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Interface.Adicao;
import Interface.AdicionarP;
import Interface.AdicionarU;
import Interface.Gestao;
import Interface.Inicio;
import Interface.Listar;
import Interface.Login;
import Interface.Pagar;
import Modelos.Alimento;
import Modelos.Bebidas;
import Modelos.Mesas;
import Modelos.Pedidos;
import Modelos.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class Botao implements ActionListener {
//public static ArrayList<Pedidos> pedidos = new ArrayList<>();
public static int num=0;
static Pedidos pedidos = new Pedidos();
static ArrayList<Alimento> comidas = new ArrayList<>();
static ArrayList<Bebidas> bebidas = new ArrayList<>();
static Ficheiro file = new Ficheiro();
public static String lognome="";
//static ArrayList<Bebidas> bebidasA = new ArrayList<>();
//int iMesa=Interface.Adicao.cbMesas.getSelectedIndex();
//int qtdBebidaNA=Integer.parseInt(Interface.Adicao.quantidadeBNA.getText());
//int qtdBebidaA=Integer.parseInt(Interface.Adicao.quantidadeBA.getText());

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login.ajuda){
            try {
                Runtime.getRuntime().exec("cmd /c start C:\\Users\\Gaara-X\\Desktop\\SnackBar1\\src\\Interface\\Ajuda.pdf");
            } catch (IOException ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        if(e.getSource()==Inicio.adicionar){
            //Inicio.listar1();
        Inicio.adicionar.setContentAreaFilled(true);
        Inicio.adicionar.setBackground(Inicio.cor);
        Inicio.gestao.setContentAreaFilled(false);
        Inicio.gestao.setBackground(Color.WHITE);
        Inicio.pagar.setContentAreaFilled(false);
        Inicio.pagar.setBackground(Color.WHITE);
        Inicio.listar.setContentAreaFilled(false);
        Inicio.listar.setBackground(Color.WHITE);
        Inicio.listar.setIcon(Inicio.IListar);
        Inicio.gestao.setIcon(Inicio.IGestao);
        Inicio.adicionar.setIcon(Inicio.IAdicionar1);
        Inicio.pagar.setIcon(Inicio.IPagar);
        Inicio.cartas.show(Inicio.baralho, "Adicao");
            System.out.println("carta adicionar");
        }
        if(e.getSource()==Inicio.gestao){
            Inicio.gestao.setContentAreaFilled(true);
            Inicio.gestao.setBackground(Inicio.cor);
            Inicio.adicionar.setContentAreaFilled(false);
            Inicio.adicionar.setBackground(Color.WHITE);
            Inicio.pagar.setContentAreaFilled(false);
            Inicio.pagar.setBackground(Color.WHITE);
            Inicio.listar.setContentAreaFilled(false);
            Inicio.listar.setBackground(Color.WHITE);
            Inicio.listar.setIcon(Inicio.IListar);
            Inicio.gestao.setIcon(Inicio.IGestao1);
            Inicio.adicionar.setIcon(Inicio.IAdicionar);
            Inicio.pagar.setIcon(Inicio.IPagar);
            Inicio.cartas.show(Inicio.baralho, "Gestao");
        }
        if(e.getSource()==Inicio.listar){
            Inicio.gestao.setContentAreaFilled(false);
            Inicio.gestao.setBackground(Color.WHITE);
            Inicio.gestao.setIcon(Inicio.IGestao);
            Inicio.adicionar.setContentAreaFilled(false);
            Inicio.adicionar.setBackground(Color.WHITE);
            Inicio.adicionar.setIcon(Inicio.IAdicionar);
            Inicio.pagar.setContentAreaFilled(false);
            Inicio.pagar.setBackground(Color.WHITE);
            Inicio.listar.setContentAreaFilled(true);
            Inicio.listar.setBackground(Inicio.cor);
            Inicio.listar.setIcon(Inicio.IListar1);
            Inicio.pagar.setIcon(Inicio.IPagar);
            Inicio.cartas.show(Inicio.baralho, "Listar");
            Listar.imprimir.setVisible(true);
            System.out.println("carta Listar");
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
        if(e.getSource()==Inicio.pagar){
            Inicio.gestao.setContentAreaFilled(false);
            Inicio.gestao.setBackground(Color.WHITE);
            Inicio.adicionar.setContentAreaFilled(false);
            Inicio.adicionar.setBackground(Color.WHITE);
            Inicio.pagar.setContentAreaFilled(true);
            Inicio.pagar.setBackground(Inicio.cor);
            Inicio.listar.setContentAreaFilled(false);
            Inicio.listar.setBackground(Color.WHITE);
            Inicio.listar.setIcon(Inicio.IListar);
            Inicio.gestao.setIcon(Inicio.IGestao);
            Inicio.adicionar.setIcon(Inicio.IAdicionar);
            Inicio.pagar.setIcon(Inicio.IPagar1);
            Inicio.cartas.show(Inicio.baralho, "Pagar");
            Listar.imprimir.setVisible(false);
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
        if(e.getSource()==Gestao.busers){
            new AdicionarU();
        }
        if(e.getSource()==Gestao.bpratos){
            new AdicionarP();  
        }
        
        if(e.getSource()==AdicionarU.gravar){
            boolean passa;
                        try {
                             if(num==1){
                                     ConectaBanco.editarUsuario(Interface.AdicionarU.lista.getSelectedIndex());
                                     AdicionarU.lista.setModel(Modelos.listaUsuarios());
                                     AdicionarU.tabela.setModel(Modelos.modeloU());
                       return; }
                            if(AdicionarU.DadosU().getEmail().contains("@") && AdicionarU.DadosU().getEmail().contains(".")){
                                ConectaBanco.inserirUsuario(AdicionarU.DadosU());
                                AdicionarU.tabela.setModel(Modelos.modeloU());
                                AdicionarU.lista.setModel(Modelos.listaUsuarios());                    
                                System.out.println(ConectaBanco.lerUsuarios());
                                AdicionarU.limpaUsuario();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Email invalido");
                            }
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
         if(e.getSource()==AdicionarP.gravar){
            try {
                ConectaBanco.inserirAlimento(AdicionarP.dadosA());
                AdicionarP.limpaComidas();
                System.out.println(ConectaBanco.lerAlimentos());
                } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         if(e.getSource()==AdicionarP.gravarB){
            try {
                ConectaBanco.inserirBebida(AdicionarP.dadosB());
                AdicionarP.limpaBebidas();
                System.out.println("teste");
                } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        if(e.getSource()==AdicionarU.editar){
            AdicionarU.cartas.show(AdicionarU.escolha, "edicao");
            num=1;
            
            System.out.println(AdicionarU.DadosU());

        }
        if(e.getSource()==AdicionarU.adicionar1){
            AdicionarU.cartas.show(AdicionarU.escolha, "adicao");
            num=2;
        }
        
        if(e.getSource()==AdicionarU.eliminar){
            AdicionarU.cartas.show(AdicionarU.escolha, "edicao");
            num=0;
        }
        
        
         if(e.getSource()==AdicionarP.editar){
            AdicionarP.cartas.show(AdicionarP.escolha, "edicao");
            AdicionarP.bebidasLista.setVisible(true);
            
        }
        if(e.getSource()==AdicionarP.adicionar){
            AdicionarP.cartas.show(AdicionarP.escolha, "adicao");
            AdicionarP.bebidasLista.setVisible(false);
        }
        
        if(e.getSource()==Interface.Adicao.adicionarC){
            try {
                int iComida=Interface.Adicao.comidas.getSelectedIndex();
                int qtdComida=Integer.parseInt(Interface.Adicao.quantidadeC.getText());
                Alimento aux = Controle.ConectaBanco.lerAlimentos().get(iComida);
                comidas.add(new Alimento(aux.getNome(),aux.getPreco(),qtdComida));
                System.out.println("Feito e Feito :)");
                Interface.Adicao.texto.setText(comidas.toString());
                for(Alimento a: comidas)
                System.out.println(a.getNome()+","+a.getPreco()+","+a.getQtd());
            } catch (SQLException ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource()==Interface.Adicao.adicionarBA){
            try {
                int iBebidaA=Interface.Adicao.bebidas.getSelectedIndex();
                int qtdBebidaA=Integer.parseInt(Interface.Adicao.quantidadeBA.getText());
                Bebidas aux = Controle.ConectaBanco.buscaBebida((String)Adicao.bebidas.getSelectedItem());
                bebidas.add(new Bebidas(aux.isAlcoolica(),aux.getNome(),aux.getPreco(),qtdBebidaA));
                Interface.Adicao.texto.setText(bebidas.toString());
                System.out.println("Feito e Feito :)");
                for(Alimento bA: bebidas)
                System.out.println(bA.getNome()+","+bA.getPreco()+","+bA.getQtd());
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource()==Interface.Adicao.adicionarBNA){
            try {
                int iBebidaNA=Interface.Adicao.bebidasN.getSelectedIndex();
                int qtdBebidaNA=Integer.parseInt(Interface.Adicao.quantidadeBNA.getText());
                Bebidas aux = Controle.ConectaBanco.buscaBebida((String)Adicao.bebidasN.getSelectedItem());
                bebidas.add(new Bebidas(aux.isAlcoolica(),aux.getNome(),aux.getPreco(),qtdBebidaNA));
                Interface.Adicao.texto.setText(bebidas.toString());
                System.out.println("Feito e Feito :)");
                for(Alimento bNA: bebidas)
                System.out.println(bNA.getNome()+","+bNA.getPreco()+","+bNA.getQtd());
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource()==Interface.Adicao.confirmar){
            int iMesa=Interface.Adicao.mesas.getSelectedIndex();
            Pedidos pedidos = new Pedidos(comidas,bebidas,iMesa);
            ArrayList<Pedidos> ped = new ArrayList<>();
            try {
                file.escreverPedido(pedidos);
               ped = file.ler();
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<ped.size();i++)
            System.out.println(ped.get(i));
            //System.out.println(pedidos);
        }
        if(e.getSource()==Interface.Login.entrar) {
            try{
            for(Usuario iter:ConectaBanco.lerUsuarios()) { 
                if(Login.tfUsername.getText().equals(iter.getUsername())&&Login.pfPassword.getText().equals(iter.getPassword())) {
                    Login.tfUsername.setText(null); Login.pfPassword.setText(null);
                    Login.menubar.setVisible(true);
                    lognome=iter.getNome();
                    if(iter.getCategoria().equalsIgnoreCase("Administrador"))
                        Inicio.gestao.setVisible(true);
                    else
                        Inicio.gestao.setVisible(false);
                    Login.cartas.show(Login.baralho, "Inicio");
                    return;
                }

            }
            
                            JOptionPane.showMessageDialog(null, "Usuario ou senha incorreta");
                            
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
                
            } 
          if((e.getSource()==Login.cancelar||e.getSource()==Login.exit)) {
            System.exit(0);
        }
                    if((e.getSource()==Login.voltar)) {
            Login.cartas.show(Login.baralho, "Login");
            Login.menubar.setVisible(false);
        }
                    if(e.getSource()==Adicao.mesas){
                        Adicao.confirmar.setText("Confirmar");
                    }
                    
                    if(e.getSource()==Adicao.cbMesasOcup){
                        Adicao.confirmar.setText("Actualizar");
                    }
    }
    
    
    
}

