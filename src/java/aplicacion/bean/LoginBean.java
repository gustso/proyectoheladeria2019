/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public Usuario validarUsuario(String nombreUs, String passwUs){
        IUsuarioDAO usuarioDao = new UsuarioDAOImp();
        Usuario usuario = usuarioDao.validarUsuario(nombreUs,passwUs);
        return usuario;
    }
}
