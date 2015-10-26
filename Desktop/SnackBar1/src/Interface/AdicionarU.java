/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Controle.Botao;
import Controle.ItemUsuario;
import Controle.Itens;
import Controle.Modelos;
import Modelos.Usuario;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stddmi1
 */
public class AdicionarU extends JFrame {
    
    public AdicionarU(){
        criacao();
    }

        public static Usuario DadosU(){
        String genero="";
        String categoria="";
        String email1= email.getText();
        String contacto1=contacto.getText();
        String nome1 = nome.getText();
        Date data1= data.getDate();
        //String strDate =(String) DateFormat.getDateInstance().format(data1);
        String endereco1= endereco.getText();
        if(masc.isSelected())
         genero="mesculino";
        else
            if(femi.isSelected())
                genero="feminino";
         if(admin.isSelected())
            categoria="administrador";
        else
            if(normal.isSelected())
                categoria="normal";
         
        String BI1= BI.getText();
        String senha1=senha.getText();
        String username1=username.getText();
        
        return new Usuario(nome1,data1,contacto1,email1,BI1,genero,endereco1,username1,senha1,categoria);
        
    }
        public static void poeDadosU( Usuario u){
            contacto.setText(u.getContacto());
            nome.setText(u.getNome());
            data.setDate(u.getDataNasc());
            endereco.setText(u.getEndereco());
            BI.setText(u.getBi());
            username.setText(u.getUsername());
            senha.setText(u.getPassword());
            email.setText(u.getEmail());
            //femi.setSelected(true);
            if(u.getGenero().equals("feminino"))
                femi.setSelected(true);
            else if(u.getGenero().equals("masculino"))
                masc.setSelected(true);
            if(u.getCategoria().equals("administrador"))
                admin.setSelected(true);
            else if(u.getGenero().equals("normal"))
                normal.setSelected(true);
        }
    public static void limpaUsuario(){
        nome.setText(null);
        data.setDate(null);
        endereco.setText(null);
        email.setText(null);
        contacto.setText(null);
        BI.setText(null);
        username.setText(null);
        senha.setText(null);
        admin.setSelected(false);
        normal.setSelected(false);
        masc.setSelected(false);
        femi.setSelected(false);        
    }
    public static Point point = new Point();
    public static JDateChooser data;
    public static ButtonGroup grupo,grupo1;
    public static JPanel painel,painD,painT,painD1,painel1,painD2,painelWest,escolha,edicao,combos,adicao,opcoes,mae,subPainelWest,painelData;
    public static JButton gravar,editar,adicionar1,eliminar;
    public static JComboBox lista;
    public static JRadioButton masc,femi,admin,normal;
    public static JTextField nome,endereco,BI,senha,username,email;
    public static JFormattedTextField contacto;
    public static CardLayout cartas;
    public static JTable tabela;
    DefaultTableModel modelo;
    JScrollPane scroll;
    public void criacao(){
        cartas = new CardLayout();
        EtchedBorder borda = new EtchedBorder(EtchedBorder.RAISED);
        TitledBorder titulo = new TitledBorder(borda,"Informação pessoal");
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[] {"nome","Data de nascimento","Nª de BI","Genero","Endereco"});
        
        
        escolha = new JPanel();
        escolha.setLayout(cartas);
        
        painelData = new JPanel();
        data = new JDateChooser();
        painelData.setLayout(new BorderLayout());
        painelData.add(data);
        
        edicao= new JPanel();
        edicao.setLayout(new GridLayout(1,1));
        BorderLayout border = new BorderLayout();
        GridLayout grid = new GridLayout(8,2);
        
        painelWest= new JPanel();
        painelWest.setLayout(new BorderLayout());
        subPainelWest= new JPanel();
        subPainelWest.setLayout(new BorderLayout());
        
        painel = new JPanel();
        painel.setLayout(border);
        painel1 = new JPanel();
        painel1.setLayout(new BorderLayout());
        painD1= new JPanel();
        painD1.setLayout(new GridLayout(3,2));
        painD1.setBorder(new TitledBorder(borda, "Informações de login"));
        
        painD = new JPanel();
        painD.setLayout(grid);
        painD.setBorder(titulo);
        
        painD2 = new JPanel();
        painD2.setBorder(borda);
        painD2.setLayout(new GridLayout(1,2));
        
