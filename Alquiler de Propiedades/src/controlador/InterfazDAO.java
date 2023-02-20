/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import controlador.listas.ListaEnlazada;

/**
 *
 * @author Dennys
 */
public interface InterfazDAO <T>{
    public void guardar(T dato) throws FileNotFoundException, JAXBException;
    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException;
    public ListaEnlazada<T> listar();
    public T obtener(Integer id);
    public void eliminar(Integer pos);
}

