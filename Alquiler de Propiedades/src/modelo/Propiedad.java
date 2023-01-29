/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author lettc
 */
public class Propiedad {
        private String Ciudad;
    private String Provincia;
    private String CalleP;
    private String CalleS;
    private String CodigoP;
    
    public boolean Wifi;
    public boolean TV;
    public boolean Lavadora;
    public boolean Secadora;
    public boolean Estacionamiento;
    public boolean Cocina;
    public boolean Picina;
    public boolean Jacuzzi;
    public boolean Parrilla;
    public boolean Patio;
    public boolean Comedor;
    public boolean SalaJuegos;
    public boolean AireAcondicionado;
    public boolean AguaCaliente;
    public boolean Otros;
    
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
    private ImageIcon Imagen;
    
    
    
    public Propiedad(String Ciudad,String Provincia,String CalleP,String CalleS, String CodigoP,
            boolean Wifi,boolean TV,boolean Lavadora,boolean Secadora,boolean Estacionamiento,boolean Cocina,boolean Picina,boolean Jacuzzi,boolean Parrilla,boolean Patio,boolean Comedor,boolean SalaJuegos,boolean AireAcondicionado,boolean AguaCaliente,boolean Otros,
            String TipoPropiedad,String Descripcion,String NumeroPropiedad,String Huesped,String Habitaciones,String Camas, String Baños,String Precio,String FechaIngreso,String FechaSalida,
            ImageIcon Imagen){
        
        this.Ciudad = Ciudad;
        this.Provincia = Provincia;
        this.CalleP = CalleP;
        this.CalleS=CalleS;
        this.CodigoP=CodigoP;
        
        this.Wifi=Wifi;
        this.TV=TV;
        this.Lavadora=Lavadora;
        this.Secadora=Secadora;
        this.Estacionamiento=Estacionamiento;
        this.Cocina=Cocina;
        this.Picina=Picina;
        this.Jacuzzi=Jacuzzi;
        this.Parrilla=Parrilla;
        this.Patio=Patio;
        this.Comedor=Comedor;
        this.SalaJuegos=SalaJuegos;
        this.AireAcondicionado=AireAcondicionado;
        this.AguaCaliente=AguaCaliente;
        this.Otros=Otros;
        
        this.TipoPropiedad=TipoPropiedad;
        this.Descripcion=Descripcion;
        this.NumeroPropiedad=NumeroPropiedad;
        this.Huesped=Huesped;
        this.Habitaciones=Habitaciones;
        this.Camas=Camas;
        this.Baños=Baños;
        this.Precio=Precio;
        this.FechaIngreso=FechaIngreso;
        this.FechaSalida=FechaSalida;
        
        this.Imagen=Imagen;
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

    public String getCodigoP() {
        return CodigoP;
    }

    public void setCodigoP(String CodigoP) {
        this.CodigoP = CodigoP;
    }

    public boolean isWifi() {
        return Wifi;
    }

    public void setWifi(boolean Wifi) {
        this.Wifi = Wifi;
    }

    public boolean isTV() {
        return TV;
    }

    public void setTV(boolean TV) {
        this.TV = TV;
    }

    public boolean isLavadora() {
        return Lavadora;
    }

    public void setLavadora(boolean Lavadora) {
        this.Lavadora = Lavadora;
    }

    public boolean isSecadora() {
        return Secadora;
    }

    public void setSecadora(boolean Secadora) {
        this.Secadora = Secadora;
    }

    public boolean isEstacionamiento() {
        return Estacionamiento;
    }

    public void setEstacionamiento(boolean Estacionamiento) {
        this.Estacionamiento = Estacionamiento;
    }

    public boolean isCocina() {
        return Cocina;
    }

    public void setCocina(boolean Cocina) {
        this.Cocina = Cocina;
    }

    public boolean isPicina() {
        return Picina;
    }

    public void setPicina(boolean Picina) {
        this.Picina = Picina;
    }

    public boolean isJacuzzi() {
        return Jacuzzi;
    }

    public void setJacuzzi(boolean Jacuzzi) {
        this.Jacuzzi = Jacuzzi;
    }

    public boolean isParrilla() {
        return Parrilla;
    }

    public void setParrilla(boolean Parrilla) {
        this.Parrilla = Parrilla;
    }

    public boolean isPatio() {
        return Patio;
    }

    public void setPatio(boolean Patio) {
        this.Patio = Patio;
    }

    public boolean isComedor() {
        return Comedor;
    }

    public void setComedor(boolean Comedor) {
        this.Comedor = Comedor;
    }

    public boolean isSalaJuegos() {
        return SalaJuegos;
    }

    public void setSalaJuegos(boolean SalaJuegos) {
        this.SalaJuegos = SalaJuegos;
    }

    public boolean isAireAcondicionado() {
        return AireAcondicionado;
    }

    public void setAireAcondicionado(boolean AireAcondicionado) {
        this.AireAcondicionado = AireAcondicionado;
    }

    public boolean isAguaCaliente() {
        return AguaCaliente;
    }

    public void setAguaCaliente(boolean AguaCaliente) {
        this.AguaCaliente = AguaCaliente;
    }

    public boolean isOtros() {
        return Otros;
    }

    public void setOtros(boolean Otros) {
        this.Otros = Otros;
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

    public ImageIcon getImagen() {
        return Imagen;
    }

    public void setImagen(ImageIcon Imagen) {
        this.Imagen = Imagen;
    }
    

    @Override
    public String toString() {
        return "Ciudad=" + Ciudad + ", Provincia=" + Provincia + ", CalleP=" + CalleP + ", CalleS=" + CalleS + ", CodigoP=" + CodigoP + ", Wifi=" + Wifi + ", TV=" + TV + ", Lavadora=" + Lavadora + ", Secadora=" + Secadora + ", Estacionamiento=" + Estacionamiento + ", Cocina=" + Cocina + ", Picina=" + Picina + ", Jacuzzi=" + Jacuzzi + ", Parrilla=" + Parrilla + ", Patio=" + Patio + ", Comedor=" + Comedor + ", SalaJuegos=" + SalaJuegos + ", AireAcondicionado=" + AireAcondicionado + ", AguaCaliente=" + AguaCaliente + ", Otros=" + Otros + ", TipoPropiedad=" + TipoPropiedad + ", Descripcion=" + Descripcion + ", NumeroPropiedad=" + NumeroPropiedad + ", Huesped=" + Huesped + ", Habitaciones=" + Habitaciones + ", Camas=" + Camas + ", Ba\u00f1os=" + Baños + ", Precio=" + Precio + ", FechaIngreso=" + FechaIngreso + ", FechaSalida=" + FechaSalida + ", Imagen=" + Imagen;
    }
    
}
