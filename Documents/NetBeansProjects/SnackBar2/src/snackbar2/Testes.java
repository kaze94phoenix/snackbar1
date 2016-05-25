package snackbar2;


import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import mysql.entity.Balconista;
import mysql.entity.ItemPedido;
import mysql.entity.Pedido;
import mysql.util.Listas;
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
        Listas listas = new Listas();
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from Balconista");
//        ArrayList list = (ArrayList) query.list();
//        for(int i=0; i<list.size();i++){
//           System.out.println(list.get(i)+"\n");
    
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
//        cal1.setTime(date1);
//        cal2.setTime(date2);
        boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
        
        Date refDate = new Date();
        int nrPedidos = 0;
        Date[] days = getDaysOfWeek(refDate, Calendar.getInstance().getFirstDayOfWeek());
        ArrayList<ItemPedido> pedidos = listas.listaItensPedidos();
        for(Date day: days){
        for(ItemPedido p:pedidos)
            if(p.getPedido().isPago()){
            cal1.setTime(p.getPedido().getData());
            cal2.setTime(day);
            if(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))
                nrPedidos++;
        }
        System.out.println(day+" "+nrPedidos+" pedidos feitos");
        nrPedidos=0;
        }
        
    
    }
    private static Date[] getDaysOfWeek(Date refDate, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(refDate);
        calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
        Date[] daysOfWeek = new Date[7];
        for (int i = 0; i < 7; i++) {
            daysOfWeek[i] = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return daysOfWeek;
    }
    
    
    }
    

