/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.test;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.mysql.ProductoDAOImp;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;

/**
 *
 * @author gustso
 */
public class testProducto {
    public static void main(String[] arg){        
        Categoria unaCategoria = new Categoria(3);
        Producto unProducto = new Producto(4,unaCategoria);
        IProductoDAO productoDAO = new ProductoDAOImp();
        productoDAO.agregar(unProducto);
    }
    
}
