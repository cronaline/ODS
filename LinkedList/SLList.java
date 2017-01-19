/*
SLList
Singly-Linked List
Version 1
12/enero/2017
Lista simplemente ligada implementa las operaciones del Stack y Queue
Se he elegido el modificador de accesso por default para tener las dos clases en un solo archivo
*/
//Clase Nodo utilizada en la clase SLList

import java.util.Scanner;

class Node{
    int val;
    Node next;
}

class SLList{
    Node head;  //Referencia el primer nodo
    Node tail;  //Referencia al ultimo nodo
    int n;  //numero de nodods

    public static void main(String args[]){
            int op, in, val;
            SLList sl = new SLList();
            Scanner sc = new Scanner(System.in);
            do{
                System.out.println("\nElija la accion a realizar");
                System.out.println("1) para obtener el tamaño del Array\n"
                    +"2) para realizar una operacion push\n"
                    +"3) para realizar una operacion pop\n"
                    +"4) para realizar una operacion add\n"
                    +"5) para realizar una operacion remove\n"
                    +"6) para mostrar los elementos de la lista lista\n"
                    +"0) para terminar el programa"
                );
                op = sc.nextInt();
                switch(op){
                    case 1:
                        System.out.println("Tamaño del arreglo: "+sl.size());
                    break;
                    case 2:
                        System.out.println("Ingrese el valor que desea insertar");
                        val = sc.nextInt();
                        sl.push(val);
                    break;
                    case 3:
                        System.out.println("El valor almacenado en la cabeza de la lista es: "+sl.pop);
                    break;
                    case 4:
                        System.out.println("Ingrese el indice en el que desea insertar el valor");
                        in = sc.nextInt();
                        System.out.println("Ingrese el nuevo valor");
                        val = sc.nextInt();
                        sl.add(in, val);
                    break;
                    case 5:
                        System.out.println("Ingrese el indice en el que desea borrar el valor");
                        in = sc.nextInt();
                        System.out.println("El valor eliminado fue: "+sl.remove(in));
                    break;
                }
            }while(op != 0);
        }

    int size(){
        return n;
    }

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
        if(-- n == 0) tail = null;
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

    void listar(){
        Node i;
        for(i = head; i == head; i = i.next){
            System.out.print(i.val);
        }
    }
}
