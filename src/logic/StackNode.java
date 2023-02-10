package logic;

import java.util.Comparator;

public class StackNode<T> {
    private Node<T> head;

    private Comparator<T> comparator;

    public StackNode(Comparator<T> comparator) {
        this.comparator = comparator;
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(T info ){
        if( isEmpty()){
            head = new Node( info);
        }else{
            Node<T> node = new Node<>( info );
            node.setNext( head );
            head = node;
        }
    }

    public T pop(){

        if( !isEmpty()){
            T info = head.getInfo();
            head = head.getNext();

            return info;
        }


        return null;
    }
}
