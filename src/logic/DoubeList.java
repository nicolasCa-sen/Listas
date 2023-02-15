package logic;

public class DoubeList<E> {
    private NodeDouble<E> cabeza; //Es el primer elemento de la lista
    private NodeDouble<E> fin;    //Es el ultimo elemento de la lista

    /*constructor que crea una LDE vacia
   Si la lista está vacía los nodos cabeza ni fin y por lo tanto seran null*/
    public DoubeList() {
        cabeza = null;
        fin = null;
    }

    //indica si la LDE esta vacia si cabeza es null, entonces carece de elementos
    private boolean estaVacia(){
        boolean vacia = false;
        if (cabeza == null) {
            vacia = true;
        }
        return vacia;
    }

    //Se crea el enlace entre nodos NodoA,NodoB
    private void enlazar(NodeDouble nodoA,NodeDouble nodoB){
        nodoA.siguiente = nodoB;
        nodoB.anterior = nodoA;
    }

    //Inserta un nodo delante del actual nodo cabeza, cabeza se actualiza con el nuevo nodo
    public void insertarInicio(E dato){
        if (duplicado(dato) == false) { //Solo entra si no esta duplicado
            NodeDouble nuevo = new NodeDouble(dato); //Se crea un nuevo nodo recibiendo como informacion el dato E
            if (estaVacia()) {
                cabeza = nuevo;
                fin = nuevo;
            }else{
                enlazar(nuevo,cabeza);
                cabeza = nuevo;
            }
        }
    }
    //Inserta un nodo al final de la lista, inserta detrás del nodo fin actualizándolo con el nuevo nodo
    public void insertarFinal(E dato) {
        if (duplicado(dato) == false) {//Solo entra si no esta duplicado
            NodeDouble nuevo = new NodeDouble(dato);   //Se crea un nuevo nodo recibiendo como informacion el dato E
            if (estaVacia() ) {
                cabeza = nuevo;
                fin = nuevo;
            } else {
                enlazar(fin, nuevo);
                fin = nuevo;
            }
        }
    }

    //Elimina el nodo del frente cabeza y actualiza cabeza con el nodo que le sigue en la lista.
    public void eliminarInicio() {
        if ( !estaVacia() ) {
            NodeDouble primero = cabeza.siguiente;
            if ( primero == null ) {
                cabeza = null;
                fin = null;
            } else {
                primero.anterior = null;
                cabeza = primero;
            }
        }
    }

    //Elimina el nodo final fin y lo actualiza con el nodo que lo antecedia
    public void eliminarFinal() {
        if ( !estaVacia() ) {
            NodeDouble ultimo = fin.anterior;
            if ( ultimo == null ) {
                cabeza = null;
                fin = null;
            } else {
                ultimo.siguiente = null;
                fin = ultimo;
            }
        }
    }

    //Muestra el nodo cabeza o inicio
    public void mostrarInicio(){
        NodeDouble iterador = cabeza;
        System.out.println(iterador.info);
    }

    //Muestra el nodo fin o final
    public void mostrarFin(){
        NodeDouble iterador = fin;
        System.out.println(iterador.info);
    }

    //muestra los valores de la lista de inicio a fin
    public void mostrarInicioFin() {
        NodeDouble iterador = cabeza; //Iterador comienza de cabeza hasta fin
        while (iterador != null) {
            System.out.print(iterador.info+" ");
            iterador = iterador.siguiente;
        }
    }

    //muestra los valores de la lista de fin a inicio
    public void mostrarFinInicio() {
        NodeDouble iterador = fin; //Iterador comienza de fin hasta cabeza
        while (iterador != null) {
            System.out.print(iterador.info+" ");
            iterador = iterador.anterior;
        }
    }

    //Se usa para buscar un duplicado y se implementa en todos los metodos de insercion para validar
    public boolean duplicado(E dato){
        boolean duplicado = false;
        NodeDouble buscado = null;
        NodeDouble iterador = cabeza;
        while (buscado == null && iterador != null ) {
            if (iterador.info == dato ) { //Si la informacion del dato es igual a la informacion que tiene el nodo, regresa true
                duplicado = true; //Si el elemento existe en nuestra lista retorna true
            }
            iterador = iterador.siguiente;
        }
        return duplicado;
    }

