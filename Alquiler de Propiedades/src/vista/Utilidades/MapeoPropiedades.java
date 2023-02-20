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
    
    /**
     * Contructor mapeo Propiedades
     * @param lista 
     */
    public MapeoPropiedades(ListaEnlazada<Propiedad> lista) {
        this.listaPropiedades = lista;
    }

    /**
     * get lista propiedades
     * @return  lista de propiedades
     */
    public ListaEnlazada<Propiedad> getListaPropiedades() {
        if (this.listaPropiedades == null) {
            this.listaPropiedades = new ListaEnlazada<>();
        }
        return listaPropiedades;
    }

    /**
     * set lista propiedades
     * @param listaPropiedades 
     */
    public void setListaPropiedades(ListaEnlazada<Propiedad> listaPropiedades) {
        this.listaPropiedades = listaPropiedades;
    }
    
    
}
