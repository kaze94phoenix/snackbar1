/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gaara-X
 */
public class Pedidos implements Serializable {
    private ArrayList<Alimento> alimentos;
    private ArrayList<Bebidas> bebidas;
    private int mesa;

    public Pedidos() {
    }

    public Pedidos(ArrayList<Alimento> alimentos, ArrayList<Bebidas> bebidas,int mesa) {
        this.alimentos = alimentos;
        this.bebidas = bebidas;
        this.mesa=mesa;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public ArrayList<Bebidas> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebidas> bebidas) {
        this.bebidas = bebidas;
    }

    @Override
    public String toString() {
       return "Pedido"+"\n" + "alimentos=" + alimentos + ", bebidas=" + bebidas + "Mesa "+mesa+" "+"\n";
    }
    
    
    

    
}
