/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.ImageIcon;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lettc
 */

@XmlRootElement
public class Propiedad {
    private Integer id;
    private String Ciudad;
    private String Provincia;
    private String CalleP;
    private String CalleS;
    private String CodigoP;
    
    private Boolean Wifi;
    private Boolean TV;
    private Boolean Lavadora;
    private Boolean Secadora;
    private Boolean Estacionamiento;
    private Boolean Cocina;
    private Boolean Picina;
    private Boolean Jacuzzi;
    private Boolean Parrilla;
    private Boolean Patio;
    private Boolean Comedor;
    private Boolean SalaJuegos;
    private Boolean AireAcondicionado;
    private Boolean AguaCaliente;
    private Boolean Otros;
    
    private String TipoPropiedad;
    private String Descripcion;
    private String NumeroPropiedad;
    private String Huesped;
    private String Habitaciones;
    private String Camas;
    private String Baños;
    private String Precio;
    private String FechaIngreso;
    private String FechaSalida;
    private Contrato contrato;

    private String ImgPropiedad;
    
    public Propiedad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCalleP() {
        return CalleP;
    }

    public void setCalleP(String CalleP) {
        this.CalleP = CalleP;
    }

    public String getCalleS() {
        return CalleS;
    }

    public void setCalleS(String CalleS) {
        this.CalleS = CalleS;
    }

    public String getImgPropiedad() {
        return ImgPropiedad;
    }

    public void setImgPropiedad(String ImgPropiedad) {
        this.ImgPropiedad = ImgPropiedad;
    }
    
    public String getCodigoP() {
        return CodigoP;
    }

    public void setCodigoP(String CodigoP) {
        this.CodigoP = CodigoP;
    }

    public Boolean getWifi() {
        return Wifi;
    }

    public void setWifi(Boolean Wifi) {
        this.Wifi = Wifi;
    }

    public String getTipoPropiedad() {
        return TipoPropiedad;
    }

    public void setTipoPropiedad(String TipoPropiedad) {
        this.TipoPropiedad = TipoPropiedad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNumeroPropiedad() {
        return NumeroPropiedad;
    }

    public void setNumeroPropiedad(String NumeroPropiedad) {
        this.NumeroPropiedad = NumeroPropiedad;
    }

    public String getHuesped() {
        return Huesped;
    }

    public void setHuesped(String Huesped) {
        this.Huesped = Huesped;
    }

    public String getHabitaciones() {
        return Habitaciones;
    }

    public void setHabitaciones(String Habitaciones) {
        this.Habitaciones = Habitaciones;
    }

    public String getCamas() {
        return Camas;
    }

    public void setCamas(String Camas) {
        this.Camas = Camas;
    }

    public String getBaños() {
        return Baños;
    }

    public void setBaños(String Baños) {
        this.Baños = Baños;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public Boolean getTV() {
        return TV;
    }

    public void setTV(Boolean TV) {
        this.TV = TV;
    }

    public Boolean getLavadora() {
        return Lavadora;
    }

    public void setLavadora(Boolean Lavadora) {
        this.Lavadora = Lavadora;
    }

    public Boolean getSecadora() {
        return Secadora;
    }

    public void setSecadora(Boolean Secadora) {
        this.Secadora = Secadora;
    }

    public Boolean getEstacionamiento() {
        return Estacionamiento;
    }

    public void setEstacionamiento(Boolean Estacionamiento) {
        this.Estacionamiento = Estacionamiento;
    }

    public Boolean getCocina() {
        return Cocina;
    }

    public void setCocina(Boolean Cocina) {
        this.Cocina = Cocina;
    }

    public Boolean getPicina() {
        return Picina;
    }

    public void setPicina(Boolean Picina) {
        this.Picina = Picina;
    }

    public Boolean getJacuzzi() {
        return Jacuzzi;
    }

    public void setJacuzzi(Boolean Jacuzzi) {
        this.Jacuzzi = Jacuzzi;
    }

    public Boolean getParrilla() {
        return Parrilla;
    }

    public void setParrilla(Boolean Parrilla) {
        this.Parrilla = Parrilla;
    }

    public Boolean getPatio() {
        return Patio;
    }

    public void setPatio(Boolean Patio) {
        this.Patio = Patio;
    }

    public Boolean getComedor() {
        return Comedor;
    }

    public void setComedor(Boolean Comedor) {
        this.Comedor = Comedor;
    }

    public Boolean getSalaJuegos() {
        return SalaJuegos;
    }

    public void setSalaJuegos(Boolean SalaJuegos) {
        this.SalaJuegos = SalaJuegos;
    }

    public Boolean getAireAcondicionado() {
        return AireAcondicionado;
    }

    public void setAireAcondicionado(Boolean AireAcondicionado) {
        this.AireAcondicionado = AireAcondicionado;
    }

    public Boolean getAguaCaliente() {
        return AguaCaliente;
    }

    public void setAguaCaliente(Boolean AguaCaliente) {
        this.AguaCaliente = AguaCaliente;
    }

    public Boolean getOtros() {
        return Otros;
    }

    public void setOtros(Boolean Otros) {
        this.Otros = Otros;
    }

    @Override
    public String toString() {
        return "Propiedad{" + "id=" + id + ", Ciudad=" + Ciudad + ", Provincia=" + Provincia + ", CalleP=" + CalleP + ", CalleS=" + CalleS + ", CodigoP=" + CodigoP + ", Wifi=" + Wifi + ", TV=" + TV + ", Lavadora=" + Lavadora + ", Secadora=" + Secadora + ", Estacionamiento=" + Estacionamiento + ", Cocina=" + Cocina + ", Picina=" + Picina + ", Jacuzzi=" + Jacuzzi + ", Parrilla=" + Parrilla + ", Patio=" + Patio + ", Comedor=" + Comedor + ", SalaJuegos=" + SalaJuegos + ", AireAcondicionado=" + AireAcondicionado + ", AguaCaliente=" + AguaCaliente + ", Otros=" + Otros + ", TipoPropiedad=" + TipoPropiedad + ", Descripcion=" + Descripcion + ", NumeroPropiedad=" + NumeroPropiedad + ", Huesped=" + Huesped + ", Habitaciones=" + Habitaciones + ", Camas=" + Camas + ", Ba\u00f1os=" + Baños + ", Precio=" + Precio + ", FechaIngreso=" + FechaIngreso + ", FechaSalida=" + FechaSalida + ", ImgPropiedad=" + ImgPropiedad + '}';
    }
}
