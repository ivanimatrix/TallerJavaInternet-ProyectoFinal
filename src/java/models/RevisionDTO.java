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
public class RevisionDTO {
    
    private int id_revision;
    private int fk_vehiculo_revision;
    private int estado_revision;

    public RevisionDTO() {
    }

    public RevisionDTO(int fk_vehiculo_revision, int estado_revision) {
        this.fk_vehiculo_revision = fk_vehiculo_revision;
        this.estado_revision = estado_revision;
    }

    public RevisionDTO(int id_revision, int fk_vehiculo_revision, int estado_revision) {
        this.id_revision = id_revision;
        this.fk_vehiculo_revision = fk_vehiculo_revision;
        this.estado_revision = estado_revision;
    }

    public int getId_revision() {
        return id_revision;
    }

    public void setId_revision(int id_revision) {
        this.id_revision = id_revision;
    }

    public int getFk_vehiculo_revision() {
        return fk_vehiculo_revision;
    }

    public void setFk_vehiculo_revision(int fk_vehiculo_revision) {
        this.fk_vehiculo_revision = fk_vehiculo_revision;
    }

    public int getEstado_revision() {
        return estado_revision;
    }

    public void setEstado_revision(int estado_revision) {
        this.estado_revision = estado_revision;
    }
    
    
    
    
}
