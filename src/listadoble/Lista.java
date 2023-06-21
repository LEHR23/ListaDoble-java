package listadoble;

public class Lista {
    
    private Nodo raiz;
    private int contador;
    
    public Lista(){
        raiz = null;
        contador = 0;
    }
    
    public void insertar(int dato){
        if(raiz == null){
            raiz = new Nodo(dato, raiz, raiz);
            contador++;
        }else{
            Nodo aux = raiz;
            while(aux.derecha != null){
                aux = aux.derecha;
            }
            aux.derecha = new Nodo(dato,null, aux);
            contador++;
        }
    }
    
    public void insertar(int dato, int posicion){
        if(raiz == null){
            raiz = new Nodo(dato, raiz, raiz);
            contador++;
        }else{
            if(posicion <= contador){
                if(posicion == 0){
                    Nodo aux = new Nodo(dato, raiz, null);
                    raiz.izquierda = aux;
                    raiz = aux;
                    contador++;
                }else{
                    int cont = 0;
                    Nodo aux = raiz;
                    while(cont < posicion){
                        aux = aux.derecha;
                        cont++;
                    }
                    Nodo aux2 = new Nodo(dato, aux, aux.izquierda);
                    aux.izquierda = aux2;
                    aux2.izquierda.derecha = aux2;
                    contador++;
                }
            }else{
                Nodo aux = raiz;
                while(aux.derecha != null){
                    aux = aux.derecha;
                }
                aux.derecha = new Nodo(dato, null, aux);
                contador++;
            }
        }
    }
    
    public void remover(int dato){
        if(raiz != null){
            if(raiz.dato == dato){
                raiz = raiz.derecha;
                raiz.izquierda = null;
                contador--;
                System.out.println("DATO REMOVIDO: " + dato);
            }else{
                Nodo aux = raiz;
                boolean encontrado = false;
                while(aux.derecha != null && !encontrado){
                    if(aux.dato == dato){
                        encontrado = true;
                    }else{
                        aux = aux.derecha;
                    }
                }
                if(aux.dato == dato){
                    encontrado = true;
                }
                if(encontrado){
                    if(aux.derecha == null){
                        aux = aux.izquierda;
                        aux.derecha = null;
                        contador--;
                        System.out.println("DATO REMOVIDO: " + dato);
                    }else{
                        aux.derecha.izquierda = aux.izquierda;
                        aux.izquierda.derecha = aux.derecha;
                        aux = null;
                        contador--;
                        System.out.println("DATO REMOVIDO: " + dato);
                    }
                }else{
                    System.out.println("DATO NO ENCONTRADO: " + dato);
                }
            }
        }else{
            System.out.println("NO HAY DATOS");
        }
    }
    
    public int obtener(){
        int dato = -1;
        if(raiz != null){
            if(contador == 1){
                dato = raiz.dato;
                raiz = null;
                contador--;
                return dato;
            }else{
                Nodo aux = raiz;
                while(aux.derecha != null){
                    aux = aux.derecha;
                }
                dato = aux.dato;
                aux = aux.izquierda;
                aux.derecha = null;
                contador--;
                return dato;
            }
        }
        System.out.println("NO HAY DATOS");
        return dato;
    }
    
    public int obtener(int posicion){
        if(raiz != null){
            if(posicion >= contador-1){
                return obtener();
            }else{
                int dato = -1;
                if(posicion == 0){
                    dato = raiz.dato;
                    raiz = raiz.derecha;
                    raiz.izquierda = null;
                    contador--;
                    return dato;
                }else{
                    Nodo aux = raiz;
                    int contador = 0;
                    while(contador != posicion){
                        aux = aux.derecha;
                        contador++;
                    }
                    dato = aux.dato;
                    aux = aux.izquierda;
                    aux.derecha = aux.derecha.derecha;
                    aux.derecha.izquierda = aux;
                    this.contador--;
                    return dato;
                }
            }
        }
        System.out.println("NO HAY DATOS");
        return -1;
    }
    
    public void vaciar(){
        contador = 0;
        raiz = null;
    }
    
    public void mostrar(){
        Nodo aux = raiz;
        if(aux !=null){
            while(aux.derecha != null){
                System.out.print("[" + aux.dato + "]->");
                aux = aux.derecha;
            }
            System.out.println("[" + aux.dato + "]->null");
        }else{
            System.out.println("NO HAY DATOS");
        }
    }
    
    public int posicion(int dato){
        if(raiz != null){
            int cont = 0;
            Nodo aux = raiz;
            boolean encontrado = false;
            while(!encontrado && aux.derecha != null){
                if(aux.dato == dato){
                    encontrado = true;
                }
                else{
                    cont++;
                    aux = aux.derecha;
                }
            }
            if(aux.dato == dato){
                encontrado = true;
            }
            if(encontrado){
                return cont;
            }else{
                System.out.println("NO EXISTE EL DATO: " + dato);
                return -1;
            }
        }
        System.out.println("NO HAY DATOS");
        return -1;
    }
    
    public int contador(){
        return contador;
    }
    
    public void voltear(){
        if(raiz != null){
            Nodo aux = raiz;
            Nodo aux2 = aux.derecha;
            while(aux2 != null){
                aux.derecha = aux.izquierda;
                aux.izquierda = aux2;
                aux = aux2;
                aux2 = aux2.derecha;
            }
            aux.derecha = aux.izquierda;
            aux.izquierda = null;
            raiz = aux;
        }
    }
    
    public void extender(Lista lista){
        while(lista.contador() != 0){
            insertar(lista.obtener(0));
        }
    }
    
}
