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
    private Pago pago;
    
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

    public Pago getPago() {
        if (this.pago==null) {
            this.pago=new Pago();
        }
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", nroDias=" + nroDias + ", pago=" + pago + '}';
    }
    
}
