package edu.cuc.listasgenericas;

import java.util.ListIterator;

/**
 *
 * @author alexisdelahoz
 */
public class DoublyLinkedList<T> extends SinglyLinkedList<T> {

    @Override
    public boolean remove(T dato) {
        if (isEmpty()) {
            return false;
        } else // Caso Nodo Unico
         if (headNode == endNode && headNode.getInfo().equals(dato)) {
                headNode = null;
                endNode = null;
                return true;
            } else {
                //Buscar la info
                DoublyNode<T> p = (DoublyNode<T>) headNode;
                while (p != null && !p.getInfo().equals(dato)) {
                    p = p.getNext();
                }
                if (p == null) {
                    //Caso no encontrado
                    return false;
                } else //Caso PTR
                 if (p == headNode) {
                        headNode = headNode.getNext();
                        DoublyNode<T> tempHead = (DoublyNode<T>) headNode;
                        tempHead.setPrevious(null);
                        return true;
                    } else //Caso Final
                     if (p == endNode) {
                            DoublyNode<T> tempEnd = (DoublyNode<T>) endNode;
                            endNode = tempEnd.getPrevious();
                            endNode.setNext(null);
                            return true;
                        } else {
                            //Nodo Intermedio
                            p.getPrevious().setNext(p.getNext());
                            p.getNext().setPrevious(p.getPrevious());
                            return true;
                        }
            }
    }

    @Override
    public void addLast(T dato) {
        //Caso 1. Lista Vacia
        DoublyNode<T> nodoNuevo = new DoublyNode<>(dato);
        if (isEmpty()) {
            headNode = nodoNuevo;
            endNode = nodoNuevo;
        } else {
            //Caso 2. Existe un nodo
            nodoNuevo.setNext(null);
            endNode.setNext(nodoNuevo);
            nodoNuevo.setPrevious((DoublyNode) endNode);
            endNode = nodoNuevo;
        }
    }

    @Override
    public void addFirst(T dato) {
        //Caso 1. Lista Vacia
        DoublyNode<T> nodoNuevo = new DoublyNode<>(dato);
        if (isEmpty()) {
            headNode = nodoNuevo;
            endNode = nodoNuevo;
        } else {
            //Caso 2. Existe un nodo
            nodoNuevo.setNext(headNode);
            DoublyNode<T> tempHead = (DoublyNode<T>) headNode;
            tempHead.setPrevious(nodoNuevo);
            headNode = nodoNuevo;
        }
    }

    /**
     * Eliminar la nesima posición de la lista
     */
    public T remove(int index) {
        if (!isEmpty()
                && index >= 0
                && index < size()) {
            //Primero
            if (index == 0) {
                T dato = getFirst();
                remove(dato);
                return dato;
            } else //Ultimo
            {
                if (index == size() - 1) {
                    DoublyNode<T> p = (DoublyNode<T>) headNode;
                    while (p != endNode) {
                        p = p.getNext();
                    }
                    T dato = p.getInfo();
                    endNode = p.getPrevious();
                    endNode.setNext(null);
                    return dato;
                } else {
                    //Intermedio
                    int posicionActual = 0;
                    DoublyNode<T> p = (DoublyNode<T>) headNode;
                    while (p != null) {
                        if (posicionActual == index) {
                            T dato = p.getInfo();
                            p.getPrevious().setNext(p.getNext());
                            return dato;
                        }
                        posicionActual++;
                        p = p.getNext();
                    }
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    /**
     * Adicionar un elemento en la nesima posición de la lista
     * @param index la posicion a ubicar el nuevo elemento
     * @param dato el elemento a adicionar
     */
    public void add(int index, T dato) {
        if (index >= 0 && index < size()) {
            //Primero
            if (index == 0) {
                addFirst(dato);
            } else //Ultimo
            {
                if (index == size() - 1) {
                    addLast(dato);
                } else {
                    //Intermedio
                    int posicionActual = 0;
                    DoublyNode<T> p = (DoublyNode<T>) headNode;
                    while (p != null) {
                        if (posicionActual == index) {
                            DoublyNode<T> nodoNuevo = new DoublyNode<>(dato);
                            p.getPrevious().setNext(nodoNuevo);
                            nodoNuevo.setPrevious(p.getPrevious());
                            nodoNuevo.setNext(p);
                            p.setPrevious(nodoNuevo);
                            return;
                        }
                        posicionActual++;
                        p = p.getNext();
                    }
                }
            }
        }
    }

    public ListIterator<T> listIterator() {
        return new ListItr();
    }

    private class ListItr implements ListIterator<T> {

        private DoublyNode<T> current;
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return !isEmpty() && currentIndex < size();
        }

        @Override
        public T next() {
            if (hasNext()) {
                currentIndex++;
                if (currentIndex == 0) {
                    current = (DoublyNode<T>) headNode;
                    return current.getInfo();
                } else if (currentIndex < size() - 1) {
                    current = current.getNext();
                    return current.getInfo();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        @Override
        public boolean hasPrevious() {
            return !isEmpty() && currentIndex > -1;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
                currentIndex--;
                if (currentIndex == size() - 1) {
                    current = (DoublyNode<T>) endNode;
                    return current.getInfo();
                } else if (currentIndex > -1) {
                    current = current.getPrevious();
                    return current.getInfo();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        @Override
        public int nextIndex() {
            if (currentIndex < size() - 1) {
                return currentIndex + 1;
            } else {
                return currentIndex;
            }
        }

        @Override
        public int previousIndex() {
            if (currentIndex > 0) {
                return currentIndex - 1;
            } else {
                return currentIndex;
            }
        }

        @Override
        public void remove() {
            if (!isEmpty()) {
                DoublyLinkedList.this.remove(currentIndex);
            }
        }

        @Override
        public void set(T e) {
            if (current != null) {
                current.setInfo(e);
            }
        }

        @Override
        public void add(T e) {
            DoublyLinkedList.this.add(currentIndex, e);
        }

    }

}
