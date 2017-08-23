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
public class VehiculoDTO {
    
    private int id_vehiculo;
    private String patente_vehiculo;
    private String marca_vehiculo;
    private String modelo_vehiculo;
    private int anyo_vehiculo;
    private int fk_cliente_vehiculo;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String patente_vehiculo, String marca_vehiculo, String modelo_vehiculo, int anyo_vehiculo, int fk_cliente_vehiculo) {
        this.patente_vehiculo = patente_vehiculo;
        this.marca_vehiculo = marca_vehiculo;
        this.modelo_vehiculo = modelo_vehiculo;
        this.anyo_vehiculo = anyo_vehiculo;
        this.fk_cliente_vehiculo = fk_cliente_vehiculo;
    }

    public VehiculoDTO(int id_vehiculo, String patente_vehiculo, String marca_vehiculo, String modelo_vehiculo, int anyo_vehiculo, int fk_cliente_vehiculo) {
        this.id_vehiculo = id_vehiculo;
        this.patente_vehiculo = patente_vehiculo;
        this.marca_vehiculo = marca_vehiculo;
        this.modelo_vehiculo = modelo_vehiculo;
        this.anyo_vehiculo = anyo_vehiculo;
        this.fk_cliente_vehiculo = fk_cliente_vehiculo;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getPatente_vehiculo() {
        return patente_vehiculo;
    }

    public void setPatente_vehiculo(String patente_vehiculo) {
        this.patente_vehiculo = patente_vehiculo;
    }

    public String getMarca_vehiculo() {
        return marca_vehiculo;
    }

    public void setMarca_vehiculo(String marca_vehiculo) {
        this.marca_vehiculo = marca_vehiculo;
    }

    public String getModelo_vehiculo() {
        return modelo_vehiculo;
    }

    public void setModelo_vehiculo(String modelo_vehiculo) {
        this.modelo_vehiculo = modelo_vehiculo;
    }

    public int getAnyo_vehiculo() {
        return anyo_vehiculo;
    }

    public void setAnyo_vehiculo(int anyo_vehiculo) {
        this.anyo_vehiculo = anyo_vehiculo;
    }

    public int getFk_cliente_vehiculo() {
        return fk_cliente_vehiculo;
    }

    public void setFk_cliente_vehiculo(int fk_cliente_vehiculo) {
        this.fk_cliente_vehiculo = fk_cliente_vehiculo;
    }
    
    
    
    
}
