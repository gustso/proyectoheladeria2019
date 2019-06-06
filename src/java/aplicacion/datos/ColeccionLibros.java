/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos;

import aplicacion.modelo.dominio.Libro;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author GustsoNT
 */
public class ColeccionLibros implements Serializable {

    private static ArrayList<Libro> libros;

    /**
     * @return the libros
     */
    public static ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * @param aLibros the libros to set
     */
    public static void setLibros(ArrayList<Libro> aLibros) {
        libros = aLibros;
    }

    public ColeccionLibros() {
        libros = new ArrayList();
    }

    //public void agregarLibros(Libro unLibro) {
      //  getLibros().add(unLibro);
    //}

    public Libro buscarLibro(String buscaTit, 
            String buscaCat, boolean cat) {
        
        Libro libroEncontrado = new Libro();
        if (cat) {
            
            for (Libro l : getLibros()) {
                //System.out.println("busca"+l.getTitulo());
                if (l.getTitulo().equals(buscaTit)) {
                    if (l.getCategoria().equals(buscaCat)) {
                        libroEncontrado = l;
                        break;
                    }
                }
            }
        } else {
            for (Libro l : getLibros()) {
                if (l.getTitulo().equals(buscaTit)) {
                    libroEncontrado = l;
                    break;
                }
            }
        }
        return libroEncontrado;
    }
    /* este es binario
     int[] x = {-5, 12, 15, 20, 30, 72, 456};
     int loIndex = 0;
     int hiIndex = x.length - 1;
     int midIndex, srch = 72;

     while (loIndex <= hiIndex) {
     midIndex = (loIndex + hiIndex) / 2;
     if (srch > x[midIndex]) {
     loIndex = midIndex + 1;
     } else if (srch < x[midIndex]) {
     hiIndex = midIndex - 1;
     } else {
     break;
     }
     }
     if (loIndex > hiIndex) {
     System.out.println(srch + " not found");
     } else {
     System.out.println(srch + " found");
     }

     } else {
     */

}
