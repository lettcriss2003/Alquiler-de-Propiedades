/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas;

import java.util.Objects;
import java.util.function.Consumer;

/**
 *
 * @author Victor
 */
public interface Iterator<E> {

    boolean ObtenerSiguiente();

    E Siguiente();

    default void Eliminar() {
        throw new UnsupportedOperationException("eliminar");
    }

    default void ParaResto(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (ObtenerSiguiente())
            action.accept(Siguiente());
    }
}