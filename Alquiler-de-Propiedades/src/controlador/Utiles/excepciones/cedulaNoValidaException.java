/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Utiles.excepciones;

/**
 *
 * @author LENOVO
 */
public class cedulaNoValidaException extends Exception {

    public cedulaNoValidaException(String msg) {
        super(msg);

    }

    public cedulaNoValidaException() {
        super("La cedula no es valida");
    }

}
