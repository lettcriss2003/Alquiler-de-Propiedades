/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author lettc
 */
public class Propiedad {
    private Integer id;
    private String nombre;
    private String nroPropiedad;
    private String servicios;
    private Float precioPorNoche;
    private String resenia;
    private String descripcion;
    private Integer nroBanios;
    private Integer nroCuartos;
    private Integer nroCamas;
    private Integer limiteHuespedes;
    private Date disponibilidad;
    private TipoPropiedad tipoPropiedad;

    public Propiedad() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroPropiedad() {
        return nroPropiedad;
    }

    public void setNroPropiedad(String nroPropiedad) {
        this.nroPropiedad = nroPropiedad;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public Float getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(Float precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNroBanios() {
        return nroBanios;
    }

    public void setNroBanios(Integer nroBanios) {
        this.nroBanios = nroBanios;
    }

    public Integer getNroCuartos() {
        return nroCuartos;
    }

    public void setNroCuartos(Integer nroCuartos) {
        this.nroCuartos = nroCuartos;
    }

    public Integer getNroCamas() {
        return nroCamas;
    }

    public void setNroCamas(Integer nroCamas) {
        this.nroCamas = nroCamas;
    }

    public Integer getLimiteHuespedes() {
        return limiteHuespedes;
    }

    public void setLimiteHuespedes(Integer limiteHuespedes) {
        this.limiteHuespedes = limiteHuespedes;
    }

    public Date getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Date disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public TipoPropiedad getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    @Override
    public String toString() {
        return "Propiedad{" + "nombre=" + nombre + ", nroPropiedad=" + nroPropiedad + ", servicios=" + servicios + ", precioPorNoche=" + precioPorNoche + ", resenia=" + resenia + ", descripcion=" + descripcion + ", nroBanios=" + nroBanios + ", nroCuartos=" + nroCuartos + ", nroCamas=" + nroCamas + ", limiteHuespedes=" + limiteHuespedes + ", disponibilidad=" + disponibilidad + ", tipoPropiedad=" + tipoPropiedad + '}';
    }
    
    
    
}
