
package edu.cuc.listasgenericas;

/**
 *
 * @author alexisdelahoz
 */
public class DoublyNode<T> extends SinglyNode<T>{
    protected DoublyNode previous;

    public DoublyNode() {
    }

    public DoublyNode(T info) {
        super(info);
    }

    public DoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    @Override
    public T getInfo() {
        return info;
    }

    @Override
    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public DoublyNode<T> getNext() {
        return (DoublyNode<T>) next;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

}
