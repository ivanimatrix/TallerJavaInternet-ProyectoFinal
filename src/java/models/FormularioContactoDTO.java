/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ivanimatrix
 */
public class FormularioContactoDTO {
    
    
    private int id_contacto;
    private String nombres_contacto;
    private String apellidos_contacto;
    private String email_contacto;
    private String telefono_contacto;
    private String mensaje_contacto;
    private String fecha_contacto;

    public String getFecha_contacto() {
        return fecha_contacto;
    }

    public void setFecha_contacto(String fecha_contacto) {
        this.fecha_contacto = fecha_contacto;
    }

    public FormularioContactoDTO() {
    }

    public FormularioContactoDTO(String nombres_contacto, String apellidos_contacto, String email_contacto, String telefono_contacto, String mensaje_contacto, String fecha_contacto) {
        this.nombres_contacto = nombres_contacto;
        this.apellidos_contacto = apellidos_contacto;
        this.email_contacto = email_contacto;
        this.telefono_contacto = telefono_contacto;
        this.mensaje_contacto = mensaje_contacto;
        this.fecha_contacto = fecha_contacto;
    }

    public FormularioContactoDTO(int id_contacto, String nombres_contacto, String apellidos_contacto, String email_contacto, String telefono_contacto, String mensaje_contacto, String fecha_contacto) {
        this.id_contacto = id_contacto;
        this.nombres_contacto = nombres_contacto;
        this.apellidos_contacto = apellidos_contacto;
        this.email_contacto = email_contacto;
        this.telefono_contacto = telefono_contacto;
        this.mensaje_contacto = mensaje_contacto;
        this.fecha_contacto = fecha_contacto;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getNombres_contacto() {
        return nombres_contacto;
    }

    public void setNombres_contacto(String nombres_contacto) {
        this.nombres_contacto = nombres_contacto;
    }

    public String getApellidos_contacto() {
        return apellidos_contacto;
    }

    public void setApellidos_contacto(String apellidos_contacto) {
        this.apellidos_contacto = apellidos_contacto;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getMensaje_contacto() {
        return mensaje_contacto;
    }

    public void setMensaje_contacto(String mensaje_contacto) {
        this.mensaje_contacto = mensaje_contacto;
    }
    
    
    
    
}
