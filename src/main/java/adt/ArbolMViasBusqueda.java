/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import excepciones.ExcepcionDatoNoExiste;
import excepciones.ExcepcionDatoYaExiste;
import java.util.List;

/**
 *
 * @author javi24
 */
public class ArbolMViasBusqueda <T extends Comparable<T>> implements IArbolBusqueda<T>{
    protected static final int ORDEN_MINIMO = 3;
    protected static final int POSICION_INVALIDA = -1;
    
    protected NodoMVias<T> raiz;
    protected int orden;
    public ArbolMViasBusqueda(){
        
    }
    
    @Override
    public void vaciar() {
       this.raiz = NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
       return this.raiz == NodoMVias.nodoVacio();
    }
    
    @Override
    public void insertar(T datoAInsertar) throws ExcepcionDatoYaExiste {
        if(datoAInsertar == null){
            throw new IllegalArgumentException("No se puede insertar datos nulos!!");
        }
        if(this.esArbolVacio()){
            this.raiz = new NodoMVias<>(this.orden,datoAInsertar);
            return;
        }
        
        NodoMVias<T> nodoEnTurno = this.raiz;
        do {
            int posionDeDato = this.buscarPosicionDeDatoEnNodo(nodoEnTurno, datoAInsertar);
            if(posionDeDato != POSICION_INVALIDA){
                throw new ExcepcionDatoYaExiste();
            }
            if(nodoEnTurno.esHoja()){ // sie es hoja
                if(nodoEnTurno.estanDatosLLenos()){
                    // no hay espacio
                     int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoEnTurno, datoAInsertar); // falta implementar
                     NodoMVias<T> nuevoNodo = new NodoMVias<>(this.orden,datoAInsertar);
                     nodoEnTurno.setHijo(posicionPorDondeBajar, nuevoNodo);
                }else {
                    //si hay espacio
                    this.insertarDatoOrdenadoEnNodo(nodoEnTurno, datoAInsertar);
                    
                }
                nodoEnTurno = NodoMVias.nodoVacio();
            } else { // si no es hoja
                int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoEnTurno, datoAInsertar);
                 if(nodoEnTurno.esHijoVacio(posicionPorDondeBajar)){
                     NodoMVias<T> nodoNuevo = new NodoMVias<>(this.orden,datoAInsertar);
                     nodoEnTurno.setHijo(posicionPorDondeBajar, nodoNuevo);
                     nodoEnTurno =  NodoMVias.nodoVacio();
                 }else {
                     nodoEnTurno = nodoEnTurno.getHijo(posicionPorDondeBajar);
                 }
            }
            
        } while (!NodoMVias.esNodoVacio(nodoEnTurno));
         
    }
    
    protected int buscarPosicionDeDatoEnNodo(NodoMVias<T> nodoEnTurno, T datoAInsertar) {
        for (int i = 0; i < nodoEnTurno.nroDeDatosNoVacios(); i++) {
            T dataEnTurnno = nodoEnTurno.getDato(i);
            if(datoAInsertar.compareTo(dataEnTurnno) == 0){
                return i;
            }
        }      
        return POSICION_INVALIDA;
    }

    @Override
    public void eliminar(T dato) throws ExcepcionDatoNoExiste {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T buscar(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contiene(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public int nivel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<T> recorridoEnInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<T> recorridoEnPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<T> recorridoEnPostOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<T> recorridoPorNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int buscarPosicionPorDondeBajar(NodoMVias<T> nodoEnTurno, T datoAInsertar) {
        for (int i = 0; i < nodoEnTurno.nroDeDatosNoVacios(); i++) {
           if(datoAInsertar.compareTo(nodoEnTurno.getDato(i)) < 0){
              return i;
           }else if(datoAInsertar.compareTo(nodoEnTurno.getDato(i)) == 0){
               return POSICION_INVALIDA;
           }
        }
        
        return orden;
    }

    private void insertarDatoOrdenadoEnNodo(NodoMVias<T> nodoEnTurno, T datoAInsertar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    
    
    
}
