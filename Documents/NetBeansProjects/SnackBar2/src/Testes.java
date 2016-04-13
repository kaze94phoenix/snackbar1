
import java.awt.List;
import java.util.ArrayList;
import mysql.entity.Balconista;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaara-X
 */
public class Testes {

    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Balconista");
        ArrayList list = (ArrayList) query.list();
        for(int i=0; i<list.size()-1;i++){
           System.out.println(list.get(i)+"\n");
        }
    }
    
}
