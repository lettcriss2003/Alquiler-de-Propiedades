/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.QuickSort;

import controlador.utiles.Utilidades;
import controlador.listas.ListaEnlazada;
import java.lang.reflect.Field;
import ordenacion.Excepciones.AtributoNoEncontradoException;

/**
 *
 * @author leomah
 */
public class MetodoQuickSort<E> {
    public static Integer ASCENDENTE = 1;
    public static Integer DESCENDENTE = 2;
    
    public ListaEnlazada<E> quickSort(ListaEnlazada<E> a, String atributo, Integer orden) throws IllegalAccessException, AtributoNoEncontradoException, IllegalArgumentException{
        Class clazz = null;
        E []matriz = a.toArray();
        if (a.getTamanio() > 0) {
            clazz = (Class)a.getCabecera().getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            if (isObject) {
                matriz = quickSortObject(matriz, 0, matriz.length-1, orden, atributo);
            }else{
                if (Utilidades.isNumber(clazz)) {
                    if (orden == DESCENDENTE) {
                        matriz = quickSortNumberDescendente(matriz, 0, matriz.length-1);
                    }else{
                        matriz = quickSortNumberAscendente(matriz, 0, matriz.length-1);
                    }
                }else{
                    if (orden == DESCENDENTE) {
                        matriz = quickSortStringDescendente(matriz, 0, matriz.length-1);
                    }else{
                        matriz = quickSortStringAscendente(matriz, 0, matriz.length-1);
                    }
                }
            }
        }
        a = a.toList(matriz);
        return a;
    }
    
    private E[] quickSortObject(E array[], Integer ini, Integer fin, Integer orden, String atributo) throws AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException{
        Class clazz = array[0].getClass();
        Field field = Utilidades.obtenerAtributos(clazz, atributo);
        if (field == null) {
            throw new AtributoNoEncontradoException();
        }
        field.setAccessible(true);
        
        Object arrayAtributos[] = new Object[array.length];
        
        for (int i = 0; i < array.length; i++) {
            E dato = array[i];
            arrayAtributos[i] = field.get(dato);
        }
        
        if (orden == DESCENDENTE) {
            array = quickSortObjectDescendente(array, ini, fin, arrayAtributos);
        }else{
            array = quickSortObjectAscendente(array, ini, fin, arrayAtributos);
        }
        
        return array;
    }
    
