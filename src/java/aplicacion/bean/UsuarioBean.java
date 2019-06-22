/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public List<Usuario> obtenerListaUsuariosActivos(){
        IUsuarioDAO usuarioDao = new UsuarioDAOImp();        
        return usuarioDao.obtenerListaUsuariosActivos();
    }
    
    public void agregarUsuario(Usuario unUsuario){
        IUsuarioDAO usuarioDao = new UsuarioDAOImp();        
        usuarioDao.agregar(unUsuario);
    }
}
