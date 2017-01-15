/*
* Node (Utilizado en las dos versiones de SkipList)
* Version 1
* 14/enero/2017
*/
public class Node{
    int val;
    Node next [];

    Node(int ix, int h){
        x = ix;
        next = Array.newIstance(Node.class, h+1);
    }

    int height(){
        return next.length - 1;
    }
}
