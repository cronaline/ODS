/*
SLList
Singly-Linked List
Version 1
12/enero/2017
Lista simplemente ligada implementa las operaciones del Stack y Queue
*/
public class SLList{
    Node head;
    Node tail;
    int n;

    int push(int x){
        Node u = new Node();
        u.val = x;
        u.next = head; //Agrega al nodo al inicio
        head = u;   //Cambia el primer nodo de la lista
        if(n == 0){
            tail = u;
        }
        n++;
        return x;
    }

    int pop(){
        if(n == 0) return null;
        int x = head.x;
        head = head.next; //Se borra el primer elemento de la lista
        if(-- n == 0) tail == null;
        return x;
    }

    int remove(){
        if(n == 0) return null;
        int x = head.x;
        head = head.next;
        if(--n == 0) tail = null;
        return x;
    }
}
