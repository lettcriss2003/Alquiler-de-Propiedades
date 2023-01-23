/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.listas.ListaEnlazada;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Cuenta;

/**
 *
 * @author LENOVO
 */
public class CuentaDAO {

    private ListaEnlazada<Cuenta> cuentas = new ListaEnlazada<>();
//    private Cuenta cuenta;

    public CuentaDAO() {

    }

    //TODO cambiar por busqueda binaria
    /**
     * Buscar el usuario en el registro de cuentas
     *
     * @param usuario
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public int buscar(String usuario) throws ListaNullException, PosicionNoEncontradaException {
        int n = -1;
        for (int i = 0; i < cuentas.getSize(); i++) {
            if (cuentas.obtener(i).getUsuario().equals(usuario)) {
                n = i;
                break;
            }
        }
        return n;
    }

    /**
     * Insertar la nueva cuenta registrada en la lista de cuentas
     *
     * @param cuenta
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public Boolean insertar(Cuenta cuenta) throws ListaNullException, PosicionNoEncontradaException {
        if (buscar(cuenta.getUsuario()) == -1) {
            cuentas.insertar(cuenta);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Modificar una cuenta registrada de la lista de cuentas, solo para
     * administradores
     *
     * @param cuenta
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public Boolean modificar(Cuenta cuenta) throws ListaNullException, PosicionNoEncontradaException {
        if (buscar(cuenta.getUsuario()) != -1) {
            Cuenta cuentaaux = obtener(cuenta.getUsuario());

            cuentaaux.setConstrasenia(cuenta.getConstrasenia());
            cuentaaux.setId(cuenta.getId());
            cuentaaux.setEstado(cuenta.getEstado());

            cuentaaux.getPersona().setNombres(cuenta.getPersona().getNombres());
            cuentaaux.getPersona().setApellidos(cuenta.getPersona().getApellidos());
            cuentaaux.getPersona().setFechaNacimiento(cuenta.getPersona().getFechaNacimiento());
            cuentaaux.getPersona().setIndentificacion(cuenta.getPersona().getIndentificacion());
            cuentaaux.getPersona().setTipoIdentificacion(cuenta.getPersona().getTipoIdentificacion());
            cuentaaux.getPersona().setEstado(cuenta.getPersona().getEstado());
            cuentaaux.getPersona().setCorreo(cuenta.getPersona().getCorreo());

            return true;
        } else {
            return false;
        }
    }

    /**
     * Eliminar una cuenta registrada de la lista de cuentas, solo para
     * administradores
     *
     * @param cuenta
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException
     */
    public Boolean eliminar(String cuenta) throws ListaNullException, PosicionNoEncontradaException {
        if (buscar(cuenta) != -1) {

            cuentas.eliminar(buscar(cuenta));

            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo accesor para obtener los usuarios de las cuentas
     * @param usuario
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException 
     */
    public Cuenta obtener(String usuario) throws ListaNullException, PosicionNoEncontradaException {
        if (buscar(usuario) != 1) {
            return cuentas.obtener(buscar(usuario));
        } else {
            return null;
        }
    }

    //GETTER AND SETTER
    public ListaEnlazada<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ListaEnlazada<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "CuentaDAO{" + "cuentas=" + cuentas + '}';
    }

}
