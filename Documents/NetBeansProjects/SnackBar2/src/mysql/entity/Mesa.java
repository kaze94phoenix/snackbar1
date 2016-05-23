package mysql.entity;
// Generated May 3, 2016 11:41:31 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Mesa generated by hbm2java
 */
public class Mesa  implements java.io.Serializable {


     private Integer id;
     private int numero;
     private boolean mesalivre;
     private Set pedidos = new HashSet(0);

    public Mesa() {
    }

	
    public Mesa(int numero, boolean mesalivre) {
        this.numero = numero;
        this.mesalivre = mesalivre;
    }
    public Mesa(int numero, boolean mesalivre, Set pedidos) {
       this.numero = numero;
       this.mesalivre = mesalivre;
       this.pedidos = pedidos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public boolean isMesalivre() {
        return this.mesalivre;
    }
    
    public void setMesalivre(boolean mesalivre) {
        this.mesalivre = mesalivre;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }

    public String toString(){
        return "Mesa "+numero;
    }


}


