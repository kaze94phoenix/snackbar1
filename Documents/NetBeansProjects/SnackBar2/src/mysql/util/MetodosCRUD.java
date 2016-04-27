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
public class MetodosCRUD {
    
    Listas listas = new Listas();
    
    public MetodosCRUD(){
        
    }
    
    public void salvarUsuario(String name, String username, String password,Date dataNasc,int nuit, String morada, Tipousuario tipoUsuario){
        Balconista balconista = new Balconista();
        balconista.setNome(name);
        balconista.setMorada(morada);
        balconista.setNuit(nuit);
        balconista.setDataNascimento(dataNasc);
        balconista.setUsername(username);
        balconista.setPassword(password);
        balconista.setTipousuario(tipoUsuario);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(balconista);
        session.getTransaction().commit();
    }
    
    public DefaultTableModel listarUsuario(){
        DefaultTableModel dtm = new DefaultTableModel();
         dtm.setColumnIdentifiers(new Object[] {"ID","Nome","Username","NUIT"});
         for(Balconista balconista:listas.listaBalconista())
             dtm.addRow(new Object[]{" "+balconista.getId(),balconista.getNome(),balconista.getUsername(),balconista.getNuit()});
        return dtm;
    }
    
    public DefaultTableModel listarItens(){
        DefaultTableModel dtm = new DefaultTableModel();
         dtm.setColumnIdentifiers(new Object[] {"ID","Nome","Preco","Tipo"});
         for(Item item:listas.listaItem())
             dtm.addRow(new Object[]{" "+item.getId(),item.getNome(),item.getPreco(),item.getTipoitem()});
        return dtm;
    }
    
    public void salvarItem(String name,double preco,Tipoitem tipoItem){
        Item item = new Item();
        item.setNome(name);
        item.setPreco(preco);
        item.setTipoitem(tipoItem);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }
    
}
