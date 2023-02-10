package logic;

import java.util.Comparator;

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

    public void addNodeAfterTo(Node<T> node, T info ){

    }

    public Node<T> findNode( T node ){

        return null;
    }
}
