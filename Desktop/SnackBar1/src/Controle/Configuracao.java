/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import java.io.Serializable;

/**
 *
 * @author Gaara-X
 */
public class Configuracao implements Serializable {
    private int fonte;
    private int mesas;

    

    public Configuracao() {
        this.fonte=15;
        this.mesas=5;
    }
    public Configuracao(int fonte, int mesas) {
        this.fonte = fonte;
        this.mesas = mesas;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    public int getFonte() {
        return fonte;
    }

    public void setFonte(int fonte) {
        this.fonte = fonte;
    }

    @Override
    public String toString() {
        return "Configuracao{" + "fonte=" + fonte + ", mesas=" + mesas + '}';
    }
    
    
}
