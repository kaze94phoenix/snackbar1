package mysql.entity;
// Generated May 3, 2016 11:41:31 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Tipoitem generated by hbm2java
 */
public class Tipoitem  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Set items = new HashSet(0);

    public Tipoitem() {
    }

	
    public Tipoitem(String nome) {
        this.nome = nome;
    }
    public Tipoitem(String nome, Set items) {
       this.nome = nome;
       this.items = items;
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
    public Set getItems() {
        return this.items;
    }
    
    public void setItems(Set items) {
        this.items = items;
    }
    
    public String toString(){
        return nome;
    }



}


