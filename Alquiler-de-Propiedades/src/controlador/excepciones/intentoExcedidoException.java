/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.excepciones;

/**
 *
 * @author LENOVO
 */
public class intentoExcedidoException extends Exception {

    public intentoExcedidoException(String msg) {
        super(msg);

    }

    public intentoExcedidoException() {
        super("Número de intentos máximo!");
    }
}
