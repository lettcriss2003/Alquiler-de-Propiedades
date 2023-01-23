/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Utiles.excepciones;

/**
 *
 * @author LENOVO
 */
public class correoNoValidoException extends Exception {

    public correoNoValidoException(String msg) {
        super(msg);
    }
    
    public correoNoValidoException(){
        super("El correo no es valido");
    }
}
