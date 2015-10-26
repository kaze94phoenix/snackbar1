/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Osvaldo Maria
 */
public class Barra extends JPanel {

    public Barra() {
        criacao();
    }
    public static Point point = new Point();
    public static JButton sair,mini;
    public static Color cor;
    public void criacao(){
        cor = new Color(0,191,255);
        JPanel painel= new JPanel();
        JPanel pain= new JPanel();
        pain.setLayout(new GridLayout(1,2));
        painel.setLayout(new BorderLayout());
        JButton sair = new JButton( new ImageIcon(getClass().getResource("/Interface/Imagens/exit2.png")));
        JButton mini = new JButton(new ImageIcon(getClass().getResource("/Interface/Imagens/mini2.png")));
        sair.setBorderPainted(false);
        mini.setBorderPainted(false);
        mini.setContentAreaFilled(false);
        sair.setContentAreaFilled(false);
        pain.add(mini);
        pain.add(sair);
        pain.setBackground(cor);
        //sair.setBackground(cor);
        //mini.setBackground(cor);
        sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               JFrame f = (JFrame) painel.getTopLevelAncestor();
               f.dispose();
            }
        });
                mini.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               JFrame f = (JFrame) painel.getTopLevelAncestor();
               f.setState(JFrame.ICONIFIED);
            }
        });
        
                this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            //AdicionarU a =new AdicionarU();
            public void mouseDragged(MouseEvent e) {
                Point p = ((JFrame) painel.getTopLevelAncestor()).getLocation();
               ((JFrame) painel.getTopLevelAncestor()).setLocation(p.x + e.getX() - point.x,
                        p.y + e.getY() - point.y);
            }
        });
        
        painel.add(pain,BorderLayout.EAST);        
 
        
        this.setLayout(new BorderLayout());
        this.setBackground(cor);
        add(painel,BorderLayout.EAST);
        
    }
    

}
