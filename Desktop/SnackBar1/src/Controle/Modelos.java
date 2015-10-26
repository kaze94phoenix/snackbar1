/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Interface.AdicionarP;
import Interface.AdicionarU;
import Modelos.Alimento;
import Modelos.Bebidas;
import Modelos.Pedidos;
import Modelos.RelatorioGestao;
import Modelos.RelatorioVenda;
import Modelos.Usuario;
import Modelos.Venda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaara-X
 */
public class Modelos {
public static ArrayList<Integer> mesas= new ArrayList<>();
public static ArrayList<Integer> mesasOcup= new ArrayList<>();
public static ArrayList<Integer> mesasLiv= new ArrayList<>();
    
    public static Double total=0.0;
    public static DefaultTableModel modeloU() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
         //ConectaBanco.lerUsuarios();
         modelo.setColumnCount(6);
         modelo.setColumnIdentifiers(new Object[] {"Nome","Nr BI","Data de nascimento","Genero","Contacto","Email","Endereco","Nome de usuario","Senha","Categoria"});
         for(Usuario u:ConectaBanco.lerUsuarios())
             modelo.addRow(new Object[]{" "+u.getNome(),u.getBi(),u.getDataNasc(),u.getGenero(),u.getContacto(),u.getEmail(),u.getEndereco(),u.getUsername(),u.getPassword(),u.getCategoria()});
         
