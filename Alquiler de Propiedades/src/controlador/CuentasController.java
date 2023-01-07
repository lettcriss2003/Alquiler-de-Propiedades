/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Cuenta;

/**
 *
 * @author leomah
 */
public class CuentasController {
    private Cuenta cuenta = new Cuenta();

    public CuentasController() {
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "CuentasController{" + "cuenta=" + cuenta + '}';
    }
    
    
}
