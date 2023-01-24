/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.excepciones;

/**
 *
 * @author LENOVO
 */
public class DatoIncorrectoException extends Exception {

    public DatoIncorrectoException(String msg) {
        super(msg);
    }

    public DatoIncorrectoException(Integer limite) {
        super("Datos incorrectos \n"
                + "Número de intentos disponibles: " + limite);
    }

}
