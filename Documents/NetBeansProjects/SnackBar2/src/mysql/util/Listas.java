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
import mysql.entity.ItemPedido;
import mysql.entity.Mesa;
import mysql.entity.Pedido;
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
        session.close();
        return balconistas;
    }
    
    public Vector<Tipoitem> vectorTipoItem(){
        Vector<Tipoitem> tipoItem = new Vector<Tipoitem>();
        for(Tipoitem aux: listaTipoItem())
            tipoItem.add(aux);
        return tipoItem;
    }
    
    
    public Vector<Item> vectorItem(){
        Vector<Item> item = new Vector<Item>();
        for(Item aux: listaItem())
            item.add(aux);
        return item;
    }
    
    public Vector<Item> vectorItems(Tipoitem tI){
        Vector<Item> itens = new Vector<Item>();  
        for(Item i:listaItem()){
            if(i.getTipoitem().getId()==tI.getId()){
                itens.add(i);
            }
        } 
        return itens;
    }
    
    public Vector<Tipousuario> vectorTipoUsuario(){
        Vector<Tipousuario> tipoUsuario = new Vector<Tipousuario>();
        for(Tipousuario aux: listaTipoUsuario())
         tipoUsuario.add(aux);
        return tipoUsuario;
    }
    
    public Vector<Mesa> vectorMesasLivres(){
        Vector<Mesa> mesas = new Vector<Mesa>();
        for(Mesa aux: listaMesas())
          if(aux.isMesalivre())
            mesas.add(aux);
        return mesas;
    }
    
    public Vector<Mesa> vectorMesasOcupadas(){
        Vector<Mesa> mesas = new Vector<Mesa>();
        for(Mesa aux: listaMesas())
          if(!aux.isMesalivre())  
            mesas.add(aux);
        return mesas;
    }
     
    
    public ArrayList<Mesa> listaMesas(){
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Mesa");
        mesas = (ArrayList) query.list();
        session.getTransaction().commit();
        session.close();
        return mesas;    
                }
    
    public ArrayList<Tipousuario> listaTipoUsuario(){
        ArrayList<Tipousuario> tipoUsuario = new ArrayList<Tipousuario>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Tipousuario");
        tipoUsuario = (ArrayList) query.list();
        session.getTransaction().commit();
        session.close();
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
        session.close();
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
        session.close();
        return item;
    }
    
    public ArrayList<Pedido> listaPedidos(){
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Pedido");
        pedidos = (ArrayList) query.list();
        session.getTransaction().commit();
        session.close();
        return pedidos;
    }
    
    public ArrayList<ItemPedido> listaItensPedidos(){
        ArrayList<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ItemPedido");
        itensPedidos = (ArrayList) query.list();
        session.getTransaction().commit();
        //session.close();
        return itensPedidos;
    }
    
}
