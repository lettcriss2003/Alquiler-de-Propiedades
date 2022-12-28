package controlador.Listas.exceptions;

public class PosicionNoEncontradaException extends Exception{
    public PosicionNoEncontradaException(String mensaje){
        super(mensaje);
    }
    
    public PosicionNoEncontradaException(){
        super("Posición fuera de límites");
    }
}
