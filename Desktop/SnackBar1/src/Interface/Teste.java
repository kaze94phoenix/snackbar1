/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;


import com.toedter.calendar.JCalendar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Junior
 */
public class Teste extends JFrame {
    public Teste(){
        criacao();
    }
    public void criacao(){
DefaultCategoryDataset ds = new DefaultCategoryDataset();
ds.addValue(40.5, "maximo", "dia 1");
ds.addValue(38.2, "maximo", "dia 2");
ds.addValue(37.3, "maximo", "dia 3");
ds.addValue(31.5, "maximo", "dia 4");
ds.addValue(35.7, "maximo", "dia 5");
ds.addValue(42.5, "maximo", "dia 6");

// cria o gráfico
JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia", 
    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
try{
OutputStream arquivo = new FileOutputStream("grafico.png");
ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
arquivo.close();
}
catch(Exception e){
    e.printStackTrace();
}
        JPopupMenu pop = new JPopupMenu();
        pop.add(new JMenuItem("1"));
        pop.add(new JMenuItem("2"));
        pop.add(new JMenuItem("3"));
        pop.add(new JMenuItem("4"));
        JPanel painel =new JPanel();
        JButton botao =new JButton("teste");
    JCalendar cal = new JCalendar();
        botao.add(pop);
        painel.add(cal);
        painel.add(new ChartPanel(grafico));
        //Calendar c = cal.getDate();
        Date data=cal.getDate();
        int dia = data.getDay();
        System.out.println(""+dia);
        
        add(painel);
    }
    
    public static void main(String[] args) {
        try {
            //Runtime.getRuntime().exec("cmd /c start Ajuda.pdf");
            Runtime.getRuntime().exec("cmd /c start C://Users//Junior//Documents//NetBeansProjects//SnackBar1//src//Interface//Ajuda.pdf");
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        Teste t = new Teste();
        t.setSize(600, 600);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
