/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arboles;
import adt.AVL;
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
       
        
 

     
       
        ArbolBinarioBusqueda<Integer> A1 = new ArbolBinarioBusqueda<>();
        
        A1.insertar(3);
        A1.insertar(1);
        A1.insertar(7);
        A1.insertar(0);
        A1.insertar(2);
        A1.insertar(5);
        A1.insertar(8);
        A1.insertar(4);
        A1.insertar(6);
        A1.insertar(9);
        
        
        
        int altu = A1.alturaDatoRec(3);
  
        
        System.out.println(altu);
        
    }
   
        
        
    
}
