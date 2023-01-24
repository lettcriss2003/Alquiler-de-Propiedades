/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Utiles;

import controlador.Utiles.excepciones.cedulaNoValidaException;
import controlador.Utiles.excepciones.contraseniaNoCoincideException;
import controlador.Utiles.excepciones.correoNoValidoException;
import controlador.Utiles.modelo.AbecedarioMinusculas;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LENOVO
 */
public class Utiles {

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

    /**
     * Validar cedula ecuatoriana
     *
     * @param cedula
     * @return
     */
    public static boolean validadorDeCedula(String cedula) throws cedulaNoValidaException {
        boolean cedulaCorrecta = false;
        cedula = (cedula.length() == 13) ? cedula.substring(0, 10) : cedula;
//        String baj = cedula.substring(10, 13);

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {

            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {

        }
        return cedulaCorrecta;
    }

    /**
     * Validar los correos ingresados al momento de registrar una cuenta nueva
     *
     * @param correo
     * @return
     * @throws correoNoValidoException
     */
    public static Boolean validarCorreo(String correo) throws correoNoValidoException {
        Boolean correoValido = false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            correoValido = true;
        } else {
            throw new correoNoValidoException();
        }
        return correoValido;
    }

    /**
     * Permite encriptar constrasenias mediante el esquema de codificacion
     * Base64
     *
     * @param dato
     * @return
     */
    public static String encriptarContrasenia(String dato) {
        if (dato != null) {
            return Base64.getEncoder().encodeToString(dato.getBytes());
        }
        return "";
    }

    /**
     * Permite desencriptar contraseñas mediante el esquema de codificacion
     * Base64
     *
     * @param dato
     * @return
     */
    public static String desencriptarContrasenia(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    /**
     * Validar si las contraseñas son iguales
     * @param contrasenia1
     * @param constrasenia2
     * @return
     * @throws contraseniaNoCoincideException 
     */
    public static Boolean validarContrasenias(String contrasenia1, String constrasenia2) throws contraseniaNoCoincideException {
        Boolean contraseniaCoincide = false;
        if (contrasenia1.equals(constrasenia2)) {
            contraseniaCoincide = true;
        } else {
            throw new contraseniaNoCoincideException();
        }
        return contraseniaCoincide;
    }
    
    /**
     * Obtenr atributos de una clase
     * @param clazz
     * @param nombre
     * @return 
     */
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

    public static Boolean isObject(Class clazz) {
        return (!isBoolean(clazz) && !isCharacter(clazz) && !isNumber(clazz) && !isString(clazz) && !isPrimitive(clazz));
    }

    public static Boolean isNumber(Class clazz) {
        return clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clazz) {
        return clazz.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clazz) {
        return clazz.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clazz) {
        return clazz.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean isPrimitive(Class clazz) {
        return clazz.isPrimitive();
    }
}
