package aplicacion.hibernate.mapeos;
// Generated Jun 5, 2019 12:08:53 PM by Hibernate Tools 4.3.1



/**
 * Detalle generated by hbm2java
 */
public class Detalle  implements java.io.Serializable {


     private int iddetalle;
     private Factura factura;
     private Productos productos;
     private Integer cantidad;
     private String precioProdCant;

    public Detalle() {
    }

	
    public Detalle(int iddetalle, Factura factura, Productos productos) {
        this.iddetalle = iddetalle;
        this.factura = factura;
        this.productos = productos;
    }
    public Detalle(int iddetalle, Factura factura, Productos productos, Integer cantidad, String precioProdCant) {
       this.iddetalle = iddetalle;
       this.factura = factura;
       this.productos = productos;
       this.cantidad = cantidad;
       this.precioProdCant = precioProdCant;
    }
   
    public int getIddetalle() {
        return this.iddetalle;
    }
    
    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getPrecioProdCant() {
        return this.precioProdCant;
    }
    
    public void setPrecioProdCant(String precioProdCant) {
        this.precioProdCant = precioProdCant;
    }




}


