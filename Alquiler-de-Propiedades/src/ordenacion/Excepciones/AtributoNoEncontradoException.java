/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion.Excepciones;

/**
 *
 * @author LENOVO
 */
public class AtributoNoEncontradoException extends Exception{

    public AtributoNoEncontradoException(String string) {
        super(string);
    }

    public AtributoNoEncontradoException() {
        super("No se puede encontrar el atributo");
    }
    
    
}
