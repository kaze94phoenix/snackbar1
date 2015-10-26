/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Auxiliar;

import Controle.ConectaBanco;
import static Controle.ConectaBanco.desconecta;
import Controle.Modelos;
import Interface.AdicionarP;
import Interface.AdicionarU;
import Interface.Gestao;
import Interface.Inicio;
import Interface.Login;
import Interface.VendasI;
import Modelos.Alimento;
import Modelos.Bebidas;
import Modelos.Mesas;
import Modelos.Pedidos;
import Modelos.RelatorioGestao;
import Modelos.Usuario;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class Botao implements ActionListener {
    public static int resp;
    public static Object[] opc={"Sim","Nao"};

    @Override
    public void actionPerformed(ActionEvent e) {

        
        if(e.getSource()==AdicionarU.gravar){
            boolean passa;
            if(AdicionarU.gravar.getText().equalsIgnoreCase("Gravar")){
                        try {
                            if(AdicionarU.DadosU().getEmail().contains("@")){
                Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Adicionou", AdicionarU.DadosU().getNome(), new Date()));
                ConectaBanco.inserirUsuario(AdicionarU.DadosU());
                AdicionarU.tabela.setModel(Modelos.modeloU());
                Interface.AdicionarU.lista.setModel(Controle.Modelos.listaUsuarios());
                Interface.AdicionarU.tabela.setModel(Controle.Modelos.modeloU());
                            System.out.println(ConectaBanco.lerUsuarios());
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Email invalido");
                            }
            } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(AdicionarU.gravar.getText().equalsIgnoreCase("Actualizar")){
                int iUsuario=Interface.AdicionarU.lista.getSelectedIndex();
                try {
                    resp=JOptionPane.showOptionDialog(null,"Desejas actualizar?","Confirmacao",0,JOptionPane.QUESTION_MESSAGE,null,opc,opc);
                    if(resp==0){
                    Controle.ConectaBanco.editarUsuario(iUsuario);
            Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Editou",(String) AdicionarU.lista.getSelectedItem(), new Date()));
                    Interface.AdicionarU.tabela.setModel(Controle.Modelos.modeloU());
                    Interface.AdicionarU.lista.setModel(Controle.Modelos.listaUsuarios());
                    }
                    } catch (Exception Exception) {
                    System.out.println("Erro na actualizacao!! "+ Exception.getMessage());
            }
                
            }
            
            if(AdicionarU.gravar.getText().equalsIgnoreCase("Apagar")){
                 //ConectaBanco.conexao();
                int iUsuario=Interface.AdicionarU.lista.getSelectedIndex();
                try {
                    resp=JOptionPane.showOptionDialog(null,"Desejas eliminar?","Confirmacao",0,JOptionPane.QUESTION_MESSAGE,null,opc,opc);
                    if(resp==0){
                    Controle.ConectaBanco.eliminarUsuario(iUsuario);
                    Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Eliminou",(String) AdicionarU.lista.getSelectedItem(), new Date()));
                    Interface.AdicionarU.tabela.setModel(Controle.Modelos.modeloU());
                    Interface.AdicionarU.lista.setModel(Controle.Modelos.listaUsuarios());
                    }
                } catch (Exception Exception) {
                    System.out.println("Erro na actualizacao!! "+ Exception.getMessage());
            }
             }
        }
        
        
         if(e.getSource()==AdicionarP.gravar){
             if(AdicionarP.gravar.getText().equalsIgnoreCase("Gravar")){
            try {
                ConectaBanco.inserirAlimento(AdicionarP.dadosA());
                Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Adicionou",(String) AdicionarP.dadosA().getNome(), new Date()));
                Interface.AdicionarP.tabela.setModel(Controle.Modelos.modeloA());
                Interface.AdicionarP.lista.setModel(Controle.Modelos.listaComidas());
                System.out.println(ConectaBanco.lerAlimentos());
                } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
             }if(AdicionarP.gravar.getText().equalsIgnoreCase("Actualizar")){
                 //ConectaBanco.conexao();
                int iComida=Interface.AdicionarP.lista.getSelectedIndex();
                
                try {
                    resp=JOptionPane.showOptionDialog(null,"Desejas actualizar?","Confirmacao",0,JOptionPane.QUESTION_MESSAGE,null,opc,opc);
                    if(resp==0){
                    Auxiliar.ConectaBanco.editarComida(iComida);
                    Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Editou",(String) AdicionarP.lista.getSelectedItem(), new Date()));
                    Interface.AdicionarP.tabela.setModel(Controle.Modelos.modeloA());
                    Interface.AdicionarP.lista.setModel(Controle.Modelos.listaComidas());
                    }
                } catch (Exception Exception) {
                    Exception.printStackTrace();
                    System.out.println("Erro na actualizacao!!");
            }
             }
             if(AdicionarP.gravar.getText().equalsIgnoreCase("Apagar")){
                 //ConectaBanco.conexao();
                int iComida=Interface.AdicionarP.lista.getSelectedIndex();
                try {
                    resp=JOptionPane.showOptionDialog(null,"Desejas eliminar?","Confirmacao",0,JOptionPane.QUESTION_MESSAGE,null,opc,opc);
                    if(resp==0){
                    Auxiliar.ConectaBanco.eliminarComida(iComida);
                    Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Eliminou",(String) AdicionarP.lista.getSelectedItem(), new Date()));
                    Interface.AdicionarP.tabela.setModel(Controle.Modelos.modeloA());
                    Interface.AdicionarP.lista.setModel(Controle.Modelos.listaComidas());
                    }
                } catch (Exception Exception) {
                    System.out.println("Erro na actualizacao!! "+ Exception.getMessage());
            }
             }
             
            
        }
         if(e.getSource()==AdicionarP.gravarB){
             if(AdicionarP.gravar.getText().equalsIgnoreCase("Gravar")){
            try {
                ConectaBanco.inserirBebida(AdicionarP.dadosB());
            Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Adicionou",(String) AdicionarP.dadosB().getNome(), new Date()));    
                Interface.AdicionarP.tabela2.setModel(Controle.Modelos.modeloB());
                Interface.AdicionarP.bebidasLista.setModel(Controle.Modelos.listaBebidas());
                System.out.println("teste");
                } catch (Exception ex) {
                Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
            }
             }if(AdicionarP.gravarB.getText().equalsIgnoreCase("Actualizar")){
                  //ConectaBanco.conexao();
                int iBebida=Interface.AdicionarP.bebidasLista.getSelectedIndex();
                try {
                    resp=JOptionPane.showOptionDialog(null,"Desejas actualizar?","Confirmacao",0,JOptionPane.QUESTION_MESSAGE,null,opc,opc);
                    if(resp==0){
                    Auxiliar.ConectaBanco.editarBebida(iBebida);
                    Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Editou",(String) AdicionarP.bebidasLista.getSelectedItem(), new Date()));
                    Interface.AdicionarP.tabela2.setModel(Controle.Modelos.modeloB());
                    Interface.AdicionarP.bebidasLista.setModel(Controle.Modelos.listaBebidas());
                    }
                } catch (Exception Exception) {
                    System.out.println("Erro na actualizacao!! "+ Exception.getMessage());
            }
                 
             }
             if(AdicionarP.gravar.getText().equalsIgnoreCase("Apagar")){
                 //ConectaBanco.conexao();
                int iBebida=Interface.AdicionarP.bebidasLista.getSelectedIndex();
                try {
                    resp=JOptionPane.showOptionDialog(null,"Desejas eliminar?","Confirmacao",0,JOptionPane.QUESTION_MESSAGE,null,opc,opc);
                    if(resp==0){
                    Auxiliar.ConectaBanco.eliminarBebida(iBebida);
                 Auxiliar.ConectaBanco.fazerRelatGestao(new RelatorioGestao(Controle.Botao.lognome, "Eliminou",(String) AdicionarP.bebidasLista.getSelectedItem(), new Date()));
                    Interface.AdicionarP.tabela2.setModel(Controle.Modelos.modeloB());
                    Interface.AdicionarP.bebidasLista.setModel(Controle.Modelos.listaBebidas());
                    }
                } catch (Exception Exception) {
                    System.out.println("Erro na actualizacao!! "+ Exception.getMessage());
            }
             }
         }
        if(e.getSource()==AdicionarU.editar){
            AdicionarU.cartas.show(AdicionarU.escolha, "edicao");
            AdicionarU.escolha.setVisible(true);
            AdicionarU.BI.setEnabled(true);
            AdicionarU.contacto.setEnabled(true);
            AdicionarU.data.setEnabled(true);
            AdicionarU.email.setEnabled(true);
            AdicionarU.endereco.setEnabled(true);
            AdicionarU.gravar.setEnabled(true);
            AdicionarU.gravar.setText("Actualizar");
            AdicionarU.nome.setEnabled(true);
            AdicionarU.senha.setEnabled(true);
            AdicionarU.username.setEnabled(true);
            //System.out.println(AdicionarU.DadosU());

        }
        if(e.getSource()==AdicionarU.adicionar1){
            AdicionarU.cartas.show(AdicionarU.escolha, "adicao");
            AdicionarU.BI.setEnabled(true);
            AdicionarU.contacto.setEnabled(true);
            AdicionarU.data.setEnabled(true);
            AdicionarU.email.setEnabled(true);
            AdicionarU.endereco.setEnabled(true);
            AdicionarU.gravar.setEnabled(true);
             AdicionarU.gravar.setText("Gravar");
            AdicionarU.nome.setEnabled(true);
            AdicionarU.senha.setEnabled(true);
            AdicionarU.username.setEnabled(true);
            
            
            
        }
        if(e.getSource()==AdicionarU.eliminar){
            AdicionarU.cartas.show(AdicionarU.escolha, "edicao");
            AdicionarU.BI.setEnabled(false);
            AdicionarU.contacto.setEnabled(false);
            AdicionarU.data.setEnabled(false);
            AdicionarU.email.setEnabled(false);
            AdicionarU.endereco.setEnabled(false);
            AdicionarU.gravar.setEnabled(true);
            AdicionarU.gravar.setText("Apagar");
            AdicionarU.nome.setEnabled(false);
            AdicionarU.senha.setEnabled(false);
            AdicionarU.username.setEnabled(false);
            
        }
        
        if(e.getSource()==AdicionarP.eliminar){
            AdicionarP.cartas.show(AdicionarP.escolha, "edicao");
            AdicionarP.bebidasLista.setVisible(true);
            AdicionarP.gravar.setText("Apagar");
            AdicionarP.gravarB.setText("Apagar");
            //AdicionarP.lista.setVisible(true);
            
        }
        
        
         if(e.getSource()==AdicionarP.editar){
            AdicionarP.cartas.show(AdicionarP.escolha, "edicao");
            AdicionarP.bebidasLista.setVisible(true);
            AdicionarP.gravar.setText("Actualizar");
            AdicionarP.gravarB.setText("Actualizar");
            //AdicionarP.lista.setVisible(true);
            
        }
         
         
        if(e.getSource()==AdicionarP.adicionar){
            AdicionarP.cartas.show(AdicionarP.escolha, "adicao");
            AdicionarP.bebidasLista.setVisible(false);
            //AdicionarP.lista.setVisible(false);
            AdicionarP.gravar.setText("Gravar");
            AdicionarP.gravarB.setText("Gravar");
            
        }
        
        if(e.getSource()==Gestao.relatorios){
            new Interface.Relatorios();
        }
        
        if(e.getSource()==Gestao.vendas){
            JFrame l = new JFrame("Vendas");
       l.add(new VendasI());
        l.setVisible(true);
        l.pack();
        l.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        }
        
        
    }
}
