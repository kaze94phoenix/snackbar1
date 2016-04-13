/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql.util;

import java.awt.List;
import java.util.ArrayList;
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
    
    public MetodosCRUD(){
        
    }
    
    public void salvarUsuario(String name, String username, String password){
        Balconista balconista = new Balconista();
        balconista.setNome(name);
        balconista.setUsername(username);
        balconista.setPassword(password);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(balconista);
        session.getTransaction().commit();
    }
    
    public DefaultTableModel listarUsuario(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Balconista");
        ArrayList list = (ArrayList) query.list();
        
        session.getTransaction().commit();
        DefaultTableModel dtm = new DefaultTableModel();
        return dtm;
    }
    
}
