package aplicacion.modelo.dominio;
// Generated Jun 4, 2019 12:47:47 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Libro generated by hbm2java
 */
public class Libro  implements java.io.Serializable {


     private int isbn;
     private Autor autor;
     private String titulo;
     private Date fechaEd;
     private String libroscol;
     private Double precio;
     private String categoria;

    public Libro() {
    }

	
    public Libro(int isbn, Autor autor) {
        this.isbn = isbn;
        this.autor = autor;
    }
    public Libro(int isbn, Autor autor, String titulo, Date fechaEd, String libroscol, Double precio, String categoria) {
       this.isbn = isbn;
       this.autor = autor;
       this.titulo = titulo;
       this.fechaEd = fechaEd;
       this.libroscol = libroscol;
       this.precio = precio;
       this.categoria = categoria;
    }
   
    public int getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public Autor getAutor() {
        return this.autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getFechaEd() {
        return this.fechaEd;
    }
    
    public void setFechaEd(Date fechaEd) {
        this.fechaEd = fechaEd;
    }
    public String getLibroscol() {
        return this.libroscol;
    }
    
    public void setLibroscol(String libroscol) {
        this.libroscol = libroscol;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }




}


