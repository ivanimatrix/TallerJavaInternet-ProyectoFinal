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
public class TrabajoDTO {
    
    private int id_trabajo;
    private int fk_revision_trabajo;
    private int fk_mecanico_trabajo;
    private String fecha_trabajo;
    private String descripcion_trabajo;
    private int valor_trabajo;

    public TrabajoDTO() {
    }

    public TrabajoDTO(int fk_revision_trabajo, int fk_mecanico_trabajo, String fecha_trabajo, String descripcion_trabajo, int valor_trabajo) {
        this.fk_revision_trabajo = fk_revision_trabajo;
        this.fk_mecanico_trabajo = fk_mecanico_trabajo;
        this.fecha_trabajo = fecha_trabajo;
        this.descripcion_trabajo = descripcion_trabajo;
        this.valor_trabajo = valor_trabajo;
    }

    public TrabajoDTO(int id_trabajo, int fk_revision_trabajo, int fk_mecanico_trabajo, String fecha_trabajo, String descripcion_trabajo, int valor_trabajo) {
        this.id_trabajo = id_trabajo;
        this.fk_revision_trabajo = fk_revision_trabajo;
        this.fk_mecanico_trabajo = fk_mecanico_trabajo;
        this.fecha_trabajo = fecha_trabajo;
        this.descripcion_trabajo = descripcion_trabajo;
        this.valor_trabajo = valor_trabajo;
    }

    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public int getFk_revision_trabajo() {
        return fk_revision_trabajo;
    }

    public void setFk_revision_trabajo(int fk_revision_trabajo) {
        this.fk_revision_trabajo = fk_revision_trabajo;
    }

    public int getFk_mecanico_trabajo() {
        return fk_mecanico_trabajo;
    }

    public void setFk_mecanico_trabajo(int fk_mecanico_trabajo) {
        this.fk_mecanico_trabajo = fk_mecanico_trabajo;
    }

    public String getFecha_trabajo() {
        return fecha_trabajo;
    }

    public void setFecha_trabajo(String fecha_trabajo) {
        this.fecha_trabajo = fecha_trabajo;
    }

    public String getDescripcion_trabajo() {
        return descripcion_trabajo;
    }

    public void setDescripcion_trabajo(String descripcion_trabajo) {
        this.descripcion_trabajo = descripcion_trabajo;
    }

    public int getValor_trabajo() {
        return valor_trabajo;
    }

    public void setValor_trabajo(int valor_trabajo) {
        this.valor_trabajo = valor_trabajo;
    }
    
    
    
    
}
