/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajeria.api.avanzada.Dao;
import com.mycompany.mensajeria.api.avanzada.Model.Usuario;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
/**
 *
 * @author fefe
 */
@Service
public class DaoUsuarios {
    
    private ArrayList<Usuario> lista;
    
    public DaoUsuarios()
    {
        lista=new ArrayList<Usuario>();
    }
    
    private void cargarUsuario(Usuario user)
    {
        lista.add(user);
    }
    
    private void eliminarUsuario(Usuario user)
    {
        lista.remove(user);
    }
    
    private Usuario traerUsuarioPorId(String nickname)
    {
        Usuario objU=new Usuario();
        
        for(Usuario user:lista)
        {
            if(nickname.equals(user.getNickName()))
            {
                objU=user;
            }
        }
        return objU;
    }
    
    private Usuario traerUsuarioIdentico(Usuario u)
    {
        Usuario objU=new Usuario();
        
        for(Usuario user:lista)
        {
            if(u.equals(user.getId()))
            {
                objU=user;
            }
        }
        return objU;
    }
    
    public ArrayList<Usuario> traerTodos()
    {
        return this.lista;
    }
}