        try {
            tabela = new JTable(Controle.Modelos.modeloU());
        } catch (Exception ex) {
            Logger.getLogger(AdicionarU.class.getName()).log(Level.SEVERE, null, ex);
        }
        scroll = new JScrollPane(tabela);
        scroll.setBorder(borda);
        masc = new JRadioButton("Masculino");
        femi = new JRadioButton("Feminino");
        admin= new JRadioButton("Admininistrador");
        normal= new JRadioButton("Normal");
        nome = new JTextField(15);
        endereco = new JTextField(15);
        BI = new JTextField(15);
        email = new JTextField(" ");
        //email.addKeyListener(new Restricao());
        contacto = new JFormattedTextField();
        username = new JTextField();
        username.addKeyListener(new Restricao());
        senha = new JTextField();
        senha.addKeyListener(new Restricao());
        gravar = new JButton("Gravar");
        gravar.addActionListener(new Auxiliar.Botao());
        adicionar1 = new JButton("Adição");
        adicionar1.addActionListener(new Auxiliar.Botao());
        editar = new JButton("Edição");
        editar.addActionListener(new Auxiliar.Botao());
        eliminar= new JButton("Remoção");
        eliminar.addActionListener(new Auxiliar.Botao());
        try {
            lista=new JComboBox(Modelos.listaUsuarios());
        } catch (Exception ex) {
            Logger.getLogger(AdicionarU.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.addItemListener(new ItemUsuario());
        //lista.addItemListener(new Itens());
        grupo1 = new ButtonGroup();
        grupo = new ButtonGroup();
        grupo.add(masc);
        grupo.add(femi);
        grupo1.add(admin);
        grupo1.add(normal);
        
        //escolhas
        //editar
        adicao= new JPanel();
        opcoes= new JPanel();
        opcoes.setLayout(new GridLayout(1,3,4,10));
        opcoes.add(adicionar1);
        opcoes.add(editar);
        opcoes.add(eliminar);
        edicao.add(lista);
        //escolha.add(edicao,"edicao");
        escolha.add(adicao,"adicao");
        escolha.add(edicao,"edicao");
        
        mae = new JPanel();
        mae.setBorder(new TitledBorder(borda, "Opções"));
        mae.setLayout(new GridLayout(2,1));
        mae.add(opcoes);
        mae.add(escolha);
        
        
        painD.add(new JLabel("Nome"));
        painD.add(nome);
        painD.add(new JLabel("Data de Nascimento"));
        //painD.add(data);
        painD.add(painelData);
        painD.add(new JLabel("Contacto"));
        painD.add(contacto);
        painD.add(new JLabel("Email"));
        painD.add(email);
        painD.add(new JLabel("Nº de BI"));
        painD.add(BI);
        painD.add(new JLabel("Genero"));
        painD.add(new JLabel(" "));
        painD.add(masc);
        painD.add(femi);
        painD.add(new JLabel("Endereco"));
        painD.add(endereco);
        
        painD1.add(new JLabel("Nome de usuario"));
        painD1.add(username);
        painD1.add(new JLabel("Senha"));
        painD1.add(senha);
        painD1.add(admin);        
        painD1.add(normal);
        painD2.add(new JLabel(""));
        painD2.add(gravar);
        
        painel1.add(painD,BorderLayout.NORTH);
        painel1.add(painD1,BorderLayout.CENTER);
        painel1.add(painD2,BorderLayout.SOUTH);
        subPainelWest.add(mae,BorderLayout.NORTH);
        subPainelWest.add(painel1,BorderLayout.CENTER);
        painelWest.add(subPainelWest,BorderLayout.NORTH); 
        
        //Barra b = new Barra();
        
        painel.add(painelWest,BorderLayout.WEST);
        painel.add(scroll,BorderLayout.CENTER);
        //painel.
        this.setLayout(new BorderLayout());
        //add(new Barra(),BorderLayout.NORTH);
        //add(painel,BorderLayout.CENTER);
        add(painel);
        //this.setUndecorated(true);
        //this.pack();
        this.setTitle("Adicionar");
        this.setSize(1000,600);
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width  / 2) - (this.getWidth() / 2)),((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
        this.setVisible(true);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        
        contacto.addKeyListener(new Restricao());
        
        
        
    }

    public static void main(String[] args) {
        final AdicionarU a = new AdicionarU();
 
    }   
}
