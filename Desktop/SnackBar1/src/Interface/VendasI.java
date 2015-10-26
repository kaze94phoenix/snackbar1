/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Gaara-X
 */
public class VendasI extends JPanel {

    public VendasI(){
        //super("Vendas");
        criacao();
    }
    JButton imprimir;
        JPanel pnTabela,pnImprimir,pnPrincipal,pnLbTabela;
        public static JTable tabela;
        EtchedBorder borda;      
    
    public void criacao(){
       borda = new EtchedBorder(EtchedBorder.RAISED);
       pnLbTabela= new JPanel();
       pnLbTabela.setLayout(new GridLayout(1,2));
       pnTabela= new JPanel();
       pnTabela.setBorder(borda);
       pnPrincipal = new JPanel();
       pnPrincipal.setLayout(new BorderLayout());
       //pnPrincipal.setBorder(borda);
        try {
            //modelo=new DefaultTableModel();
            //modelo.setColumnIdentifiers(colunas);
            tabela= new JTable(Controle.Modelos.modeloVendas());
        } catch (Exception ex) {
            Logger.getLogger(RelatorioVendaI.class.getName()).log(Level.SEVERE, null, ex);
        }
       pnTabela.add(new JScrollPane(tabela));
       pnLbTabela.add(new JLabel(""));       
       pnLbTabela.add(new JLabel(""));
       pnPrincipal.add(pnLbTabela,BorderLayout.NORTH);
       pnPrincipal.add(new JLabel(""));
       pnPrincipal.add(pnTabela,BorderLayout.SOUTH);
       add(pnPrincipal);
    }
    
    public static void main(String[] args) {
        JFrame l = new JFrame();
       l.add(new VendasI());
        l.setVisible(true);
        l.pack();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}