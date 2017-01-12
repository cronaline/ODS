/*
* DualArrayDeque
* Version 1
* 10/enero/2017
* Clase que implemento la interfaz de la LSE utilizando dos pilas
* Una llama da front (que alamcena los elementos en el orden inverso al que fueron almacenados)
* otra llamada back (esta almacena los elementos en el orden comun)
*/
class DualArrayDeque{
    ArrayStack front = new ArrayStack();
    ArrayStack back = new ArrayStack();

    //Metodo que almacena el numero de elementos almacenados en la lista
    public int size(){
        return front.size() + back.size();
    }

    //Metodo que obtiene el un valor almacenado en la lista a partir de su indice
    //Entrada: (int) indice del elemento que se desea obtener
    //Salida: (int) valor almacenado en ese indice de la lista
    public int get(int i){
        if(i < front.size()){
            return front.get(front.size()- 1 - i);//Ya que los elementos estan almacenados al reves, obtenemos la posicion de i apartir del final de la pila
        }else{
            return back.get(i - front. size());
        }
    }

    //Metodo que cambia el contenido de un elemento de la lista apartir de su indice
    //Entrada: indice del elemento al que se le desea cambiar el valor
    //Salida: valor anterior almacenado en el indice
    public int set(int i, int val){
        if(i < front.size()){
            return front.set((front.size() - i - 1), val);
        }else{
            return back.set(i - front.size(),val);
        }
    }

    
}
