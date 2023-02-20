/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.loginExcepciones;

/**
 *
 * @author LENOVO
 */
public class cedulaNovalidaException extends Exception{

    public cedulaNovalidaException(String msg) {
        super(msg);
    }
    
    public cedulaNovalidaException(){
        super("Porfavor, ingrese una cedula valida");
    }
    
}
