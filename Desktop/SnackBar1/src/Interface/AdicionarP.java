/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Controle.Botao;
import static Interface.AdicionarU.adicionar1;
import static Interface.AdicionarU.tabela;
import Modelos.Alimento;
import Modelos.Bebidas;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Junior
 */
public class AdicionarP extends JFrame {
    public AdicionarP(){
        criacao();
    }
public static JPanel pnBebidaTab,pnComidaTab,pnBebida,painel,pnTabelas,painelWest,subPainelWest,adicao,opcoes,escolha,mae,edicao,painData,bebidas,opcoesB,bebidasP,painelButOpcoes,maeB;
public static JTextField nome,preco,coment,nomeB,precoB;
public static JButton gravar,adicionar,editar,eliminar,gravarB,adicionarB,editarB,eliminarB;
public static JComboBox lista,bebidasLista;
public static CardLayout cartas;
public static JTable tabela,tabela2;
public static DefaultTableModel modelo;
public static JScrollPane scroll;
public static JRadioButton alcoolica,nAlcoolica;

public static Alimento dadosA(){
   String nome1 = nome.getText();
   double preco1= Double.parseDouble(preco.getText());
  Alimento a = new Alimento(nome1,preco1);
   return a;
} 
public static Bebidas dadosB(){
    boolean cat = true;
    String nome1= nomeB.getText();
    Double preco1 = Double.parseDouble(precoB.getText());
    if(alcoolica.isSelected())
                   cat= true;
    else if (nAlcoolica.isSelected())
        cat= false;
    return new Bebidas(cat,nome1,preco1);
}
public static void poeDadosB(Bebidas b){
    nomeB.setText(b.getNome());
    precoB.setText(Double.toString(b.getPreco()));
    if(b.isAlcoolica())
        alcoolica.setSelected(true);
    else if(!b.isAlcoolica())
        nAlcoolica.setSelected(true);
}
public static void limpaBebidas(){
    nomeB.setText(null);
    precoB.setText(null);
    alcoolica.setSelected(false);
    nAlcoolica.setSelected(false);
}
public static void limpaComidas(){
    nome.setText(null);
    preco.setText(null);    
}
    public static void poeDadosA(Alimento a){
    nome.setText(a.getNome());
    preco.setText(Double.toString(a.getPreco()));
}
        
