package controlador.listas;

import controlador.listas.Exepciones.AtributoException;
import java.lang.reflect.Array;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.NodoLista;
import controlador.utiles.Utilidades;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer tamanio;

    public ListaEnlazada() {
        cabecera = null;
        tamanio = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

    /**
     * insertar
     * @param dato 
     */
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);

        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);

        }

        tamanio++;
    }

    /**
     * imprimir
     */
    public void imprimir() {
        System.out.println("Lista Enlazada");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
    }

    /**
     * insertar en cabecera
     * @param dato 
     */
    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            tamanio++;
        }
    }

    /**
     * insertar posicion
     * @param dato
     * @param pos
     * @throws PosicionNoEncontradaException 
     */
    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < tamanio) {
            if (pos == 0) {
                insertar(dato);
            } else {
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
            //}else if(pos == tamanio){
            //insertar(dato);
        } else {
            throw new PosicionNoEncontradaException();
        }
    }

    /**
     * modificar posicion
     * @param dato
     * @param pos 
     */
 public void modificarPoscicion(E dato, Integer pos) {
        E[] arreglo = this.toArray();
        if (pos <=getTamanio()) {
            for (int i = 0; i < arreglo.length; i++) {
                if (i == pos) {
                    arreglo[i] = dato;
                }
            }
        } else {
            System.out.println("OUT OF SIZE");
        }
        this.toList(arreglo);

    }

 /**
  * obtener
  * @param pos
  * @return dato
  * @throws ListaVaciaException
  * @throws PosicionNoEncontradaException 
  */
    public E obtener(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < tamanio) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }

        //return dato;
    }

    /**
     * elimina el valor en la posicion del indice
     *
     * @param pos
     * @return dato
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public E eliminarPosicion(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < tamanio) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    if (cabecera.getSiguiente() != null) {
                        cabecera = cabecera.getSiguiente();
                    } else {
                        cabecera = null;
                    }
                    this.tamanio--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 1; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getSiguiente().getDato();
                    if (aux.getSiguiente().getSiguiente() != null) {
                        NodoLista<E> proximo = aux.getSiguiente();
                        aux.setSiguiente(proximo.getSiguiente());
                    } else {
                        aux.setSiguiente(null);
                    }
                    tamanio--;
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }
    }

    /**
     * Obtiene la cabecera
     *
     * @return
     */
    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    /**
     * Establece la cabecera
     *
     * @param cabecera
     */
    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Obtiene el tamaño de la lista
     *
     * @return tamanio
     */
    public Integer getTamanio() {
        //this.tamanio = tamanio();
        return tamanio;
    }

    /**
     * Establece el tamaño de la lista
     *
     * @param tamanio
     */
    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * convierte la lista en un arreglo en la pocicion indicada
     *
     * @return matriz
     */
    public E[] toArray() {
        //Class<E> clazz=(Class<E>) ;
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

    /**
     * Convierte a lista simple
     *
     * @param array
     * @return lista enlazada
     */
    public ListaEnlazada<E> toList(E[] array) {
        this.vaciar();
        for (int i = 0; i < array.length; i++) {
            insertar(array[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;
        setTamanio(0);
    }

    /**
     * Metodo para realizar una busqueda binaria
     *
     * @param atributo
     * @param dato
     * @return Un unico valor dentro de la lista
     * @throws Exception
     */
    public ListaEnlazada<E> busquedaBinaria(String atributo, Object dato) throws Exception {

        ListaEnlazada<E> result = new ListaEnlazada<>();

        Class<E> clazz = (Class<E>) cabecera.getDato().getClass();
        if (tamanio > 0) {
            E[] matriz = toArray();
            Boolean isObject = Utilidades.isObject(matriz[0].getClass());
            Integer centro, inicio, fin;
            Object valorCentral, aux;
            inicio = 0;
            fin = matriz.length - 1;
            while (inicio <= fin) {
                centro = (inicio + fin) / 2;
                valorCentral = matriz[centro];
                if (isObject) {

                    Field field = Utilidades.obtenerAtributos(clazz, atributo);
                    if (field == null) {
                        throw new AtributoException();
                    } else {
                        field.setAccessible(true);
                        aux = field.get(valorCentral);
                    }
                    if (Utilidades.isNumber(aux.getClass())) {
                        if (((Number) dato).doubleValue() == ((Number) aux).doubleValue()) {
                            result.insertar(matriz[centro]);
                            return result;
                        } else if (((Number) dato).doubleValue() < ((Number) aux).doubleValue()) {
                            fin = centro - 1;
                        } else {
                            inicio = centro + 1;
                        }
                    }
                    if (Utilidades.isString(aux.getClass())) {

                        if (dato.toString().toLowerCase().equals(aux.toString().toLowerCase())) {
                            result.insertar(matriz[centro]);
                            return result;
                        } else if (dato.toString().toLowerCase().compareTo(aux.toString().toLowerCase()) < 0) {
                            fin = centro - 1;
                        } else {
                            inicio = centro + 1;
                        }
                    }
                } else {
                    if (Utilidades.isNumber(matriz[0].getClass())) {
                        if (((Number) dato).doubleValue() == ((Number) valorCentral).doubleValue()) {
                            result.insertar(matriz[centro]);
                            return result;
                        } else if (((Number) dato).doubleValue() < ((Number) valorCentral).doubleValue()) {
                            fin = centro - 1;
                        } else {
                            inicio = centro + 1;
                        }
                    }
                }
            }
        }
        return result;
    }

}
