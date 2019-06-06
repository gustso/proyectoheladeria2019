/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IClienteDAO;
import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.ClienteDAOImp;
import aplicacion.dao.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }
    
    public void agregarCliente(Usuario unUsuario, Cliente unCliente){
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuarioDAO.agregar(unUsuario);
        IClienteDAO clienteDAO = new ClienteDAOImp();
        clienteDAO.agregar(unCliente);
        
    }
}
