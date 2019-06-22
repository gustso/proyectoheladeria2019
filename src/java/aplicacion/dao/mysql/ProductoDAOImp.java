/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IProductoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gustso
 */
public class ProductoDAOImp implements IProductoDAO{

    @Override
    public Producto consultarProducto(int codigo) {
        Producto p = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.like("codProducto", codigo));
        if(!criteria.list().isEmpty())
            p = (Producto)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public void modificar(Producto unProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> obtenerListaProductos() {
        List<Producto> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.isNotNull("stock"));
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();        
        return listado;
    }

    @Override
    public void agregar(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unProducto);
        session.getTransaction().commit();
        session.close();
    }
    
}
