/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.loginExcepciones;

/**
 *
 * @author LENOVO
 */
public class datoIncorrectoException extends Exception {

    public datoIncorrectoException(String msg) {
        super(msg);
    }

    public datoIncorrectoException(Integer limite) {
        super("Datos incorrectos \n"
                + "Número de intentos disponibles: " + limite);
    }

}
