/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import modelo.Cuenta;

/**
 *
 * @author leomah
 */
public class CuentasController {
    private Cuenta cuenta = new Cuenta();
    private static CuentaDAO cuentadao = new CuentaDAO();

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
    
    public static Boolean autentificar(String usuario, String contrasenia) throws ListaVaciaException, PosicionNoEncontradaException {
        if (obtener(usuario) != null) {
            Cuenta cuentaConsulta = obtener(usuario);
            if (cuentaConsulta.getUsuario().equals(usuario)
                    && cuentaConsulta.getContrasenia().equals(contrasenia)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    
    public static Cuenta obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.obtener(usuario);
    }
    
    public static Boolean insertar(Cuenta cuenta) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.insertar(cuenta);
    }
    
    public static Boolean modificar(Cuenta cuenta) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.modificar(cuenta);
    }
    
    public static Boolean eliminar(String usuario) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.eliminar(usuario);
    }
    
}

/*
public class CuentaController {

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
*/