    private void criacao() {
        EtchedBorder borda = new EtchedBorder(EtchedBorder.RAISED);
        painelWest= new JPanel();
        painelWest.setLayout(new BorderLayout());
        subPainelWest= new JPanel();
        subPainelWest.setLayout(new BorderLayout());
        painel= new JPanel();
        painel.setLayout(new BorderLayout());
        escolha= new JPanel();
        pnBebida = new JPanel(new BorderLayout());
        pnBebidaTab = new JPanel(new BorderLayout());
        pnComidaTab = new JPanel(new BorderLayout());
        cartas = new CardLayout();
        escolha.setLayout(cartas);
        
        nome= new JTextField(15);
        preco= new JTextField(15);
        //coment= new JTextField();
        
        //Painel das bebidas
        //Opcoes das bebidas
        pnTabelas = new JPanel(new GridLayout(2,1));
        opcoesB = new JPanel();
        bebidasP = new JPanel();
        painelButOpcoes = new JPanel();
        painelButOpcoes.setLayout(new GridLayout(1,3));
        bebidasP.setLayout(new GridLayout(1,1));
        opcoesB.setLayout(new GridLayout(2,1));
        adicionarB = new JButton("Adição");
        adicionarB.addActionListener(new Auxiliar.Botao());
        editarB = new JButton("Edição");
        editarB.addActionListener(new Auxiliar.Botao());
        eliminarB= new JButton("Remoção");
        try {
            bebidasLista=new JComboBox(Controle.Modelos.listaBebidas());
        } catch (Exception ex) {
            Logger.getLogger(AdicionarP.class.getName()).log(Level.SEVERE, null, ex);
        }
        bebidasLista.setVisible(false);
        bebidasLista.addItemListener(new Controle.ItemBebida());
        
        bebidas = new JPanel();
        bebidas.setLayout(new GridLayout(4,2));
            nomeB = new JTextField();
            precoB = new JTextField();
            gravarB = new JButton("Gravar");
            gravarB.addActionListener(new Auxiliar.Botao());
            alcoolica = new JRadioButton("Alcoolica");
            nAlcoolica = new JRadioButton("Não alccolica");
        bebidasP.add(bebidasLista);
        maeB = new JPanel();
        maeB.setLayout(new BorderLayout());
        maeB.add(bebidasP,BorderLayout.NORTH);
        
        bebidas.add(new JLabel("Nome"));
        bebidas.add(nomeB);
        bebidas.add(new JLabel("Preço"));;
        bebidas.add(precoB);
        bebidas.add(alcoolica);
        bebidas.add(nAlcoolica);
        bebidas.add(new JLabel(""));
        bebidas.add(gravarB);
        pnBebida.add(bebidas,BorderLayout.NORTH);
        //bebidas.add(new JLabel(""));
        maeB.add(pnBebida,BorderLayout.CENTER);
        JPanel containerB = new JPanel();
        containerB.setLayout(new BorderLayout());
        containerB.add(new JLabel("Informações da Bebida"),BorderLayout.NORTH);
        containerB.add(maeB,BorderLayout.CENTER);
        //containerB.add(new JLabel("teste"),BorderLayout.SOUTH);
        
        gravar = new JButton("Gravar");
        gravar.addActionListener(new Auxiliar.Botao());
        painData= new JPanel();
        painData.setLayout(new GridLayout(3,2,0,5));
        painData.add(new JLabel("Nome"));
        painData.add(nome);
        painData.add(new JLabel("Preço"));
        painData.add(preco);
        painData.add(new JLabel(""));
        painData.add(gravar);
        painData.setBorder(new TitledBorder(borda, "Informações da Comida"));

        //Opcoes
        adicionar = new JButton("Adição");
        adicionar.addActionListener(new Auxiliar.Botao());
        editar = new JButton("Edição");
        editar.addActionListener(new Auxiliar.Botao());
        eliminar= new JButton("Remoção");
        eliminar.addActionListener(new Auxiliar.Botao());
        
        
        try {
            lista=new JComboBox(Controle.Modelos.listaComidas());
            tabela = new JTable(Controle.Modelos.modeloA());
            tabela2= new JTable(Controle.Modelos.modeloB());
        } catch (Exception ex) {
            Logger.getLogger(AdicionarP.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.addItemListener(new Controle.ItemComida()); 
        scroll = new JScrollPane(tabela);
        TitledBorder titulo = new TitledBorder(borda,"Informação pessoal");
        scroll.setBorder(borda);
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[] {"Prato","Bebida","Preço"});

        edicao = new JPanel();
        edicao.setLayout(new GridLayout(1,1));
        
        adicao= new JPanel();
        opcoes= new JPanel();
        opcoes.setLayout(new GridLayout(1,3,4,10));
        opcoes.add(adicionar);
        opcoes.add(editar);
        opcoes.add(eliminar);
        edicao.add(lista);
        escolha.add(adicao,"adicao");
        escolha.add(edicao,"edicao");
        
        mae = new JPanel();
        mae.setBorder(new TitledBorder(borda, "Opções"));
        mae.setLayout(new GridLayout(2,1));
        mae.add(opcoes);
        mae.add(escolha);
        mae.setBorder(borda);
        
        pnComidaTab.add(new JLabel("Lista de Comidas"),BorderLayout.NORTH);
        pnComidaTab.add(scroll,BorderLayout.CENTER);
        
        pnBebidaTab.add(new JLabel("Lista de Bebidas"),BorderLayout.NORTH);
        pnBebidaTab.add(new JScrollPane(tabela2),BorderLayout.CENTER);
        
        
        pnTabelas.add(pnComidaTab);
        pnTabelas.add(pnBebidaTab);
        subPainelWest.add(mae,BorderLayout.NORTH);
        subPainelWest.add(painData,BorderLayout.CENTER);
        painelWest.add(subPainelWest,BorderLayout.NORTH); 
        painelWest.add(containerB,BorderLayout.CENTER);
        painel.add(painelWest,BorderLayout.WEST);
        painel.add(pnTabelas,BorderLayout.CENTER);
        
        
        
        this.setLayout(new BorderLayout());
//        add(new Barra(),BorderLayout.NORTH);
        add(painel,BorderLayout.CENTER);
//        this.setUndecorated(true);
//        this.pack();
        this.setTitle("Adicionar");
        this.setSize(900,600);
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width  / 2) - (this.getWidth() / 2)),((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
        this.setVisible(true);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        final AdicionarP a = new AdicionarP();
 
    }  
}
