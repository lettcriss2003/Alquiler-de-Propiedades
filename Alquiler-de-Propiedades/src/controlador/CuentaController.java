/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.CuentaDAO;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import java.util.Base64;
import modelo.Cuenta;

/**
 *
 * @author LENOVO
 */
public class CuentaController {

    private static CuentaDAO cuentadao = new CuentaDAO();

    /**
     * Metodo para autentificar las credenciales ingresadas por el usuario
     *
     * @param usuario
     * @param contrasenia
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean autentificar(String usuario, String contrasenia) throws ListaNullException, PosicionNoEncontradaException {
        if (obtener(usuario) != null) {
            Cuenta cuentaConsulta = obtener(usuario);
            if (cuentaConsulta.getUsuario().equals(usuario)
                    && CuentaController.desencriptarContrasenia(cuentaConsulta.getConstrasenia()).equals(contrasenia)) {
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

    /**
     * Permite encriptar constrasenias mediante el esquema de codificacion
     * Base64
     *
     * @param dato
     * @return
     */
    public static String encriptarContrasenia(String dato) {
        if (dato != null) {
            return Base64.getEncoder().encodeToString(dato.getBytes());
        }
        return "";
    }

    /**
     * Permite desencriptar contraseñas mediante el esquema de codificacion
     * Base64
     *
     * @param dato
     * @return
     */
    public static String desencriptarContrasenia(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    //GETTER AND SETTER
    public static CuentaDAO getCuentadao() {
        return cuentadao;
    }

    public static void setCuentadao(CuentaDAO cuentadao) {
        CuentaController.cuentadao = cuentadao;
    }

}
