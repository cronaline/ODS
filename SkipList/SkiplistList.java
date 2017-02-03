/*
SkiplistSSet
Version 1
14/enero/2017
Skiplist que implementa la interfaz de un lista simplemente ligada
*/
import java.lang.reflect.Array;

class Nodo{
    int x;
    Node next[];
    int length[];

    Node(int ix, int h){
        x = ix;
        next = Array.newInstance(Node.class, h+1);
        length = new int[h + 1];
    }

    int height(){
        return next.length -1;
    }
}

class SkiplistList{
    Node findPred(int i){
        Node u = sentinel;
        int r = h;
        int j = -1;
        while(r >= 0){
            while(u.next[r] != null && j+ u.length[r] < i){
                j += u.length[r];
                u = u.net[r];
            }
            r--;
        }
        return u;
    }
}
