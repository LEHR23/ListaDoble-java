package listadoble;

public class Main {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(0);
        lista.insertar(5);
        lista.insertar(8);
        lista.insertar(6);
        lista.mostrar();
        Lista lista2 = new Lista();
        lista2.insertar(10);
        lista2.insertar(55);
        lista2.insertar(78);
        lista2.insertar(66);
        lista2.mostrar();
        lista.extender(lista2);
        lista.mostrar();
    }
    
}
