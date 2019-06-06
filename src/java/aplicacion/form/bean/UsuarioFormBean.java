/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;


import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author caroapaza
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean implements Serializable{
    private boolean esAdministrador;
    private boolean esUsuario;
    
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    public UsuarioFormBean() {
    }
    
        
    /**
     * Obtiene la lista de usuarios activos
     * @return 
     */
    public List<Usuario> obtenerListaUsuariosActivos(){
        return usuarioBean.obtenerListaUsuariosActivos();
    }
    
    /**
     * agrega un usuario
     * con rol usuario
     */
    public void agregarNuevoUsuario(){
        //recupero objeto rol usuario
        //usuarioBean.getUsuario().setRol(new ListadoRoles().getListaRoles().get(1));
        Usuario unUsuario = new Usuario();
        usuarioBean.agregarUsuario(unUsuario);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Éxito",  "Se agregó un Usuario correctamente." ));        
    }
    
    /**
     * agrega un nuevo usuario
     * con rol administrador
     */
    public void agregarNuevoUsuarioAdmin(){
        //recupero objeto rol administrador
        //usuarioBean.getUsuario().setRol(new ListadoRoles().getListaRoles().get(0));
        Usuario unUsuario = new Usuario();
        usuarioBean.agregarUsuario(unUsuario);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Éxito",  "Se agregó un Usuario Administrador correctamente." ));
        
    }
    
    /**
     * retorna el nombre del usuario en sesión
     * @return 
     */
    public String devolverNombreUsuario() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return "[ " + usuario.getApellidos()+", "+usuario.getNombres() + " ]  ";
    }

    /**
     * Verifica si el usuario 
     * logueado al sistema permanece en sesión
     * @return 
     */
    public boolean verificarSesion() {
        boolean sesionValida = false;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") != null) {
            sesionValida = true;
        }
        return sesionValida;
    }
    
    /**
     * Devuelve el rol de usuario
     * @return  nombre de rol (administrador o usuario)
     */
    public String devolverRolUsuario(){
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return usuario.getTipoUsuario();
    }
    
    /**
     * Retorna el nombre de la página
     * que permite dar de alta un usuario
     * @return 
     */
    public String generarNuevoUsuario(){
        return "usuario-new.xhtml";
    }
    
    /**
     * Retorna el nombre de la página
     * que permite loguear al usuario
     * @return 
     */
    public String mostrarLogin(){
        return "login.xhtml";
    }

    
    

    public boolean isEsAdministrador() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(usuario.getTipoUsuario().equals("admin")){
            esAdministrador = true;
        }else{
            esAdministrador = false;
        }
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    public boolean isEsUsuario() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(usuario.getTipoUsuario().equals("usuario")){
            esUsuario = true;
        }else{
            esUsuario = false;
        }
        return esUsuario;
    }

    public void setEsUsuario(boolean esUsuario) {
        this.esUsuario = esUsuario;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    
    
}
