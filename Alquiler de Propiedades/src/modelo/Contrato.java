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
public class Contrato {
    private Integer id;
    private Integer nroDias;
    private Integer pagoID;
    
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

    public Integer getPagoID() {
        return pagoID;
    }

    public void setPagoID(Integer pagoID) {
        this.pagoID = pagoID;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", nroDias=" + nroDias + ", pagoID=" + pagoID + '}';
    }

 

   
}
