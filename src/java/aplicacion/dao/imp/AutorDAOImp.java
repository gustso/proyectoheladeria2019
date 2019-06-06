/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IAutorDAO;
import aplicacion.modelo.dominio.Autor;
import java.util.List;

/**
 *
 * @author gustso
 */
public class AutorDAOImp implements IAutorDAO{
//Como
    @Override
    public void agregarAutor(Autor unAutor) {
        
    }

    @Override
    public void eliminarAutor(Autor unAutor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarAutor(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarAutor(Autor unAutor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> obtenerTodosAutores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
