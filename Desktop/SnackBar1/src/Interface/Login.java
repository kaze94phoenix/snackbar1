/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Controle.Botao;
import Controle.TrataVenda;
import static Interface.Inicio.menubar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Gaara-X
 */
public class Login extends JPanel {
    public static Color cor;
    public static boolean passa=true;
   public static JMenu ficheiro,help,redo;
   public static JMenuBar menubar;
   public static JMenuItem voltar,exit,ajuda,faq,undo;
   public static JPanel pnUsername,pnPassword,pnBotoes,pnDados,pnEast,baralho,painel;
   public static JButton entrar,cancelar;
   public static JTextField tfUsername;
   public static JPasswordField pfPassword;
   public static ImageIcon Iundo,Iredo;
    JLabel icon;
    static EtchedBorder borda;
   public static CardLayout cartas;
    
    
   public Login(){
       criacao();
   }

    private void criacao() {
      cartas= new CardLayout();
      cor = Color.WHITE;
      ImageIcon sai = new ImageIcon(getClass().getResource("/Interface/Imagens/sai.png"));
      ImageIcon entra = new ImageIcon(getClass().getResource("/Interface/Imagens/entra.png"));
      ImageIcon login = new ImageIcon(getClass().getResource("/Interface/Imagens/login.png"));
      Iundo = new ImageIcon(getClass().getResource("/Interface/Imagens/undo.png"));
      Iredo = new ImageIcon(getClass().getResource("/Interface/Imagens/redo.png"));
      borda = new EtchedBorder(EtchedBorder.RAISED);
      baralho=new JPanel(cartas);
      painel=new JPanel(new BorderLayout());
      pnUsername = new JPanel();
      pnPassword = new JPanel();
      pnBotoes = new JPanel(new GridLayout(1,2));
      pnEast= new JPanel(new BorderLayout());
      //pnUsername.setBackground(Color.red);
      
      
      icon = new JLabel(login);
      tfUsername = new JTextField(15);
      pfPassword = new JPasswordField(15);
      
      
      entrar = new JButton(entra);
      entrar.setBackground(cor);
      entrar.setBorderPainted(false);
      entrar.addActionListener(new Botao());
      entrar.setContentAreaFilled(false);
      entrar.addMouseListener(new Mouse());
      cancelar= new JButton(sai);
      cancelar.addActionListener(new Botao());
      cancelar.setBackground(cor);
      cancelar.setBorderPainted(false);
      cancelar.setContentAreaFilled(false);
      cancelar.addMouseListener(new Mouse());
      //
      
      
      pnUsername.add(new JLabel("Usuario:"));pnUsername.add(tfUsername);
      pnPassword.add(new JLabel("Senha:"));pnPassword.add(pfPassword);
      pnBotoes.add(cancelar);pnBotoes.add(entrar);
      pnDados = new JPanel(new GridLayout(4,1,5,5));
      pnDados.add(new JLabel("  ")); pnDados.add(pnUsername); pnDados.add(pnPassword);pnDados.add(pnBotoes);
      pnEast.add(pnDados,BorderLayout.NORTH);
      painel.add(pnEast,BorderLayout.EAST);
      painel.add(icon,BorderLayout.CENTER); 
      baralho.add(painel,"Login");
      baralho.add(new Inicio(),"Inicio");
      this.setLayout(new BorderLayout());
      this.add(baralho);
      this.setBackground(cor);
      pnEast.setBackground(cor);
      painel.setBackground(cor);
      pnDados.setBackground(Color.white);
              Component[] c = pnDados.getComponents();
              System.out.println(c.length);
        for(int i=1;i<c.length;i++){
            if(c[i] instanceof JPanel){
           JPanel p = ((JPanel) c[i]);  c[i].setBackground(cor);
            }
            else{
            System.out.println("Não há paineis");
    }
      
    }

        
    }
   
   public static void main(String[]args) {
      Loading l = new Loading();
      l.setTempo(3000);
      Thread t =new Thread(l);
      t.start();
   /*   while(passa)
          try {
              wait();
          } catch (InterruptedException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
      l.dispose();*/
               try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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
               menubar.setLayout(new BoxLayout(menubar,BoxLayout.LINE_AXIS));
               undo = new JMenuItem("Desfazer");
               undo.addActionListener(new TrataVenda());
               undo.setIcon(Iundo);
               redo = new JMenu("Desfazer/Refazer");
               redo.setIcon(Iredo);
               redo.add(undo);
        ficheiro = new JMenu("Ficheiro");
        help = new JMenu("Ajuda");
        voltar = new JMenuItem("Voltar");
        voltar.addActionListener(new Botao());
        menubar.add(ficheiro);
        menubar.add(help);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(Box.createRigidArea(new Dimension(5,0)));
        //menubar.add(undo);
        menubar.add(redo);
        menubar.setVisible(false);
        exit = new JMenuItem("Sair");
        exit.addActionListener(new Botao());
        ajuda= new JMenuItem("Ajuda");
        faq = new JMenuItem("sobre");
        ficheiro.add(exit);
        ficheiro.add(voltar);
        help.add(ajuda);
        ajuda.addActionListener(new Botao());
        help.add(faq);
        faq.addActionListener(new Botao());
        
        
        JFrame f = new JFrame();
        f.setJMenuBar(menubar);
        f.add(new Login());
        //JPanel p;
        Component[] c = f.getComponents();
        for(int i=1;i<c.length;i++)
            if(c[i].getClass().getName().equals("JPanel")){
           JPanel p = ((JPanel) c[i]);  c[i].setBackground(cor);
            }
        f.setVisible(true);
        f.setSize(800, 600);
        f.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width  / 2) - (f.getWidth() / 2)),((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (f.getHeight() / 2)));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passa=false;
        //t.notifyAll();
    }
    
}
