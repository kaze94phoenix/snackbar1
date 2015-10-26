/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;


// JToggleButtonEvents.java
//
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 
public class JToggleButtonEvents {
  public static void main(String[] args) {
    JToggleButton jtb = new JToggleButton("Press Me");
    jtb.add(new JButton("hjka"),2);
    
    jtb.addActionListener(new ActionListener( ) {
      public void actionPerformed(ActionEvent ev) {
        System.out.println("ActionEvent!");
      }
    });
    jtb.addItemListener(new ItemListener( ) {
      public void itemStateChanged(ItemEvent ev) {
        System.out.println("ItemEvent!");
      }
    });
    jtb.addChangeListener(new ChangeListener( ) {
      public void stateChanged(ChangeEvent ev) {
        System.out.println("ChangeEvent!");
      }
    });
    JFrame f = new JFrame( );
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane( );
    c.setLayout(new FlowLayout( ));
    c.add(jtb);
    f.pack( );
    f.setVisible(true);
  }
}