 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion.controlador.Shell;
import controlador.listas.ListaEnlazada;
import java.lang.reflect.Field;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import controlador.utiles.Utilidades;

/**
 *
 * @author leomah
 */
public class MetodoShell<E> {    
    public static Integer ASCENDENTE = 1;
    public static Integer DESCENDENTE = 2;
    
    public ListaEnlazada<E> shell(ListaEnlazada<E> a, String atributo, Integer orden) throws IllegalAccessException, IllegalArgumentException, AtributoNoEncontradoException{
        Class clazz = (Class)a.getCabecera().getDato().getClass();
        E []matriz = a.toArray();
        
        Integer mitad = (matriz.length/2);
        Boolean isObject = Utilidades.isObject(clazz);
        
        for (int i = 0; i <= matriz.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (isObject) {
                    intercambioObjeto(matriz, j, clazz, orden, atributo, mitad);
                    modificado = true;
                } else {
                    intercambioDato(matriz, j, orden, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (matriz.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(matriz);
        return a;
    }

    private void intercambioDato(E[] matriz, int j, Integer orden, Integer mitad) {
        E auxj = matriz[j];
        E auxjMi = matriz[j + mitad];
        intercambio(j, auxj, auxjMi, orden, matriz, mitad);
    }  
    
    private void intercambioObjeto(E []matriz, int j, Class clazz, Integer orden, String atributo, Integer mitad) throws IllegalArgumentException, IllegalAccessException, AtributoNoEncontradoException{
        E auxj = matriz[j];
        E auxjMi = matriz[j+mitad];
        Field field = Utilidades.obtenerAtributos(clazz, atributo);
        if (field == null) {
            throw new AtributoNoEncontradoException();
        }
        field.setAccessible(true);
        Object a = field.get(auxj);
        Object b = field.get(auxjMi);
        intercambio(j, a, b, orden, matriz, mitad);
    }
    
    private void intercambio(int j, Object auxj, Object auxj1, Integer orden, E matriz[], Integer mitad){
        Class clazz = auxj.getClass();
        E a = matriz[j];
        E b = matriz[j+mitad];
        if (Utilidades.isNumber(clazz)) {
            if (orden == DESCENDENTE) {
                if (((Number)auxj).doubleValue() < ((Number) auxj1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j+mitad] = a;
                }
            }else{
                if (((Number)auxj).doubleValue() > ((Number) auxj1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j+mitad] = a;
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            if (orden == DESCENDENTE) {
                if (auxj.toString().toLowerCase().compareTo(auxj1.toString().toLowerCase()) < 0) {
                    matriz[j] = b;
                    matriz[j+mitad] = a;
                }
            }else{
                if (auxj.toString().toLowerCase().compareTo(auxj1.toString().toLowerCase()) > 0) {
                    matriz[j] = b;
                    matriz[j+mitad] = a;
                }
            }
        }
    }
    
    private static Object[] intercambiarDatos(Object[] matriz, int j, int mitad) {
        Object aux = matriz[j + mitad];
        matriz[j + mitad] = matriz[j];
        matriz[j] = aux;
        return matriz;
    }
    
    public static ListaEnlazada<Integer> shellListIntegerAscendente(ListaEnlazada<Integer> a){
        Integer array[] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (array[j] > array[j + mitad]) {
                    intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<Integer> shellListIntegerDescendente(ListaEnlazada<Integer> a){
        Integer array[] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (array[j] < array[j + mitad]) {
                    intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }            
        }
        
        a = a.toList(array);
        return a;
    }

    public static ListaEnlazada<String> shellListStringAscendente(ListaEnlazada<String> a){
        String array [] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                Integer valoresCadena1[] = Utilidades.valorLetrasString(array[j]);
                Integer valoresCadena2[] = Utilidades.valorLetrasString(array[j + mitad]);
                Integer corto = (valoresCadena1.length > valoresCadena2.length) ? valoresCadena2.length : valoresCadena1.length;
                
                if (valoresCadena1[0] == valoresCadena2[0]) {
                    for (int k = 0; k < corto; k++) {
                        if (valoresCadena1[k] > valoresCadena2[k]) {
                            intercambiarDatos(array, j, mitad);
                            modificado = true;
                        }
                    }
                } else {
                    if (valoresCadena1[0] > valoresCadena2[0]) {
                        intercambiarDatos(array, j, mitad);
                        modificado = true;
                    }
                }
                j = j + mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<String> shellListStringDescendente(ListaEnlazada<String> a){
        String array [] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                Integer valoresCadena1[] = Utilidades.valorLetrasString(array[j]);
                Integer valoresCadena2[] = Utilidades.valorLetrasString(array[j + mitad]);
                Integer corto = (valoresCadena1.length > valoresCadena2.length) ? valoresCadena2.length : valoresCadena1.length;
                
                if (valoresCadena1[0] == valoresCadena2[0]) {
                    for (int k = 0; k < corto; k++) {
                        if (valoresCadena1[k] > valoresCadena2[k]) {
                            array = (String[])intercambiarDatos(array, j, mitad);
                            modificado = true;
                        }
                    }
                } else {
                    if (valoresCadena1[0] < valoresCadena2[0]) {
                        array = (String[])intercambiarDatos(array, j, mitad);
                        modificado = true;
                    }
                }
                j = j + mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }

    public static ListaEnlazada<Float> shellListFloatAscendente(ListaEnlazada<Float> a){
        Float array[] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (array[j] > array[j + mitad]) {
                    array = (Float[])intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<Float> shellListFloatDescendente(ListaEnlazada<Float> a){
        Float array[] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (array[j] < array[j + mitad]) {
                    array = (Float[])intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<Double> shellListDoubleAscendente(ListaEnlazada<Double> a){
        Double array[] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (array[j] > array[j + mitad]) {
                    array = (Double[])intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<Double> shellListDoubleDescendente(ListaEnlazada<Double> a){
        Double array[] = a.toArray();
        Integer mitad = (array.length/2);
        
        for (int i = 0; i <= array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                if (array[j] < array[j + mitad]) {
                    array = (Double[])intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j+mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }
        
        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<Character> shellListCharacterAscendente(ListaEnlazada<Character> a) {
        Character array[] = a.toArray();
        Integer mitad = (array.length/2);
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                Integer valorChar1 = Utilidades.valorCharacter(array[j]);
                Integer valorChar2 = Utilidades.valorCharacter(array[j + 1]);
                if (valorChar1 > valorChar2) {
                    array = (Character[])intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j + mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }

        a = a.toList(array);
        return a;
    }
    
    public static ListaEnlazada<Character> shellListCharacterDescendente(ListaEnlazada<Character> a) {
        Character array[] = a.toArray();
        Integer mitad = (array.length/2);
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            boolean modificado = false;
            do {
                Integer valorChar1 = Utilidades.valorCharacter(array[j]);
                Integer valorChar2 = Utilidades.valorCharacter(array[j + 1]);
                if (valorChar1 < valorChar2) {
                    array = (Character[])intercambiarDatos(array, j, mitad);
                    modificado = true;
                }
                j = j + mitad;
            } while ((j+mitad) < (array.length));
            
            if (mitad == 1) {
                if (!modificado) {
                    break;
                }
            }
            
            if (mitad/2 < 1) {
                mitad = 1;
            }else{
                mitad = mitad/2;
            }
        }

        a = a.toList(array);
        return a;
    }
}
