/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio01;

import edu.cuc.listasgenericas.DoublyLinkedList;
import java.util.Objects;

/**
 *
 * @author gvega2
 */
public class Cuestionario {
    private int IDCues;
    private String Nombre;
    protected DoublyLinkedList<Pregunta>listaPreguntas ;
    protected DoublyLinkedList<Calificacion>listaCalificaciones;

    public Cuestionario(int IDCues, String Nombre, DoublyLinkedList<Pregunta> 
            listaPreguntas, DoublyLinkedList<Calificacion> listaCalificaciones) {
        this.IDCues = IDCues;
        this.Nombre = Nombre;
        this.listaPreguntas = listaPreguntas;
        this.listaCalificaciones = listaCalificaciones;
    }

    public int getIDCues() {
        return IDCues;
    }

    public void setIDCues(int IDCues) {
        this.IDCues = IDCues;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public DoublyLinkedList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(DoublyLinkedList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public DoublyLinkedList<Calificacion> getListaEstudiantes() {
        return listaCalificaciones;
    }

    public void setListaEstudiantes(DoublyLinkedList<Calificacion> listaEstudiantes) {
        this.listaCalificaciones = listaEstudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IDCues;
        hash = 97 * hash + Objects.hashCode(this.Nombre);
        hash = 97 * hash + Objects.hashCode(this.listaPreguntas);
        hash = 97 * hash + Objects.hashCode(this.listaCalificaciones);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuestionario other = (Cuestionario) obj;
        if (this.IDCues != other.IDCues) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuestionario{" + "IDCues=" + IDCues + ", Nombre=" + Nombre +
      ", listaPreguntas=" + listaPreguntas + 
     ", listaCalificacion=" + listaCalificaciones+ '}';
    }
    
    public void eliminarPreguntas(){
        listaPreguntas.remove(new Pregunta(IDCues, Nombre, Nombre, IDCues, IDCues));
    }
    public void agregarPreguntas(){
        listaPreguntas.addLast(new Pregunta(IDCues, Nombre, Nombre, IDCues, IDCues));
    }
    public void buscarPreguntas(){
        listaPreguntas.contains(new Pregunta(IDCues, Nombre, Nombre, IDCues, IDCues));
    }
    public void eliminarCalificacion(){
        listaCalificaciones.remove( new Calificacion(IDCues, IDCues));
    }
    public void  agregarCalificacion(){
        listaCalificaciones.addLast(new Calificacion(IDCues, IDCues));
    }
    public void buscarCalificacion(){
        listaCalificaciones.contains(new Calificacion(IDCues, IDCues)); 
    }
  
}
