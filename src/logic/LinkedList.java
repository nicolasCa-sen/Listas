package logic;

import java.util.Comparator;
import java.util.List;

public class LinkedList <T>{
    private Node<T> head;
    private Comparator<T> comparator;

    public LinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(T info){

    }

    public void addLast(T info){

    }

    public void addNodeAfterTo(Node<T> node, T info ){

    }

    public void addNodeBeforeTo(Node<T> node, T info ){

    }

    public void addNodeSorted(T info){

    }

    public Node<T> findNode( T node ){

        return null;
    }

    public T findInfo( T node ){

        return null;
    }

    public List<T> getLinkedList(){

        return null;
    }

    public T deleteNode( Node<T> node){

        return null;
    }

    public int getSize(){

        return 0;
    }

    public T getObject( int pos){

        return null;
    }

    public T getFirst(){

        return null;
    }

    public T getLast(){

        return null;
    }
}
