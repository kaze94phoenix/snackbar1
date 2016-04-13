package mysql.entity;
// Generated Apr 11, 2016 9:21:47 AM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * ItemPedido generated by hbm2java
 */
public class ItemPedido  implements java.io.Serializable {


     private Integer id;
     private int itemId;
     private int pedidoId;
     private Date data;

    public ItemPedido() {
    }

    public ItemPedido(int itemId, int pedidoId, Date data) {
       this.itemId = itemId;
       this.pedidoId = pedidoId;
       this.data = data;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getItemId() {
        return this.itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getPedidoId() {
        return this.pedidoId;
    }
    
    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }




}


