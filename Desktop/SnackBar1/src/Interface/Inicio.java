/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Controle.Botao;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Junior
 */
public class Inicio extends JPanel {
    public Inicio(){
        criacao();
    }
static JMenu ficheiro,help;
static JMenuBar menubar;
static JMenuItem voltar,exit,ajuda,faq;
Font fonte;
String look;
public static CardLayout cartas;
public static JPanel painel,opcoes,baralho;
public static JButton adicionar,listar,pagar,gestao;
EtchedBorder borda;
public static Color cor;
public static ImageIcon IAdicionar,IListar,IPagar,IGestao,IGestao1,IListar1,IAdicionar1,IPagar1;
GridBagConstraints gbc;


    public  void criacao(){
        //gbc = new GridBagConstraints();
         IAdicionar = new ImageIcon(getClass().getResource("/Interface/Imagens/plus.png"));
         IAdicionar1 = new ImageIcon(getClass().getResource("/Interface/Imagens/plus1.png"));
         IListar= new ImageIcon(getClass().getResource("/Interface/Imagens/menu.png"));
         IListar1= new ImageIcon(getClass().getResource("/Interface/Imagens/menu1.png"));
         IGestao= new ImageIcon(getClass().getResource("/Interface/Imagens/settings.png"));
         IGestao1= new ImageIcon(getClass().getResource("/Interface/Imagens/settings1.png"));
         IPagar= new ImageIcon(getClass().getResource("/Interface/Imagens/pay.png"));
         IPagar1= new ImageIcon(getClass().getResource("/Interface/Imagens/pay1.png"));

        cor = new Color(0,191,255);
         borda = new EtchedBorder(EtchedBorder.RAISED);
        fonte = new Font( "Arial", Font.PLAIN, 15 );
        cartas = new CardLayout();
        
        painel= new JPanel();
        painel.setLayout(new BorderLayout());
        opcoes = new JPanel();
        opcoes.setBackground(Color.WHITE);
        opcoes.setBorder(borda);
        baralho = new JPanel();
        baralho.setLayout(cartas);
        baralho.add(new Adicao(),"Adicao");
        baralho.add(new Listar(),"Listar");
        baralho.add(new Gestao(),"Gestao");
        baralho.add(new Pagar(),"Pagar");
        
        adicionar = new JButton("Pedido",IAdicionar);
        adicionar.setFont(fonte);
        adicionar.setContentAreaFilled(false);
        adicionar.setBorderPainted(false);
        adicionar.addActionListener(new Botao());

        listar = new JButton("Listar",IListar);        
        listar.setFont(fonte);
        listar.setContentAreaFilled(false);
        listar.setBorderPainted(false);
        listar.addActionListener(new Botao());

        pagar = new JButton("Pagar",IPagar);
        pagar.setFont(fonte);
        pagar.setBorderPainted(false);
        pagar.setContentAreaFilled(false);
        pagar.addActionListener(new Botao());
        
        gestao = new JButton("Gestao",IGestao);
        gestao.setFont(fonte);
        gestao.setContentAreaFilled(false);
        gestao.setBorderPainted(false);
        gestao.addActionListener(new Botao());
        
        opcoes.setLayout(new GridLayout(4,1));
        opcoes.add(adicionar);
        opcoes.add(listar);
        //listar.setVerticalTextPosition(SwingConstants.VERTICAL);
        //listar.setHorizontalAlignment(SwingConstants.LEFT);
        opcoes.add(pagar);
        opcoes.add(gestao);

        painel.add(opcoes,BorderLayout.WEST);
        painel.add(baralho,BorderLayout.CENTER);
        
        this.setLayout(new BorderLayout());
        this.add(painel,BorderLayout.CENTER);
        
    }


    
    public static void main(String[] args) {
        try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) { 
          try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception d){
            System.out.println("erro");
        }   
}
        menubar = new JMenuBar();
        ficheiro = new JMenu("Ficheiro");
        help = new JMenu("Ajuda");
        voltar = new JMenuItem("Voltar");
        voltar.addActionListener(new Botao());
        menubar.add(ficheiro);
        menubar.add(help);
        menubar.setVisible(false);
        exit = new JMenuItem("Sair");
        exit.addActionListener(new Botao());
        ajuda= new JMenuItem("Contacto");
        faq = new JMenuItem("Sobre");
        ficheiro.add(exit);
        ficheiro.add(voltar);
        help.add(ajuda);
        help.add(faq);

        JFrame f = new JFrame("Teste");
        f.setJMenuBar(menubar);
        menubar.setVisible(true);
        f.add(new Inicio());
        //f.add(new AdicionarU());
        f.setVisible(true);        
        f.pack();
        f.setSize(800, 650);
        f.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width  / 2) - (f.getWidth() / 2)),((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (f.getHeight() / 2)));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
