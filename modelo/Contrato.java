/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lettc
 */
public class Contrato {
    private Integer id;
    private Integer nroDias;
    private MetodoPago metodoPago;

    public Contrato() {
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroDias() {
        return nroDias;
    }

    public void setNroDias(Integer nroDias) {
        this.nroDias = nroDias;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", nroDias=" + nroDias + ", metodoPago=" + metodoPago + '}';
    }
    
}
