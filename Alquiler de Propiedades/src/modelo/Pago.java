/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lettc
 */

@XmlRootElement 
public class Pago {
    
    private Integer id;
    private MetodoPago metodoPago;
    private TipoDePago tipoDePago;
    private Boolean estadoPago;
    private Integer mesesPlazo;
    private Double cuotaPorMes;
    
    
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(TipoDePago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Integer getMesesPlazo() {
        return mesesPlazo;
    }

    public void setMesesPlazo(Integer mesesPlazo) {
        this.mesesPlazo = mesesPlazo;
    }

    public Double getCuotaPorMes() {
        return cuotaPorMes;
    }

    public void setCuotaPorMes(Double cuotaPorMes) {
        this.cuotaPorMes = cuotaPorMes;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", metodoPago=" + metodoPago + ", tipoDePago=" + tipoDePago + ", estadoPago=" + estadoPago + ", mesesPlazo=" + mesesPlazo + ", cuotaPorMes=" + cuotaPorMes + '}';
    }
}
