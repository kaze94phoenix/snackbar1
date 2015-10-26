package Interface;


import Controle.Ficheiro;
import Controle.Item;
import Controle.Modelos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaara-X
 */
public class Listar extends JPanel {

    
   public Listar(){
       criacao();
   }
   
   public static JPanel painel,pain,pain1,pnImprimir;
   public static JButton imprimir;
   public static JComboBox mesas;
   public static JTable tabela;
   EtchedBorder borda;
   //Object[] colunas={"Nome","Preco Unitario","Quantidade","Preco Total"};
   //Object[] itensMesas={"Mesa 1","Mesa 2","Mesa 3","Mesa 4","Mesa 5"};
   DefaultTableModel modelo;
   
   public void criacao(){
       imprimir= new JButton("Imprimir");
       pnImprimir= new JPanel();
       pnImprimir.setLayout(new BoxLayout(pnImprimir, BoxLayout.LINE_AXIS));
       pnImprimir.add(new JLabel(""));
       pnImprimir.add(Box.createHorizontalGlue());
       pnImprimir.add(Box.createRigidArea(new Dimension(5,0)));
       pnImprimir.add(imprimir);
       borda = new EtchedBorder(EtchedBorder.RAISED);
       pain= new JPanel();
       pain.setLayout(new GridLayout(1,2));
       pain1= new JPanel();
       pain1.setBorder(borda);
       painel = new JPanel();
       painel.setLayout(new BorderLayout());
       try {
           //painel.setBorder(borda);
           mesas = new JComboBox(new Auxiliar.Ficheiro().mesaOcupada());
           tabela= new JTable(Modelos.modeloLista(1));
       } catch (Exception ex) {
           Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
       }
      // mesas.setBorder(borda);
       mesas.addItemListener(new Item());
       
       //modelo=new DefaultTableModel();
       //modelo.setColumnIdentifiers(colunas);       
       pain1.add(new JScrollPane(tabela));
       pain.add(mesas);       
       pain.add(new JLabel(""));
       painel.add(pain,BorderLayout.NORTH);
       painel.add(new JLabel(""));
       painel.add(pain1,BorderLayout.CENTER);
       painel.add(pnImprimir,BorderLayout.SOUTH);
       this.add(painel);
   }
   
   public static void main(String[] args) {
       System.out.println( new Auxiliar.Ficheiro().listaMesas());
       //new Auxiliar.Ficheiro().escreveLiv(1);
       System.out.println(new Auxiliar.Ficheiro().listaMesasLiv());
       new Auxiliar.Ficheiro().escreveMesaOcup(5);
       System.out.println(new Auxiliar.Ficheiro().listaMesasOcup());
       JFrame l = new JFrame();
       l.add(new Listar());
        l.setVisible(true);
        l.pack();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } 
}
