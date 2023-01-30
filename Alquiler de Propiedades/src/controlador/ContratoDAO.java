/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Contrato;

/**
 *
 * @author Dennys
 */
public class ContratoDAO extends AdaptadorDao<Contrato> {
    private Contrato contrato=new Contrato();
    
    public ContratoDAO() {
        super(Contrato.class);
    }

    public Contrato getContrato() {
        if (contrato==null) {
            contrato=new Contrato();
        }
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
     public boolean guardar() throws Exception{
        this.contrato.setId(generarId());
        guardar(this.contrato);
        return true;
    }

    private Integer generarId(){
        return listar().getTamanio()+1;
    }
    
    public Contrato obtenerPago(Integer id){
        if (id<=listar().getTamanio()) {
            return obtener(id);
        }else{
            System.out.println("FUERA DE LIMITES DEL ARCHIVO");
            return null;
        }
    }
    
    public boolean modificar(Integer pos) throws Exception{
        modificar(this.contrato, pos);
        return true;
    }
}
