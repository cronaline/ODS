/*
ArrayQueue
Version 1
5/enero/2017
*/
import static java.lang.Math.max;
import java.util.NoSuchElementException;
public class ArrayQueue{
    private static final int TAM = 10;
    private int a[] = new int[TAM];
    private int j = 0, n = 0;

    //Agrega un elemento a la cola
    //Entrada: Valor a insertar
    //Salida: True??
    public boolean add(int val){
        if(n + 1 > a.length) resize(); //si el sigueinte elemento supera el tamaño de la cola, esta cambia de tamaño
        a[(j+n) % a.length] = val; //Para que la insercion se lleve a cabo al inicio del arreglo cuando j ha avanzado
        n++;//incremento del nuemro de elementos almacenados en la cola
        return true;
    }

    //Elimina el elemento que se encuentra en la cabeza de la cola
    //Entrada:
    //Salida: El valor que se ecnotraba en la cabeza del arreglo
    public int remove(){
        if (n == 0) throw new NoSuchElementException();
        int x = a[j];
        j = (j + 1) % a.length;
        n--;
        if (a.length <= 3*n) resize();
        return x;
    }

    //Funciona que redimensiona la cola si esta crecio mas de su tamaño establecido
    public void resize(){
        int b[] = new int[max(1,n*2)];//en caso de que la cola se quede vacia cambia su tamaño a uno para evitar un error con un tamaño 0
        for(int k = 0; k < n; k++ ){
            b[k] = a[(j+k) % a.length]; //los elementos se agregan al inicio del nuevo arreglo
        }
        a = b;
        j = 0;//Reinicia el inicio virtual de la cola
    }



}
