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
public class Curso {
    private int IDCur;
    private String nombreDelCurso;
    private int numeroDeEstudiantes;
    protected DoublyLinkedList<Estudiante> listaEstudiantes;

    public Curso(int ID, String nombreDelCurso, int numeroDeEstudiantes, 
            DoublyLinkedList<Estudiante> listaEstudiantes) {
        this.IDCur = ID;
        this.nombreDelCurso = nombreDelCurso;
        this.numeroDeEstudiantes = numeroDeEstudiantes;
        this.listaEstudiantes = listaEstudiantes;
    }

    public int getID() {
        return IDCur;
    }

    public void setID(int ID) {
        this.IDCur = ID;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public void setNombreDelCurso(String nombreDelCurso) {
        this.nombreDelCurso = nombreDelCurso;
    }

    public int getNumeroDeEstudiantes() {
        return numeroDeEstudiantes;
    }

    public void setNumeroDeEstudiantes(int numeroDeEstudiantes) {
        this.numeroDeEstudiantes = numeroDeEstudiantes;
    }

    public DoublyLinkedList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(DoublyLinkedList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.IDCur;
        hash = 59 * hash + Objects.hashCode(this.nombreDelCurso);
        hash = 59 * hash + this.numeroDeEstudiantes;
        hash = 59 * hash + Objects.hashCode(this.listaEstudiantes);
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
        final Curso other = (Curso) obj;
        if (this.IDCur != other.IDCur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "ID=" + IDCur + ", nombreDelCurso="
       + nombreDelCurso + ", numeroDeEstudiantes=" + numeroDeEstudiantes
                + ", listaEstudiantes=" + listaEstudiantes + '}';
    }
    public void eliminarEstudiante(){
        listaEstudiantes.remove(new Estudiante(IDCur, nombreDelCurso, nombreDelCurso));
    }
    public void agregarEstudiante(){
        listaEstudiantes.addLast(new Estudiante(IDCur, nombreDelCurso, nombreDelCurso));
    }
    public void buscarEstudiante(){
        listaEstudiantes.contains(new Estudiante(IDCur, nombreDelCurso, nombreDelCurso));
    }
   
    
}
