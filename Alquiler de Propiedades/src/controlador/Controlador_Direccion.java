/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import modelo.Direccion;

/**
 *
 * @author lettc
 */
public class Controlador_Direccion {
    private Direccion direccion = new Direccion();
    
    public Controlador_Direccion(){
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Controlador_Direccion{" + "direccion=" + direccion + '}';
    }
    
    
    
}
