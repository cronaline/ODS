/*
DLList
Doubly-Linked List
Version 1
12/enero/2017
Lista doblemente ligada, cuenta con un nodo llamado dummy que une el inicio de la lista con el final de la misma
con el obejtivo de facilitar las operaciones
*/

//Clase Nodo que sera utilizada en la lista doblemente ligada
//Contiene el valor almacenado en el Nodo, asi como las referencias
//al nodo anterior y al siguiente
class Node{
    int x;
    Node prev, next;
}

class DLList{
    int n;
    Node dummy; //Nodo que une al ultimo y al primer elemento de la lista

    //Constructor de la clase que inicializa al nodo dummy, asi como el numero de elementos de la lista
    DLList(){
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    //Metodo que encuentra un nodo de acuerdo a su posicion en la lista
    //Entrada: posicion en la lista
    Node getNode(int i){
        Node p = null;
        if(i < n / 2){ //Si el elemento se encuentra en la primera mitad de la lista
            p = dummy.next;
            for(int j = 0; j < i; j++){
                p = p.next;
            }
        }else{  //Si se encuentra en la segunda mitad de la lista
            p = dummy.prev;
            for(int j = n; j > i; j--){
                p = p.prev;
            }
        }
        return p;
    }

    //Metodo que devuleve un valor almacenado en un nodo
    //Entrada: indice del elemento que se busca
    //Salida: Valor almacenado en el nodo indicado
    int get(int i){
        return getNode(i).x;
    }

    //Metodo que cambia el valor almacenado en un nodo
    //Entrada: indice de nodo a buscar, nuevo valor a almacenar
    //Salida: antiguo valor almacenado en ese nodo
    int set(int i, int x){
        Node u = getNode(i);
        int y = u.x;
        u.x = x;
        return y;
    }

    //Metodo que agrega un nodo antes que otro nodo
    //Entrada: Nodo al que se le agregara detras el nuevo nodo, valor a almacenar en el nuevo nodo
    //Salida: nuevo nodo almacenado
    Node addBefore(Node w, int x){
        Node u = new Node();
        u.x = x;
        u.prev = w.prev; //el anterior al nuevo nodo se enlaza con el anterior a w
        u.next = w; //el siguiente del nuevo nodo se enlaza a w
        u.next.prev = u; //Se enlaza el w al nodo anterior (nuevo)
        u.prev.next = u; //El nodo anterior al nuevo, se enlaza al nuevo
        n++;
        return u;
    }

    //Metodo que agrega un valor en una posicion dada
    //Entrada: indice en el cual se agregara el nuevo nodo, valor a alamcenar
    void add(int i, int x){
        addBefore(getNode(i), x);
    }

    //Metodo que desliga un nodo de la lista
    //Entrada: nodo a borrar
    void remove(Node w){
        w.prev.next = w.next;
        w.next.prev = w.prev;
        n--;
    }

    //Metodo que borra un nodo de la lista
    //Entrada: posicion de la lista a ser eliminada
    //Salida: antiguo valor almacenado en esa posicion de la lista
    int remove(int i){
        Node w = getNode(i);
        remove(w);
        return w.x;
    }
}
