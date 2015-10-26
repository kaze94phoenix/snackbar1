package Controle;

//Celso Maria Afonso Maxlhaieie
//Osvaldo Maria
import Modelos.Mesas;
import Modelos.Pedidos;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Ficheiro implements Serializable {
	String caminho = "C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1\\Mesas.dat";
	//private ArrayList<Pedidos> requests = new ArrayList<>();
	
	public Ficheiro(){
	}
	
	public void escreverPedido(Pedidos p) throws Exception{
            ArrayList<Pedidos> requests = new ArrayList<>();    
            if(ler()==null){
                requests.add(p);
		FileOutputStream fos = new FileOutputStream(caminho);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(requests);
		oos.close();
		fos.close();
                }else{
               // requests= ler();
                    requests=organizaPedidos(p);
		FileOutputStream fos = new FileOutputStream(caminho);
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
            FileInputStream fis = new FileInputStream(caminho);
		ObjectInputStream ois = new ObjectInputStream(fis);
		requests = (ArrayList<Pedidos>) ois.readObject();
		return requests;
            }catch(EOFException ex){
                System.out.println("Ficheiro vazio mas tudo bem :)");
            return null;
	}
            
               
	
/*	public void remover(int i,Mesas[] mesas) throws Exception{
		tables=mesas;
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Gaara-X\\Desktop\\NetBeansProjects\\SnackBar1");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		tables[i]=null;
		oos.writeObject(tables[i]);
		oos.close();
		fos.close();
	} */
	
}
        
        public ArrayList<Integer> mesasOcupadas() throws Exception{
            ArrayList<Pedidos> mesas =ler();
            ArrayList<Integer> imesas = new ArrayList<>();
            for(Pedidos iter:mesas)
                imesas.add(iter.getMesa());
            return imesas;
        }
      public boolean containsPedido(int mesa) throws Exception{
          ArrayList<Pedidos> requests = new ArrayList<>();
        requests=ler();
        for(int i=0;i<requests.size();i++)
            if(requests.get(i).getMesa()==mesa)
                return true;
        return false;
      }
      public  int buscaPedido(int mesa) throws Exception{
        ArrayList<Pedidos> requests = new ArrayList<>();
        requests=ler();
        for(int i=0;i<requests.size();i++)
            if(requests.get(i).getMesa()==mesa)
                return i;
        return 0;
    }
      
      public  Pedidos buscaPedidoI(int mesa) throws Exception{
        ArrayList<Pedidos> requests = new ArrayList<>();
        requests=ler();
        for(int i=0;i<requests.size();i++)
            if(requests.get(i).getMesa()==mesa)
                return requests.get(i);
        return null;
    }
      
    public  void apagaPedido(int mesa) throws Exception{
        ArrayList<Pedidos> requests = new ArrayList<>();
        if(containsPedido(mesa)) {
        requests=ler();
        requests.remove(buscaPedido(mesa));
        
            FileOutputStream fos = new FileOutputStream(caminho);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(requests);
            oos.close();
            fos.close();
    }
        else
            JOptionPane.showMessageDialog(null, "Mesa"+mesa+"Sem pedidos");
    }
        public static void main(String[] args) {
    }
        }
