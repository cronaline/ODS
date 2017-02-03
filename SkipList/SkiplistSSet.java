/*
SkiplistSSet
Version 1
14/enero/2017
Skiplist que implementa la interfaz de un SSet
*/
import java.util.Random;
import java.lang.reflect.Array;

class Node{
    int x;
    Node next [];

    //Constructor de la clase nodo, recibe el valor a almacenar en el nodo, asi como su altura
    Node(int ix, int h){
        x = ix;
        next = Array.newInstance(Node.class, h+1);
    }

    //Metodo que retorna la altura del nodo
    int height(){
        return next.length - 1;
    }
}
class SkiplistSSet{
    Random rand = new Random();
    private Node findPredNode(int i){
        Node u = sentinel;
        int r =h;
        while(r >= 0){
            while(u.next[r] != null && compare(u.next[r].x, x) < 0){
                u = u.next[r];
            }
            r--;
        }
        return u;
    }

    public int find(int val){
        Node u = findPredNode(val);
        return u.next[0] == null ? null : u.next[0].x;
    }

    int pickHeight(){
        int z = rand.nextInt();
        int k = 0;
        int m = 1;
        while((z & m) != 0){
            k++;
            m <<= 1;
        }
        return k;
    }

    boolean add(int x){
        Node u = sentinel;
        int r = h;
        int comp = 0;
        while(r >= 0){
            while(u.next[r] != null && (comp = compare(u.next[r].x, x)) < 0){
                u = u.next[r];
            }if(u.next[r] != null && comp == 0) return false;
            stack[r--] = u; //hacia abajo, guarda u
        }
        Node w = new Node(x, pickHeight());
        while(h < w.height()){
            stack[++h] = sentinel; //incrementa altura
        }for(int i = 0; i < w.next.length; i++){
            w.next[i] = stack[i].next[i];
            stack[i].next[i] = w;
        }
        n++;
        return true;
    }

    boolean remove(int x){
        boolean removed = false;
        Node u = sentinel;
        int r = h;
        int comp = 0;
        while(r >= 0){
            while(u.next[r] != null && (comp = compare(u.next[r].x, x)) < 0){
                u = u.next[r];
            }if(u.next[r] != null && comp == 0){
                removed = true;
                u.next[r] = u.next[r].next[r];
                if(u == sentinel && u.next[r] == null){
                    h--;// reduce la altura
                }
            }
            r--;
        }
        if (removed) n--;
        return removed;
    }
}
