/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOAlquilerDePropiedades;
import controlador.Listas.ListaEnlazada;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author leomah
 */
public interface InterfazDao <T>{
    public void guardar(T dato) throws FileNotFoundException, JAXBException;
    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException;
    public ListaEnlazada<T> listar();
    public T obtener(Integer id);
    public void eliminar(Integer pos);
}
