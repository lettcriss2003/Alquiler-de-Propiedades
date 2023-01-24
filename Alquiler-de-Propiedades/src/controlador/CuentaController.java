/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.CuentaDAO;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Cuenta;
import controlador.Utiles.Utiles;
import controlador.excepciones.DatoIncorrectoException;
import controlador.excepciones.intentoExcedidoException;

/**
 *
 * @author LENOVO
 */
public class CuentaController {

    private static CuentaDAO cuentadao = new CuentaDAO();
    Integer limite = 5;

    /**
     * Metodo para autentificar las credenciales ingresadas por el usuario
     *
     * @param usuario
     * @param contrasenia
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     * @throws controlador.excepciones.intentoExcedidoException
     * @throws controlador.excepciones.DatoIncorrectoException
     */
    public Boolean autentificar(String usuario, String contrasenia) throws ListaNullException, PosicionNoEncontradaException, intentoExcedidoException, DatoIncorrectoException {
        Boolean autentificacion = false;
        if (obtener(usuario) != null) {
            Cuenta cuentaConsulta = obtener(usuario);
            if (cuentaConsulta.getUsuario().equals(usuario)
                    && Utiles.desencriptarContrasenia(cuentaConsulta.getConstrasenia()).equals(contrasenia)) {
                autentificacion = true;
                return autentificacion;
            } else if (limite > 1) {
                throw new DatoIncorrectoException(--limite);
            } else {
                System.exit(0);
                throw new intentoExcedidoException();
            }
        } else {
            throw new ListaNullException();
        }
    }

    /**
     * Metodo para insertar una cuenta
     *
     * @param cuenta
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean insertar(Cuenta cuenta) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.insertar(cuenta);
    }

    /**
     * Metodo para modificar una cuenta
     *
     * @param cuenta
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean modificar(Cuenta cuenta) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.modificar(cuenta);
    }

    /**
     * Metodo para eliminar un usuario
     *
     * @param usuario
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean eliminar(String usuario) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.eliminar(usuario);
    }

    /**
     * Metodo para obtener un usuario
     *
     * @param usuario
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public static Cuenta obtener(String usuario) throws ListaNullException, PosicionNoEncontradaException {
        return cuentadao.obtener(usuario);
    }

    //GETTER AND SETTER
    public static CuentaDAO getCuentadao() {
        return cuentadao;
    }

    public static void setCuentadao(CuentaDAO cuentadao) {
        CuentaController.cuentadao = cuentadao;
    }

}
