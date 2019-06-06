/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.LibroDAO;
import aplicacion.dao.mysql.LibroDAOImp;
import aplicacion.modelo.dominio.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@ViewScoped
public class LibroBean implements Serializable{    
    private LibroDAO libroDAO;
    
    /**
     * Creates a new instance of LibroBean
     */
    public LibroBean() {   
        libroDAO = new LibroDAOImp();
    }
    
    public ArrayList<Libro> obtenerListado(){
        return getLibroDAO().obtenerListado();
    }
    
    public void agregarLibro(Libro unLibro){        
        //Libro nuevoLibro = new Libro(unLibro.getIsbn(),unLibro.getTitulo(),unLibro.getCategoria());
        getLibroDAO().agregar(unLibro);
        
    }       
    
    public Libro consultarLibro(){
        Libro unLibro = new Libro();
        return unLibro;
    }
    
    public void modificarLibro(Libro unLibro){
        getLibroDAO().modificar(unLibro);
    }
    /**
     * @return the libroDAO
     */
    public LibroDAO getLibroDAO() {
        return libroDAO;
    }

    /**
     * @param libroDAO the libroDAO to set
     */
    public void setLibroDAO(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    

}
