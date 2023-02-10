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

    /**
     * Método que agrega un nodo despues de otro nodo (que existe)
     * Precondicion. La lista contiene nodos
     * @param node El Node a partir del cual se agrega el nuevo
     * @param info La informacion del objeto para crear el nuevo nodo
     */
    public void addNodeAfterTo(Node<T> node, T info ){
        Node<T> nodeNew = new Node<>(info);
        nodeNew.setNext( node.getNext());
        node.setNext( nodeNew);

    }

    public void addNodeBeforeTo(Node<T> node, T info ){
        if ( node == head ){
            addFirst( info );
        }else{
            Node<T> nodeNew = new Node<>( info );
            Node<T> aux = head;
            while( aux.getNext() != node ){
                aux = aux.getNext();
            }
            nodeNew.setNext( aux.getNext());
            aux.setNext( nodeNew );
        }
    }

    public void addNodeSorted(T info){
        if( isEmpty()){
            head = new Node<>(info);
        }else{
            Node<T> node = new Node<>(info);
            Node<T> act = head;
            Node<T> ant = null;
            while( act != null && comparator.compare( node.getInfo(), act.getInfo()) > 0 ){
                ant = act;
                act = act.getNext();
            }
            if( ant == null ){
                head = node;
            }else{
                ant.setNext( node );
            }
            node.setNext( act );
        }
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
