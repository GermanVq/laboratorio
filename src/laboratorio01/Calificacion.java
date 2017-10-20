/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio01;

import java.util.Objects;

/**
 *
 * @author gvega2
 */
public class Calificacion {
    private int IDCal;
    private double nota;
    public Estudiante estudiantes;
    public Pregunta preguntas;

    public Calificacion(int IDCal, double nota) {
        this.IDCal = IDCal;
        this.nota = nota;
    }

    public int getIDCal() {
        return IDCal;
    }

    public void setIDCal(int IDCal) {
        this.IDCal = IDCal;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Pregunta getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.IDCal;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.nota) ^ (Double.doubleToLongBits(this.nota) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.estudiantes);
        hash = 97 * hash + Objects.hashCode(this.preguntas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Calificacion other = (Calificacion) obj;
        if (this.IDCal != other.IDCal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "IDCal=" + IDCal + ", nota=" + nota + '}';
    }

 
}
