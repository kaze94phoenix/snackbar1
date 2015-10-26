package Controle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package livraria;

import Interface.AdicionarP;
import Interface.AdicionarU;
import Modelos.Alimento;
import Modelos.Bebidas;
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
            System.out.println("Conectado com Sucesso");//imprime uma mensagem
        } catch (SQLException ex) {//exception
            System.out.println("Erro na Conexao\\n Erro:"+ex.getMessage());
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
        desconecta();
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
             Alimento al = new Alimento(rs.getString("nome_comida"),rs.getDouble("preco_comida"), rs.getInt("id_comida"));
             arr.add(al);
         } desconecta();
         return arr;
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
            
            desconecta();
            return arrayList;
            
                    
      }
     
     
     
     public static ArrayList<Bebidas> lerBebida() throws Exception {
          conexao();  
         ArrayList<Bebidas> a = new ArrayList();        
            String sql=" select * from bebidas ";
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
         desconecta();
         return a;
     }
     
     public Usuario pesquisa(int id) throws SQLException{
         return null;
         
     }
     
     public static Alimento buscaAlimento(String s) throws SQLException{
         Alimento al= new Alimento("Vazio",0);
         for(Alimento a:lerAlimentos())
             if(a.getNome().equals(s))
                 al=a;
     return al;
     }
     
          public static Bebidas buscaBebida(String s) throws SQLException, Exception{
         Bebidas al= new Bebidas(false,"Vazio",0);
         for(Bebidas b:lerBebida())
             if(b.getNome().equals(s))
                 al=b;
     return al;
     }
               public static Usuario buscaUsuario(String s) throws SQLException{
         Usuario u= null;
         for(Usuario a:lerUsuarios())
             if(a.getNome().equals(s))
                 u=a;
     return u;
     }
    
               
                    public static void editarUsuario(int iUsuario) throws SQLException {
                    int id = Controle.ConectaBanco.lerUsuarios().get(iUsuario).getCodigo();
                    conexao();
                    PreparedStatement stm = ConectaBanco.conn.prepareStatement("update usuarios set nome_usuario=? , bi_usuario=? , data_usuario=? , contacto_usuario=? , genero_usuario=? , morada_usuario=? , username_usuario=? , password_usuario=? , categoria=? , email_usuario=? where id_usuario=?");
                    Usuario u =  AdicionarU.DadosU();
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
         int id = Controle.ConectaBanco.lerAlimentos().get(iComida).getCodigo();
                             conexao();
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
         int id = Controle.ConectaBanco.lerBebida().get(iBebida).getCodigo();
                    conexao();
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
         int id = Controle.ConectaBanco.lerUsuarios().get(iUsuario).getCodigo();
         conexao();
                 PreparedStatement stm = ConectaBanco.conn.prepareStatement("delete from usuarios where id_usuario=?");
                    stm.setInt(1, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Eliminado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
      
          public static void eliminarComida(int iComida) throws SQLException {
         int id = Controle.ConectaBanco.lerAlimentos().get(iComida).getCodigo();
                  conexao();
                 PreparedStatement stm = ConectaBanco.conn.prepareStatement("delete from comidas where id_comida=?");
                    stm.setInt(1, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Eliminado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }
              public static void eliminarBebida(int iBebida) throws Exception {
         int id = Controle.ConectaBanco.lerBebida().get(iBebida).getCodigo();
                 PreparedStatement stm = ConectaBanco.conn.prepareStatement("delete from bebidas where id_bebida=?");
                    stm.setInt(1, id);
                    stm.execute();
                    JOptionPane.showMessageDialog(null, "Eliminado Com Sucesso");//imprime uma mensagem
                    desconecta();
                    
                    System.out.println("Funciona :')");
     }

    public static void desconecta(){ 
        try {
            //metodo responsavel por desconectar a base
       conn.close();//fecha a conexao
            System.out.println("Desconectado com Sucesso");
        } catch (SQLException ex) {
            System.out.println("erro ao fechar a conexao\n Erro:"+ex.getMessage());
        }
    }

    
    
}
