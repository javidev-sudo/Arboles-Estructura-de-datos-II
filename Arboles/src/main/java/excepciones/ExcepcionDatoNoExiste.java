/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author Nicolas Jr
 */
public class ExcepcionDatoNoExiste extends Exception{

    /**
     * Creates a new instance of <code>ExcepcionDatoNoExiste</code> without
     * detail message.
     */
    public ExcepcionDatoNoExiste() {
        this("Dato no existe en su arbol");
    }

    /**
     * Constructs an instance of <code>ExcepcionDatoNoExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionDatoNoExiste(String msg) {
        super(msg);
    }
}
