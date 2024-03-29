package aplicacion.modelo.dominio;
// Generated Jun 11, 2019 1:12:09 PM by Hibernate Tools 4.3.1



/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {
     private int codProducto;
     private Categoria categorias;
     private String descripcion;
     private Double precio;
     private Integer stock;
     private Boolean estado;
     private byte[] foto;     

    public Producto() {
    }

	
    public Producto(int codProducto, Categoria categorias) {
        this.codProducto = codProducto;
        this.categorias = categorias;
    }

    public Producto(int codProducto, Categoria categorias, String descripcion, Double precio, Integer stock, Boolean estado, byte[] foto) {
        this.codProducto = codProducto;
        this.categorias = categorias;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.foto = foto;
    }
    
   
    public int getCodProducto() {
        return this.codProducto;
    }
    
    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }
    public Categoria getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}


