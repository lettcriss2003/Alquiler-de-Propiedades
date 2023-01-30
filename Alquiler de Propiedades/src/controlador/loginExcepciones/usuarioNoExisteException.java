/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.loginExcepciones;

/**
 *
 * @author LENOVO
 */
public class usuarioNoExisteException extends Exception {

    public usuarioNoExisteException(String msg) {
        super(msg);
    }

    public usuarioNoExisteException() {
        super("Usuario no encontrado, registrese");
    }
    
    
    
}
