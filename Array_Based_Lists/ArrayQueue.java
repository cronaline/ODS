/*
ArrayQueue
Version 1
5/enero/2017
*/

public class ArrayQueue{
    private static final TAM = 10;
    private int a[] = new int[TAM];
    private int j = 0, n = 0;

    //Agrega un elemento a la cola
    //Entrada: Valor a insertar
    //Salida: True??
    boolean add(int val){
        if(n + 1 > a.length) resize(); //si el sigueinte elemento supera el tamaño de la cola, esta cambia de tamaño
        a[(j+n) % a.length] = x; //Para que la insercion se lleve a cabo al inicio del arreglo cuando j ha avanzado
        n++;//incremento del nuemro de elementos almacenados en la cola
        return true;
    }
}