         return modelo;
    }
    
    public static DefaultTableModel modeloA() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
         modelo.setColumnCount(2);
         modelo.setColumnIdentifiers(new Object[] {"Nome","Preco"});
         for(Alimento a:ConectaBanco.lerAlimentos())
             modelo.addRow(new Object[]{" "+a.getNome(),a.getPreco()});
         
         return modelo;
    }
    
   public static DefaultTableModel modeloB() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
         modelo.setColumnCount(3);
         modelo.setColumnIdentifiers(new Object[] {"Nome","Preco","Alcoolica"});
         for(Bebidas b:ConectaBanco.lerBebida())
             modelo.addRow(new Object[]{" "+b.getNome(),b.getPreco(),b.isAlcoolica()});
         
         return modelo;
    }
   
       public static DefaultComboBoxModel todasBebidas() throws Exception {
        //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Vector<String> v = new Vector();
        for (Bebidas b : ConectaBanco.lerBebida()) {
            v.add(b.getNome());
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
       public static DefaultComboBoxModel listaComidas() throws SQLException{
         //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           Vector<String> v = new Vector();
           for(Alimento a:ConectaBanco.lerAlimentos())
               v.add(a.getNome());
               DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
       
              public static DefaultComboBoxModel bebidasAlcoolicas() throws  Exception{
         //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           Vector<String> v = new Vector();
           for(Bebidas b:ConectaBanco.lerBebida())
               if(b.isAlcoolica())
               v.add(b.getNome());
               DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
                     public static DefaultComboBoxModel bebidasNaoAlcoolicas() throws Exception{
         //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           Vector<String> v = new Vector();
           for(Bebidas b:ConectaBanco.lerBebida())
               if(!b.isAlcoolica())
               v.add(b.getNome());
               DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
    public static DefaultComboBoxModel listaUsuarios() throws Exception{
         //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           Vector<String> v = new Vector();
           for(Usuario u:ConectaBanco.lerUsuarios())
               v.add(u.getNome());
               DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
       public static DefaultComboBoxModel listaBebidas() throws Exception{
         //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           Vector<String> v = new Vector();
           for(Bebidas b:ConectaBanco.lerBebida())
               v.add(b.getNome());
               DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
              public static DefaultComboBoxModel modeloMesas() throws Exception{
         //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           Vector<String> v = new Vector();
           //for(Bebidas b:ConectaBanco.lerBebida())
                  for (int i = 1; i < 5; i++) {
                   v.add("Mesa "+i);   
                  }
               
               DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }
              
    public static DefaultTableModel modeloLista(int iMesa) throws Exception  {
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        ArrayList<Alimento> conteudo = new ArrayList<>();
        Ficheiro file = new Ficheiro();
        pedidos=file.ler();
        //Double total =0;
         //ConectaBanco.lerUsuarios();
        //modelo.setColumnCount(5);
        for (Pedidos p : pedidos) {
            if (p.getMesa() == iMesa) {
                for (Alimento c : p.getAlimentos()) {
                    conteudo.add(c);
                }
                for(Bebidas b : p.getBebidas()){
                    conteudo.add(b);
                }
                 
            }
        } 
        modelo.setColumnIdentifiers(new Object[]{"Nome", "Preco Unitario", "Quantidade", "Preco Total"});
        for(Alimento p: conteudo)
            modelo.addRow(new Object[]{p.getNome(),p.getPreco(),p.getQtd(),p.getPreco()*p.getQtd()});
        total=0.0;
        for(Alimento p: conteudo)
            total+=p.getPreco()*p.getQtd();
        
        modelo.addRow(new Object[] {"","","",""});
        modelo.addRow(new Object[] {"Total","","",total});
      //  total=0.0;
        return modelo;
    }
    //------------------Modelos das Mesas------------------------------------------------------------
    
    public static void adicionaMesas(){
        for (int i = 1; i <= 5; i++)
            mesas.add(i);
        
         System.out.println("Tamanho Adicionado"+mesas.size());
    }
    public static void removeMesaLivre(int i){
        mesasLiv.remove(mesasLiv.get(i));
    }
    public static void removeMesaOcupada(int i){
        for(int j=0;j<mesasOcup.size();j++)
          if(mesasOcup.get(j)==i)
              mesasOcup.remove(j);
        //mesasOcup.remove(i);
    }
    public static void limpaMesasLivres(){
                 mesasLiv.clear();
    }
    
    public static void limpaMesasOcupadas(){
        mesasOcup.clear();
    }
        public static DefaultComboBoxModel mesas() {
        //  DefaultComboBoxModel modelo = new DefaultComboBoxModel();
 System.out.println("Tamanho"+mesas.size());
        Vector<String> v = new Vector();
        for (int i = 1; i <= mesas.size(); i++) {
            v.add("Mesa " + i);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

        return modelo;
    }

    public static DefaultComboBoxModel mesasOcupadas() throws Exception {
           //limpaMesasOcupadas(); //mesasOcup.clear(); 

        for (int i = 0; i < mesas.size(); i++) 
            if(!mesasLiv.contains(mesas.get(i))&&!mesasOcup.contains(mesas.get(i)))
                 mesasOcup.add(mesas.get(i));
               Collections.sort(mesasOcup);
        System.out.println("dados"+mesas);
        Vector<String> v = new Vector();
        for (int j = 0; j <mesasOcup.size(); j++) {
            v.add("Mesa " +mesasOcup.get(j));
            
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

            
        return modelo;
    }
    
     public static DefaultComboBoxModel mesasLiv() {
         ///limpaMesasLivres(); //mesasLiv.clear();
        for (int i = 0; i < mesas.size(); i++) {
            if(!mesasOcup.contains(mesas.get(i))&&!mesasLiv.contains(mesas.get(i)))
                mesasLiv.add(mesas.get(i));
            Collections.sort(mesasLiv);
        }
        Vector<String> v = new Vector();
        for (int j = 0; j < mesasLiv.size(); j++) {
            v.add("Mesa " + mesasLiv.get(j));
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

            
        return modelo;
    } 

    
    
    
    //////////-------------De Celso-------///////////////////////////////
       public static void preencheCamposU(int iUsuario){
        try {
            Usuario u = Controle.ConectaBanco.lerUsuarios().get(iUsuario);
            AdicionarU.nome.setText(u.getNome());
            AdicionarU.data.setDate(u.getDataNasc());
            AdicionarU.contacto.setText(u.getContacto());
            AdicionarU.email.setText(u.getEmail());
            AdicionarU.BI.setText(u.getBi());
            AdicionarU.endereco.setText(u.getEndereco());
            AdicionarU.username.setText(u.getUsername());
            AdicionarU.senha.setText(u.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(Modelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public static void preencheCamposB(int iBebida){
        try {
            Bebidas b = Controle.ConectaBanco.lerBebida().get(iBebida);
            AdicionarP.nomeB.setText(b.getNome());
            AdicionarP.precoB.setText(String.valueOf(b.getPreco()));
        } catch (Exception ex) {
            Logger.getLogger(Modelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public static void preencheCamposC(int iComida){
        try {
            Alimento a = Controle.ConectaBanco.lerAlimentos().get(iComida);
            AdicionarP.nome.setText(a.getNome());
            AdicionarP.preco.setText(String.valueOf(a.getPreco()));
        } catch (SQLException ex) {
            Logger.getLogger(Modelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
    public static DefaultTableModel modeloRelatVendas() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        // modelo.setColumnCount(4);
         modelo.setColumnIdentifiers(new Object[] {"Usuario","Valor Pago","Mesa","Data"});
         for(RelatorioVenda rv: Auxiliar.ConectaBanco.buscaRelatVendas())
             modelo.addRow(new Object[]{rv.getUsuario(),rv.getPagamento(),rv.getMesa(),rv.getData()});
         return modelo;
    }
    
    
    public static DefaultTableModel modeloVendas() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        // modelo.setColumnCount(4);
         modelo.setColumnIdentifiers(new Object[] {"Item","Quentidade","Mesa","Preco Unitario","Preco Total","Data"});
         for(Venda v: Auxiliar.ConectaBanco.buscaVendas())
             modelo.addRow(new Object[]{v.getItem(),v.getQtd(),v.getMesa(),v.getPrecoUni(),v.getPrecoTotal(),v.getData()});
         return modelo;
    }
    
    
    
    public static DefaultTableModel modeloRelatGestao() throws Exception{
        DefaultTableModel modelo = new DefaultTableModel();
        // modelo.setColumnCount(4);
         modelo.setColumnIdentifiers(new Object[] {"Usuario","Accao","Registro","Data"});
            for(RelatorioGestao rv: Auxiliar.ConectaBanco.buscaRelatGestao())
             modelo.addRow(new Object[]{rv.getUsuario(),rv.getAccao(),rv.getRegistro(),rv.getData()});
         return modelo;
    }


}