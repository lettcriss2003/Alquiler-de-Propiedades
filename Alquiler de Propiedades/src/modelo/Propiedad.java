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
    private String Banios;
    private String Precio;
    private String FechaIngreso;
    private String FechaSalida;
<<<<<<< HEAD
    
    private String Img;
    private String Img1;
    private String Img2;
    private String Img3;
    private String Img4;
    private String Img5;

    public Propiedad() {
    }
    
    public Propiedad(String Ciudad1, String provincia, String CalleP1, String CalleS1, String CodigoP1, boolean Wifi1, boolean TV1, boolean Lavadora1, boolean Secadora1, boolean Estacionamiento1, boolean Cocina1, boolean Picina1, boolean Jacuzzi1, boolean Parrilla1, boolean Patio1, boolean Comedor1, boolean SalaJuegos1, boolean AireAcondicionado1, boolean AguaCaliente1, boolean Otros1, String TipoPropiedad1, String Descripcion1, String NumeroPropiedad1, String Huesped1, String Habitaciones1, String Camas1, String Banios1, String Precio1, String FechaIngreso1, String FechaSalida1, ImageIcon imagen, ImageIcon imagen1, ImageIcon imagen2, ImageIcon imagen3, ImageIcon imagen4, ImageIcon imagen5) {
    }

    public Propiedad(Integer id, String Ciudad, String Provincia, String CalleP, String CalleS, String CodigoP, 
            Boolean Wifi, Boolean TV, Boolean Lavadora, Boolean Secadora, Boolean Estacionamiento, Boolean Cocina, 
            Boolean Picina, Boolean Jacuzzi, Boolean Parrilla, Boolean Patio, Boolean Comedor, Boolean SalaJuegos, 
            Boolean AireAcondicionado, Boolean AguaCaliente, Boolean Otros, String TipoPropiedad, String Descripcion, 
            String NumeroPropiedad, String Huesped, String Habitaciones, String Camas, String Banios, String Precio, 
            String FechaIngreso, String FechaSalida, String Img, String Img1, String Img2, String Img3, String Img4, String Img5) {
        this.id = id;
        this.Ciudad = Ciudad;
        this.Provincia = Provincia;
        this.CalleP = CalleP;
        this.CalleS = CalleS;
        this.CodigoP = CodigoP;
        this.Wifi = Wifi;
        this.TV = TV;
        this.Lavadora = Lavadora;
        this.Secadora = Secadora;
        this.Estacionamiento = Estacionamiento;
        this.Cocina = Cocina;
        this.Picina = Picina;
        this.Jacuzzi = Jacuzzi;
        this.Parrilla = Parrilla;
        this.Patio = Patio;
        this.Comedor = Comedor;
        this.SalaJuegos = SalaJuegos;
        this.AireAcondicionado = AireAcondicionado;
        this.AguaCaliente = AguaCaliente;
        this.Otros = Otros;
        this.TipoPropiedad = TipoPropiedad;
        this.Descripcion = Descripcion;
        this.NumeroPropiedad = NumeroPropiedad;
        this.Huesped = Huesped;
        this.Habitaciones = Habitaciones;
        this.Camas = Camas;
        this.Banios = Banios;
        this.Precio = Precio;
        this.FechaIngreso = FechaIngreso;
        this.FechaSalida = FechaSalida;
        this.Img = Img;
        this.Img1 = Img1;
        this.Img2 = Img2;
        this.Img3 = Img3;
        this.Img4 = Img4;
        this.Img5 = Img5;
    }

    
    
=======
    private Contrato contrato;

    private String ImgPropiedad;
    
    public Propiedad() {
    }
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha

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

    public String getBanios() {
        return Banios;
    }

    public void setBanios(String Baños) {
        this.Banios = Baños;
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
<<<<<<< HEAD
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public String getImg1() {
        return Img1;
    }

    public void setImg1(String Img1) {
        this.Img1 = Img1;
    }

    public String getImg2() {
        return Img2;
    }

    public void setImg2(String Img2) {
        this.Img2 = Img2;
    }

    public String getImg3() {
        return Img3;
    }

    public void setImg3(String Img3) {
        this.Img3 = Img3;
    }

    public String getImg4() {
        return Img4;
    }

    public void setImg4(String Img4) {
        this.Img4 = Img4;
    }

    public String getImg5() {
        return Img5;
    }

    public void setImg5(String Img5) {
        this.Img5 = Img5;
=======
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Propiedad{" + "id=" + id + ", Ciudad=" + Ciudad + ", Provincia=" + Provincia + ", CalleP="
                + CalleP + ", CalleS=" + CalleS + ", CodigoP=" + CodigoP + ", Wifi=" + Wifi + ", TV=" + TV 
                + ", Lavadora=" + Lavadora + ", Secadora=" + Secadora + ", Estacionamiento=" + Estacionamiento + ", Cocina=" 
                + Cocina + ", Picina=" + Picina + ", Jacuzzi=" + Jacuzzi + ", Parrilla=" + Parrilla + ", Patio=" + Patio 
                + ", Comedor=" + Comedor + ", SalaJuegos=" + SalaJuegos + ", AireAcondicionado=" + AireAcondicionado 
                + ", AguaCaliente=" + AguaCaliente + ", Otros=" + Otros + ", TipoPropiedad=" + TipoPropiedad + ", Descripcion=" 
                + Descripcion + ", NumeroPropiedad=" + NumeroPropiedad + ", Huesped=" + Huesped + ", Habitaciones=" + Habitaciones 
                + ", Camas=" + Camas + ", Banios=" + Banios + ", Precio=" + Precio + ", FechaIngreso=" + FechaIngreso
                + ", FechaSalida=" + FechaSalida + ", Img=" + Img + ", Img1=" + Img1 + ", Img2=" + Img2 + ", Img3=" + Img3 
                + ", Img4=" + Img4 + ", Img5=" + Img5 + '}';
    }
 
=======
        return "Propiedad{" + "id=" + id + ", Ciudad=" + Ciudad + ", Provincia=" + Provincia + ", CalleP=" + CalleP + ", CalleS=" + CalleS + ", CodigoP=" + CodigoP + ", Wifi=" + Wifi + ", TV=" + TV + ", Lavadora=" + Lavadora + ", Secadora=" + Secadora + ", Estacionamiento=" + Estacionamiento + ", Cocina=" + Cocina + ", Picina=" + Picina + ", Jacuzzi=" + Jacuzzi + ", Parrilla=" + Parrilla + ", Patio=" + Patio + ", Comedor=" + Comedor + ", SalaJuegos=" + SalaJuegos + ", AireAcondicionado=" + AireAcondicionado + ", AguaCaliente=" + AguaCaliente + ", Otros=" + Otros + ", TipoPropiedad=" + TipoPropiedad + ", Descripcion=" + Descripcion + ", NumeroPropiedad=" + NumeroPropiedad + ", Huesped=" + Huesped + ", Habitaciones=" + Habitaciones + ", Camas=" + Camas + ", Ba\u00f1os=" + Baños + ", Precio=" + Precio + ", FechaIngreso=" + FechaIngreso + ", FechaSalida=" + FechaSalida + ", ImgPropiedad=" + ImgPropiedad + '}';
    }
>>>>>>> pagosPropiedades-gestionPropiedadesAnfitrion-Pucha
}
