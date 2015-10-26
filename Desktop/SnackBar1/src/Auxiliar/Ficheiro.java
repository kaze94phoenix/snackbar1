package Auxiliar;

//Celso Maria Afonso Maxlhaieie
//Osvaldo Maria
import Controle.Configuracao;
import Modelos.Mesas;
import Modelos.Pedidos;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;


public class Ficheiro {
	
	//private ArrayList<Pedidos> requests = new ArrayList<>();
	static String caminhoMesas ="C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\mesasTotal.dat";
                //"C:\\Users\\Junior\\Desktop\\NetBeansProjects\\SnackBar1\\mesasTotal.dat";
        static String caminhoOcup="C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\mesasOcup.dat";
        static String caminhoLiv = "C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\mesasLiv.dat";
        static String caminhoConfig ="C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\Config.dat";
	public Ficheiro(){
	}
	//"C:\\Users\\Junior\\Desktop\\NetBeansProjects\\SnackBar1\\Mesas.dat"
    
        
public ArrayList<Integer> apaga(int i,ArrayList<Integer> a){
    ArrayList<Integer> arr = new ArrayList<>();
    for (int j = 0; j <a.size(); j++) {
        if(a.get(j)<=i)
            arr.add(a.get(j));
      
    }
      return arr;
}
public Configuracao config(){
       // Configuracao c = new Configuracao();
                    try{	
            FileInputStream fis = new FileInputStream(caminhoConfig);
		ObjectInputStream ois = new ObjectInputStream(fis);
	Configuracao c = (Configuracao) ois.readObject();
		return c;
            }catch(Exception ex){
                System.out.println("Ficheiro vazio mas tudo bem :)");
            return new Configuracao();
	}
    } 
public void escreverMesas(int i){
    Controle.Configuracao c = new Configuracao();
    if(i>5)        
  c.setMesas(i);
   //    for(int k=1;k<=i;k++)
       //     new Auxiliar.Ficheiro().escreveLiv(k);  
  
  
    try{
    FileOutputStream fos = new FileOutputStream(caminhoConfig);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c);
		oos.close();
		fos.close();
      //  System.out.println("N Mesas escrito"+c.getMesas());
            // for(int k=1;k<=i+1;k++)
         //   new Auxiliar.Ficheiro().escreveLiv(k);
}
    catch(Exception e){
        e.printStackTrace();
    }
}

