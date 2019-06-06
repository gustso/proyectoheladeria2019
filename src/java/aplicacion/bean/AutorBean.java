/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IAutorDAO;
import aplicacion.dao.mysql.AutorDAOImp;
import aplicacion.modelo.dominio.Autor;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@ViewScoped
public class AutorBean implements Serializable{
IAutorDAO autorDAO;
    /**
     * Creates a new instance of BeandBean
     */
    public AutorBean() {
        autorDAO = new AutorDAOImp();
    }
    
public void agregarAutor(Autor unAutor){
    autorDAO.agregarAutor(unAutor);
}

public List<Autor> obtenerAutores(){
    return autorDAO.obtenerTodosAutores();
}
}
