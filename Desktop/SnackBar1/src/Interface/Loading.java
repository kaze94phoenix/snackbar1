package Interface;


import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Junior
 */
public class Loading extends JFrame implements Runnable {

    int tempo;
    boolean passa;
    public Loading() {
        criacao();
        this.tempo=tempo;
        this.passa=passa;
    }

    private void criacao() {
     add(loadingPanel()); 
    }
        private JPanel loadingPanel() {
    JPanel panel = new JPanel();
    BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
    panel.setLayout(layoutMgr);

    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL imageURL   = cldr.getResource("img/spinner.gif");
    ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Interface/Imagens/spinner.gif"));
    //ImageIcon imageIcon = new ImageIcon("C:/Users/Junior/Documents/NetBeansProjects/Testes/src/Threads/spinner.gif");
    JLabel iconLabel = new JLabel();
    iconLabel.setIcon(imageIcon);
    imageIcon.setImageObserver(iconLabel);

    JLabel label = new JLabel("Carregando...");
    panel.add(iconLabel);
    panel.add(label);
    panel.setBackground(Color.WHITE);
    return panel;
}

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public void run() {
        System.out.println("sep"+System.lineSeparator());
                       try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) { 
          try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception d){
            System.out.println("erro");
        }   
}

  
        this.setUndecorated(true);
        this.pack();
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width  / 2) - (this.getWidth() / 2)),((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            //wait();
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    }
    
    public static void main(String[] args) {
         Loading r = new Loading();
       Thread t = new Thread(r);
       t.start();
     /*   try {
            t.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
        }*/
      // t.stop();
        
    }
    
    
}
