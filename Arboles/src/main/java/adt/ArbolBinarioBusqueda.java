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
 * @author Nicolas Jr
 */
public class ArbolBinarioBusqueda <T extends Comparable<T>>
    implements IArbolBusqueda<T>{
    protected NodoBinario<T> raiz;
    @Override
    public void insertar(T datoAInsertar) throws ExcepcionDatoYaExiste {
        if (datoAInsertar==null){
            throw new IllegalArgumentException("No se puede insertar Nulos");
        }
        if (this.esArbolVacio()){
            this.raiz= new NodoBinario<>(datoAInsertar);
            return;
        }
        NodoBinario<T> nodoAnt= NodoBinario.nodoVacio();
        NodoBinario<T> nodoAux= this.raiz;
        do{
            T datoDelNodoAuxiliar = nodoAux.getDato();
            if (datoAInsertar.compareTo(datoDelNodoAuxiliar)<0){
                nodoAux=nodoAux.getHijoIzq();
            }else if (datoAInsertar.compareTo(datoDelNodoAuxiliar)>0){
                nodoAux=nodoAux.getHijoIzq();
            }else{
                throw new ExcepcionDatoYaExiste();
            }               
        }while (!NodoBinario.esNodoVacio(nodoAux));       
        NodoBinario<T> nuevoNodo =new NodoBinario<>(datoAInsertar);
        T datoDelNodoAnterior= nodoAnt.getDato();
        if (datoAInsertar.compareTo(datoDelNodoAnterior)<0) {
            nodoAnt.setHijoIzq(nuevoNodo);
        } else if (datoAInsertar.compareTo(datoDelNodoAnterior)>0) {
            nodoAnt.setHijoDer(nuevoNodo);
        }
    }
    
    @Override
    public void eliminar(T dato) throws ExcepcionDatoNoExiste {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T buscar(T datoABuscar) {
        if (datoABuscar==null){
            throw new IllegalArgumentException("Dato a buscar invalido. No puede enviar nulo");
        }
        if (!this.esArbolVacio()){
            NodoBinario<T> nodoAux=this.raiz;
            do{
                T datoDelNodoAuxiliar = nodoAux.getDato();
                if (datoABuscar.compareTo(datoDelNodoAuxiliar)<0){
                    nodoAux=nodoAux.getHijoIzq();
                }else if (datoABuscar.compareTo(datoDelNodoAuxiliar)>0){
                    nodoAux=nodoAux.getHijoIzq();
                }else{
                    return datoDelNodoAuxiliar;
                }               
            }while (!NodoBinario.esNodoVacio(nodoAux));
        }
        return null;
    }

    @Override
    public boolean contiene(T dato) {
        return this.buscar(dato)!=null;
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
    public void vaciar() {
        this.raiz=NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(raiz);
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
}
