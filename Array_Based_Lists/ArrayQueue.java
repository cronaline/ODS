/*
ArrayQueue
Version 1
5/enero/2017
*/

public class ArrayQueue{
    private static final TAM = 30;
    private int a[] = new int[TAM];
    private int j = 0, n = 0;

    boolean add(int val){
        if(n + 1 > a.length) resize();
        a[(j+n) % a.length] = x;
        n++;
        return true;
    }
}
