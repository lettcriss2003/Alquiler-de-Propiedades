/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.CuentaDAO;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Cuenta;

/**
 *
 * @author LENOVO
 */
public class CuentaController {

    private static CuentaDAO cuentadao = new CuentaDAO();

    public static Boolean autentificar(String usuario, String contrasenia) throws ListaNullException, PosicionNoEncontradaException {
        if (obtener(usuario) != null) {
            Cuenta cuentaConsulta = obtener(usuario);
            if (cuentaConsulta.getUsuario().equals(usuario)
                    && cuentaConsulta.getConstrasenia().equals(contrasenia)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static Boolean insertar(Cuenta cuenta) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.insertar(cuenta);
    }

    public static Boolean modificar(Cuenta cuenta) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.modificar(cuenta);
    }

    public static Boolean eliminar(String usuario) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.eliminar(usuario);
    }

    public static Cuenta obtener(String usuario) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.obtener(usuario);
    }

    public static CuentaDAO getCuentadao() {
        return cuentadao;
    }

    public static void setCuentadao(CuentaDAO cuentadao) {
        CuentaController.cuentadao = cuentadao;
    }

    @Override
    public String toString() {
        return "CuentaController{" + '}';
    }

    
}
