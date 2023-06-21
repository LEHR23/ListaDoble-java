package listadoble;

public class Nodo {
    
    Nodo derecha;
    Nodo izquierda;
    int dato;
    
    public Nodo(){
        izquierda = null;
        derecha = null;
        dato = 0;
    }
    
    public Nodo(int dat){
        izquierda = null;
        derecha = null;
        dato = dat;
    }
    
    public Nodo(int dat, Nodo der, Nodo izq){
        dato = dat;
        derecha = der;
        izquierda = izq;
    }
    
}
