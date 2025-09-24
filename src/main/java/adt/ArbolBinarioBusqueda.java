/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;


import excepciones.ExcepcionDatoNoExiste;
import excepciones.ExcepcionDatoYaExiste;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 *
 * @author javi24
 * @param <T>
 */
public class ArbolBinarioBusqueda<T extends Comparable<T>> implements IArbolBusqueda<T>{ // esto significa que cada objeto de esta estructura tiene que tener si o si un metodo llamado compareTo

   public NodoBinario<T> raiz;
   
   
   
  
   public ArbolBinarioBusqueda(){
       
   }
   
     public ArbolBinarioBusqueda(List<T> recorridoInOrden, List<T> recorridoNoInOrden, boolean recPostOrden) throws ExcepcionDatoYaExiste{
       
       if(recPostOrden){
           this.raiz = recostruccionDeArbolConPostOrden(recorridoInOrden,recorridoNoInOrden);
       }else{
           this.raiz = recostruccionDeArbolConPreOrden(recorridoInOrden,recorridoNoInOrden);
       }
           
   }
   
   @Override
   public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }
   
   @Override
   public T buscar(T datoABuscar) {
        if (!this.esArbolVacio()) {
            NodoBinario<T> nodoAux = this.raiz;
            do {
                T datoNodoAux = nodoAux.getDato();
                
                if (datoABuscar.compareTo(datoNodoAux) < 0) { // esto significa que el dato si es menor
                    
                    nodoAux = nodoAux.getHijoIzq();
                    
                } else if (datoABuscar.compareTo(datoNodoAux) > 0) { // el dato que busco es mayor
                    
                    nodoAux = nodoAux.getHijoDer();
                    
                } else { // el dato que bbsco es igual
                    
                    return datoABuscar;
                    
                }
            } while (!NodoBinario.esNodoVacio(nodoAux)); // 
        }
        return null;
    }
   
    /**
     *
     * @param datoAInsertar
     * @throws ExcepcionDatoYaExiste
     */
    @Override
   public void insertar(T datoAInsertar) throws ExcepcionDatoYaExiste {
       // aqui pregunto si la raiz es vacio o null
        if (this.esArbolVacio()) { 
            this.raiz = new NodoBinario(datoAInsertar); // creo un objeto NodoBin y inserto el dato
            return;
        }
        NodoBinario<T> nodoAnterior = NodoBinario.nodoVacio(); // nodoVacio(); me retorna null
        NodoBinario<T> nodoAux = this.raiz;
        do {
            T datoNodoAux = nodoAux.getDato(); // creo una variable del objeto que esta en el nodo
            
            nodoAnterior = nodoAux;
            
            if (datoAInsertar.compareTo(datoNodoAux) < 0) { // el objeto T tiene su compareTo // si mmi dato a insertar es menor
                
                nodoAux = nodoAux.getHijoIzq();
                
            } else if (datoAInsertar.compareTo(datoNodoAux) > 0) { // si mmi dato a insertar es mayor
                
                nodoAux = nodoAux.getHijoDer();
                
            } else {
                
                throw new ExcepcionDatoYaExiste();
                
            }
            
        } while (!NodoBinario.esNodoVacio(nodoAux));
        
        NodoBinario<T> nuevoNodo = new NodoBinario<>(datoAInsertar); // aqui creo un nuevo nodo con el objeto que renia que insertar
        
        if (datoAInsertar.compareTo(nodoAnterior.getDato()) < 0) {
            
            nodoAnterior.setHijoIzq(nuevoNodo);
            
        } else {
            
            nodoAnterior.setHijoDer(nuevoNodo);
            
        }
    } //fin metodo
   
   
   @Override
   public List<T> recorridoPorNiveles(){ 
       List<T> listaDelRecorrido = new ArrayList<>();
       
       if(!this.esArbolVacio()){
           Queue<NodoBinario<T>> colaDeNodos = new LinkedList<>(); // cola de la cual se instancia a travez de arraylist o linkedList
           colaDeNodos.offer(this.raiz);
           
           while(!colaDeNodos.isEmpty()){
               
               NodoBinario<T> nodoEnTurno = colaDeNodos.poll(); // saca el dato de la cola
               
               listaDelRecorrido.add(nodoEnTurno.getDato());
               
               if(!nodoEnTurno.esVacioHijoIzq()){
                   
                   colaDeNodos.offer(nodoEnTurno.getHijoIzq());
               }
               if(!nodoEnTurno.esVacioHijoDer()){
                   
                   colaDeNodos.offer(nodoEnTurno.getHijoDer());
               }
           }// fin del while
           
       }//fin if 
       
       return listaDelRecorrido;
   }
   
   // recorridos iterativos
   public List<T> recorridoEnPreOrdenItera(){
       List<T> listaDelRecorrido = new ArrayList<>();
       if(!this.esArbolVacio()){
           Stack<NodoBinario<T>> pilaDeNodos = new Stack<>(); // pila, de la cual tiene su propio constructor
           pilaDeNodos.push(this.raiz);
           while(!pilaDeNodos.isEmpty()){
               NodoBinario<T> nodoEnTurno = pilaDeNodos.pop();
                listaDelRecorrido.add(nodoEnTurno.getDato());
               if(!nodoEnTurno.esVacioHijoDer()){
                   pilaDeNodos.push(nodoEnTurno.getHijoDer());
               }
               if(!nodoEnTurno.esVacioHijoIzq()){
                   pilaDeNodos.push(nodoEnTurno.getHijoIzq());
               }
           }
       }
       
       return listaDelRecorrido;
   }
   
   
   public List<T> recorridoPostOrdenItera(){
       List<T> listaDeRecorrido = new LinkedList<>();
       Stack<NodoBinario<T>> pilaDeNodos = new Stack<>();
       NodoBinario<T> nodoAux = this.raiz;
       this.meterEnPilaParaPostOrden(nodoAux, pilaDeNodos);
       
       while(!pilaDeNodos.isEmpty()){ // si la pila no esta vacia
           
           nodoAux = pilaDeNodos.pop();
           
           listaDeRecorrido.add(nodoAux.getDato());
           
           if(!pilaDeNodos.empty()){
               
               NodoBinario<T> nodoDelTope = pilaDeNodos.peek();
               
               if (!nodoDelTope.esVacioHijoDer()){ //esto sirve para hacer un posible barrido de la rama derecha
                   
                   if (nodoAux != nodoDelTope.getHijoDer()){ // aqui si podemos preguntar si es distinto, y si es distinto le damos del tope su lado derecho
                       
                       this.meterEnPilaParaPostOrden(nodoDelTope.getHijoDer(), pilaDeNodos);
                   }
               }
           }
       } // aqui termina el while(!pilaDeNodos.empty())
       
       
       
       return listaDeRecorrido;
   }
   
   private void meterEnPilaParaPostOrden(NodoBinario<T> nodoAux, Stack<NodoBinario<T>> pilaDeNodos){
       
       while(!NodoBinario.esNodoVacio(nodoAux)){
           pilaDeNodos.push(nodoAux);
           if (!nodoAux.esVacioHijoIzq()){
               nodoAux = nodoAux.getHijoIzq();
           }else {
               nodoAux = nodoAux.getHijoDer();
           }
           
       } 
   }
   
   //hecho por mi
   public List<T> recorridoInOrdenItera(){
       List<T> listaDeRecorrido = new LinkedList<>();
       NodoBinario<T> nodoAux = this.raiz;
       Stack<NodoBinario<T>> pilaDeNodos = new Stack<>();
       this.meterEnPilaParaInOrden(nodoAux,pilaDeNodos);
       while(!pilaDeNodos.isEmpty()){
           
           nodoAux = pilaDeNodos.pop();
           
           listaDeRecorrido.add(nodoAux.getDato());
           
           if(!nodoAux.esVacioHijoDer()){
               
               meterEnPilaParaInOrden(nodoAux.getHijoDer(),pilaDeNodos);
               
           }
       }
       
       return listaDeRecorrido;
   }
   
   
   private void meterEnPilaParaInOrden(NodoBinario<T> nodoAux, Stack<NodoBinario<T>> pilaDeNodos){
        
       while(!NodoBinario.esNodoVacio(nodoAux)){
           pilaDeNodos.push(nodoAux);
           nodoAux = nodoAux.getHijoIzq();  
       }
   }
    
   
   // hecho por mi
   @Override
   public int size(){
       return size(this.raiz);
   }
   
   protected int size(NodoBinario<T> nodoEnTurno){ // compañero
       if(NodoBinario.esNodoVacio(nodoEnTurno)){
           return 0;
       }
       
       int cantidadPorIzquierda = size(nodoEnTurno.getHijoIzq());
       int cantidadPorDerecha = size(nodoEnTurno.getHijoDer());
       
       return (cantidadPorDerecha + cantidadPorIzquierda) + 1;
       
       
   }
   
   //recorridos recursivos
   @Override
   public List<T> recorridoEnPreOrden(){
       List<T> listaDeRecorrido = new LinkedList<>();
       recorridoEnPreOrden(this.raiz, listaDeRecorrido);
       return listaDeRecorrido;
   }
   
   private void recorridoEnPreOrden(NodoBinario<T> nodoEnTurno, List<T> listaDeRecorrido){
       if(NodoBinario.esNodoVacio(nodoEnTurno)){
           return; // es caso base no tengo datos que agregar
       }
       
       listaDeRecorrido.add(nodoEnTurno.getDato());
       recorridoEnPreOrden(nodoEnTurno.getHijoIzq(),listaDeRecorrido);
       recorridoEnPreOrden(nodoEnTurno.getHijoDer(),listaDeRecorrido);
       
   }
   
   @Override
   public List<T> recorridoEnPostOrden(){
       List<T> listaDeRecorrido = new LinkedList<>();
       recorridoPostOrden(raiz,listaDeRecorrido);
       return listaDeRecorrido;
       
   }
   
   private void recorridoPostOrden(NodoBinario<T> nodoEnTurno, List<T> listaDeRecorrido){
       
       if (NodoBinario.esNodoVacio(nodoEnTurno)) {
           return; //es caso base no tengo datos que agregar
       }
       
       recorridoPostOrden(nodoEnTurno.getHijoIzq(),listaDeRecorrido);      
       recorridoPostOrden(nodoEnTurno.getHijoDer(),listaDeRecorrido);
       listaDeRecorrido.add(nodoEnTurno.getDato());
   }
   
   
   @Override
   public List<T> recorridoEnInOrden(){
       List<T> listaDeRecorrido = new LinkedList<>();
       recorridoInOrden(raiz,listaDeRecorrido);
       return listaDeRecorrido;
   }
   
   private void recorridoInOrden(NodoBinario<T> nodoEnTunro, List<T> listaDeRecorrido){
       
       if(NodoBinario.esNodoVacio(nodoEnTunro)){
           return;
           
       }    
       recorridoInOrden(nodoEnTunro.getHijoIzq(),listaDeRecorrido);
       listaDeRecorrido.add(nodoEnTunro.getDato());
       recorridoInOrden(nodoEnTunro.getHijoDer(),listaDeRecorrido);
   }
   
   
    public int alturaItera() {

        int contador = 0;
        if (!this.esArbolVacio()) {
            Queue<NodoBinario<T>> colaDeNodos = new LinkedList<>(); // cola de la cual se instancia a travez de arraylist o linkedList
            colaDeNodos.offer(this.raiz);
            while (!colaDeNodos.isEmpty()) {
                for (int i = 0; i < colaDeNodos.size(); i++) {
                    NodoBinario<T> nodoEnTurno = colaDeNodos.poll();

                    if (!nodoEnTurno.esVacioHijoIzq()) {
                        colaDeNodos.offer(nodoEnTurno.getHijoIzq());
                    }
                    if (!nodoEnTurno.esVacioHijoDer()) {
                        colaDeNodos.offer(nodoEnTurno.getHijoDer());
                    }
                }
                contador++;
            }// fin del while
        }//fin if 
        return contador;
    }
    
    public int sizeIterativo(){
       int contadorDeNodos = 0;
       if(!this.esArbolVacio()){
           Queue<NodoBinario<T>> colaDeNodos = new LinkedList<>();
           colaDeNodos.offer(raiz);
           while(!colaDeNodos.isEmpty())
           {
               NodoBinario<T> nodoEnTurno = colaDeNodos.poll();
               contadorDeNodos++;
               if(!nodoEnTurno.esVacioHijoIzq()){
                   colaDeNodos.offer(nodoEnTurno.getHijoIzq());
               }
               if(!nodoEnTurno.esVacioHijoDer()){
                   colaDeNodos.offer(nodoEnTurno.getHijoDer());
               }
           }
       }
       
       return contadorDeNodos;
   }
   public int nivelItera() {
        if(NodoBinario.esNodoVacio(raiz)){
            return -1;
        }
        
        int contador = -1;
        Queue<NodoBinario<T>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(raiz);
        
        while(!colaDeNodos.isEmpty()) {
            int longitud = colaDeNodos.size();
            
            for(int i = 0; i < longitud;i++){
                NodoBinario<T> nodoEnTurno = colaDeNodos.poll();
                
                if (!nodoEnTurno.esVacioHijoIzq()) {
                    colaDeNodos.offer(nodoEnTurno.getHijoIzq());
                }
                if (!nodoEnTurno.esVacioHijoDer()) {
                    colaDeNodos.offer(nodoEnTurno.getHijoDer());
                }
            }
            contador++;
        }
        
        
        return contador;
    }

    @Override
    public void eliminar(T datoAEliminar) throws ExcepcionDatoNoExiste {
        if(datoAEliminar == null){
            throw new ExcepcionDatoNoExiste("Dato a eliminar no puede ser nulo");
        }
        this.raiz = eliminar(raiz,datoAEliminar);
    }
    
    private NodoBinario<T> eliminar(NodoBinario<T> nodoEnTurno, T datoAEliminar)
        throws ExcepcionDatoNoExiste {
        
       if(NodoBinario.esNodoVacio(nodoEnTurno)){
           throw new ExcepcionDatoNoExiste();
       }
       
       T datoDelNodoEnTurno = nodoEnTurno.getDato(); // saco el dato del nodo, esto puede ser cualquier dato generico
       
       if(datoAEliminar.compareTo(datoDelNodoEnTurno) < 0){ //el dato a eliminar es menor osea que puede dar valores negativos
           NodoBinario<T> supuestoNuevoHijoIzq = this.eliminar(nodoEnTurno.getHijoIzq(), datoAEliminar);
           
           nodoEnTurno.setHijoIzq(supuestoNuevoHijoIzq);
           return nodoEnTurno;
       }
       
       if(datoAEliminar.compareTo(datoDelNodoEnTurno) > 0){ //el dato a eliminar es mayor y que va entrar si hay valores positivos 
           NodoBinario<T> supuestoNuevoHijoDer = this.eliminar(nodoEnTurno.getHijoDer(), datoAEliminar);
           
           nodoEnTurno.setHijoDer(supuestoNuevoHijoDer);
           return nodoEnTurno;
       }
       // SI LLEGAMOS HASTA ACA SABEMOS QUE EL NODO EN TURNO TIENE EL DATO QUE TENEMOS QUE ELIMINAR
       //CASO 1 que el nodo sea una hoja
       
       if(nodoEnTurno.esHoja()){
           
           return NodoBinario.nodoVacio(); // 
           
       }
       
       // CASO 2a que el nodo tenga un solo hijo en este caso que solo haya el izquierdo
       
       if(!nodoEnTurno.esVacioHijoIzq() && nodoEnTurno.esVacioHijoDer()){ 
           NodoBinario<T> nodoARetornar = nodoEnTurno.getHijoIzq();
           nodoEnTurno.setHijoIzq(NodoBinario.nodoVacio());
           return nodoARetornar;
       }
       
       // CASO 2b que el nodo tenga un solo hijo en este caso que solo haya el derecho
       
       if(nodoEnTurno.esVacioHijoIzq() && !nodoEnTurno.esVacioHijoDer()){
           NodoBinario<T> nodoARetornar = nodoEnTurno.getHijoDer();
           nodoEnTurno.setHijoDer(NodoBinario.nodoVacio());
           return nodoARetornar;
       }
       
       // CASO 3 que el nodo que se quiere eliminar tenga dos hijos, pero no lo eliminamos si no hacemos un reemplazo de valores  
       
       T reemplazo = this.buscarSucesorInOrden(nodoEnTurno.getHijoDer());
       NodoBinario<T> supuestoNuevoHijoDerecho = this.eliminar(nodoEnTurno.getHijoDer(), reemplazo);
       nodoEnTurno.setHijoDer(supuestoNuevoHijoDerecho);
       nodoEnTurno.setDato(reemplazo);
       return nodoEnTurno;
    }
    
    
    protected T buscarSucesorInOrden(NodoBinario<T> nodoAuxiliar){
        while(!nodoAuxiliar.esVacioHijoIzq()){
            nodoAuxiliar = nodoAuxiliar.getHijoIzq();
        }
        return nodoAuxiliar.getDato();
    }

    @Override
    public boolean contiene(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public int altura() {
       
       return altura(this.raiz);
    }
    
    /**
     *
     * @param nodoEnTurno
     * @return
     */
    protected int altura(NodoBinario<T> nodoEnTurno){ // funcin amigo
        
        if(NodoBinario.esNodoVacio(nodoEnTurno)){ // caso base
            return 0;
        }
  
        int alturaPorIzquierda = altura(nodoEnTurno.getHijoIzq());
        int alturaPorDerecha = altura(nodoEnTurno.getHijoDer());
        
        if(alturaPorIzquierda > alturaPorDerecha){
            return alturaPorIzquierda + 1;
        }
        
        return alturaPorDerecha + 1;
        
    }

    @Override
    public void vaciar() {
        this.raiz = NodoBinario.nodoVacio();
    }

    @Override
    public int nivel(){
        return nivel(this.raiz);
    }

    private int nivel(NodoBinario<T> nodoEnTurno) { 
        if (NodoBinario.esNodoVacio(nodoEnTurno)) {
            return -1;
        }
        if (nodoEnTurno.esHoja()) {
            
            return 0;
        }
        
        int nivelPorIzquierda = nivel(nodoEnTurno.getHijoIzq());
        int nivelPorDerecha = nivel(nodoEnTurno.getHijoDer());
        
        
        return (nivelPorIzquierda > nivelPorDerecha)? nivelPorIzquierda+1 : 
               (nivelPorDerecha > nivelPorIzquierda)? nivelPorDerecha+1 : nivelPorIzquierda;
        
       /* if (nivelPorIzquierda > nivelPorDerecha){
            
            return nivelPorIzquierda+1;
             
        }else if(nivelPorDerecha > nivelPorIzquierda) {
            
            return nivelPorDerecha+1;
        }
        
        
        return nivelPorDerecha;*/
    }
    
    //EJERCICIO PROPUESTO POR MI : SABER EN QUE ALTURA ESTA UN ELEMENTO O DATO 
    
    public int alturaDato(T datoABuscar) throws ExcepcionDatoNoExiste{
        if (!esArbolVacio()) {
            Queue<NodoBinario<T>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(raiz);
            int contadorAltura = 1;

            while (!colaDeNodos.isEmpty() && !NodoBinario.esNodoVacio(colaDeNodos.peek())) {
               
                    NodoBinario<T> nodoEnTurno = colaDeNodos.poll();

                    T datoCola = nodoEnTurno.getDato();

                    if (datoABuscar.compareTo(datoCola) > 0) { // significa que mi dato a buscar es mayor

                        colaDeNodos.offer(nodoEnTurno.getHijoDer());

                    } else if (datoABuscar.compareTo(datoCola) < 0) { //significa que mi dato a buscar es menor

                        colaDeNodos.offer(nodoEnTurno.getHijoIzq());

                    } else {
                        return contadorAltura;
                    }
                    
                contadorAltura++;
            }
            
            throw new ExcepcionDatoNoExiste("el dato que quiere saber la altura no existe en el arbol");
        }
        
        throw new ExcepcionDatoNoExiste("el dato que quiere saber la altura no existe en el arbol");
    }
    
    ///FALTA HACER O DAR UNA SOLUCION
    public int alturaDatoRec(T datoABuscar){
        return alturaDatoRec(this.raiz, datoABuscar);
    }
    
    private int alturaDatoRec(NodoBinario<T> nodoEnTurno, T datoABuscar) {
        return 1;
    }
    
    ///////////////////////////////////////////////////////////////////////////7
    public int cantidadDeHojas(){
       
        if(esArbolVacio()){
            return 0;
        }
       NodoBinario<T> nodoAux = this.raiz;
       int cantidadHojas = 0;
       Stack<NodoBinario<T>> pilaDeNodos = new Stack<>();
       this.meterEnPilaParaInOrden(nodoAux,pilaDeNodos);
       cantidadHojas++;
       
       while(!pilaDeNodos.isEmpty()){
           nodoAux = pilaDeNodos.pop();
           if(!NodoBinario.esNodoVacio(nodoAux.getHijoDer())) {
               this.meterEnPilaParaInOrden(nodoAux.getHijoDer(), pilaDeNodos);
               cantidadHojas++;
           }
       }
       return cantidadHojas;
    }
    
    public int cantidadDeHojasRecursivo(){
       
       return cantidadDeHojasRecursivo(raiz);
    }

    private int cantidadDeHojasRecursivo(NodoBinario<T> nodoEnTurno) {
       if (NodoBinario.esNodoVacio(nodoEnTurno)){
           return 0;
       }
       if(nodoEnTurno.esHoja()) {
           return 1;
       }
       
       int cantidadHojaIzquierda = cantidadDeHojasRecursivo(nodoEnTurno.getHijoIzq());
       int cantidadHojasDerecha = cantidadDeHojasRecursivo(nodoEnTurno.getHijoDer());
       
       return cantidadHojaIzquierda+cantidadHojasDerecha;
    }
}
