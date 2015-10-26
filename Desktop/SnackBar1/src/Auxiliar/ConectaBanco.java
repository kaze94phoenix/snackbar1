package Auxiliar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package livraria;

import Interface.AdicionarP;
import Interface.AdicionarU;
import Modelos.Alimento;
import Modelos.Bebidas;
import Modelos.Pedidos;
import Modelos.RelatorioGestao;
import Modelos.RelatorioVenda;
import Modelos.Usuario;
import Modelos.Venda;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class ConectaBanco {
    public static PreparedStatement pst;
    public static Statement stm;//responsavel por preparar e realizar pesquisas na base de dados
    public static ResultSet rs;//responsavel por armazenar o resultado de uma pesquisa passada para o statement
    private static String driver="org.postgresql.Driver";//e responsavel por identificar o servico de base de dados
    private static String caminho="jdbc:postgresql://localhost:5433/snackbar";//responsavel por configurar o servico de base de dados
    private static String  usuario="postgres";
    private static String senha="powerfull";
    public static Connection conn;//responsavel por realizar a conexao com a base de dados
   // private final String INSERT_PESSOA = "INSERT INTO criancas (nome_crianca,genero_crianca,dia_crianca,mes_crianca,ano_crianca,distrito_crianca) VALUES (?,?,?,?,?,?,?)";
    public static void conexao(){//metodo responsavel por realizar a conexao com a base
       
        try {//tentativa inicial
             System.setProperty("jdbc.Drivers",driver);//configura o driver de conexao
            conn=DriverManager.getConnection(caminho, usuario, senha);//realiza a conexao com  base de dados
            System.out.println("Conectado Com Sucesso");//imprime uma mensagem
        } catch (SQLException ex) {//exception
            JOptionPane.showMessageDialog(null,"Erro na Conexao\n Erro:"+ex.getMessage());
        }
    }
    
    
     public static void inserirUsuario(Usuario u) throws Exception{
        conexao();
        String sql="insert into usuarios(nome_usuario,bi_usuario,data_usuario,contacto_usuario,genero_usuario,morada_usuario,username_usuario,password_usuario,categoria,email_usuario) values(?,?,?,?,?,?,?,?,?,?)  ";
        
        PreparedStatement stm=conn.prepareStatement(sql);
        
        stm.setString(1,u.getNome());
        stm.setString(2,u.getBi());
        stm.setDate(3, new java.sql.Date( u.getDataNasc().getTime()));
        stm.setString(4,u.getContacto());
        stm.setString(5, u.getGenero());
        stm.setString(6, u.getEndereco());
        stm.setString(7, u.getUsername());
        stm.setString(8, u.getPassword());
        stm.setString(9, u.getCategoria());
        stm.setString(10, u.getEmail());
        stm.executeUpdate();
        JOptionPane.showMessageDialog(null,"Gravado Com Sucesso");//imprime uma mensagem
        //desconecta();
     }
     public static void inserirBebida(Bebidas b) throws Exception{
         conexao();
         String sql ="insert into bebidas(nome_bebida,preco_bebida,alcoolica_bebida) values(?,?,?)";
         PreparedStatement stm=conn.prepareStatement(sql);
         
         stm.setString(1, b.getNome());
         stm.setDouble(2, b.getPreco());
         stm.setBoolean(3, b.isAlcoolica());
         stm.executeUpdate();
         JOptionPane.showMessageDialog(null, "Gravado com sucesso");
         desconecta();
     }  
     
     public static void inserirAlimento(Alimento a) throws SQLException{
         conexao();
         String sql="insert into comidas(nome_comida,preco_comida) values(?,?)";
         PreparedStatement stm=conn.prepareStatement(sql);
         stm.setString(1,a.getNome());
         stm.setDouble(2, a.getPreco());
         stm.executeUpdate();
         JOptionPane.showMessageDialog(null,"Gravado Com Sucesso");
        desconecta(); 
     }
     
     public static ArrayList<Alimento> lerAlimentos() throws SQLException{
         conexao();
         ArrayList<Alimento> arr = new ArrayList();
         String sql= "select * from comidas";
         PreparedStatement stm = conn.prepareStatement(sql);
         ResultSet rs = stm.executeQuery();
         while(rs.next()){
             Alimento al = new Alimento(rs.getString("nome_comida"),rs.getDouble("preco_comida"),rs.getInt("id_comida"),rs.getInt("id_comida"));
             arr.add(al);
         } //desconecta();
         return arr;
     }
     
     public static void editarUsuario(int iUsuario) throws SQLException {
         int id =  lerUsuarios().get(iUsuario).getCodigo();
                    
                    PreparedStatement stm = ConectaBanco.conn.prepareStatement("update usuarios set nome_usuario=? , bi_usuario=? , data_usuario=? , contacto_usuario=? , genero_usuario=? , morada_usuario=? , username_usuario=? , password_usuario=? , categoria=? , email_usuario=? where id_usuario=?");
                    stm.setString(1, AdicionarU.DadosU().getNome());
                    stm.setString(2, AdicionarU.DadosU().getBi());
                    stm.setDate(3, new java.sql.Date(AdicionarU.DadosU().getDataNasc().getTime()));
                    stm.setString(4, AdicionarU.DadosU().getContacto());
                    stm.setString(5, AdicionarU.DadosU().getGenero());
                    stm.setString(6, AdicionarU.DadosU().getEndereco());
                    stm.setString(7, AdicionarU.DadosU().getUsername());
                    stm.setString(8, AdicionarU.DadosU().getPassword());
                    stm.setString(9, AdicionarU.DadosU().getCategoria());
                    stm.setString(10, AdicionarU.DadosU().getEmail());
                    stm.setInt(11, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Actualizado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
     
     public static void editarComida(int iComida) throws SQLException {
         int id = lerAlimentos().get(iComida).getCodigo();
                    
                    PreparedStatement stm = ConectaBanco.conn.prepareStatement("update comidas set nome_comida=? , preco_comida=?  where id_comida=?");
                    stm.setString(1, AdicionarP.dadosA().getNome());
                    stm.setDouble(2, AdicionarP.dadosA().getPreco());
                    stm.setInt(3, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Actualizado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
     
     
     public static void editarBebida(int iBebida) throws Exception {
         int id =  lerBebida().get(iBebida).getCodigo();
                    
                    PreparedStatement stm = ConectaBanco.conn.prepareStatement("update bebidas set nome_bebida=? , preco_bebida=? , alcoolica_bebida=?  where id_bebida=?");
                    stm.setString(1, AdicionarP.dadosB().getNome());
                    stm.setDouble(2, AdicionarP.dadosB().getPreco());
                    stm.setBoolean(3, AdicionarP.dadosB().isAlcoolica());
                    stm.setInt(4, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Actualizado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
     
     public static void eliminarUsuario(int iUsuario) throws SQLException {
         int id =  lerUsuarios().get(iUsuario).getCodigo();
                  conexao();
                 PreparedStatement stm = ConectaBanco.conn.prepareStatement("delete from usuarios where id_usuario=?");
                    stm.setInt(1, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Eliminado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
     
     public static void eliminarComida(int iComida) throws SQLException {
         int id =  lerAlimentos().get(iComida).getCodigo();
                 PreparedStatement stm = ConectaBanco.conn.prepareStatement("delete from comidas where id_comida=?");
                    stm.setInt(1, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Eliminado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
     
     public static void eliminarBebida(int iBebida) throws Exception {
         int id =  lerBebida().get(iBebida).getCodigo();
                 PreparedStatement stm = ConectaBanco.conn.prepareStatement("delete from bebidas where id_bebida=?");
                    stm.setInt(1, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Eliminado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
     
      
     
     public static ArrayList<Usuario> lerUsuarios() throws SQLException{
        conexao();
          ArrayList<Usuario> arrayList = new ArrayList();
          
        
            String sql=" select* from usuarios ";
            PreparedStatement stm=conn.prepareStatement(sql);
            
            
            ResultSet rs =  stm.executeQuery();
            
            while(rs.next()){
                Usuario p = new Usuario();
                p.setCodigo(rs.getInt("id_usuario"));
                p.setNome(rs.getString("nome_usuario"));
                p.setBi(rs.getString("bi_usuario"));
                p.setDataNasc((Date)rs.getDate("data_usuario"));
                p.setContacto(rs.getString("contacto_usuario"));
                p.setGenero(rs.getString("genero_usuario"));
                p.setEndereco(rs.getString("morada_usuario"));
                p.setUsername(rs.getString("username_usuario"));
                p.setPassword(rs.getString("password_usuario"));
                p.setCategoria((rs.getString("categoria")));
                p.setEmail(rs.getString("email_usuario"));
                arrayList.add(p);
            }
            
            //desconecta();
            return arrayList;
            
                    
      }
     
     public static ArrayList<Bebidas> lerBebida() throws SQLException {
          conexao();  
         ArrayList<Bebidas> a = new ArrayList();        
            String sql=" select* from bebidas ";
            PreparedStatement stm=conn.prepareStatement(sql);

         ResultSet rs = stm.executeQuery();
         while(rs.next()){
             Bebidas b = new Bebidas();
             b.setCodigo(rs.getInt("id_bebida"));
             b.setNome(rs.getString("nome_bebida"));
             b.setPreco(rs.getDouble("preco_bebida"));
             b.setAlcoolica(rs.getBoolean("alcoolica_bebida"));
             a.add(b);
           }
         //desconecta();
         return a;
     }
     
     public static ArrayList<Bebidas> lerBebidaNA() throws SQLException { 
         ArrayList<Bebidas> bebidasNA = new ArrayList<>();
            for(Bebidas bNA: lerBebida())
                if(!bNA.isAlcoolica())
                    bebidasNA.add(bNA);
         return bebidasNA;
     }
     
     
     public static ArrayList<Bebidas> lerBebidaA() throws SQLException { 
         ArrayList<Bebidas> bebidasA = new ArrayList<>();
            for(Bebidas bA: lerBebida())
                if(bA.isAlcoolica())
                    bebidasA.add(bA);
         return bebidasA;
     }
     
     
     public static void fazerRelatVendas(RelatorioVenda rv) throws Exception{
         conexao();
         String sql ="insert into relatorio_vendas(usuario,pagamento,mesa,data) values(?,?,?,?)";
         PreparedStatement stm=conn.prepareStatement(sql);
         
         stm.setString(1, rv.getUsuario());
         stm.setDouble(2, rv.getPagamento());
         stm.setInt(3, rv.getMesa());
         stm.setDate(4, new java.sql.Date( rv.getData().getTime()));
         stm.executeUpdate();
         System.out.println("Relatorio efectuado com sucesso");
         desconecta();
     }  
     
     
     public static void fazerRelatGestao(RelatorioGestao rg) throws Exception{
         conexao();
         String sql ="insert into relatorio_gestao(usuario,accao,registro,data) values(?,?,?,?)";
         PreparedStatement stm=conn.prepareStatement(sql);
         
         stm.setString(1, rg.getUsuario());
         stm.setString(2, rg.getAccao());
         stm.setString(3, rg.getRegistro());
         stm.setDate(4, new java.sql.Date( rg.getData().getTime()));
         stm.executeUpdate();
         System.out.println("Relatorio efectuado com sucesso");
         desconecta();
     }  
     
     public Usuario pesquisa(int id) throws SQLException{
         return null;
         
     }
     
     public static ArrayList<RelatorioGestao> buscaRelatGestao() throws Exception{
        conexao();
          ArrayList<RelatorioGestao> arrayList = new ArrayList();
          
        
            String sql=" select* from relatorio_gestao";
            PreparedStatement stm=conn.prepareStatement(sql);
            
            
            ResultSet rs =  stm.executeQuery();
            
            while(rs.next()){
                RelatorioGestao rg = new RelatorioGestao();
                rg.setUsuario(rs.getString("usuario"));
                rg.setAccao(rs.getString("accao"));
                rg.setRegistro(rs.getString("registro"));
                rg.setData(rs.getDate("data"));
                arrayList.add(rg);
            }
            
            //desconecta();
            return arrayList;
         
     }
     
     public static ArrayList<RelatorioVenda> buscaRelatVendas() throws Exception{
        conexao();
          ArrayList<RelatorioVenda> arrayList = new ArrayList();
          
        
            String sql=" select* from relatorio_vendas";
            PreparedStatement stm=conn.prepareStatement(sql);
            
            
            ResultSet rs =  stm.executeQuery();
            
            while(rs.next()){
                RelatorioVenda rv = new RelatorioVenda();
                rv.setUsuario(rs.getString("usuario"));
                rv.setPagamento(rs.getDouble("pagamento"));
                rv.setMesa(rs.getInt("mesa"));
                rv.setData(rs.getDate("data"));
                arrayList.add(rv);
            }
            
            //desconecta();
            return arrayList;
         
     }
     
     public static ArrayList<Venda> buscaVendas() throws SQLException{
        conexao();
          ArrayList<Venda> arrayList = new ArrayList();
          
        
            String sql=" select* from vendas";
            PreparedStatement stm=conn.prepareStatement(sql);
            
            
            ResultSet rs =  stm.executeQuery();
            
            while(rs.next()){
                Venda v = new Venda();
                v.setItem(rs.getString("item"));
                v.setQtd(rs.getInt("qtd"));
                v.setMesa(rs.getInt("mesa"));
                v.setPrecoUni(rs.getDouble("preco_unitario"));
                v.setPrecoTotal(rs.getDouble("preco_total"));
                v.setData(rs.getDate("data"));
                arrayList.add(v);
            }
            
            //desconecta();
            return arrayList;
         
     }
     
     public static void escreveVenda(Pedidos p) throws SQLException{
         conexao();
         //int mesa=p.getMesa();
//         Date  data = new Date();
         ArrayList<Alimento> com = p.getAlimentos();
         ArrayList<Bebidas> beb = p.getBebidas();
         
         for(Alimento c: com){
         String sql ="insert into vendas(item,qtd,mesa,preco_unitario,preco_total,data) values(?,?,?,?,?,?)";
         PreparedStatement stm=conn.prepareStatement(sql);
         
         stm.setString(1, c.getNome());
         stm.setInt(2, c.getQtd());
         stm.setDouble(3, p.getMesa());
         stm.setDouble(4, c.getPreco());
         stm.setDouble(5, c.precoTotal());
         stm.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
         stm.executeUpdate();
         System.out.println("Relatorio efectuado com sucesso");
         }
         
         for(Bebidas b: beb){
         String sql ="insert into vendas(item,qtd,mesa,preco_unitario,preco_total,data) values(?,?,?,?,?,?)";
         PreparedStatement stm=conn.prepareStatement(sql);
         
         stm.setString(1, b.getNome());
         stm.setInt(2, b.getQtd());
         stm.setDouble(3, p.getMesa());
         stm.setDouble(4, b.getPreco());
         stm.setDouble(5, b.precoTotal());
         stm.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
         stm.executeUpdate();
         System.out.println("Relatorio efectuado com sucesso");
         }
         
         desconecta();
     }
     
     
     public static void executaSQL(String sql) throws SQLException{
         stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = stm.executeQuery(sql);
     }
     
    

    public static void desconecta(){ 
        try {
            //metodo responsavel por desconectar a base
       conn.close();//fecha a conexao
            System.out.println("Desconectado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao fechar a conexao\n Erro:"+ex.getMessage());
        }
    }

    
    
}
