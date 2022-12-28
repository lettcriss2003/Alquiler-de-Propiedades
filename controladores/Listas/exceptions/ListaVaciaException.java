package controlador.Listas.exceptions;

public class ListaVaciaException extends Exception{

    public ListaVaciaException() {
        super("Lista vacía");
    }

    public ListaVaciaException(String mensaje) {
        super(mensaje);
    }
    
}
