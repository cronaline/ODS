/*
SLList
Singly-Linked List
Version 1
12/enero/2017
Lista simplemente ligada
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
}
