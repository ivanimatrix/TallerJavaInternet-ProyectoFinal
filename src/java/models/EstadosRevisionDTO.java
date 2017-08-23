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
public class EstadosRevisionDTO {
    
    private int codigo_estrev;
    private String nombre_estrev;

    public EstadosRevisionDTO() {
    }

    public EstadosRevisionDTO(int codigo_estrev, String nombre_estrev) {
        this.codigo_estrev = codigo_estrev;
        this.nombre_estrev = nombre_estrev;
    }

    public int getCodigo_estrev() {
        return codigo_estrev;
    }

    public void setCodigo_estrev(int codigo_estrev) {
        this.codigo_estrev = codigo_estrev;
    }

    public String getNombre_estrev() {
        return nombre_estrev;
    }

    public void setNombre_estrev(String nombre_estrev) {
        this.nombre_estrev = nombre_estrev;
    }
    
    
    
    
}
