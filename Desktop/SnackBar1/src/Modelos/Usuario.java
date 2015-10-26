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
public class Usuario implements java.io.Serializable {
    private String nome,contacto,bi,genero,endereco,username,password,categoria,email;
    private Date dataNasc;
    private int codigo;

    public Usuario(String nome, String contacto, String bi, String genero, String endereco, String username, String password, String categoria, String email, Date dataNasc, int codigo) {
        this.nome = nome;
        this.contacto = contacto;
        this.bi = bi;
        this.genero = genero;
        this.endereco = endereco;
        this.username = username;
        this.password = password;
        this.categoria = categoria;
        this.email = email;
        this.dataNasc = dataNasc;
        this.codigo = codigo;
    }
   

    public Usuario() {
    }

    public Usuario(String nome, Date dataNasc, String contacto,String email, String bi, String genero, String endereco, String username, String password,String categoria) {
        this.nome = nome;
        this.contacto = contacto;
        this.email=email;
        this.bi = bi;
        this.genero = genero;
        this.endereco = endereco;
        this.username = username;
        this.password = password;
        this.dataNasc = dataNasc;
        this.categoria= categoria;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    


    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", contacto=" + contacto + ", bi=" + bi + ", genero=" + genero + ", endereco=" + endereco + ", username=" + username + ", password=" + password + ", dataNasc=" + dataNasc+" Categoria" +categoria+"Email :"+email+ '}';
    }
    
      
}
