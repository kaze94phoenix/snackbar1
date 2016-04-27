/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql.util;

import java.util.ArrayList;
import java.util.Vector;
import mysql.entity.Balconista;
import mysql.entity.Item;
import mysql.entity.Tipoitem;
import mysql.entity.Tipousuario;
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
    
    public Vector<Tipoitem> vectorTipoItem(){
        Vector<Tipoitem> tipoItem = new Vector<Tipoitem>();
        for(Tipoitem aux: listaTipoItem())
            tipoItem.add(aux);
        return tipoItem;
    }
    
    public Vector<Tipousuario> vectorTipoUsuario(){
        Vector<Tipousuario> tipoUsuario = new Vector<Tipousuario>();
        for(Tipousuario aux: listaTipoUsuario())
            tipoUsuario.add(aux);
        return tipoUsuario;
    }
     
    
    public ArrayList<Tipousuario> listaTipoUsuario(){
        ArrayList<Tipousuario> tipoUsuario = new ArrayList<Tipousuario>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Tipousuario");
        tipoUsuario = (ArrayList) query.list();
        session.getTransaction().commit();
        return tipoUsuario;
    }
    
     public ArrayList<Tipoitem> listaTipoItem(){
        ArrayList<Tipoitem> tipoItem = new ArrayList<Tipoitem>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Tipoitem");
        tipoItem = (ArrayList) query.list();
        session.getTransaction().commit();
        return tipoItem;
    }
    
    public ArrayList<Item> listaItem(){
        ArrayList<Item> item = new ArrayList<Item>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Item");
        item = (ArrayList) query.list();
        session.getTransaction().commit();
        return item;
    }
    
    
}
