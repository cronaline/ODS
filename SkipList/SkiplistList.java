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
