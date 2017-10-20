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
public class Estudiante {
    private int IDEs;
    private String nombre;
    private String Apellido;

    public Estudiante(int ID, String nombre, String Apellido) {
        this.IDEs = ID;
        this.nombre = nombre;
        this.Apellido = Apellido;
    }

    public int getID() {
        return IDEs;
    }

    public void setID(int ID) {
        this.IDEs = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IDEs;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.Apellido);
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
        final Estudiante other = (Estudiante) obj;
        if (this.IDEs != other.IDEs) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "ID=" + IDEs + ", nombre=" + nombre + ", Apellido=" + Apellido + '}';
    }
  
    
}
