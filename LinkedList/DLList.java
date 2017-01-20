/*
DLList
Doubly-Linked List
Version 1
12/enero/2017
Lista doblemente ligada, cuenta con un nodo llamado dummy que une el inicio de la lista con el final de la misma
con el obejtivo de facilitar las operaciones. Esta lista doblemente ligada implementa las operaciones de la queue
*/

//Clase Nodo que sera utilizada en la lista doblemente ligada
//Contiene el valor almacenado en el Nodo, asi como las referencias
//al nodo anterior y al siguiente
import java.util.Scanner;

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

    public static void main(String args[]){
        int op, ind, val;
        DLList dl = new DLList();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\nElija la accion a realizar");
            System.out.println("1) para obtener el tamaño del Array\n"
                +"2) para realizar una operacion get\n"
                +"3) para realizar una operacion set\n"
                +"4) para realizar una operacion add\n"
                +"5) para realizar una operacion remove\n"
                +"6) para mostrar los elementos de la lista lista\n"
                +"7) para mostrar los elementos de la lista lista en el orden inverso\n"
                +"0) para terminar el programa"
            );
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Tamaño del arreglo: "+dl.size());
                break;
                case 2:
                    System.out.println("Ingrese el indice del que desea conocer el valor");
                    val = sc.nextInt();
                    dl.get(val);
                break;
                case 3:
                    System.out.println("Ingrese el indice del nodo cuyo valor desea cambiar");
                    ind = sc.nextInt();
                    System.out.println("Ingrese el nuevo valor");
                    val = sc.nextInt();
                    dl.set(ind, val);
                break;
                case 4:
                    System.out.println("Ingrese el indice del nodo que desea agregar");
                    ind = sc.nextInt();
                    System.out.println("Ingrese el nuevo valor");
                    val = sc.nextInt();
                    dl.add(ind, val);
                break;
                case 5:
                    System.out.println("Ingrese el indice del nodo que desea borrar");
                    ind = sc.nextInt();
                    System.out.println("El valor eliminado fue: "+dl.remove(ind));
                break;
                case 6:
                    System.out.println();
                    dl.listar();
                break;
                case 7:
                    System.out.println();
                    dl.listarAlReves();
                break;
            }
        }while(op != 0);
    }

    int size(){
        return n;
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

    void listar(){
        for(Node i = dummy.next; i != dummy; i=i.next){
            System.out.print(i.x+" ");
        }
    }

    void listarAlReves(){
        for(Node i = dummy.prev; i != dummy; i=i.prev){
            System.out.print(i.x+" ");
        }
    }
}
