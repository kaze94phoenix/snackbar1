package Modelos;

//Celso Maria Afonso Maxlhaieie
//Osvaldo Maria
import java.util.*;

public class Mesas implements java.io.Serializable {

    private ArrayList<Pedidos> pedidos;
    private double total = 0, totalComida = 0, totalBebida = 0;

    public Mesas(ArrayList<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
    
    public Mesas(){
        
    }
    
    public void setPedidos(Pedidos pedido){
        pedidos.add(pedido);
    }

    public void setPedidos(ArrayList<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Pedidos> getPedidos() {
        return pedidos;
    }

//Metodo que devolvera a conta da respectiva mesa 
    public double getTotal() {
        return total;
    }

//Metodo que devolvera o total em comidas da respectiva mesa
    public double getTotalComida() {
        return totalComida;
    }

//Metodo que devolvera o total em bebidas da respectiva mesa
    public double getTotalBebida() {
        return totalBebida;
    }

    public String toString() {
        return null;
    }

}
