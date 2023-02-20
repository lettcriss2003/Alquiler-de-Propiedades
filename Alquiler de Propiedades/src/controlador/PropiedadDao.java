/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Propiedad;

/**
 *
 * @author Dennys
 */
public class PropiedadDao extends AdaptadorDAO<Propiedad>{
    private Propiedad propiedad;

    public PropiedadDao() {
        super(Propiedad.class);
    }

    /**
     * get propiedad
     * @return propiedad
     */
    public Propiedad getPropiedad() {
        if (propiedad==null) {
            this.propiedad=new Propiedad();
        }
        return propiedad;
    }

    /**
     * set propiedad
     * @param propiedad 
     */
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
    
    /**
     * guardar
     * @return boolean
     * @throws Exception 
     */
    public boolean guardar() throws Exception{
        this.propiedad.setId(generarId());
        guardar(this.propiedad);
        return true;
    }

    private Integer generarId(){
        return listar().getTamanio()+1;
    }
    

    public Propiedad obtenerPropiedad(Integer id){
        if (id<=listar().getTamanio()) {
            return obtener(id);
        }else{
            System.out.println("FUERA DE LIMITES DEL ARCHIVO");
            return null;
        }
    }
    
    /**
     * modificar
     * @param pos
     * @return boolean
     * @throws Exception 
     */
    public boolean modificar(Integer pos) throws Exception{
        modificar(this.propiedad, pos);
        return true;
    }
}
