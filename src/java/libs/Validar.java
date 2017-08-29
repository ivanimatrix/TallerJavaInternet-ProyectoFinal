/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UsuarioDTO;

/**
 *
 * @author ivanimatrix
 */
public class Validar {
    
    
    public boolean validarAccionPerfil(HttpServletRequest request, HttpServletResponse response, int[] perfiles) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        
        boolean valido = true;
        
        for(int perfil : perfiles){
            if(usuario.getPerfil_usuario() == perfil){
                valido = false;
            }
        }
        
        return valido;
    }
    
}