    //Recorrer o E a inicio o de E a fin, segun sea el booleano
    public void recorreDesde(E dato,boolean decision){
        //Recorrer de E a inicio
        if (decision == true) {
            NodeDouble iterador = cabeza;
            while (iterador != null ) {

                if (iterador.info == dato ) {

                    while(iterador.siguiente!=cabeza.anterior){
                        System.out.print(iterador.info+" ");
                        iterador = iterador.siguiente;
                    }System.out.println(iterador.info);
                }
                iterador = iterador.siguiente;
            }

        }
        //Recorrer de E a fin
        if (decision == false) {
            NodeDouble iterador = fin;
            while (iterador != null ) {

                if (iterador.info == dato ) {

                    while(iterador.anterior!=fin.siguiente){
                        System.out.print(iterador.info+" ");
                        iterador = iterador.anterior;
                    }System.out.println(iterador.info);
                }
                iterador = iterador.anterior;
            }
        }

    }

    public boolean InsertarDespuesDeElemento(E referencia, E datonuevo){
        NodeDouble siguiente = null;
        boolean resultado = false;
        if (duplicado(referencia) == true) {
            NodeDouble buscar= buscar(referencia); // Es el nodo que sirve de referencia, se usa el metodo buscar
            NodeDouble nuevo = new NodeDouble(datonuevo); //Es el nodo que trae la nueva informacion
            siguiente = buscar.siguiente; //Realizamos los enlaces
            siguiente.anterior = nuevo;
            nuevo.siguiente=siguiente;
            buscar.siguiente=nuevo;
            nuevo.anterior=buscar;
            resultado = true;//Devuelve true por lo tanto se puede almacenar
        }if(duplicado(referencia) == false) {
            System.out.println(referencia+" no existe en la lista");
        }return resultado;
    }

    public boolean InsertarAntesDeElemento(E referencia, E datonuevo){
        NodeDouble anterior = null;
        boolean resultado = false;
        if (duplicado(referencia) == true) {
            NodeDouble buscar= buscar(referencia); // Es el nodo que sirve de referencia, se usa el metodo buscar
            NodeDouble nuevo = new NodeDouble(datonuevo); //Es el nodo que trae la nueva informacion
            anterior = buscar.anterior; //Realizamos los enlaces
            anterior.siguiente =nuevo;
            nuevo.anterior=anterior;
            nuevo.siguiente=buscar;
            buscar.anterior=nuevo;
            resultado = true;//Devuelve true por lo tanto se puede almacenar
        }if(duplicado(referencia) == false) {
            System.out.println(referencia+" no existe en la lista");
        }return resultado;
    }


    public boolean removerEspecifico(E referencia){
        NodeDouble anterior = null;
        NodeDouble siguiente = null;
        boolean resultado = false;
        if (duplicado(referencia) == true) {
            NodeDouble buscar= buscar(referencia); //Es el nodo que se va a eliminar, usa buscar() hasta encontrarlo
            anterior = buscar.anterior;//G
            siguiente = buscar.siguiente;//E
            anterior.siguiente = buscar.siguiente;
            siguiente.anterior = buscar.anterior;
            resultado = true;//Devuelve true por lo tanto se puede almacenar
        }if(duplicado(referencia) == false) { //En dado caso que no exista no hace nada
            System.out.println("La lista ya esta sin " + referencia);
        }return resultado;
    }

    //Sirve para buscar un nodo en especifico y nos devuelve el nodo una vez que lo encuentra
    public NodeDouble buscar(E dato) {
        NodeDouble buscado = null;
        NodeDouble iterador = cabeza;
        while ( buscado == null && iterador != null ) {
            if ( iterador.info == dato ) {
                buscado = iterador;
            }
            iterador = iterador.siguiente;
        }
        return buscado;
    }



}
