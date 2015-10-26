/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

/**
 *
 * @author Gaara-X
 */
public class Stringss {
    
    
    public static void main(String[] args) {
        
        String conc="";
        System.out.println(conc);
        String nome="Mesa 10";
        int  j=nome.length();
        
        for(int i=0;i<nome.length();i++){
            if(Character.isDigit(nome.charAt(i)))
            conc+=String.valueOf(nome.charAt(i));
        }
        System.out.println(conc);
        System.out.println(Integer.parseInt(conc));
    }
}
