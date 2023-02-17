/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busqueda.controlador.LinealBinaria;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.lang.reflect.Field;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import ordenacion.controlador.Shell.MetodoShell;
import controlador.utiles.Utilidades;

/**
 *
 * @author leomah
 */
public class BusquedaLinealBinaria<E> {
    public ListaEnlazada<Integer> linealBinaria(ListaEnlazada<E> lista, E dato, String atributo) throws AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException, ListaVaciaException, PosicionNoEncontradaException{
        MetodoShell ms = new MetodoShell();
        lista = ms.shell(lista, atributo, MetodoShell.ASCENDENTE);
        ListaEnlazada<Integer> pos = new ListaEnlazada<>();
        Class clazz = lista.getCabecera().getDato().getClass();
        Object array[] = null;
        if (Utilidades.isObject(clazz)) {
            array = binariaObject(lista.toArray(), dato, atributo, pos);
        }else{
            if (Utilidades.isNumber(clazz)) {
                array = binariaNumber(lista.toArray(), dato, pos);
            }else{
                array = binariaString(lista.toArray(), dato, pos);
            }
        }
        return pos;
    }
    
    private static Object[] binariaNumber(Object array[], Object dato, ListaEnlazada<Integer> pos) throws ListaVaciaException, PosicionNoEncontradaException, PosicionNoEncontradaException{
        Integer mitad = array.length/2;
        Object arrayAux[] = null;
        Boolean mayor = false;
        Integer mitadAux = 0;
        do {
            if (((Number)array[mitad]).doubleValue() == ((Number)dato).doubleValue()) {                
                if (!verificarPos(pos, mitad+mitadAux)) {
                    pos.insertar(mitad+mitadAux);
                }
                arrayAux = new Object[mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[i];
                }
                pos = linealString(arrayAux, dato, pos, false, mitad+mitadAux);
                arrayAux = new Object[array.length - mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[mitad + i];
                }
                pos = linealString(arrayAux, dato, pos, true, mitad+mitadAux);
                break;
            }else if(((Number)dato).doubleValue() < ((Number)array[mitad]).doubleValue()){
                arrayAux = new Object[mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[i];
                }
                array = arrayAux;
            }else{
                mayor = true;
                arrayAux = new Object[array.length-mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[mitad+i];
                }
                array = arrayAux;
                mitadAux = mitadAux + mitad;
            }
            mitad = mitad/2;
        } while (mitad > 4);
        
        if (arrayAux != null) {
            pos = linealNumber(array, dato, pos, mayor, mitadAux);
        }
        
        return arrayAux;
    }
    
    private static ListaEnlazada<Integer> linealNumber(Object array[], Object dato, ListaEnlazada<Integer> pos, Boolean mayor, Integer mitad) throws ListaVaciaException, PosicionNoEncontradaException{
        for (int i = 0; i < array.length; i++) {
            if (((Number)array[i]).doubleValue() == ((Number)dato).doubleValue()) {
                if (mayor) {
                    if (!verificarPos(pos,i+mitad)) {
                        pos.insertar(i + mitad);
                    }
                }else{
                    if (!verificarPos(pos, i)) {
                        pos.insertar(i);
                    }
                }
            }
        }
        
        if (pos.estaVacia()) {
            System.out.println("El elemento no se encuenta en la lista");
        }
        
        return pos;
    }
    
    private static Object[] binariaString(Object array[], Object dato, ListaEnlazada<Integer> pos) throws PosicionNoEncontradaException, ListaVaciaException{
        Integer mitad = array.length / 2;
        Object arrayAux[] = null;
        Boolean mayor = false;
        Integer mitadAux = 0;
        do {
            if (array[mitad].equals(dato)) {
                if (!verificarPos(pos, mitad+mitadAux)) {
                    pos.insertar(mitad+mitadAux);
                }
                arrayAux = new Object[mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[i];
                }
                pos = linealString(arrayAux, dato, pos, false, mitad+mitadAux);
                arrayAux = new Object[array.length - mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[mitad + i];
                }
                pos = linealString(arrayAux, dato, pos, true, mitad+mitadAux);
                break;
            }else{
                Integer valoresMitad[] = Utilidades.valorLetrasString(array[mitad].toString());
                Integer valoresDato[] = Utilidades.valorLetrasString(dato.toString());
                if(valoresDato[0] < valoresMitad[0]){
                    arrayAux = new Object[mitad];
                    for (int i = 0; i < arrayAux.length; i++) {
                        arrayAux[i] = array[i];
                    }
                    array = arrayAux;
                }else{
                    mayor = true;
                    arrayAux = new Object[array.length-mitad];
                    for (int i = 0; i < arrayAux.length; i++) {
                        arrayAux[i] = array[mitad+i];
                    }
                    array = arrayAux;
                    mitadAux = mitadAux + mitad;
                }
            }
            mitad = mitad/2;
        } while (mitad > 4);
        
        if (arrayAux != null) {
            pos = linealString(array, dato, pos, mayor, mitadAux);
        }
        
        return arrayAux;
    }
    
