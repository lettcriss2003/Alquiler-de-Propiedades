/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import controlador.PagoDAO;
import modelo.TipoDePago;
import vista.Utilidades.Utilidades;

/**
 *
 * @author lettc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PagoDAO pg=new PagoDAO();
        pg.getPago().setMesesPlazo(15);
        pg.getPago().setTipoDePago(TipoDePago.unSoloPago);
        try {
            pg.guardar();
        } catch (Exception e) {
        }
    }
    
}
