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

    public static void main(String args[]){
        int op, in, val;
        ArrayDeque ad = new ArrayDeque();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\nElija la accion a realizar");
            System.out.println("1) para obtener el tamaño de la lista\n"
                +"2) para obtener un elemento del Array apartir de su indice\n"
                +"3) para cambiar el valor de un elemento apartir de su indice\n"
                +"4) para agregar un elemento al arreglo en el indice elegido\n"
                +"5) para borrar un elemento del arreglo a apartir de su indice\n"
                +"6) para listar el arreglo"
                +"0) para terminar el programa"
            );
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Tamaño del arreglo: "+ad.size());
                break;
                case 2:
                    System.out.println("Ingrese el indice que desea obtener de la lista");
                    in = sc.nextInt();
                    System.out.println("El valor almacenado en el indice "+in+" es: "+ad.get(in));
                break;
                case 3:
                    System.out.println("Ingrese el indice que desea cambiar de la lista");
                    in = sc.nextInt();
                    System.out.println("Ingrese el nuevo valor");
                    val = sc.nextInt();
                    System.out.println("El valor almacenado en el indice "+in+" es: "+ad.set(in, val));
                break;
                case 4:
                    System.out.println("Ingrese el indice en el que desea insertar el valor");
                    in = sc.nextInt();
                    System.out.println("Ingrese el nuevo valor");
                    val = sc.nextInt();
                    ad.add(in, val);
                break;
                case 5:
                    System.out.println("Ingrese el indice en el que desea borrar el valor");
                    in = sc.nextInt();
                    System.out.println("El valor eliminado fue: "+ad.remove(in));
                break;
                case 6:
                System.out.println("Los valores almacenados en la lista son: ");
                ar.listar();
                break;
            }
        }while(op != 0);
    }

    public size(){
        return n;
    }

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
    public void listar(){
        for(int k=0; k<n; k++){
            System.out.print(a[(j + k) % a.length]);
        }
    }

    //Metodo para cambiar de tamaño el arreglo
    private void resize(){
        int b[] = new int[max(1, n*2)];
        for(int k = 0; k < n; k++){
            b[k] = a[(j + k) % a.length];//Se insertan los elementos en el supuesto orden en el que estaban
        }
        a = b;
        j = 0;
    }
}
