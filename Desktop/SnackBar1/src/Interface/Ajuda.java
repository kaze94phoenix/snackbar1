/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.DataFormat.HTML;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Junior
 */
public class Ajuda extends JPanel {
    public Ajuda(){
        try {
            criacao();
        } catch (BadLocationException ex) {
            Logger.getLogger(Ajuda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ajuda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criacao() throws BadLocationException, IOException {
         Reader fin = new InputStreamReader(new FileInputStream("C://Users//Junior//Documents//NetBeansProjects//SnackBar1//src//Interface//primeiro.html"));
            JTextPane text_panel = new JTextPane();
             
    HTMLEditorKit kit = new HTMLEditorKit();
    HTMLDocument doc = new HTMLDocument();
    kit.read(fin, doc, 0);
    
    text_panel.setEditorKit(kit);
    text_panel.setDocument(doc);
    kit.insertHTML(doc, doc.getLength(), "<b>hello", 0, 0, null);
    kit.insertHTML(doc, doc.getLength(), "<font color='red'><u>world</u></font>", 0, 0, null);
        JTextPane texto = new JTextPane();
        texto.setContentType("text/html");
       String s= "<html><body><font color='red'>Depois de modificar<br>este campo poderá<br> ter de reiniciar <br>a aplicação</body></html>";
       String s1= "<html><body><font color='red'>Depois de modificar<br>este campo poderá<br> ter de reiniciar <br>a aplicação</body></html>";
       String s2= "<html> <body>  <UL>      <LI> Adicões: \n"  +
"         <UL>          <LI> Adicao de usuários          <LI> Adicção de Pratos          <LI> Adição de mesas          </UL>      <UL> Pedidos:          <UL>          <LI> Novo pedido          <LI> Listar Pedidos          </UL>      </UL>     </body> </html> ";
    texto.setDocument(doc);
    this.add(texto);
    //this.add(new JLabel(s2));
    //this.add(text_panel);
    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new Ajuda());
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