    private E[] quickSortObjectAscendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if(ini < fin){
            Integer posPivote;
            posPivote = ubicarPivoteObjectAscendente(array, ini, fin, arrayAtributos);
            array = quickSortObjectAscendente(array, ini, posPivote-1, arrayAtributos);
            array = quickSortObjectAscendente(array, posPivote+1, fin, arrayAtributos);
        }
        return array;
    }
    
    private Integer ubicarPivoteObjectAscendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if (Utilidades.isNumber(arrayAtributos[0].getClass())) {
            while (ini < fin) {
                while(((Number)arrayAtributos[fin]).doubleValue() >= ((Number)arrayAtributos[ini]).doubleValue() && ini < fin){
                    fin--;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);

                while(((Number)arrayAtributos[ini]).doubleValue() <= ((Number)arrayAtributos[fin]).doubleValue() && ini < fin){
                    ini++;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }else{
            while (ini < fin) {
                Integer valoresIni[] = Utilidades.valorLetrasString(arrayAtributos[ini].toString());
                Integer valoresFin[] = Utilidades.valorLetrasString(arrayAtributos[fin].toString());

                while(valoresFin[0] >= valoresIni[0] && ini < fin){
                    fin--;
                    valoresFin = Utilidades.valorLetrasString(arrayAtributos[fin].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
                Integer aux[] = valoresFin;
                valoresFin = valoresIni;
                valoresIni = aux;

                while(valoresIni[0] <= valoresFin[0] && ini < fin){
                    ini++;
                    valoresIni = Utilidades.valorLetrasString(arrayAtributos[ini].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }
        return ini;
    }
    
    private E[] quickSortObjectDescendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if(ini < fin){
            Integer posPivote;
            posPivote = ubicarPivoteObjectDescendente(array, ini, fin, arrayAtributos);
            array = quickSortObjectDescendente(array, ini, posPivote-1, arrayAtributos);
            array = quickSortObjectDescendente(array, posPivote+1, fin, arrayAtributos);
        }
        return array;
    }
    
    private Integer ubicarPivoteObjectDescendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if (Utilidades.isNumber(arrayAtributos[0].getClass())) {
            while (ini < fin) {
                while(((Number)arrayAtributos[fin]).doubleValue() <= ((Number)arrayAtributos[ini]).doubleValue() && ini < fin){
                    fin--;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);

                while(((Number)arrayAtributos[ini]).doubleValue() >= ((Number)arrayAtributos[fin]).doubleValue() && ini < fin){
                    ini++;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }else{
            while (ini < fin) {
                Integer valoresIni[] = Utilidades.valorLetrasString(arrayAtributos[ini].toString());
                Integer valoresFin[] = Utilidades.valorLetrasString(arrayAtributos[fin].toString());

                while(valoresFin[0] <= valoresIni[0] && ini < fin){
                    fin--;
                    valoresFin = Utilidades.valorLetrasString(arrayAtributos[fin].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
                Integer aux[] = valoresFin;
                valoresFin = valoresIni;
                valoresIni = aux;

                while(valoresIni[0] >= valoresFin[0] && ini < fin){
                    ini++;
                    valoresIni = Utilidades.valorLetrasString(arrayAtributos[ini].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }
        return ini;
    }    
    
    private static Object[] intercambiarDatosObject(Object array[], Integer ini, Integer fin){
        Object aux = array[fin];
        array[fin] = array [ini];
        array[ini] = aux;
        return array;
    }
    
    private E[] intercambiarDatos(E array[], Integer ini, Integer fin){
        E aux = array[fin];
        array[fin] = array [ini];
        array[ini] = aux;
        return array;
    }
    
    private E[] quickSortNumberAscendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteNumberAscendente(array, ini, fin);
            array = quickSortNumberAscendente(array, ini, posPivote-1);
            array = quickSortNumberAscendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteNumberAscendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            while(((Number)array[fin]).doubleValue() >= ((Number)array[ini]).doubleValue() && ini < fin){
                fin--;
            }
            array = intercambiarDatos(array, ini, fin);
            
            while(((Number)array[ini]).doubleValue() <= ((Number)array[fin]).doubleValue() && ini < fin){
                ini++;
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    private E[] quickSortNumberDescendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteNumberDescendente(array, ini, fin);
            array = quickSortNumberDescendente(array, ini, posPivote-1);
            array = quickSortNumberDescendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteNumberDescendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            while(((Number)array[fin]).doubleValue() <= ((Number)array[ini]).doubleValue() && ini < fin){
                fin--;
            }
            array = intercambiarDatos(array, ini, fin);
            
            while(((Number)array[ini]).doubleValue() >= ((Number)array[fin]).doubleValue() && ini < fin){
                ini++;
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    private E[] quickSortStringAscendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteStringAscendente(array, ini, fin);
            array = quickSortStringAscendente(array, ini, posPivote-1);
            array = quickSortStringAscendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteStringAscendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            Integer valoresIni[] = Utilidades.valorLetrasString(array[ini].toString());
            Integer valoresFin[] = Utilidades.valorLetrasString(array[fin].toString());
            
            while(valoresFin[0] >= valoresIni[0] && ini < fin){
                fin--;
                valoresFin = Utilidades.valorLetrasString(array[fin].toString());
            }
            array = intercambiarDatos(array, ini, fin);
            Integer aux[] = valoresFin;
            valoresFin = valoresIni;
            valoresIni = aux;
            
            while(valoresIni[0] <= valoresFin[0] && ini < fin){
                ini++;
                valoresIni = Utilidades.valorLetrasString(array[ini].toString());
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    private E[] quickSortStringDescendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteStringDescendente(array, ini, fin);
            array = quickSortStringDescendente(array, ini, posPivote-1);
            array = quickSortStringDescendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteStringDescendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            Integer valoresIni[] = Utilidades.valorLetrasString(array[ini].toString());
            Integer valoresFin[] = Utilidades.valorLetrasString(array[fin].toString());
           
            while(valoresFin[0] <= valoresIni[0] && ini < fin){
                fin--;
                valoresFin = Utilidades.valorLetrasString(array[fin].toString());
            }
            array = intercambiarDatos(array, ini, fin);
            Integer aux[] = valoresFin;
            valoresFin = valoresIni;
            valoresIni = aux;
            
            while(valoresIni[0] >= valoresFin[0] && ini < fin){
                ini++;
                valoresIni = Utilidades.valorLetrasString(array[ini].toString());
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    /*
    public static ListaEnlazada<Integer> quickSortListIntegerAscendente(ListaEnlazada<Integer> a){
        Object array[] = a.toArray();
        array = quickSortNumberAscendente(array, 0, array.length-1);
        a = a.toList((Integer[])array);
        return a;
    }
    
    public static ListaEnlazada<Integer> quickSortListIntegerDescendente(ListaEnlazada<Integer> a){
        Object array[] = a.toArray();
        array = quickSortNumberDescendente(array, 0, array.length-1);
        a = a.toList((Integer[])array);
        return a;
    }
        
    public static ListaEnlazada<String> quickSortListStringAscendente(ListaEnlazada<String> a){
        String array[] = a.toArray();
        array = quickSortStringAscendente(array, 0, array.length-1);
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<String> quickSortListStringDescendente(ListaEnlazada<String> a){
        String array[] = a.toArray();
        array = quickSortStringDescendente(array, 0, array.length-1);
        a = a.toList(array);
        return a;
    }
        
    public static ListaEnlazada<Float> quickSortListFloatAscendente(ListaEnlazada<Float> a){
        Object array[] = a.toArray();
        array = quickSortNumberAscendente(array, 0, array.length-1);
        a = a.toList((Float[])array);
        return a;
    }
    
    public static ListaEnlazada<Float> quickSortListFloatDescendente(ListaEnlazada<Float> a){
        Object array[] = a.toArray();
        array = quickSortNumberDescendente(array, 0, array.length-1);
        a = a.toList((Float[])array);
        return a;
    }
    
    
    public static ListaEnlazada<Double> quickSortListDoubleAscendente(ListaEnlazada<Double> a){
        Object array[] = a.toArray();
        array = quickSortNumberAscendente(array, 0, array.length-1);
        a = a.toList((Double[])array);
        return a;
    }
    
    public static ListaEnlazada<Double> quickSortListDoubleDescendente(ListaEnlazada<Double> a){
        Object array[] = a.toArray();
        array = quickSortNumberDescendente(array, 0, array.length-1);
        a = a.toList((Double[])array);
        return a;
    }*/
}