    public static ListaEnlazada<Integer> linealString(Object array[], Object dato, ListaEnlazada<Integer> pos, Boolean mayor, Integer mitad) throws ListaVaciaException, PosicionNoEncontradaException{
        for (int i = 0; i < array.length; i++) {
            if (array[i].toString().toLowerCase().trim().equals(dato.toString().toLowerCase().trim())) {
                if (mayor) {
                    if (!verificarPos(pos, i+mitad)) {
                        pos.insertar(i + mitad);
                    }
                }else{
                    if (!verificarPos(pos, i)) {
                        pos.insertar(i);
                    }
                }
            }
        }
        
        if (pos.estaVacia()) {
            System.out.println("El elemento no se encuenta en la lista");
        }
        
        return pos;
    }
    
    private static Object[] binariaBoolean(Object array[], Object dato, ListaEnlazada<Integer> pos) throws PosicionNoEncontradaException, ListaVaciaException{
        Integer mitad = array.length / 2;
        Object arrayAux[] = null;
        Boolean mayor = false;
        Integer mitadAux = 0;
        do {
            if (array[mitad] == (dato)) {
                if (!verificarPos(pos, mitad+mitadAux)) {
                    pos.insertar(mitad+mitadAux);
                }
                arrayAux = new Object[mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[i];
                }
                pos = linealBoolean(arrayAux, dato, pos, false, mitad+mitadAux);
                arrayAux = new Object[array.length - mitad];
                for (int i = 0; i < arrayAux.length; i++) {
                    arrayAux[i] = array[mitad + i];
                }
                pos = linealBoolean(arrayAux, dato, pos, true, mitad+mitadAux);
                break;
            }else{
                //I//nteger valoresMitad[] = Utilidades.valorLetrasString(array[mitad].toString());
                //Integer valoresDato[] = Utilidades.valorLetrasString(dato.toString());
                if(dato.equals(true)){
                    arrayAux = new Object[mitad];
                    for (int i = 0; i < arrayAux.length; i++) {
                        arrayAux[i] = array[i];
                    }
                    array = arrayAux;
                }else{
                    mayor = true;
                    arrayAux = new Object[array.length-mitad];
                    for (int i = 0; i < arrayAux.length; i++) {
                        arrayAux[i] = array[mitad+i];
                    }
                    array = arrayAux;
                    mitadAux = mitadAux + mitad;
                }
            }
            mitad = mitad/2;
        } while (mitad > 4);
        
        if (arrayAux != null) {
            pos = linealBoolean(array, dato, pos, mayor, mitadAux);
        }
        
        return arrayAux;
    }
    
    public static ListaEnlazada<Integer> linealBoolean(Object array[], Object dato, ListaEnlazada<Integer> pos, Boolean mayor, Integer mitad) throws ListaVaciaException, PosicionNoEncontradaException{
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(dato)) {
                if (mayor) {
                    if (!verificarPos(pos, i+mitad)) {
                        pos.insertar(i + mitad);
                    }
                }else{
                    if (!verificarPos(pos, i)) {
                        pos.insertar(i);
                    }
                }
            }
        }
        
        if (pos.estaVacia()) {
            System.out.println("El elemento no se encuenta en la lista");
        }
        
        return pos;
    }
    
    private static boolean verificarPos(ListaEnlazada<Integer> posiciones, Integer pos) throws ListaVaciaException, PosicionNoEncontradaException{
        boolean esta = false;
        for (int i = 0; i < posiciones.getTamanio(); i++) {
            if(posiciones.obtener(i) == pos){
                esta = true;
                break;
            }
        }
        return esta;
    }
    
    private static Object[] binariaObject(Object array[], Object dato, Object atributo, ListaEnlazada<Integer> pos) throws AtributoNoEncontradoException, IllegalAccessException, ListaVaciaException, PosicionNoEncontradaException{
        Field field = Utilidades.obtenerAtributos(array[0].getClass(), atributo.toString());
        if (field == null) {
            throw new AtributoNoEncontradoException();
        }
        field.setAccessible(true);
        Object arrayAtributos[] = new Object[array.length];
        
        for (int i = 0; i < array.length; i++) {
            arrayAtributos[i] = field.get(array[i]);
        }
        if (Utilidades.isNumber(arrayAtributos[0].getClass())) {
            return binariaNumber(arrayAtributos, dato, pos);
        }else if(Utilidades.isBoolean(arrayAtributos[0].getClass())){
            return binariaBoolean(arrayAtributos, dato, pos);
        }else{
            return binariaString(arrayAtributos, dato, pos);
        }
    }
}
