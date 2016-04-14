/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql.util;

import java.util.ArrayList;
import mysql.entity.Balconista;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Gaara-X
 */
public class Listas {
    public Listas(){
        
    }
    
    public ArrayList<Balconista> listaBalconista(){
        ArrayList<Balconista> balconistas = new ArrayList<Balconista>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Balconista");
        balconistas = (ArrayList) query.list();
        session.getTransaction().commit();
        return balconistas;
    }
    
    
}
