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
public class RelatorioVenda {
    private String usuario;
    private int mesa;
    private double pagamento;
    private Date data;

    public RelatorioVenda() {
    }

    public RelatorioVenda(String usuario, int mesa, double pagamento, Date data) {
        this.usuario = usuario;
        this.mesa = mesa;
        this.pagamento = pagamento;
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RelatorioVenda{" + "usuario=" + usuario + ", mesa=" + mesa + ", pagamento=" + pagamento + ", data=" + data + '}';
    }
    
    
}
