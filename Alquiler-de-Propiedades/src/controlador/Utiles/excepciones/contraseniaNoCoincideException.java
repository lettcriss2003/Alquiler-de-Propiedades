/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Utiles.excepciones;

/**
 *
 * @author LENOVO
 */
public class contraseniaNoCoincideException extends Exception {

    public contraseniaNoCoincideException(String msg) {
        super(msg);

    }

    public contraseniaNoCoincideException() {
        super("Las contraseñas no coinciden");
    }
}
