/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author Nicolas Jr
 */
public class ExcepcionDatoYaExiste extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionDatoYaExiste</code> without
     * detail message.
     */
    public ExcepcionDatoYaExiste() {
            this("Dato ya existe en su arbol");
    }

    /**
     * Constructs an instance of <code>ExcepcionDatoYaExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionDatoYaExiste(String msg) {
        super(msg);
    }
}
