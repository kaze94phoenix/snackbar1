/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.util.Date;

/**
 *
 * @author Gaara-X
 */
public class Venda {
    private String item;
    private int qtd,mesa;
    private double precoUni,precoTotal;
    private Date data;
    
    public Venda() {
    }

    public Venda(String item, int qtd, int mesa, double precoUni, double precoTotal, Date data) {
        this.item = item;
        this.qtd = qtd;
        this.mesa = mesa;
        this.precoUni = precoUni;
        this.precoTotal = precoTotal;
        this.data = data;
    }

    public Venda(String item, int qtd, int mesa, double precoUni, double precoTotal) {
        this.item = item;
        this.qtd = qtd;
        this.mesa = mesa;
        this.precoUni = precoUni;
        this.precoTotal = precoTotal;
        
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public double getPrecoUni() {
        return precoUni;
    }

    public void setPrecoUni(double precoUni) {
        this.precoUni = precoUni;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
   
}
