package controlador.listas;

import java.lang.reflect.Array;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ListaEnlazada <E> {
    private NodoLista<E> cabecera;
    private Integer tamanio;
    
    public ListaEnlazada(){
        cabecera = null;
        tamanio = 0;
    }
    
    public Boolean estaVacia(){
        return cabecera == null;
    }
    
    /*private Integer tamanio(){
        Integer tamanio = 0;
        NodoLista<E> aux = cabecera;
        
        while (aux != null) {
            tamanio++;
            aux = aux.getSiguiente();
        }
        
        return tamanio;
    }*/
    
    public void insertar(E dato){
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        
        if (estaVacia()) {
            this.cabecera = nodo;
        }else{
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
            
        }
        
        tamanio++;
    }
    
    public E[] toArray(){
        E[] matriz = null;
        if (this.tamanio > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.tamanio);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.tamanio; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }
    
    /*
    
    public Object[] toArray() {
        Object[] result = new Object[tamanio];
        int i = 0;
        for (Node<E> x = primero; x != null; x = x.siguiente)
            result[i++] = x.item;
        return result;
    }
    */
    
    public ListaEnlazada toList(E []a){
        ListaEnlazada lista = new ListaEnlazada<>();
        for (int i = 0; i < a.length; i++) {
            lista.insertar(a[i]);
        }
        return lista;
    }
    
    public void imprimir(){
        System.out.println("Lista Enlazada");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
    }
    
    public void insertarCabecera(E dato){
        if (estaVacia()) {
            insertar(dato);
        }else{
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            tamanio++;
        }
    }
    
    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException{
        if(estaVacia()){
            insertar(dato);
        }else if (pos >= 0 && pos < tamanio){
            if (pos == 0){
                insertar(dato);
            }else{
                NodoLista<E> nodo = new NodoLista<>(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                tamanio++;
            }
        }else if(pos == tamanio){
            insertar(dato);
        }else {
            throw new PosicionNoEncontradaException();
        }
    }
    
    public void modificarPoscicion(E dato, Integer pos){
        if(pos >= 0 && pos < tamanio){
            NodoLista aux = this.cabecera;
            for(int i = 0; i < tamanio; i++){
                if(i == pos){
                    aux.setDato(dato);
                }
                aux = aux.getSiguiente();
            }
        }
//        else if (pos == tamanio){
//            
//        }else {
//            
        //}
    }
    
    public E obtener(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException{
        
        if(!estaVacia()){
            E dato = null;
            if(pos >= 0 && pos < tamanio){
                if (pos == 0){
                    dato = cabecera.getDato();
                }else{
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    } 
                    dato = aux.getDato();
                }
            }else 
                throw new PosicionNoEncontradaException();
            return dato;
        }else 
            throw new ListaVaciaException();
                
        //return dato;
    }
    
    /*
    public E eliminarPosicion(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException{
        if(!estaVacia()){
            E dato = null;
            if(pos >= 0 && pos < tamanio){
                if (pos == 0){
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    this.tamanio--;
                }else{
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    } 
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    tamanio--;
                }
            }else 
                throw new PosicionNoEncontradaException();
            return dato;
        }else 
            throw new ListaVaciaException();
    }
    */
    
    public E eliminarPosicion(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException{
        if(!estaVacia()){
            E dato = null;
            if(pos >= 0 && pos < tamanio){
                if (pos == 0){
                    dato = cabecera.getDato();
                    if (cabecera.getSiguiente() != null) {
                        cabecera = cabecera.getSiguiente();
                    }else{
                        cabecera = null;
                    }
                    this.tamanio--;
                }else{
                    NodoLista<E> aux = cabecera;
                    for (int i = 1; i < pos; i++) {
                        aux = aux.getSiguiente();
                    } 
                    dato = aux.getSiguiente().getDato();
                    if (aux.getSiguiente().getSiguiente() != null) {
                        NodoLista<E> proximo = aux.getSiguiente();
                        aux.setSiguiente(proximo.getSiguiente());
                    }else{
                        aux.setSiguiente(null);
                    }
                    tamanio--;
                }
            }else 
                throw new PosicionNoEncontradaException();
            return dato;
        }else 
            throw new ListaVaciaException();
    }
    

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getTamanio() {
        //this.tamanio = tamanio();
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }
    
    transient Node<E> primero;

    transient Node<E> ultimo;
    
    public ListaEnlazada(Collection<? extends E> c) {
        this();
        addAll(c);
    }
    
    void finallista(E e) {
        final Node<E> l = ultimo;
        final Node<E> newNode = new Node<>(l, e, null);
        ultimo = newNode;
        if (l == null)
            primero = newNode;
        else
            l.siguiente = newNode;
        tamanio++;
        modCount++;
    }

    void EnlasarDespues(E e, Node<E> succ) {
        final Node<E> pred = succ.previo;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.previo = newNode;
        if (pred == null)
            primero = newNode;
        else
            pred.siguiente = newNode;
        tamanio++;
        modCount++;
    }
    

    E unalista(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> siguientes = x.siguiente;
        final Node<E> prev = x.previo;

        if (prev == null) {
            primero = siguientes;
        } else {
            prev.siguiente = siguientes;
            x.previo = null;
        }

        if (siguientes == null) {
            ultimo = prev;
        } else {
            siguientes.previo = prev;
            x.siguiente = null;
        }

        x.item = null;
        tamanio--;
        modCount++;
        return element;
    }



    public boolean añadir(E e) {
        finallista(e);
        return true;
    }
    
    public boolean eliminar(Object o) {
        if (o == null) {
            for (Node<E> x = primero; x != null; x = x.siguiente) {
                if (x.item == null) {
                    unalista(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = primero; x != null; x = x.siguiente) {
                if (o.equals(x.item)) {
                    unalista(x);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean addAll(Collection<? extends E> c) {
        return addAll(tamanio, c);
    }
    
    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == tamanio) {
            succ = null;
            pred = ultimo;
        } else {
            succ = node(index);
            pred = succ.previo;
        }

        for (Object o : a) {
            @SuppressWarnings("desconocido") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                primero = newNode;
            else
                pred.siguiente = newNode;
            pred = newNode;
        }

        if (succ == null) {
            ultimo = pred;
        } else {
            pred.siguiente = succ;
            succ.previo = pred;
        }

        tamanio += numNew;
        modCount++;
        return true;
    }
    
    public void clear() {
        for (Node<E> x = primero; x != null; ) {
            Node<E> next = x.siguiente;
            x.item = null;
            x.siguiente = null;
            x.previo = null;
            x = next;
        }
        primero = ultimo = null;
        tamanio = 0;
        modCount++;
    }
    
    public E get(int index) {
        RevisarElementoIndice(index);
        return node(index).item;
    }
    
    public E set(int index, E element) {
        RevisarElementoIndice(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }
    
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == tamanio)
            finallista(element);
        else
            EnlasarDespues(element, node(index));
    }
    
    public E Eliminar(int index) {
        RevisarElementoIndice(index);
        return unalista(node(index));
    }

    private boolean ElementoIndice(int index) {
        return index >= 0 && index < tamanio;
    }

    private boolean PosicionIndice(int index) {
        return index >= 0 && index <= tamanio;
    }

    private String FueraLugar(int index) {
        return "Index: "+index+", tamaño: "+tamanio;
    }

    private void RevisarElementoIndice(int index) {
        if (!ElementoIndice(index))
            throw new IndexOutOfBoundsException(FueraLugar(index));
    }

    private void checkPositionIndex(int index) {
        if (!PosicionIndice(index))
            throw new IndexOutOfBoundsException(FueraLugar(index));
    }
    
    Node<E> node(int index) {

        if (index < (tamanio >> 1)) {
            Node<E> x = primero;
            for (int i = 0; i < index; i++)
                x = x.siguiente;
            return x;
        } else {
            Node<E> x = ultimo;
            for (int i = tamanio - 1; i > index; i--)
                x = x.previo;
            return x;
        }
    }
    
    public int Indice(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = primero; x != null; x = x.siguiente) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = primero; x != null; x = x.siguiente) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }
    
    public int IndiceFinal(Object o) {
        int index = tamanio;
        if (o == null) {
            for (Node<E> x = ultimo; x != null; x = x.previo) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = ultimo; x != null; x = x.previo) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }
   
    
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListaCreada(index);
    }

    private class ListaCreada implements ListIterator<E> {
        private Node<E> retornarUltimo;
        private Node<E> next;
        private int nextIndex;
        private int NumeroEsperado = modCount;
        

        ListaCreada(int index) {

            next = (index == tamanio) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < tamanio;
        }

        public E next() {
            RevisarCondicion();
            if (!hasNext())
                throw new NoSuchElementException();

            retornarUltimo = next;
            next = next.siguiente;
            nextIndex++;
            return retornarUltimo.item;
        }


        public void remove() {
            RevisarCondicion();
            if (retornarUltimo == null)
                throw new IllegalStateException();

            Node<E> lastNext = retornarUltimo.siguiente;
            unalista(retornarUltimo);
            if (next == retornarUltimo)
                next = lastNext;
            else
                nextIndex--;
            retornarUltimo = null;
            NumeroEsperado++;
        }

        public void set(E e) {
            if (retornarUltimo == null)
                throw new IllegalStateException();
            RevisarCondicion();
            retornarUltimo.item = e;
        }

        public void add(E e) {
            RevisarCondicion();
            retornarUltimo = null;
            if (next == null)
                finallista(e);
            else
                EnlasarDespues(e, next);
            nextIndex++;
            NumeroEsperado++;
        }

        final void RevisarCondicion() {
            if (modCount != NumeroEsperado)
                throw new ConcurrentModificationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            ListIterator.super.forEachRemaining(action); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
    }

    private static class Node<E> {
        E item;
        Node<E> siguiente;
        Node<E> previo;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.siguiente = next;
            this.previo = prev;
        }
    }
    
    @SuppressWarnings("desconocido")
    public <T> T[] toArray(T[] a) {
        if (a.length < tamanio) {
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), tamanio);
        }
        int i = 0;
        Object[] result = a;
        for (Node<E> x = primero; x != null; x = x.siguiente)
            result[i++] = x.item;

        if (a.length > tamanio)
            a[tamanio] = null;

        return a;
    }
    
    protected transient int modCount = 0;
    
}
