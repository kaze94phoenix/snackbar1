/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelos.Alimento;
import Modelos.Bebidas;
import java.util.ArrayList;

/**
 *
 * @author Gaara-X
 */
public class Pedidos implements java.io.Serializable {
    private ArrayList<Alimento> alimentos;
    private ArrayList<Bebidas> bebidas;
    private int nrMesa;

    public Pedidos(ArrayList<Alimento> alimentos, ArrayList<Bebidas> bebidas, int nrMesa) {
        this.alimentos = alimentos;
        this.bebidas = bebidas;
        this.nrMesa = nrMesa;
    }
    
    public Pedidos() {
    }

    public Pedidos(ArrayList<Alimento> alimentos, ArrayList<Bebidas> bebidas) {
        this.alimentos = alimentos;
        this.bebidas = bebidas;
    }

    public int getNrMesa() {
        return nrMesa;
    }

    public void setNrMesa(int nrMesa) {
        this.nrMesa = nrMesa;
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
    public String listaPedidos(){
        String lista="";
        String lista1="";
        for(Alimento iter:alimentos)
            lista+=iter.toString();
        for(Bebidas iter:bebidas)
            lista1+=iter.toString();
        return (lista+lista1);
    }

    @Override
    public String toString() {
        return "Pedidos{" + "alimentos=" + alimentos + ", bebidas=" + bebidas + ", nrMesa=" + nrMesa + '}';
    }
    
    
    

    
}
