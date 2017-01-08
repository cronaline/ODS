/*
ArrayQueue
Version 1
5/enero/2017
*/
import java.util.Scanner;
import static java.lang.Math.max;
import java.util.NoSuchElementException;
public class ArrayQueue{
    private static final int TAM = 10;
    private int a[] = new int[TAM];
    private int j = 0, n = 0;

    public static void main(String args[]){
        int op, val;
        ArrayQueue aq = new ArrayQueue();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\nElija la accion a realizar");
            System.out.println("1) para obtener el numero de elementos en la cola\n"
                +"2) para AGREGAR un elemento a la cola\n"
                +"3) para ELIMINAR un elemento de la cola \n"
                +"4) para LISTAR el arreglo\n"
                +"0) para terminar el programa"
            );
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Tamaño del arreglo: "+aq.getSize());
                break;
                case 2:
                    System.out.println("Ingrese valor que desea agregar a la cola");
                    val = sc.nextInt();
                    if(aq.add(val)){
                        System.out.println("El valor fue insertado correctamente");
                    }
                break;
                case 3:
                    System.out.println("El valor obtenido es: "+aq.remove());
                break;
                case 4:
                    System.out.println("Los valores almacenados en la cola son:");
                    aq.listar();
                break;
            }
        }while(op != 0);
    }

    public int getSize(){
        return n;
    }

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

    //Metodo que redimensiona la cola si esta crecio mas de su tamaño establecido
    public void resize(){
        int b[] = new int[max(1,n*2)];//en caso de que la cola se quede vacia cambia su tamaño a uno para evitar un error con un tamaño 0
        for(int k = 0; k < n; k++ ){
            b[k] = a[(j+k) % a.length]; //los elementos se agregan al inicio del nuevo arreglo
        }
        a = b;
        j = 0;//Reinicia el inicio virtual de la cola
    }

    //Metodo que imprime los valores contenidos en la cola
    public void listar(){
        int i = j;
        do{
            System.out.print(" "+a[i]);
            i = ++i % a.length;
        }while( i != j);
    }




}
