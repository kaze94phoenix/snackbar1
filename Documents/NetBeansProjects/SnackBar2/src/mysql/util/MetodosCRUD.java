/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql.util;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import mysql.entity.Balconista;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Gaara-X
 */
public class MetodosCRUD {
    
    Listas listas = new Listas();
    
    public MetodosCRUD(){
        
    }
    
    public void salvarUsuario(String name, String username, String password,Date dataNasc,int nuit, String morada){
        Balconista balconista = new Balconista();
        balconista.setNome(name);
        balconista.setMorada(morada);
        balconista.setNuit(nuit);
        balconista.setDataNascimento(dataNasc);
        balconista.setUsername(username);
        balconista.setPassword(password);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(balconista);
        session.getTransaction().commit();
    }
    
    public DefaultTableModel listarUsuario(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnCount(3);
         dtm.setColumnIdentifiers(new Object[] {"ID","Nome","Username","NUIT"});
         for(Balconista balconista:listas.listaBalconista())
             dtm.addRow(new Object[]{" "+balconista.getId(),balconista.getNome(),balconista.getUsername(),balconista.getNuit()});
        return dtm;
    }
    
}
