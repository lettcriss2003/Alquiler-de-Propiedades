/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import controlador.CuentaDAO;

/**
 *
 * @author LENOVO
 */
public class Parse {

    private CuentaDAO cd;

    public Parse() {
    }

    public Parse(CuentaDAO cd) {
        this.cd = cd;
    }

    public CuentaDAO getCd() {
        return cd;
    }

    public void setCd(CuentaDAO cd) {
        this.cd = cd;
    }

}
