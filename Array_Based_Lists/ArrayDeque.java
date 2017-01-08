/*
* ArrayQueue
* Version 1
* 7/enero/2017
* Este programa implementa la interfaz de una LSE usando un arreglo
*/
public class ArrayDeque{
    private final static int TAM = 10;
    private int a[] = new int[TAM];
    int j = 0;  //Inicio relativo de la lista
    int n = 0;  //Numero de elementos almacenados en la lista

    //Metodo que obtiene el valor de un elemento almacenado en cierto indice de acuerdo a inicio de la lista
    //Entrada: el indice del elemento que se desea obtener
    //Salida: valor almacenado en dicho indice
    public int get(int i){
        return a[(j+i)%a.length];
    }

    //Metodo que cambia el valor de un elemento de la lista
    //Entrada: indice del elemento al que se desea cambiar de valor
    //Salida: antiguo valor de ese elemento
    public int set(int i, int x){
        int val = a[(j+i) % a.length];
        a[(j+i) % a.length] = x;
        return val;
    }

}
