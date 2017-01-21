/*
* Node (Utilizado en las dos versiones de SkipList)
* Version 1
* 14/enero/2017
*/
import java.lang.reflect.Array;
public class Node{
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
