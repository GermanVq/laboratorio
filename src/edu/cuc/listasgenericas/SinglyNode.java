package edu.cuc.listasgenericas;

import java.io.Serializable;


/**
 *
 * @author adelahoz6
 * @param <T> Tipo del Dato de la lista
 */

public class SinglyNode<T> implements Serializable {
    protected T info;
    protected SinglyNode<T> next;

    /**
     * Constructor por defecto
     */
    public SinglyNode() {
    }

    /**
     * Constructor con info definida 
     * @param info el valor a almacenar en el nodo
     */
    public SinglyNode(T info) {
        this.info = info;
    }

    /**
     * Getter del atributo info
     * @return el dato almacenado en el nodo
     */
    public T getInfo() {
        return info;
    }

    /**
     * Setter del atributo info
     * @param info el dato a asignar/modificar en el nodo
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Getter del atributo next 
     * @return el siguiente nodo conectado al actual
     */
    public SinglyNode<T> getNext() {
        return next;
    }

    /**
     * Setter del atributo next
     * @param next el nodo a asignar como siguiente del actual
     */
    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return info.toString();
    }

}
