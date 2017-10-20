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
public class Pregunta {
    private int IDPre;
    private String texto;
    private String respuesta;
    private int aciertos;
    private int vecesUsado;

    public Pregunta(int IDPre, String texto, String respuesta, 
            int aciertos, int vecesUsado) {
        this.IDPre = IDPre;
        this.texto = texto;
        this.respuesta = respuesta;
        this.aciertos = aciertos;
        this.vecesUsado = vecesUsado;
    }

    public int getIDPre() {
        return IDPre;
    }

    public void setIDPre(int IDPre) {
        this.IDPre = IDPre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getVecesUsado() {
        return vecesUsado;
    }

    public void setVecesUsado(int vecesUsado) {
        this.vecesUsado = vecesUsado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.IDPre;
        hash = 17 * hash + Objects.hashCode(this.texto);
        hash = 17 * hash + Objects.hashCode(this.respuesta);
        hash = 17 * hash + this.aciertos;
        hash = 17 * hash + this.vecesUsado;
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
        final Pregunta other = (Pregunta) obj;
        if (this.IDPre != other.IDPre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "IDPre=" + IDPre + ", texto=" + texto + ", respuesta=" + respuesta + ", aciertos=" + aciertos + ", vecesUsado=" + vecesUsado + '}';
    }
    
}
