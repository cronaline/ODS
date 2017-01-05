/*
ArrayStack
Version 1
4/enero/2017
*/
public class ArrayStack
{
    int n = 0;
    int a[] = new int[10];
    // public ArrayStack(){
    //     int n = 0;
    //     int a[] = new int[10];
    // }

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

}
