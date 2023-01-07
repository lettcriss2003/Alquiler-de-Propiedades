/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utiles;

import java.lang.reflect.Field;

/**
 *
 * @author leomah
 */
public class Utilidades {
    public static String capitalizar(String nombre){
        char aux[] = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }
    
    public static Field obtenerAtributos(Class clazz, String nombre){
        Field atributo = null;
        for (Field aux:clazz.getDeclaredFields()) {
            if(nombre.equalsIgnoreCase(aux.getName())){
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    
    public static Object transformarDato(Field atributo, String dato){
        Object transformar = null;
        if(atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")){
            if(atributo.getType().getSimpleName().equals("Integer")){
                transformar = Integer.parseInt(dato);
            }
        }else if(atributo.getType().isEnum()){
            Enum enumeracion = Enum.valueOf((Class)atributo.getType(), dato.toString());
            transformar = enumeracion;
        } else if(atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Boolean")){
            transformar = Boolean.parseBoolean(dato);
        } else{
            transformar = dato;
        }
        return transformar;
    }
    

}
