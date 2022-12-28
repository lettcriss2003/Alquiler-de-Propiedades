/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas.excepciones;

/**
 *
 * @author LENOVO
 */
public class PosicionNoEncontradaException extends Exception {
    
    public PosicionNoEncontradaException(String msg) {
        super (msg);
    }
    
    public PosicionNoEncontradaException() {
        super ("La posicion dada esta fuera de los limites de la lista");
    }
}
