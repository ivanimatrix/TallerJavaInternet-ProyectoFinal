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
public class MecanicoDTO {
    
    private int id_mecanico;
    private String especialidad_mecanico;

    public MecanicoDTO() {
    }

    public MecanicoDTO(int id_mecanico, String especialidad_mecanico) {
        this.id_mecanico = id_mecanico;
        this.especialidad_mecanico = especialidad_mecanico;
    }

    public int getId_mecanico() {
        return id_mecanico;
    }

    public void setId_mecanico(int id_mecanico) {
        this.id_mecanico = id_mecanico;
    }

    public String getEspecialidad_mecanico() {
        return especialidad_mecanico;
    }

    public void setEspecialidad_mecanico(String especialidad_mecanico) {
        this.especialidad_mecanico = especialidad_mecanico;
    }
    
    
    
}
