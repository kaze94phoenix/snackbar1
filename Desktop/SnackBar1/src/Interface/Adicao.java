/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Controle.Botao;
import Controle.Ficheiro;
import Controle.Modelos;
import Controle.TrataVenda;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Junior
 */
public class Adicao extends JPanel {
    public Adicao(){
       criacao();
    }
    public boolean getScrollableTracksViewportWidth(){
        return true;
    }
    public static void mouseListener(JPanel p){
        JButton b;
        Component[] c = p.getComponents();
        for(int i=0;i<c.length;i++){
            if(c[i] instanceof JButton){
                b=(JButton) c[i];
                b.addMouseListener(new Mouse());
            }
                
        }
    }
    
    public static JComboBox comidas,bebidas,bebidasN,mesas,cbMesasOcup,mesasTeste;
    JPanel painel,pnBtConf,pain,pain1,pain2,pain3,pain4,pain5,spPainelBebidas,painelBebidas,painelAlcoolicas,painelNAlcoolicas,painelBotoes,painelDados,painelComidas,painelDadosComidas,painelMesas,painelMesasOcup,pnEscolheMesa;
    public static JButton adicionarBA,adicionarBNA,adicionarC,confirmar,undo;
    EtchedBorder borda;
    ButtonGroup grupo;
    JRadioButton[] botoes;
    JTextArea lista;
    public static JTextArea texto;
   public static JTextField quantidadeBA,quantidadeBNA,quantidadeC;
    JScrollPane scroll;
    public void criacao(){
        EtchedBorder borda = new EtchedBorder(EtchedBorder.RAISED);
//        painelEdicao= new JPanel(new GridLayout());
        pnBtConf = new JPanel();
        pnEscolheMesa = new JPanel(new BorderLayout());
        painelMesas= new JPanel(new GridLayout(3,1,-10,-10));
        painelMesasOcup= new JPanel(new GridLayout(3,1,-10,-10));
        painelComidas = new JPanel(new GridLayout(2,1));
        painelDadosComidas= new JPanel();
        painelDados= new JPanel();
        painelDados.setLayout(new GridLayout(1,4));
        painelBotoes= new JPanel();
        painelBotoes.setLayout(new GridLayout(4,1));
        painelBebidas= new JPanel();
        painelBebidas.setLayout(new GridLayout(4,1,5,5));        
        painelNAlcoolicas= new JPanel();
        painelAlcoolicas= new JPanel();
        painelAlcoolicas.setLayout(new BorderLayout(10,3));
        painelNAlcoolicas.setLayout(new BorderLayout(10,3));
        spPainelBebidas = new JPanel();
        spPainelBebidas.setLayout(new BorderLayout(10,3));
        spPainelBebidas.setBorder(borda);
         quantidadeBA = new JTextField(2);
         quantidadeBNA = new JTextField(2);
         quantidadeBNA.setToolTipText("Quantidade");
         quantidadeBA.setToolTipText("Quantidade");
         quantidadeC = new JTextField(2);
         quantidadeC.setToolTipText("Quantidade");
         quantidadeBA.addKeyListener(new Restricao());
         quantidadeBNA.addKeyListener(new Restricao());
         quantidadeC.addKeyListener(new Restricao());
         
        texto =new JTextArea();
        //texto.setEditable(false);
        //texto.setContentType("text/html");
        //texto.setText("tdfff");
        scroll= new JScrollPane(texto);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        confirmar = new JButton("Confirmar");
        pnBtConf.add(confirmar);
       // undo = new JButton("Undo");
       // undo.addActionListener(new TrataVenda());
         //       painelEdicao.add(undo);
        botoes = new JRadioButton[6];
        grupo = new ButtonGroup();
        borda = new EtchedBorder(EtchedBorder.RAISED);
        Controle.Modelos.adicionaMesas();
        try {
            bebidasN = new JComboBox(Controle.Modelos.bebidasNaoAlcoolicas());
           mesasTeste = new JComboBox(Controle.Modelos.modeloMesas());
           mesas=new JComboBox(new Auxiliar.Ficheiro().mesaLivre());
           mesas.addActionListener(new Botao());
           //Controle.Modelos.removeMesaLivre(2);
           //Controle.Modelos.removeMesaLivre(1);
           cbMesasOcup=new JComboBox(new Auxiliar.Ficheiro().mesaOcupada());
           cbMesasOcup.addActionListener(new Botao());
           //mesas.setModel(Controle.Modelos.mesasLiv());
        } catch (Exception ex) {
            Logger.getLogger(Adicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            comidas = new JComboBox(Controle.Modelos.listaComidas());
        } catch (SQLException ex) {
            Logger.getLogger(Adicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bebidas= new JComboBox(Controle.Modelos.bebidasAlcoolicas());
        } catch (Exception ex) {
            Logger.getLogger(Adicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        painel = new JPanel();
        pain= new JPanel();
        pain1 = new JPanel();
        pain2 = new JPanel();
        pain3 = new JPanel();
        pain4 = new JPanel();
        //painel.setLayout(new BorderLayout());
        painel.setLayout(new GridLayout(2,1));
        pain.setLayout(new GridLayout(2,1,5,5));
        pain1.setLayout(new GridLayout(1,2,200,200));
        pain1.setBorder(borda);
        pain2.setBorder(borda);
        pain3.setLayout(new BorderLayout());
        pain3.setBorder(borda);
        
        adicionarBA = new JButton("Adicionar");
        adicionarBNA = new JButton("Adicionar");
        adicionarC = new JButton("Adicionar");
        adicionarC.addActionListener(new TrataVenda());
        adicionarBA.addActionListener(new TrataVenda());
        adicionarBNA.addActionListener(new TrataVenda());
        confirmar.addActionListener(new TrataVenda());
        
        painelBotoes.add(new JLabel(""));
        painelBotoes.add(adicionarBA);
        painelBotoes.add(new JLabel(""));
        painelBotoes.add(adicionarBNA);
        
        painelNAlcoolicas.add(bebidasN,BorderLayout.CENTER);
        painelNAlcoolicas.add(quantidadeBNA,BorderLayout.EAST);
        painelAlcoolicas.add(bebidas,BorderLayout.CENTER);
        painelAlcoolicas.add(quantidadeBA,BorderLayout.EAST);

        painelBebidas.add(new JLabel("Bebidas Alcoolicas"));
        painelBebidas.add(painelAlcoolicas);
        painelBebidas.add(new JLabel("Bebidas nao Alcoolicas"));
        painelBebidas.add(painelNAlcoolicas);
        spPainelBebidas.add(painelBebidas,BorderLayout.CENTER);
        spPainelBebidas.add(painelBotoes,BorderLayout.EAST);
        
        painelDadosComidas.add(new JLabel("Comidas"));
        painelDadosComidas.add(comidas);
        painelDadosComidas.add(quantidadeC);
        painelDadosComidas.add(adicionarC);
        painelComidas.add(painelDadosComidas);
        //pain2.add(new JLabel("              "));
        painelDados.add(painelDadosComidas);
        painelDados.add(spPainelBebidas);
        
        
        //Painel de edicao
        //painelEdicao.add(cbMesasOcup);
        painelMesas.add(new JLabel("Mesas Livres"));
        painelMesas.add(mesas);
        painelMesas.add(new JLabel(""));
        
        painelMesasOcup.add(new JLabel("Mesas Ocupadas"));
        painelMesasOcup.add(cbMesasOcup);
        painelMesasOcup.add(new JLabel(""));
        pain1.add(painelMesas);
        pain1.add(painelMesasOcup);
        pnEscolheMesa.add(pain1,BorderLayout.CENTER);
        pnEscolheMesa.add(pnBtConf,BorderLayout.SOUTH);
        //lista.setAutoscrolls(true);
        pain3.add(new JLabel("Lista de itens para a mesa"),BorderLayout.PAGE_START);
        pain3.add(scroll,BorderLayout.CENTER);
        //pain3.add(pnBtConf,BorderLayout.EAST);
        //pain3.add(confirmar,BorderLayout.SOUTH);
        pain.add(painelDados);
        pain.add(pnEscolheMesa);
        this.setLayout(new BorderLayout());
        this.add(pain,BorderLayout.NORTH);
        this.add(pain3,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        JPanel p;
        System.out.println(Controle.Modelos.mesas);
/*        try {
            System.out.println(new Ficheiro().mesasOcupadas());
        } catch (Exception ex) {
            Logger.getLogger(Adicao.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        JFrame f = new JFrame();
       /* Component[] c=f.getComponents();
        while(c!=null){
            for(int i=1;i<c.length;i++)
            if(c[i] instanceof JPanel)
             p = (JPanel) c[i];
            p.getComponents();
        }
        System.out.println(c.length);*/
        f.add(new Adicao());
        f.setSize(800, 600);
        //f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
