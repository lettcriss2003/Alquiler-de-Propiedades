/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import controlador.CuentasController;

/**
 *
 * @author leomah
 */
public class MapeoCuentas {
    private CuentasController cc;

    public MapeoCuentas() {
    }

    /**
     * Contructor Mapeo Cuentas
     * @param cc 
     */
    public MapeoCuentas(CuentasController cc) {
        this.cc = cc;
    }

    /**
     * Get Cuentas controller
     * @return cuentaController
     */
    public CuentasController getCc() {
        return cc;
    }

    /**
     * Set Cuentas controller
     * @param cc 
     */
    public void setCc(CuentasController cc) {
        this.cc = cc;
    }

    
}
