/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import busqueda.controlador.LinealBinaria.BusquedaLinealBinaria;
import controlador.CuentasController;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import vista.Utilidades.Utilidades;

/**
 *
 * @author lettc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CuentasController cuentasController = new CuentasController();
        try {
            cuentasController = Utilidades.cargarCuentas();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        BusquedaLinealBinaria blb = new BusquedaLinealBinaria();
        CuentasController ccAux = new CuentasController();
        ListaEnlazada<Integer> posAux = new ListaEnlazada<>();
        if (true) {
            try {
                posAux = blb.linealBinaria(cuentasController.getCuentaslList(), true, "estado");
            } catch (AtributoNoEncontradoException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaVaciaException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                posAux = blb.linealBinaria(cuentasController.getCuentaslList(), false, "estado");
            } catch (AtributoNoEncontradoException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaVaciaException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < posAux.getTamanio(); i++) {
            try {
                ccAux.getCuentaslList().insertar(cuentasController.getCuentaslList().obtener(posAux.obtener(i)));
            } catch (ListaVaciaException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
