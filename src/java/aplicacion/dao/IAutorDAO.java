/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Autor;
import java.util.List;

/**
 *
 * @author gustso
 */
public interface IAutorDAO {
    //qué
    public void agregarAutor(Autor unAutor);
    public void eliminarAutor(Autor unAutor);
    public void consultarAutor(String codigo);
    public void modificarAutor(Autor unAutor);
    public List<Autor> obtenerTodosAutores();
}
