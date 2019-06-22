/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ClienteBean;
import aplicacion.bean.LibroBean;
import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;

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
        getUnUsuario().setClientes(unCliente);
        //Debe cambiar el codigo
        getUnUsuario().setCodigo(152);
        try {
            usuarioBean.agregarUsuario(unUsuario);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Agregado Correctamente","Usuario" + unUsuario.getApellidos());
                FacesContext.getCurrentInstance().addMessage(null,facesMessage);
        }
        catch (Exception e) {        
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","No se pudo agregar Usuario");
                FacesContext.getCurrentInstance().addMessage(null,facesMessage);        
        }           
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

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
}
