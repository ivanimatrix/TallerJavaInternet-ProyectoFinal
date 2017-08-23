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
public class ClienteDTO {
    
    private int id_cliente;
    private String email_cliente;
    private String fono_cliente;

    public ClienteDTO() {
    }

    public ClienteDTO(int id_cliente, String email_cliente, String fono_cliente) {
        this.id_cliente = id_cliente;
        this.email_cliente = email_cliente;
        this.fono_cliente = fono_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getFono_cliente() {
        return fono_cliente;
    }

    public void setFono_cliente(String fono_cliente) {
        this.fono_cliente = fono_cliente;
    }
    
    
    
}
