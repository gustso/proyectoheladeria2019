/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.CategoriaBean;
import aplicacion.bean.ProductoBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gustso
 */
@ManagedBean
@SessionScoped
public class ProductoFormBean implements Serializable {

    @ManagedProperty(value = "#{productoBean}")
    private ProductoBean productoBean;
    @ManagedProperty(value = "#{categoriaBean}")
    private CategoriaBean categoriaBean;

    private Producto unProducto;
    private List<Categoria> categorias;
    private transient UploadedFile archivo = null;
    private List<Producto> listadoProductos;
    private Producto productoSeleccionado;

    /**
     * Creates a new instance of productoFormBean
     */
    public ProductoFormBean() {
        unProducto = new Producto();
        listadoProductos = new ArrayList();
    }

    @PostConstruct
    public void init() {
        obtenerListaCategorias();
    }

    public List<Producto> obtenerListaProductos() {
        return productoBean.obtenerListaProductos();
    }

    private void obtenerListaCategorias() {
        categorias = new ArrayList();
        categorias = categoriaBean.obtenerListaCategorias();
    }

    public void agregarProducto() {
        getUnProducto().setEstado(true);        

        if (getArchivo() != null) {
            byte[] contents = getArchivo().getContents();
            getUnProducto().setFoto(contents);
        } else {
            getUnProducto().setFoto(null);
        }

        try {
            getProductoBean().agregarProducto(getUnProducto());
            FacesMessage facesMessage = new FacesMessage
        (FacesMessage.SEVERITY_INFO, "Producto agregado correctamente", "Producto " + getUnProducto().getDescripcion());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage
        (FacesMessage.SEVERITY_WARN, "Error Grave", "No se pudo agregar Producto");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }

        setUnProducto(new Producto());
    }

    public void agregarCompra(){            
            try {
            getListadoProductos().add(getProductoSeleccionado());
            FacesMessage facesMessage = new FacesMessage
        (FacesMessage.SEVERITY_INFO, "Producto agregado al Carro de Compras", "Producto " + getProductoSeleccionado().getDescripcion());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage
        (FacesMessage.SEVERITY_WARN, "Error Grave", "No se pudo agregar Producto");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    
    public String comprar(){
        //crear un modo de pago, luego una factura que tiene el uusario y finalmente on la factura y este array armar el detalle que se mostrara
        String resultado = null;
        if (getListadoProductos().isEmpty()){
            FacesMessage facesMessage = new FacesMessage
        (FacesMessage.SEVERITY_WARN, "Error Grave", "Debe agregar producto a comprar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else{
            //mandar el listado a la otra pagina
            resultado = "compraProductos";
        }
        return resultado;
    }
    
    public void establecerProducto(Producto producto){        
        System.out.println("cccccccccccccccccccccccccccccccccccccccccccccc"+producto.getDescripcion());
        setProductoSeleccionado(producto);
    }
    
    public ProductoBean getProductoBean() {
        return productoBean;
    }

    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }

    public Producto getUnProducto() {
        return unProducto;
    }

    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public StreamedContent getFotoProducto() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();        
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {            
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            //se ubica en el ciclo de vida de request
            return new DefaultStreamedContent();
        } else {            
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String codigo = context.getExternalContext().getRequestParameterMap().get("codProd");
            Producto producto = getProductoBean().consultarProducto(Integer.parseInt(codigo));
            if (producto.getFoto() == null) {
                //no tiene foto
                return null;
            } else {
                return new DefaultStreamedContent(new ByteArrayInputStream(producto.getFoto()));
            }
        }
    }

    public List<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
}
