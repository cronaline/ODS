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
}
