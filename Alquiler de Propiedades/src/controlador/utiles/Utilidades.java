/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utiles;
import controlador.utiles.modelo.AbecedarioMinusculas;
import java.lang.reflect.Field;
import javax.swing.JComboBox;
import modelo.TipoPropiedad;

/**
 *
 * @author leomah
 */
public class Utilidades {
    public static Integer[] valorLetrasString(String cadena) {
        char arrayCadena[] = cadena.toLowerCase().toCharArray();
        Integer a[] = new Integer[arrayCadena.length];
        for (int i = 0; i < arrayCadena.length; i++) {
            for (AbecedarioMinusculas letra : AbecedarioMinusculas.values()) {
                if (arrayCadena[i] == letra.toString().charAt(0)) {
                    a[i] = letra.getValor();
                }
            }
        }
        return a;
    }
    
    public static Integer valorCharacter(Character caracter) {
        Integer valor = null;
        for (AbecedarioMinusculas letra : AbecedarioMinusculas.values()) {
            if (caracter.toLowerCase(caracter) == letra.toString().charAt(0)) {
                valor = letra.getValor();
            }
        }
        return valor;
    }
    
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
        } else if(atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")){
            transformar = Boolean.parseBoolean(dato);
        } else{
            transformar = dato;
        }
        return transformar;
    }
    
    public static void cargarTipoPropiedad(JComboBox cbx){
            for(TipoPropiedad tipo: TipoPropiedad.values()){
                 cbx.addItem(tipo);
            }
    }
    
    public static TipoPropiedad obtenerTipoPropiedad(JComboBox cbx){
        return (TipoPropiedad) cbx.getSelectedItem();
    }
    
    public static Boolean isObject(Class clazz){
        return (!isBoolean(clazz) && !isCharacter(clazz) && !isNumber(clazz) && !isString(clazz) && !isPrimitive(clazz));
    }
    
    public static Boolean isNumber(Class clazz){
        return clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    
    public static Boolean isString(Class clazz){
        return clazz.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isCharacter(Class clazz){
        return clazz.getSimpleName().equalsIgnoreCase("Character");
    }
    
    public static Boolean isBoolean(Class clazz){
        return clazz.getSimpleName().equalsIgnoreCase("Boolean");
    }
    
    public static Boolean isPrimitive(Class clazz){
        return clazz.isPrimitive();
    }

}
