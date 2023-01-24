/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas;

/**
 *
 * @author Victor
 */
public interface ListaCreada<E> extends java.util.Iterator<E> {

    E siguiente();
    E previo();
    boolean ObtenerPrevio();
    boolean ObtenerSiguiente();
    int SiguienteIndice();
    int indicePrevio();
    void eliminar();
    void set(E e);
    void add(E e);
}