package logic;
public class NodeDouble<E> {
    public NodeDouble<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodeDouble<E> anterior) {
        this.anterior = anterior;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public NodeDouble<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodeDouble<E> siguiente) {
        this.siguiente = siguiente;
    }

    NodeDouble<E> anterior;  //Nodo parte anterior
    E info;     //Donde se mete el dato
    NodeDouble<E> siguiente; //Nodo parte siguiente

    public NodeDouble(E dato){
        info = dato;
        anterior = null;
        siguiente = null;
    }

    public String toString() {
        return info+"\n";
    }
}
