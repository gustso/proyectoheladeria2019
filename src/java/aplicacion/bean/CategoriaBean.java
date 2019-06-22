/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.dao.mysql.CategoriaDAOImp;
import aplicacion.modelo.dominio.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable{

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
    }
 
    public List<Categoria> obtenerListaCategorias(){
        ICategoriaDAO categoriaDao = new CategoriaDAOImp();        
        return categoriaDao.obtenerListaCategorias();
    }
}
