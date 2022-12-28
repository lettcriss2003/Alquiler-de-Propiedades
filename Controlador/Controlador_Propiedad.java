/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import modelo.Propiedad;

/**
 *
 * @author lettc
 */
public class Controlador_Propiedad {
    
    private Propiedad propiedad = new Propiedad();
    
    public Controlador_Propiedad(){
    
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    @Override
    public String toString() {
        return "Controlador_Propiedad{" + "propiedad=" + propiedad + '}';
    }
    
    
    
    
}
