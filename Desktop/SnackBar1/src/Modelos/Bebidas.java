/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

/**
 *
 * @author Gaara-X
 */
public class Bebidas extends Alimento implements java.io.Serializable {
    protected boolean alcoolica;

    public Bebidas(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    public Bebidas() {
    }
    

    public Bebidas(boolean alcoolica, String nome, double preco) {
        super(nome, preco);
        this.alcoolica = alcoolica;
    }

    public Bebidas(boolean alcoolica, String nome, double preco, int qtd, int codigo) {
        super(nome, preco, qtd, codigo);
        this.alcoolica = alcoolica;
    }

    public Bebidas(String nome, double preco, int qtd, int codigo) {
        super(nome, preco, qtd, codigo);
    }
    
    

    public Bebidas(boolean alcoolica, String nome, double preco, int qtd) {
        super(nome, preco, qtd);
        this.alcoolica = alcoolica;
    }
    
    

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    @Override
    public String toString() {
        return "Bebida" + "  " + nome + ", preco=" + preco + ", qtd=" + qtd +"\n" ;
    }
    

}


