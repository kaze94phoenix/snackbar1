package mysql.entity;
// Generated Apr 11, 2016 9:21:47 AM by Hibernate Tools 3.6.0



/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private double preco;
     private int tipoitemId;

    public Item() {
    }

    public Item(String nome, double preco, int tipoitemId) {
       this.nome = nome;
       this.preco = preco;
       this.tipoitemId = tipoitemId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return this.preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getTipoitemId() {
        return this.tipoitemId;
    }
    
    public void setTipoitemId(int tipoitemId) {
        this.tipoitemId = tipoitemId;
    }




}


