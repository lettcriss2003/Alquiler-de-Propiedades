/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import controlador.loginExcepciones.datoIncorrectoException;
import controlador.loginExcepciones.intentoExcedidoException;
import controlador.loginExcepciones.usuarioNoExisteException;
import controlador.utiles.Utilidades;
import modelo.Cuenta;

/**
 *
 * @author leomah
 */
public class CuentasController {

    private ListaEnlazada<Cuenta> cuentaslList = new ListaEnlazada<>();
    private static CuentaDAO cuentadao = new CuentaDAO();
    protected Integer limite = 5;

    public CuentasController() {
    }

    public ListaEnlazada<Cuenta> getCuentaslList() {
        return cuentaslList;
    }

    public void setCuentaslList(ListaEnlazada<Cuenta> cuentaslList) {
        this.cuentaslList = cuentaslList;
    }
//
//    @Override
//    public String toString() {
//        return "CuentasController{" + "cuenta=" + cuenta + '}';
//    }

    /**
     * Metodo para autentificar las credenciales ingresadas por el usuario
     *
     * @param usuario
     * @param contrasenia
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     * @throws controlador.loginExcepciones.intentoExcedidoException
     * @throws controlador.loginExcepciones.datoIncorrectoException
     */
    public Boolean autentificar(String usuario, String contrasenia) throws ListaVaciaException, PosicionNoEncontradaException, intentoExcedidoException, datoIncorrectoException, usuarioNoExisteException {
        Boolean autentificacion = false;
        if (cuentadao.getCuentas().estaVacia()) {
            throw new usuarioNoExisteException();
        } else {
            if (obtener(usuario) != null) {
                Cuenta cuentaConsulta = obtener(usuario);
                if (cuentaConsulta.getUsuario().equals(usuario)
                        && Utilidades.desencriptarContrasenia(cuentaConsulta.getContrasenia()).equals(contrasenia)) {
                    autentificacion = true;
                    limite = 5;
                    return autentificacion;
                } else if (limite > 1) {
                    throw new datoIncorrectoException(--limite);
                } else {
                    System.exit(0);
                    throw new intentoExcedidoException();
                }
            } else {
                throw new ListaVaciaException();
            }
        }
        
    }

    /**
     * Metodo para obtener un usuario
     *
     * @param usuario
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public static Cuenta obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.obtener(usuario);
    }

    /**
     * Metodo para insertar una cuenta
     *
     * @param cuenta
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean insertar(Cuenta cuenta) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.insertar(cuenta);
    }

    /**
     * Metodo para modificar una cuenta
     *
     * @param cuenta
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean modificar(Cuenta cuenta) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.modificar(cuenta);
    }

    /**
     * Metodo para eliminar un usuario
     *
     * @param usuario
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public static Boolean eliminar(String usuario) throws ListaVaciaException, PosicionNoEncontradaException {
        return cuentadao.eliminar(usuario);
    }

    //GETTER AND SETTER
    public static CuentaDAO getCuentadao() {
        if (cuentadao == null) {
            cuentadao = new CuentaDAO();
        }

        return cuentadao;
    }

    public static void setCuentadao(CuentaDAO cuentadao) {
        CuentasController.cuentadao = cuentadao;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
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
