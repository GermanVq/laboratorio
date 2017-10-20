package edu.cuc.listasgenericas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author adelahoz6
 * @param <T> Tipo del Dato de la Lista
 */
public class SinglyLinkedList<T> implements Serializable, Iterable<T> {
    protected SinglyNode<T> headNode;
    protected SinglyNode<T> endNode;

    /**
     * Indica si la lista está vacía o no
     * @return true, si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return headNode == null;
    }

    /**
     * Adiciona un nuevo dato al inicio de la lista
     * @param dato el dato a adicionar
     */
    public void addFirst(T dato) {
        //Caso 1. Lista Vacia
        SinglyNode<T> nodoNuevo = new SinglyNode<>(dato);
        if (isEmpty()) {
            headNode = nodoNuevo;
            endNode = nodoNuevo;
        } else {
            //Caso 2. Existe un nodo
            nodoNuevo.setNext(headNode);
            headNode = nodoNuevo;
        }
    }

    /**
     * Adiciona un nuevo dato al final de la lista
     * @param dato el dato a adicionar
     */
    public void addLast(T dato) {        
        //Caso 1. Lista Vacia
        SinglyNode<T> nodoNuevo = new SinglyNode<>(dato);
        if (isEmpty()) {
            headNode = nodoNuevo;
            endNode = nodoNuevo;
        } else {
            //Caso 2. Existe un nodo
            nodoNuevo.setNext(null);
            endNode.setNext(nodoNuevo);
            endNode = nodoNuevo;
        }
    }

    /**
     * Indica si un elemento pertenece a la lista
     * @param dato el elemento a buscar
     * @return true, si se encuentra, false en otro caso
     */
    public boolean contains(T dato) {
        if (isEmpty()) {
            return false;
        } else {
            SinglyNode<T> p = headNode;
            while (p != null) {
                if (p.getInfo().equals(dato)) {
                    return true;
                }
                p = p.getNext();
            }
            return false;
        }
    }

    /**
     * Retorna el primer elemento de la lista
     * @return el elemento inicial de la lista
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            SinglyNode<T> p = headNode;
            headNode = headNode.getNext();
            return p.getInfo();
        }
    }

    /**
     * Retona el último elemento de la lista
     * @return el elemento final de la lista
     */
    public T getLast() {
        if (headNode == null) {
            return null;
        } else {
            if (headNode == endNode) {
                SinglyNode<T> p = headNode;
                headNode = endNode = null;
                return p.getInfo();
            } else {
                SinglyNode<T> ant = null;
                SinglyNode<T> p = headNode;
                while (p != endNode) {
                    ant = p;
                    p = p.getNext();
                }
                endNode = ant;
                ant.setNext(null);
                return p.getInfo();
            }

        }
    }

    /**
     * Eliminar un elemento de la lista
     * @param dato el elemento a eliminar
     * @return true, si se eliminó exitosamente, false en caso contrario
     */
    public boolean remove(T dato) {
        if (isEmpty()) {
            return false;
        } else {
            // Caso Nodo Unico
            if (headNode == endNode && headNode.getInfo().equals(dato)) {
                headNode = null;
                endNode = null;
                return true;
            } else {
                //Buscar la info
                SinglyNode<T> antP = null;
                SinglyNode<T> p = headNode;
                while (p != null && !p.getInfo().equals(dato)) {
                    antP = p;
                    p = p.getNext();
                }
                if (p == null) {
                    //Caso no encontrado
                    return false;
                } else {
                    //Caso PTR
                    if (p == headNode) {
                        headNode = headNode.getNext();
                        return true;
                    } else {
                        //Caso Final
                        if (p == endNode) {
                            antP.setNext(null);
                            endNode = antP;
                            return true;
                        } else {
                            //Nodo Intermedio
                            antP.setNext(p.getNext());
                            return true;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        SinglyNode<T> p = headNode;
        String cad = "Lista: ";
        while (p != null) {
            cad += p.toString() + " ";
            p = p.getNext();
        }
        return cad;
    }
   

    /**
     * Metodo para serializacion de la lista
     * @param nombreArchivo el nombre del archivo donde se guardara la lista
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void guardarEnArchivo(String nombreArchivo) throws FileNotFoundException, IOException {
        //Abrir flujo de archivo
        FileOutputStream fos = new FileOutputStream(nombreArchivo);
        //Abrir flujo de objetos
        ObjectOutputStream os = new ObjectOutputStream(fos);
        //Realizar escritura en el flujo
        os.writeObject(this);
        //Cierrar flujo
        os.close();
    }


    /**
     * Metodo para deserializacion de la lista
     * @param nomArchivo el archivo donde se encuentra lista serializada
     * @return la lista leida del archivo
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public SinglyLinkedList<T> leerDeArchivo(String nomArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        //Abrir flujo de archivo
        FileInputStream fis = new FileInputStream(nomArchivo);
        //Abrir flujo de objetos
        ObjectInputStream os = new ObjectInputStream(fis);
        //Realizar lectura del flujo
        SinglyLinkedList<T> listaLeida = (SinglyLinkedList<T>) os.readObject();
        //Cerrar flujo
        os.close();
        //Retorno
        return listaLeida;
    }

    @Override
    public Iterator<T> iterator() {
        
        Iterator<T> it = new Iterator<T>() {
            SinglyNode<T> p = headNode;
            
            @Override
            public boolean hasNext() {
                if (isEmpty()) {
                    return false;
                }
                return p != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T dato = p.getInfo();
                    p = p.getNext();
                    return dato;
                } else {
                    return null;
                }
            }
        };
                return it;
    }
    
    /**
     * Indicar cuantos elementos tiene la lista
     */
    public int size() {
        int contador = 0;
        SinglyNode<T> p = headNode;
        while (p != null) {
            //1. El proceso
            contador++;
            //2. Moverse al siguiente
            p = p.getNext();
        }
        return contador;
    }

    /**
     * Adicionar una lista completa a otra
     * @param lista La lista que se adiciona
     * @return La lista con las modificaciones
     */
    public SinglyLinkedList<T> addAll(SinglyLinkedList<T> lista) {
        Iterator<T> it = lista.iterator();
        while (it.hasNext()) {
            T actual = it.next();
         this.addLast(actual);
        }
        return this;
    }
    
    public T get(int indice) {
        if (indice < 0 || indice >= this.size()) {
            throw new IndexOutOfBoundsException("Indice : "+indice);
        } else {
            if (indice == 0) {
                return this.getFirst();
            }
            if (indice == this.size() - 1) {
                return this.getLast();
            }
            SinglyNode<T> p = headNode;
            int indiceActual = 0;
            while (p != null && indiceActual < indice) {
                p = p.getNext();
                indiceActual++;
            }
            return p.getInfo();
        }
    }
    
    // Adicionar en una posicion dada de la lista
     public SinglyLinkedList<T> addPosition(T item, int indice) {
        if (indice < 0 || indice >= this.size()) {
            throw new IndexOutOfBoundsException("Indice : "+indice);
        } else {
            if (indice == 0) {
                this.addFirst(item);
                return this;
            }
            if (indice == this.size() - 1) {
                this.addLast(item);
                return this;
            }
            SinglyNode<T> p = headNode;
            int indiceActual = 0;
//            while (p != null && indiceActual < indice) {
//                p = p.getNext();
//                indiceActual++;
//            }
            for (int i = 0; i < indice; i++) {
                p = p.getNext();
            }
            SinglyNode<T> nuevo = new SinglyNode<>(p.getInfo());
            p.setInfo(item);
            nuevo.setNext(p.getNext());
            p.setNext(nuevo);
            return this;
        }
    }
    
}
