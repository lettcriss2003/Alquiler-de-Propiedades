/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Cuenta {

    private String usuario;
    private String constrasenia;
    private Persona persona;
    private Integer id;
    private Boolean estado;

    public Cuenta() {
    }

    public Cuenta(String usuario, String constrasenia, Persona persona, Integer id, Boolean estado) {
        this.usuario = usuario;
        this.constrasenia = constrasenia;
        this.persona = persona;
        this.id = id;
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "usuario=" + usuario + ", constrasenia=" + constrasenia + ", persona=" + persona + ", id=" + id + ", estado=" + estado + '}';
    }

    
}
