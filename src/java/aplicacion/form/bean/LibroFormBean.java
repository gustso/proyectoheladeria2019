/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.AutorBean;
import aplicacion.bean.LibroBean;
import aplicacion.modelo.dominio.Autor;
import aplicacion.modelo.dominio.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author GustsoNT
 */
@ManagedBean
@ViewScoped
public class LibroFormBean implements Serializable {
    @ManagedProperty(value="#{libroBean}")
    private LibroBean libroBean;
    @ManagedProperty(value="#{autorBean}")
    private AutorBean autorBean;
    private List<Autor> autores;
    private Autor unAutor; 
    private Libro unLibro;
    private ArrayList<Libro> listadoLibros;
    
    
    private boolean cat;
    private String buscaTitulo;
    private String buscaCat;
    

    /**
     * Creates a new instance of LibroFormBean
     */
    public LibroFormBean() {
       //autores = new ArrayList();       
       //autores.add(new Autor (38000000,"Juan","Fernandez"));
       //autores.add(new Autor (39000000,"Pedro","Borneman"));
       //autores.add(new Autor (40000000,"Maria","Quinta"));       
        cat = false;
        unLibro = new Libro();        
    }
    
    @PostConstruct
    public void init(){
        agregarAutores();
    }
    
    private void agregarAutores(){
       //autorBean = new AutorBean();       
       autores = new ArrayList();
       autores = autorBean.obtenerAutores();
        
    }

    //public ArrayList<Autor> llenarAutores(){
      //  autores = new ArrayList();
       // autores.add(new Autor ("38000000","Juan","Sosa"));
        //autores.add(new Autor ("39000000","Pedro","Borneman"));
        //autores.add(new Autor ("40000000","Maria","Quinta"));
        //return autores;
   // }
    
    public void agregarLibro() {
        //setUnLibro(new Libro(getUnIsbn(), getUnAutor(), getUnTitulo(), getUnPrecio(), getUnaCategoria(),getUnaFecha()));
                //getLibroBean().agregarLibro(getUnLibro());
        try {
            System.out.println("llllllllllllllllllllllllllllllllega");    
            getLibroBean().agregarLibro(getUnLibro());
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Libro Agregado Correctamente","Libro" + getUnLibro().getTitulo());
                FacesContext.getCurrentInstance().addMessage(null,facesMessage);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","No se pudo agregar Libro");
                FacesContext.getCurrentInstance().addMessage(null,facesMessage);
            }
        setUnLibro(new Libro());
    }
    
    public void obtenerListado(){
        setListadoLibros(getLibroBean().obtenerListado());
    }

    public void buscarLibro() {
        //libro = new Libro();
        //libro = libros.buscarLibro(getBuscaTitulo(), getBuscaCat(), isCat());
        //System.out.println("encontrado" + libro.getAutor());
    }
    
    public void establecerLibro(Libro otroLibro){        
        setUnLibro(otroLibro);
    }
    
    public void modificarLibro(){
        try {
                getLibroBean().modificarLibro(getUnLibro());
                FacesMessage facesMessage = new FacesMessage
        (FacesMessage.SEVERITY_INFO,"Libro Modificado Correctamente","Libro" + getUnLibro().getTitulo());
                FacesContext.getCurrentInstance().addMessage(null,facesMessage);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","No se pudo agregar Libro");
                FacesContext.getCurrentInstance().addMessage(null,facesMessage);
            }
        setUnLibro(new Libro());
    }

   public void validarCampo(){
       if (!"1234".equals(getUnLibro().getIsbn())){
           FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, 
     new FacesMessage(FacesMessage.SEVERITY_ERROR,"error al ingresar ISBN","revisar error por favor-"));
       }
   }
    /**
     * @return the cat
     */
    public boolean isCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(boolean cat) {
        this.cat = cat;
    }

    /**
     * @return the buscaTitulo
     */
    public String getBuscaTitulo() {
        return buscaTitulo;
    }

    /**
     * @param buscaTitulo the buscaTitulo to set
     */
    public void setBuscaTitulo(String buscaTitulo) {
        this.buscaTitulo = buscaTitulo;
    }

    /**
     * @return the buscaCat
     */
    public String getBuscaCat() {
        return buscaCat;
    }

    /**
     * @param buscaCat the buscaCat to set
     */
    public void setBuscaCat(String buscaCat) {
        this.buscaCat = buscaCat;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    /**
     * @return the libroBean
     */
    public LibroBean getLibroBean() {
        return libroBean;
    }

    /**
     * @param libroBean the libroBean to set
     */
    public void setLibroBean(LibroBean libroBean) {
        this.libroBean = libroBean;
    }

    /**
     * @return the unAutor
     */
    public Autor getUnAutor() {
        return unAutor;
    }

    /**
     * @param unAutor the unAutor to set
     */
    public void setUnAutor(Autor unAutor) {
        this.unAutor = unAutor;
    }

    /**
     * @return the unLibro
     */
    public Libro getUnLibro() {
        return unLibro;
    }

    /**
     * @param unLibro the unLibro to set
     */
    public void setUnLibro(Libro unLibro) {
        this.unLibro = unLibro;
    }

    /**
     * @return the listadoLibros
     */
    public ArrayList<Libro> getListadoLibros() {
        return listadoLibros;
    }

    /**
     * @param listadoLibros the listadoLibros to set
     */
    public void setListadoLibros(ArrayList<Libro> listadoLibros) {
        this.listadoLibros = listadoLibros;
    }

    public AutorBean getAutorBean() {
        return autorBean;
    }

    public void setAutorBean(AutorBean autorBean) {
        this.autorBean = autorBean;
    }


}
