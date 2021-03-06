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

    int get(int i){
        return findPred(i).next[0].x;
    }

    int set(int i, int x){
        Node u = findPred(i).next[0];
        int y = u.x;
        u.x = x;
        return y;
    }

    void add(int i, int x){
        Node w = new Node(x, pickHeight());
        if(w.height() h){
            h = w.height();
        }
        add(i, w);
    }

    Node add(int i, Node w){
        Node u = sentinel;
        int k = w.height();
        int r = h;
        int j = -1;
        while(r >= 0){
            while(u.next[r] != null && j+u.length[r] < i){
                j += u.length[r];
                u = u.next[r];
            }
            u.length[r]++;
            if(r <= k){
                w.next[r] = u.next[r];
                u.next[r] = w;
                w.length[r] = u.length[r] - (i - j);
                u.length[r] = i -j;
            }
            r--;
        }
        n++;
        return u;
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

}
