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
public class MapeoCuentas {
    private CuentasController cc;

    public MapeoCuentas() {
    }

    public MapeoCuentas(CuentasController cc) {
        this.cc = cc;
    }

    public CuentasController getCc() {
        return cc;
    }

    public void setCc(CuentasController cc) {
        this.cc = cc;
    }

    
}
