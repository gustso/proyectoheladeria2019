/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;
import java.util.List;

/**
 *
 * @author gustso
 */
public interface IClienteDAO {
    
    Cliente obtenerCliente(String nombreCliente);

    void modificar(Cliente unCliente);
    
    public List<Cliente> obtenerListaClientesActivos();
    
    public void agregar(Cliente unCliente);
    
}
