/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.LibroDAO;
import aplicacion.datos.ColeccionLibros;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Libro;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author gustso
 */
public class LibroDAOImp implements LibroDAO{

    @Override
    public void agregar(Libro unLibro) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unLibro);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Libro unLibro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Libro unLibro) {
        //revisar tiene que haber un campo que no se pueda modificar, con este realizar la comparacion
        boolean esHallado = false;
        for (int i = 0;i<ColeccionLibros.getLibros().size()&&esHallado!=true;i++){
            Libro libroDelListado = ColeccionLibros.getLibros().get(i);
            if (libroDelListado.equals(unLibro)){
                ColeccionLibros.getLibros().set(i, unLibro);
                esHallado = true;
            }
        }
    }

    @Override
    public Libro consultar(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Libro> obtenerListado() {
        return ColeccionLibros.getLibros();
    }
    
}
