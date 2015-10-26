/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Gaara-X
 */
public class Relatorios extends JFrame {

    public Relatorios(){
        super("Relatorios");
        criacao();
    }
    
    public void criacao(){
        
        JButton imprimir;
        JPanel pnVendas,pnGestao,pnImprimir;
        JTabbedPane conteudo;
        
        pnVendas = new RelatorioVendaI();
        pnGestao = new RelatorioGestaoI();
        pnImprimir = new JPanel();
        pnImprimir.add(new JButton("Imprimir"));
        
        conteudo = new JTabbedPane();
        conteudo.add("Relatorio de Vendas", pnVendas);
        conteudo.add("Relatorio de Registros", pnGestao);
       
	add(conteudo,BorderLayout.CENTER);
        add(pnImprimir,BorderLayout.SOUTH);
	setSize(400,400);
	setVisible(true);
        pack();
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
    }
    
    public static void main(String[] args) {
        new Relatorios();
    }
}
