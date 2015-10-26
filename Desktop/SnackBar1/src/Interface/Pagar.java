/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controle.Item;
import Controle.Modelos;
import Controle.TrataVenda;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Junior
 */
public class Pagar extends JPanel {
    public Pagar(){
        criacao();
    }
    JPanel painel,pnDados,pnMesas;
   public static JButton pagar;
   public static JTextField total,trocos;
    public static JComboBox mesas;
    public static JTable tabela;

    private void criacao() {
        painel= new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.LINE_AXIS));
        pnMesas=new JPanel(new GridLayout(1,3));
        pnDados= new JPanel(new BorderLayout(5,5));
        //lista.add(Listar.tabela);
        pagar = new JButton("Pagar");
        pagar.addActionListener(new TrataVenda());
        total= new JTextField(3);
        trocos = new JTextField(3);        
        total.addKeyListener(new Restricao());         
        trocos.setEditable(false);
        trocos.setBorder(BorderFactory.createLineBorder(painel.getBackground()));
        trocos.setBackground(this.getBackground());
        painel.add(new JLabel("Total Recebido"));
        painel.add(total);
        painel.add(pagar);
        painel.add(Box.createHorizontalGlue());
        painel.add(Box.createRigidArea(new Dimension(5,0)));
        painel.add(new JLabel("Trocos"));
        painel.add(trocos);
        
               try {
           //painel.setBorder(borda);
           mesas = new JComboBox(new Auxiliar.Ficheiro().mesaOcupada());
           tabela= new JTable(Modelos.modeloLista(0));
       } catch (Exception ex) {
           Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
       }
               pnMesas.add(mesas);
               pnMesas.add(new JLabel(""));
               pnMesas.add(new JLabel(""));
          mesas.addItemListener(new Item());
        pnDados.add(pnMesas,BorderLayout.NORTH);
        pnDados.add(new JScrollPane(tabela),BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(pnDados,BorderLayout.CENTER);
        this.add(painel,BorderLayout.SOUTH);
    }
    
       public static void main(String[] args) {
       JFrame l = new JFrame();
       l.add(new Pagar());
        l.setVisible(true);
        l.pack();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } 
    
}
