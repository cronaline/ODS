/*
ArrayStack
Version 1
4/enero/2017
*/
import java.util.Scanner;

public class ArrayStack
{
    private int n = 0;
    private int a[] = new int[10];

    //Retorna el numero de elementos almacenados en el ArrayStack
    public int size(){
        return n;
    }

    //Retorna un valor almacenado en el arreglo
    //Entrada: Un indice del arreglo, i
    //Salida: El elemento del arreglo con el indice i
    public int get(int i){
        return a[i];
    }

    //Cambia el elemento del arreglo con el indice i
    //Entrada: Un indice del arreglo, i
    //Salida: El valor contenido en el arreglo antes de ser modificado
    public int set(int i, int x){
        int var = a[i];
        a[i] = x;
        return var;
    }

    //Agrega un elemento al arraglo en el indice i, recorre todos los elementos apartir de este una casilla  a la derecha
    //Entrada: Un indice del arreglo (i), valor que se desea ingresar (x)
    //Salida:
    public void add(int i, int x){
        if(n + 1 > a.length) resize(); //Si el nuevo elemento excede el tamaño del arreglo
        for(int j = n; j > i; j--){ //recorre todos los elementos una casilla a la derecha, inicia desde el ultimo elemento
            a[j] = a[j-1];
        }
        a[i] = x;//Actualiza el valor del arreglo en la posicion i
        n++;//incremento del numero de elementos contenidos en el arreglo
    }

    //Elimina el elemento del arreglo con el indice i, recorre todos los elementos despues el iesimo elemento un casilla a la izquierda
    //Entrada: Un indice del arreglo, i
    //Salida: El valor contenido en el arreglo antes de ser modificado
    public int remove(int i){
        int var = a[i];
        for(int j = i; j < n-1; j++){//corrimiento a la izquierda
            a[j] = a[j+1];
        }
        n--;
        if(a.length <= 3*n) resize();//si el arreglo tiene menos de un 1/3 ocupado, se llama a la funcion resize
        return var;
    }

    //Cambia el tamaño del arreglo en funcion del numero de elementos que contenga, por lo cual lo puede hacer mas grande o mas pequeño
    //Entrada:
    //Salida:
    public void resize(){
        int b[] = new int[n*2];
        for(int i=0; i < n; i++){
            b[i] = a[i];
        }
        a = b;
    }

}
