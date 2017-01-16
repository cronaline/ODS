/*
SLList
Singly-Linked List
Version 1
12/enero/2017
Lista simplemente ligada implementa las operaciones del Stack y Queue
Se he elegido el modificador de accesso por default para tener las dos clases en un solo archivo
*/
//Clase Nodo utilizada en la clase SLList
class Node{
    int val;
    Node next;
}

class SLList{
    Node head;  //Referencia el primer nodo
    Node tail;  //Referencia al ultimo nodo
    int n;  //numero de nodods

    //Metodo para implementar la operacion push de un Stack
    //Entrada: valor a almacenar en la pila
    void push(int x){
        Node u = new Node();
        u.val = x;
        u.next = head; //Agrega al nodo al inicio
        head = u;   //Cambia el primer nodo de la lista
        if(n == 0){
            tail = u;
        }
        n++;
    }

    //Metodod para implementar la operacion pop de un Stack
    //Salida: valor almacenado en la primera posicion de la lista
    int pop(){
        if(n == 0) return null;
        int x = head.x;
        head = head.next; //Se borra el primer elemento de la lista
        if(-- n == 0) tail == null;
        return x;
    }

    //Metodo que elimia un elemento de la lista para implementar la interfaz de un Queue
    //Salida: el valor almacenado en la primera posicion de la lista
    int remove(){
        if(n == 0) return null;
        int x = head.x;
        head = head.next;
        if(--n == 0) tail = null;
        return x;
    }

    //Metodo que agrega un elemento a la lista en la ultima posicion
    //Entrada: Valor a almacenar en la lista
    //Salida: true, si el elemento se inserta correctamente
    boolean add(int x){
        Node u = new Node();
        u.x = x;
        if(n == 0){ //Si es el primer elemento de la lista
            head = u;
        }else{
            tail.next = u; //Enlaza el nuevo nodo
        }
        tail = u; //Cambia la referencia de tail
        n++;
        return true;
    }
}
