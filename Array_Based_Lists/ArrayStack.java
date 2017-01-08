/*
ArrayStack
Version 1
4/enero/2017
*/
import java.util.Scanner;
public class ArrayStack
{
    int n = 0;
    int a[] = new int[10];

    public static void main(String args[]){
        int op, in, val;
        ArrayStack ar = new ArrayStack();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\nElija la accion a realizar");
            System.out.println("1) para obtener el tamaño del Array\n"
                +"2) para obtener un elemento del Array apartir de su indice\n"
                +"3) para cambiar el valor de un elemento apartir de su indice\n"
                +"4) para agregar un elemento al arreglo en el indice elegido\n"
                +"5) para borrar un elemento del arreglo a apartir de su indice\n"
                +"6) para listar el arraglo"
                +"0) para terminar el programa"
            );
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Tamaño del arreglo: "+ar.size());
                break;
                case 2:
                    System.out.println("Ingrese el indice que desea obtener del arreglo");
                    in = sc.nextInt();
                    System.out.println("El valor almacenado en el indice "+in+" es: "+ar.get(in));
                break;
                case 3:
                    System.out.println("Ingrese el indice que desea cambiar arreglo");
                    in = sc.nextInt();
                    System.out.println("Ingrese el nuevo valor");
                    val = sc.nextInt();
                    System.out.println("El valor almacenado en el indice "+in+" es: "+ar.set(in, val));
                break;
                case 4:
                    System.out.println("Ingrese el indice en el que desea insertar el valor");
                    in = sc.nextInt();
                    System.out.println("Ingrese el nuevo valor");
                    val = sc.nextInt();
                    ar.add(in, val);
                break;
                case 5:
                    System.out.println("Ingrese el indice en el que desea borrar el valor");
                    in = sc.nextInt();
                    System.out.println("El valor eliminado fue: "+ar.remove(in));
                break;
                case 6:
                System.out.println("Los valores almacenados en el arreglo son: ");
                ar.listar();
                break;
            }
        }while(op != 0);
    }

    public int size(){
        return n;
    }

    public int get(int i){
        return a[i];
    }

    public int set(int i, int x){
        int var = a[i];
        a[i] = x;
        return var;
    }

    public void add(int i, int x){
        if(n + 1 > a.length) resize();
        for(int j = n; j > i; j--){
            a[j] = a[j-1];
        }
        a[i] = x;
        n++;
    }

    public int remove(int i){
        int var = a[i];
        for(int j = i; j < n-1; j++){
            a[j] = a[j+1];
        }
        n--;
        if(a.length <= 3*n) resize();
        return var;
    }

    public void resize(){
        int b[] = new int[n*2];
        for(int i=0; i < n; i++){
            b[i] = a[i];
        }
        a = b;
    }

    public void listar(){
        System.out.println();
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }

}
