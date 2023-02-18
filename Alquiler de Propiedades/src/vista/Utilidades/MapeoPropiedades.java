/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import controlador.listas.ListaEnlazada;
import modelo.Propiedad;

/**
 *
 * @author Core i7-W11
 */
public class MapeoPropiedades {
    private ListaEnlazada<Propiedad> listaPropiedades;

    public MapeoPropiedades() {
    }
    
    public MapeoPropiedades(ListaEnlazada<Propiedad> lista) {
        this.listaPropiedades = lista;
    }

    public ListaEnlazada<Propiedad> getListaPropiedades() {
        if (this.listaPropiedades == null) {
            this.listaPropiedades = new ListaEnlazada<>();
        }
        return listaPropiedades;
    }

    public void setListaPropiedades(ListaEnlazada<Propiedad> listaPropiedades) {
        this.listaPropiedades = listaPropiedades;
    }
    
    
}
