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
public class Alimento implements java.io.Serializable {
    protected String nome;
    protected double preco;
    protected int qtd;
    protected int codigo;
    public Alimento() {
    }

    public Alimento(String nome, double preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }
    
    

    public Alimento(String nome, double preco, int qtd, int codigo) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Alimento(int codigo,String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }
    
    
    

    public Alimento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    public double precoTotal(){
        return qtd*preco;
    }

    @Override
    public String toString() {
        return "Alimento" + "  " + nome + ", preco=" + preco + ", qtd=" + qtd +"\n";
    }

    
    
}
