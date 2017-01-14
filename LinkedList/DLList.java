/*
DLList
Doubly-Linked List
Version 1
12/enero/2017
Lista simplemente ligada implementa las operaciones del Stack y Queue
*/

class Node{
    int val;
    Node prev, next;
}

class DLList{
    int n;
    Node dummy;
    DLList(){
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    Node getNode(int i){
        Node p = null;
        if(i < n / 2){
            p = dummy.next;
            for(int j = 0; j < i; j++){
                p = p.next;
            }
        }else{
            p = dummy;
            for(int j = n; j > i; j--){
                p = p.prev;
            }
        }
        return p;
    }

    int get(int i){
        return getNode(i).val;
    }

    int set(int i, int x){
        Node u = getNode(i);
        int y = u.x;
        u.x = x;
        return y;
    }

    Node addBefore(Node w, int x){
        Node u = new Node();
        u.x = x;
        u.prev = w.prev; //el anterior al nuevo nodo se enlaza con el anterior a w
        u.next = w; //el siguiente del nuevo nodo se enlaza a w
        u.next.prev = u; //Se enlaza el w al nodo anterior (nuevo)
        u.prev.next = u; //El nodo anterior al nuevo, se enlaza al nuevo
        n++
        return u;
    }

    void add(int i, int x){
        addBefore(getNode(i), x);
    }

    void remove(Node w){
        w.prev.next = w.next;
        w.next.prev = w.prev;
        n--;
    }

    int remove(int i){
        Node w = getNode(i);
        remove(w);
        return w.x;
    }
}
