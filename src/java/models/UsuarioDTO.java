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
public class UsuarioDTO {

    private int id_usuario;
    private String rut_usuario;
    private String pass_usuario;
    private String nombres_usuario;
    private String apellidos_usuario;
    private int perfil_usuario;
    
    
    public UsuarioDTO(){
        
    }
    
    public UsuarioDTO(int id_usuario){
        this.id_usuario = id_usuario;	
    }

    public UsuarioDTO(int id_usuario, String rut_usuario, String pass_usuario, String nombres_usuario, String apellidos_usuario, int perfil_usuario) {
        this.id_usuario = id_usuario;
        this.rut_usuario = rut_usuario;
        this.pass_usuario = pass_usuario;
        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.perfil_usuario = perfil_usuario;
    }

    
    public UsuarioDTO(String rut_usuario, String pass_usuario, String nombres_usuario, String apellidos_usuario, int perfil_usuario) {
        this.rut_usuario = rut_usuario;
        this.pass_usuario = pass_usuario;
        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.perfil_usuario = perfil_usuario;
    }
    
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public int getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(int perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getNombres_usuario() {
        return nombres_usuario;
    }

    public void setNombres_usuario(String nombres_usuario) {
        this.nombres_usuario = nombres_usuario;
    }

    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) {
        this.apellidos_usuario = apellidos_usuario;
    }
    
    
    

    
}
