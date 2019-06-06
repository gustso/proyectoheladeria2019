/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.dominio.Autor;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Raon
 */

@FacesConverter("autorConverter")
public class AutorConverter implements Converter{
    private LibroFormBean listado;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        
        Autor autor = new Autor();
        if(value != null && value.trim().length() > 0) {
            try {
        ArrayList<Autor> autores = new ArrayList();        
        listado = new LibroFormBean();
        //autores = listado.llenarAutores();
               for(Autor a : autores){
                  //  if(a.getDni().equals(value.trim())){
                  //se comenta porque en el cambio el dni quedo como int
                        autor = a;
                    //}
                }
                
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid "));
            }
        }else {
            return null;
        }
        return autor;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            
            return String.valueOf(((Autor) object).getDni());
            
        }
        else {
            return null;
        }
    }   

    public LibroFormBean getListado() {
        return listado;
    }

    public void setListado(LibroFormBean listado) {
        this.listado = listado;
    }
    
}


