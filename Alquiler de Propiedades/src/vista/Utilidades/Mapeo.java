/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import controlador.CuentasController;
import controlador.listas.ListaEnlazada;
import modelo.Cuenta;

/**
 *
 * @author leomah
 */
public class Mapeo {
    private ListaEnlazada<CuentasController> cuentaList;

    public Mapeo() {
    }

    public Mapeo(ListaEnlazada<CuentasController> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public ListaEnlazada<CuentasController> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(ListaEnlazada<CuentasController> cuentaList) {
        this.cuentaList = cuentaList;
    }

   
}