public void escreverFonte(int i){
    Controle.Configuracao c = new Configuracao(15, 5);
    if(i>=15)
  c.setFonte(i);
    try{
    FileOutputStream fos = new FileOutputStream(caminhoConfig);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c);
		oos.close();
		fos.close();
}
    catch(Exception e){
    }
}
        
       
       public ArrayList<Integer> listaMesas() {
           ArrayList<Integer> mesas = new ArrayList<>();
           for(int i=1;i<=config().getMesas();i++)
               mesas.add(i);
     try{
    FileOutputStream fos = new FileOutputStream(caminhoMesas);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(mesas);
		oos.close();
		fos.close();
           return mesas;
     }
     catch(Exception e){
         e.printStackTrace();
         return null;
     }
       }
    
    public void escreveMesaOcup(int i){
        ArrayList<Integer> lista=listaMesasOcup();
        if(!lista.contains(i)&&!listaMesasLiv().contains(i))
        lista.add(i);
        else
        for(int j=0;j<lista.size();j++)
            if(lista.get(j)==i)
                lista.remove(j);
        try{
        FileOutputStream fos = new FileOutputStream(caminhoOcup);
        Collections.sort(lista);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(lista);
		oos.close();
		fos.close();
        }
        catch(Exception e){
            System.out.println("Erro ao escrever mesa");
            e.printStackTrace();
        }
    }

       
    public ArrayList<Integer> listaMesasOcup(){
        ArrayList<Integer> lista = new ArrayList<>();
                    try{	
            FileInputStream fis = new FileInputStream(caminhoOcup);
		ObjectInputStream ois = new ObjectInputStream(fis);
		lista = (ArrayList<Integer>) ois.readObject();
                Collections.sort(lista);
		return lista;
            }catch(Exception ex){
                System.out.println("Ficheiro vazio mas tudo bem :)");
         //lista.add(0);
            return lista;
	}
    }
    
        
        public  void escreveLiv(int i){
        ArrayList<Integer> lista=listaMesasLiv();
        
        if(!lista.contains(i)&&!listaMesasOcup().contains(i))
        lista.add(i);
        else
        for(int j=0;j<lista.size();j++)
            if(lista.get(j)==i)
                lista.remove(j);
        try{
        FileOutputStream fos = new FileOutputStream(caminhoLiv);
        Collections.sort(lista);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(lista);
		oos.close();
		fos.close();
        }
        catch(Exception e){
            System.out.println("Erro ao escrever mesa");
            e.printStackTrace();
        }
    }
        
               
    public  ArrayList<Integer> listaMesasLiv(){
        ArrayList<Integer> lista = new ArrayList<>();
                    try{	
            FileInputStream fis = new FileInputStream(caminhoLiv);
		ObjectInputStream ois = new ObjectInputStream(fis);
		lista = (ArrayList<Integer>) ois.readObject();
                Collections.sort(lista);
            //  return new Ficheiro().apaga(config().getMesas(), lista);
		return lista;
            }catch(Exception ex){
               ex.printStackTrace();
            return lista;
	}
    }
       
        
        

        public  DefaultComboBoxModel mesaOcupada(){

        System.out.println("dados"+listaMesasOcup());
        Vector<String> v = new Vector();
        for (int j = 0; j <listaMesasOcup().size(); j++) {
            v.add("Mesa " +listaMesasOcup().get(j));
            
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

            
        return modelo;
        }
        

        public  DefaultComboBoxModel mesaLivre(){
            for (int i = 0; i <listaMesas().size(); i++) {
            if(!listaMesasOcup().contains(listaMesas().get(i))&&!listaMesasLiv().contains(listaMesas().get(i)))
                escreveLiv(listaMesas().get(i));
            //Collections.sort(mesasLiv);
        }
        Vector<String> v = new Vector();
        for (int j = 0; j < listaMesasLiv().size(); j++) {
            v.add("Mesa " + listaMesasLiv().get(j));
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(v);

            
        return modelo;
  
        }
        
	public void escreverPedido(Pedidos p) throws Exception{
            ArrayList<Pedidos> requests = new ArrayList<>();
            boolean conf=true;
            if(ler()==null){
                requests.add(p);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\Mesas.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(requests);
		oos.close();
		fos.close();
                }else{
                requests=organizaPedidos(p);
//                    
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\Mesas.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(requests);
		oos.close();
		fos.close();
                    
                }
	}
        
        public ArrayList<Pedidos> organizaPedidos(Pedidos p) throws Exception{
            ArrayList<Pedidos> requests = new ArrayList<>();
            requests=ler();
            boolean conf=true;
                    for(Pedidos ped: requests){
                        if(ped.getMesa()==p.getMesa()){
                            ped.getAlimentos().addAll(p.getAlimentos());
                            ped.getBebidas().addAll(p.getBebidas());
                            conf=false;
                    }
                    }
                    if(conf)
                        requests.add(p);
                    for(Pedidos peds: requests){
                        for(int i=0; i<peds.getAlimentos().size()-1;i++)
                            for(int j=i+1; j<peds.getAlimentos().size();j++)
                                if(peds.getAlimentos().get(i).getNome().equals(peds.getAlimentos().get(j).getNome())){
                                    peds.getAlimentos().get(i).setQtd(peds.getAlimentos().get(i).getQtd()+peds.getAlimentos().get(j).getQtd());
                                    peds.getAlimentos().remove(j);
                                }
                        for(int i=0; i<peds.getBebidas().size()-1;i++)
                            for(int j=i+1; j<peds.getBebidas().size();j++)
                                if(peds.getBebidas().get(i).getNome().equals(peds.getBebidas().get(j).getNome())){
                                    peds.getBebidas().get(i).setQtd(peds.getBebidas().get(i).getQtd()+peds.getBebidas().get(j).getQtd());
                                    peds.getBebidas().remove(j);
                                }
                    }
                    return requests;
        }
	
	public ArrayList<Pedidos> ler() throws Exception{
            try{
	ArrayList<Pedidos> requests = new ArrayList<>();	
            FileInputStream fis = new FileInputStream("C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\Mesas.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		requests = (ArrayList<Pedidos>) ois.readObject();
		return requests;
            }catch(EOFException ex){
                System.out.println("Ficheiro vazio mas tudo bem :)");
            return null;
	}
	

}
        
        public static void main(String[] args) {
  //          new Auxiliar.Ficheiro().escreverMesas(6);
            
           // for(int k=0;k<5;k++)
         //   new Auxiliar.Ficheiro().escreveLiv(8);
            //new Auxiliar.Ficheiro().escreveMesaOcup(2);
            
            
            System.out.println("das config"+new Auxiliar.Ficheiro().config().getMesas());
            System.out.println(new Auxiliar.Ficheiro().listaMesas());
            System.out.println("Livres"+ new Ficheiro().listaMesasLiv());
            System.out.println("Livres"+ new Ficheiro().listaMesasOcup());
            ArrayList<Integer> a = new Ficheiro().listaMesasLiv();
           // System.out.println(a);
           // System.out.println(new Ficheiro().apaga(5, a));new Ficheiro().apaga(5, a);
            //System.out.println(a);
    }
        }
