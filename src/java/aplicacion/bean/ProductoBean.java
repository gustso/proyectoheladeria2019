/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.mysql.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
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
public class ProductoBean implements Serializable{

    /**
     * Creates a new instance of productoBean
     */
    public ProductoBean() {
    }
 
    public List<Producto> obtenerListaProductos(){
        IProductoDAO productoDao = new ProductoDAOImp();        
        return productoDao.obtenerListaProductos();
    }
    
    public void agregarProducto(Producto unProducto){
        IProductoDAO productoDao = new ProductoDAOImp();        
        productoDao.agregar(unProducto);
    }
    
    public Producto consultarProducto(int codigo){
        IProductoDAO productoDAO = new ProductoDAOImp();
        Producto producto = productoDAO.consultarProducto(codigo);
        return producto;
    }
}
