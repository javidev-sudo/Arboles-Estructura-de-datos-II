/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arboles;
import adt.NodoBinario;
import adt.ArbolBinarioBusqueda;
import adt.IArbolBusqueda;
import excepciones.ExcepcionDatoNoExiste;
import excepciones.ExcepcionDatoYaExiste;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 
 */
public class Arboles {

    public static void main(String[] args) throws ExcepcionDatoYaExiste, ExcepcionDatoNoExiste {
       
        List<Integer> inOrden = Arrays.asList(
        5, 10, 20, 25, 30, 35, 40, 50, 55, 60, 65, 70, 75, 77, 80, 90
        );

        List<Integer> preOrden = Arrays.asList(
        50, 30, 20, 10, 5, 25, 40, 35, 70, 60, 55, 65, 80, 75, 77, 90
        );

        List<Integer> postOrden = Arrays.asList(
        5, 10, 25, 20, 35, 40, 30, 55, 65, 60, 77, 75, 90, 80, 70, 50
        );
        
        List<Integer> in = new LinkedList<>(inOrden);
        List<Integer> post = new LinkedList<>(preOrden);
 

     
       
        ArbolBinarioBusqueda<Integer> A1 = new ArbolBinarioBusqueda<>(in,post,false);
        
  
        
        System.out.println(A1.toString());
        
    }
   
        
        
    
}
