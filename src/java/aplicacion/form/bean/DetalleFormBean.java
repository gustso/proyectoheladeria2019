/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.hibernate.mapeos.Detalle;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@SessionScoped
public class DetalleFormBean implements Serializable{
    private int cantidad;
    private Detalle unDetalle;
    private String modoPago;
    private List<String> tiposModPago;
    private int cantidadCuotas;

    /**
     * Creates a new instance of DetalleFormBean
     */
    public DetalleFormBean() {
    }

    public void confirmarCompra(){
        
    }
    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Detalle getUnDetalle() {
        return unDetalle;
    }

    public void setUnDetalle(Detalle unDetalle) {
        this.unDetalle = unDetalle;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    public List<String> getTiposModPago() {
        return tiposModPago;
    }

    public void setTiposModPago(List<String> tiposModPago) {
        this.tiposModPago = tiposModPago;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }
    
}
