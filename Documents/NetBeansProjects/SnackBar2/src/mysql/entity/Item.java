package mysql.entity;
// Generated May 3, 2016 11:41:31 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer id;
     private Tipoitem tipoitem;
     private String nome;
     private double preco;
     private Set itemPedidos = new HashSet(0);

    public Item() {
    }

	
    public Item(Tipoitem tipoitem, String nome, double preco) {
        this.tipoitem = tipoitem;
        this.nome = nome;
        this.preco = preco;
    }
    public Item(Tipoitem tipoitem, String nome, double preco, Set itemPedidos) {
       this.tipoitem = tipoitem;
       this.nome = nome;
       this.preco = preco;
       this.itemPedidos = itemPedidos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Tipoitem getTipoitem() {
        return this.tipoitem;
    }
    
    public void setTipoitem(Tipoitem tipoitem) {
        this.tipoitem = tipoitem;
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
    public Set getItemPedidos() {
        return this.itemPedidos;
    }
    
    public void setItemPedidos(Set itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public String toString(){
        return nome;
    }


}


