/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Controle.Botao;
import Controle.MesaAd;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Junior
 */
public class Gestao extends JPanel {
    public Gestao(){
        criacao();
    }
JPanel painel,mesas,users,pratos,container,pFonte;
public static JButton busers,bpratos,gravar,vendas,relatorios;
public static JSpinner spin,Tfonte;
public static Font fonte;
public static int tamanho;
public static int num;
    public void criacao() {
        tamanho = 15;
        fonte = new Font( "Arial", Font.PLAIN, tamanho);
        EtchedBorder borda = new EtchedBorder(EtchedBorder.RAISED);
        int[] i = new int[58];
        SpinnerModel model = new SpinnerNumberModel(new Auxiliar.Ficheiro().config().getMesas(),5,150,1);       
        SpinnerModel modelT = new SpinnerNumberModel(15,15,30,5);
        Tfonte = new JSpinner(modelT);
       spin= new JSpinner(model);
              spin.addChangeListener(new MesaAd());
        num = (Integer) Interface.Gestao.spin.getValue();
       painel= new JPanel();
       users= new JPanel();
       pratos= new JPanel();
       mesas= new JPanel();
       container= new JPanel();
       pFonte = new JPanel();
       container.setLayout(new GridLayout(4,1,0,5));
       painel.setLayout(new BorderLayout());
       //painel= new JPanel();
       busers = new JButton("Usuarios");
       bpratos = new JButton("Pratos");
       gravar = new JButton("Gravar");
       relatorios = new JButton("Relatorios");
       vendas = new JButton("Vendas");
       vendas.addActionListener(new Auxiliar.Botao());
       busers.addActionListener(new Botao());
       vendas.addActionListener(new Botao());
       relatorios.addActionListener(new Auxiliar.Botao());
       bpratos.addActionListener(new Botao());
       
       container.add(vendas);
       container.add(relatorios);
       container.add(busers);
       container.add(bpratos);
       container.setBorder(borda);
       mesas.add(new JLabel("<html><body><font color='red'>Depois de modificar<br>este campo poderá<br> ter de reiniciar <br>a aplicação</body></html>"));
       //"Depois de modificar \r este campo poderá ter de reiniciar a aplicação"
       mesas.add(new JLabel("Nº de mesas"));
       mesas.add(spin);
       //mesas.add(gravar);
       mesas.setBorder(borda);
       pFonte.add(Tfonte);
       painel.add(mesas,BorderLayout.WEST); painel.add(pFonte,BorderLayout.CENTER);
       painel.add(container,BorderLayout.EAST);
       
       this.setLayout(new GridLayout(1,1));
       this.add(painel);
    }
     public static void main(String[] args) {
       JFrame l = new JFrame();
       l.add(new Gestao());
        l.setVisible(true);
        l.pack();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     }
}
