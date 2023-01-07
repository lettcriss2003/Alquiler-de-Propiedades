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
public class ListaNullException extends Exception {
    
    public ListaNullException(String msg){
        super(msg);
        
    }    
    
    public ListaNullException(){
        super("La lista esta vacia");
        
    }  
    
}
