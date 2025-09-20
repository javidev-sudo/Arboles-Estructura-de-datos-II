/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arboles;
import adt.NodoBinario;
import adt.ArbolBinarioBusqueda;
import adt.IArbolBusqueda;
import excepciones.ExcepcionDatoNoExiste;
import excepciones.ExcepcionDatoYaExiste;
import java.util.List;

/**
 *
 * @author 
 */
public class Arboles {

    public static void main(String[] args) throws ExcepcionDatoYaExiste, ExcepcionDatoNoExiste {
       
        ArbolBinarioBusqueda<Integer> A1 = new ArbolBinarioBusqueda<>();
        
       
        A1.insertar(50);
        A1.insertar(60);
        A1.insertar(25);
        A1.insertar(30);
        A1.insertar(10);
        A1.insertar(9);
        A1.insertar(5);
        A1.insertar(11);
        
        System.out.println("");
        
        
        
        //System.out.println(A1.recorridoInOrden());
        
        
        
    }
   
        
        
    
}
