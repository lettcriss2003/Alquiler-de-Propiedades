/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author lettc
 */
public class Cuenta {
    
    private Integer id;
    private String usuario;
    private Boolean estado;
    private String contrasenia;
    private Persona persona;
    private Rol rol;

    public Cuenta() {
    }
    
    public Cuenta(String usuario, String contrasenia, Persona persona, Integer id, Boolean estado, Rol rol) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.persona = persona;
        this.id = id;
        this.estado = estado;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @Override
    public String toString() {
        return "Cuenta{" + "usuario=" + usuario + ", constrasenia=" + contrasenia + ", persona=" + persona + ", id=" + id + ", estado=" + estado + '}';
    }
}
