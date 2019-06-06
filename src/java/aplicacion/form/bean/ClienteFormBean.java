/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ClienteBean;
import aplicacion.bean.LibroBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@ViewScoped
public class ClienteFormBean {
    private Cliente unCliente;
    private Usuario unUsuario;
    @ManagedProperty(value="#{clienteBean}")
    private ClienteBean clienteBean;

    /**
     * Creates a new instance of ClienteFormBean
     */
    public ClienteFormBean() {
        unCliente = new Cliente();
        unUsuario = new Usuario();
    }
    
    public void agregarCliente(){
        getUnUsuario().setEstado(true);
        getUnUsuario().setTipoUsuario("cliente");
        clienteBean.agregarCliente(getUnUsuario(),getUnCliente());
    }
    /**
     * @return the unCliente
     */
    public Cliente getUnCliente() {
        return unCliente;
    }

    /**
     * @param unCliente the unCliente to set
     */
    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }
    
}
