/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celso;

/**
 *
 * @author OsvaldoMaria
 */
public class Teste {

    
    public static void main(String[] args) {
        Node<Integer> n = new Node<>(5);
        Node<Integer> d = new Node<>(6,n);
        n.addChild(6);
        n.addChild(7);
        for (Node<Integer> arg : n.getChildren()) {
            System.out.println("data "+arg.getData().toString());
        }

        System.out.println("data "+d.getParent().getData());
        d.setParent(n);
       // n.addChild(d);
    }
}
