/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package celso;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 *
 * @author Gaara-X
 */
public class BFS<T> {
    Node<T> bfs;
    List<Node<T>> visited = new LinkedList<>();
    Queue<Node<T>> queue = new LinkedList<>();
    List<Node<T>> goals = new LinkedList<>();
    public BFS(Node<T> bfs){
        this.bfs=bfs;
        queue.add(this.bfs);
        
    }
    
    public void roll(){
        Node<T> temp = bfs;
        //System.out.println("Parent:"+this.bfs);
        while(!queue.isEmpty()){
        System.out.println("Queue currently "+queue);    
        System.out.println("Removing first item "+queue.peek());
        visited.add(queue.remove());
//        if(temp.getParent()==null)
//            visited.add(temp);
        System.out.println("Visited list "+visited);
        //Iterator<Node<T>> iter = bfs.getParent().getChildren().iterator();
        System.out.println("Father:"+temp.getParent());
        System.out.println("Element:"+temp.getData());
        System.out.println("Children:"+temp.getChildren());
        for(int i=0; i<temp.getChildren().size();i++){
            queue.add(temp.getChildren().get(i));
        }
        temp=queue.peek();
        
        
//        while(iter.hasNext()){
//            queue.add(iter.next());
//        }
    }
        Iterator<Node<T>> iter = visited.iterator();
        System.out.println("All visited");
        while(iter.hasNext()){
        System.out.println(iter.next());
        }
        bestGoal((LinkedList<Node<T>>) goals);
    }
    
    public boolean isGoal(Jug j){
     return j.getCurrent()==2;
    }
    
    public void bestGoal(LinkedList<Node<T>> goals){
        int lvl=0;
        LinkedList<Node<T>> goal = goals;
        LinkedList<Node<T>> path = new LinkedList<Node<T>>();
        while(!goal.isEmpty()){
           Node<T> temp = goal.poll();
           Node<T> temp2 = temp;
           path.add(temp);
           while(temp.getParent()!=null){
               temp=temp.getParent();
               lvl++;
               path.add(temp);
               
           }
           System.out.println("goal:"+temp2+" in "+lvl+" levels :^)"+"oh!! and the path is:"+path);
           path.clear();
           lvl=0;
        }
    }

    public static void main(String args[]){
//        Node<Integer> n3 = new Node(7);
//        Node<Integer> n2 = new Node(3);
//        n3.addChild(2);
//        n3.addChild(4);
//        n3.addChild(5);
//        n2.addChild(n3);
//        //List<Node<Integer>> l= n3.getChildren();
//        //System.out.println("last "+l.get(l.size()-1).getChildren().toString());
//        Node<Integer> n = new Node(1);
//        n.addChild(n2);
//       // System.out.println("Children added n:"+n.getChildren());
//        BFS<Integer> b = new BFS<Integer>(n);
//        b.roll();
       
        Jug j= new Jug(4, 0, 0);
        Jug j1= new Jug(3, 0, 0);
        Manage m = new Manage(j, j1);
        
        
        BFS<State> c = new BFS<State>(m.getRoot());
        c.goals = m.getGoals();
        c.roll();
    }
    
     
            
    
}

