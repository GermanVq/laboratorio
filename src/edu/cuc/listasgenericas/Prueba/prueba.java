/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cuc.listasgenericas.Prueba;

import edu.cuc.listasgenericas.DoublyLinkedList;
import laboratorio01.Estudiante;


/**
 *
 * @author gvega2
 */
public class prueba {
    public static void main(String[] args) {
        DoublyLinkedList<Estudiante> listaEstudiante= new DoublyLinkedList();
        listaEstudiante.addLast(new Estudiante(23, "german","vega"));
        listaEstudiante.addLast(new Estudiante(22, "grman","vea"));
        System.out.println("nuevo estudiante"+listaEstudiante.remove(new Estudiante(23, "german", "vega")));
        System.out.println("lista nueva: "+listaEstudiante);
        
       
    }
    
}
