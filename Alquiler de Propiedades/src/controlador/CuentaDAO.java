/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import busqueda.controlador.LinealBinaria.BusquedaLinealBinaria;
import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import modelo.Cuenta;
import ordenacion.Excepciones.AtributoNoEncontradoException;

public class CuentaDAO {

    private ListaEnlazada<Cuenta> cuentas = new ListaEnlazada<>();

    /**
     * Buscar los usuarios registrados
     *
     * @param usuario
     * @return n
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public int buscar(String usuario) throws ListaVaciaException, PosicionNoEncontradaException {
        int n = -1;
        for (int i = 0; i < cuentas.getTamanio(); i++) {
            if (cuentas.obtener(i).getUsuario().equals(usuario)) {
                n = i;
                break;
            }
        }
        return n;
    }

    /**
     * Inserta en la lista de cuentas un nuevo usuario
     *
     * @param cuenta
     * @return boolean
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public Boolean insertar(Cuenta cuenta) throws ListaVaciaException, PosicionNoEncontradaException {
        if (buscar(cuenta.getUsuario()) == -1) {
            cuentas.insertar(cuenta);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Modifica en la lista de cuentas un usuario que haya sido registrado
     *
     * @param cuenta
     * @return boolean
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     * @throws ordenacion.Excepciones.AtributoNoEncontradoException
     * @throws java.lang.IllegalAccessException
     */
    public Boolean modificar(Cuenta cuenta) throws ListaVaciaException, PosicionNoEncontradaException, AtributoNoEncontradoException, IllegalAccessException, Exception {
        if (buscar(cuenta.getUsuario()) != -1) {
            Cuenta cuentaaux = obtener(cuenta.getUsuario());

            cuentaaux.setContrasenia(cuenta.getContrasenia());
            cuentaaux.setId(cuenta.getId());
            cuentaaux.setEstado(cuenta.getEstado());

            cuentaaux.getPersona().setNombres(cuenta.getPersona().getNombres());
            cuentaaux.getPersona().setApellidos(cuenta.getPersona().getApellidos());
            cuentaaux.getPersona().setFechaNacimiento(cuenta.getPersona().getFechaNacimiento());
            cuentaaux.getPersona().setIdentificacion(cuenta.getPersona().getIdentificacion());
            cuentaaux.getPersona().setTipoIdentificacion(cuenta.getPersona().getTipoIdentificacion());
            cuentaaux.getPersona().setEstado(cuenta.getPersona().getEstado());
            cuentaaux.getPersona().setCorreo(cuenta.getPersona().getCorreo());

            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un usurio de la lista de cuentas
     *
     * @param cuenta
     * @return boolean
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public Boolean eliminar(String cuenta) throws ListaVaciaException, PosicionNoEncontradaException {
        if (buscar(cuenta) != -1) {
            cuentas.eliminarPosicion(buscar(cuenta));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtener un usuario de la lista de cuentas
     *
     * @param usuario
     * @return cuenta
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     * @throws ordenacion.Excepciones.AtributoNoEncontradoException
     * @throws java.lang.IllegalAccessException
     */
    public Cuenta obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException, Exception {
        try {
            if (!cuentas.busquedaBinaria("usuario", usuario).equals(usuario)) {
                return cuentas.obtener(buscar(usuario));
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * get Cuentas
     * @return cuentas
     */
    public ListaEnlazada<Cuenta> getCuentas() {
        if (cuentas == null) {
            cuentas = new ListaEnlazada<>();
        }
        return cuentas;
    }

    /**
     * set cuentas
     * @param cuentas 
     */
    public void setCuentas(ListaEnlazada<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
