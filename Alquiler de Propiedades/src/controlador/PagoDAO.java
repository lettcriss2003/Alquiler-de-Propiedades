/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Pago;

/**
 *
 * @author Dennys
 */

public class PagoDAO extends AdaptadorDao<Pago>{
    private Pago pago;

    public PagoDAO() {
        super(Pago.class);
    }
    


    public Pago getPago() {
        if (pago==null) {
            pago=new Pago();
        }
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    public boolean guardar() throws Exception{
        this.pago.setId(generarId());
        guardar(this.pago);
        return true;
    }

    private Integer generarId(){
        return listar().getTamanio()+1;
    }
    
    public Pago obtenerPago(Integer id){
        if (id<=listar().getTamanio()) {
            return obtener(id);
        }else{
            System.out.println("FUERA DE LIMITES DEL ARCHIVO");
            return null;
        }
    }
    
    public boolean modificar(Integer pos) throws Exception{
        modificar(this.pago, pos);
        return true;
    }
}
