package controlador.listas;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import java.lang.reflect.Array;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
        }else {
            throw new PosicionNoEncontradaException();
        }
    }
    
    public void modificarPoscicion(E dato, Integer pos){
        E[] arreglo=this.toArray();
        if (pos<=tamanio) {
            for (int i = 0; i < arreglo.length; i++) {
                if (i==pos) {
                    arreglo[i]=dato;
                }
            }
        }
        else{
            System.out.println("OUT OF SIZE");
        }
        this.toList(arreglo);
  
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
               
    }
    
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
    
    public E[] toArray(){
        //Class<E> clazz=(Class<E>) ;
        E[] matriz =null;
        if (this.tamanio>0) {
            matriz=(E[])Array.newInstance(cabecera.getDato().getClass(),this.tamanio);
            NodoLista<E> aux=cabecera;
            for (int i = 0; i < this.tamanio; i++) {
                matriz[i]=aux.getDato();
                aux=aux.getSiguiente();
            }
        }
        return matriz;
    }
    
    public ListaEnlazada<E> toList(E[] array){
        this.vaciar();
        for (int i = 0; i < array.length; i++) {
            insertar(array[i]);
        }
        return this;
    }
     public void vaciar(){
        this.cabecera=null;
        setTamanio(0);
    }
}
