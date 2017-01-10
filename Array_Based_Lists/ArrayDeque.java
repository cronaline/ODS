/*
* ArrayQueue
* Version 1
* 7/enero/2017
* Este programa implementa la interfaz de una LSE usando un arreglo
*/
import java.util.Scanner;
import static java.lang.Math.max;
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

    //Metodo que agrega un elemento a la lista en un indice dado
    //Entrada: indice en que se pretende insertar el valor
    public void add(int i, int val){
        if(n + 1 > a.length) resize();
        if(i < n/2){ //movemos una casilla a la izquierda todos los elementos anteriores a i
            j = (j == 0) ? a.length -1 : j - 1; //Si el inicio de la lista estaba al inicio del arreglo, lo recorre al final del arreglo, si no solo una casilla
            for(int k = 0; k < i; k++){ //corrimiento de todos los elementos a la izquierda
                a[(j + k) % a.length] = a[(j + k + 1) % a.length];//inicio virtual + el desplazamiento
            }
        }else{//movemos una casilla a la derecha todos los elementos posteriores a i
            for(int k = n; k > i; k++){//n indica el numero de elementos por lo que apunta al indice del siguiente del ultimo elemento de la lista
                a[(j + k) % a.length] = a[(j + k - 1) % a.length];
            }
        }
        a[(j + i) % a.length] = val;
        n++;
    }

    //Metodo que corra un elemento de la lista ligada
    //Entrada: indice donde se encuentra el elemento que se desea borrar
    //Salida: Valor almacenado en ese indice
    public int remove(int i){
        int x = a[(j+i)%a.length];
        if(i < n/2){ //Mueve los elementos anteriores al iesimo una casilla a la derecha
            for(int k = i; k > 0; k--){
                a[(j + k)%a.length] = a[(j + k -1 ) % a.length];
            }
            j = (j + 1) %a.length;//recorremos el inicio virtual de la cola ya que borramos un elemento
        }else{//movemos todos los elementos posteriores a i una casilla hacia la izquierda
            for(int k = i; k < n; k++){
                a[(j + k)%a.length] = a[(j + k +1)%a.length];
            }
        }
        n--;
        if(3*n < a.legth) resize();
        return x;
    }

    private void resize(){
        int b[] = new int[max(1, n*2)];
        for(int k = 0; k < n; k++){
            b[k] = a[(j + k) % a.length];//Se insertan los elementos en el supuesto orden en el que estaban
        }
        a = b;
        j = 0;
    }
}
