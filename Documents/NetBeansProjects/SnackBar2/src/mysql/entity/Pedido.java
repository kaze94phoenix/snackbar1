package mysql.entity;
// Generated Apr 11, 2016 9:21:47 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Pedido generated by hbm2java
 */
public class Pedido  implements java.io.Serializable {


     private Integer id;
     private int balconistaId;
     private int mesaId;
     private Date data;

    public Pedido() {
    }

    public Pedido(int balconistaId, int mesaId, Date data) {
       this.balconistaId = balconistaId;
       this.mesaId = mesaId;
       this.data = data;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getBalconistaId() {
        return this.balconistaId;
    }
    
    public void setBalconistaId(int balconistaId) {
        this.balconistaId = balconistaId;
    }
    public int getMesaId() {
        return this.mesaId;
    }
    
    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }




}


