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
public class RelatorioGestao {
    private String usuario,accao,registro;
    private Date data;

    public RelatorioGestao() {
    }

    public RelatorioGestao(String usuario, String accao, String registro, Date data) {
        this.usuario = usuario;
        this.accao = accao;
        this.registro = registro;
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccao() {
        return accao;
    }

    public void setAccao(String accao) {
        this.accao = accao;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RelatorioGestao{" + "usuario=" + usuario + ", accao=" + accao + ", registro=" + registro + ", data=" + data + '}';
    }

    

}


