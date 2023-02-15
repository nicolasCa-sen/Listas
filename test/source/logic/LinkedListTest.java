package source.logic;

import logic.Dish;
import logic.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Dish> list;
    private LinkedList<Dish> listSort;

    /***
     * Método que crea una lista con los nodos sin orden
     */
    void setupList(){
        list = new LinkedList<>((o1,o2)->o1.getCode().compareTo(o2.getCode()));
        list.addFirst( new Dish("10","Pollo",300,false,34600));
        list.addFirst( new Dish("45","Pescado",200,false,40000));
        list.addLast( new Dish("20","Carne",400,false,45000));
        list.addNodeBeforeTo(list.findNode(new Dish("45",null,0,false,0.0)) ,new Dish("30","Pasta",100,true,20000));
        list.addNodeAfterTo(list.findNode(new Dish("10",null,0,false,0.0)) ,new Dish("80","Taco al Pastor",200,true,18000));
        list.addLast( new Dish("40","Hamburguesa",500,false,32000));
    }

    /**
     * Método que crea una lista ordenada por valor del plato
     */
    void setupListSort(){
        listSort = new LinkedList<>( (o1,o2)->Double.compare(o1.getValue(),o2.getValue()));
        listSort.addNodeSorted( new Dish("10","Pollo",300,false,34_600));
        listSort.addNodeSorted( new Dish("45","Pescado",200,false,40_000));
        listSort.addNodeSorted( new Dish("20","Carne",400,false,45_000));
        listSort.addNodeSorted(new Dish("30","Pasta",100,true,20_000));
        listSort.addNodeSorted(new Dish("80","Taco al Pastor",200,true,18_000));
        listSort.addNodeSorted( new Dish("40","Hamburguesa",500,false,32_000));
    }

    @Test
    void findNode() {
        setupList();
        assertNull(list.findNode(new Dish("555",null,0,false,0.0)));
        assertNotNull(list.findNode(new Dish("30",null,0,false,0.0)));
        assertEquals("30",list.findNode(new Dish("30",null,0,false,0.0)).getInfo().getCode());
        assertEquals("Pescado",list.findNode(new Dish("45",null,0,false,0.0)).getInfo().getName());
        assertEquals("40",list.findNode(new Dish("40",null,0,false,0.0)).getInfo().getCode());
    }

    @Test
    void findInfo() {
        setupList();
        assertNull(list.findInfo(new Dish("555",null,0,false,0.0)));
        assertNotNull(list.findInfo(new Dish("30",null,0,false,0.0)));
        assertEquals("Taco",list.findInfo(new Dish("80",null,0,false,0.0)).getName());
        assertEquals("Carne",list.findInfo(new Dish("40",null,0,false,0.0)).getName());
        assertEquals("45",list.findInfo(new Dish("45",null,0,false,0.0)).getCode());
    }

    @Test
    void getLinkedList() {
        setupListSort();
        assertEquals(6,listSort.getLinkedList().size());
        assertEquals("Taco",listSort.getLinkedList().get(0).getName());
        assertEquals("40",listSort.getLinkedList().get(5).getCode());
    }

    @Test
    void deleteNode() {
        setupList();
        assertEquals("Pasta",list.deleteNode(list.findNode(new Dish("30",null,0,false,0.0))).getName());
        assertNull( list.findNode(new Dish("30",null,0,false,0.0)));
        assertEquals(5, list.getSize());
        //TODO destruir lista
    }

    @Test
    void getSize() {
        setupListSort();
        assertEquals(6,listSort.getSize());
        listSort.deleteNode(listSort.findNode(new Dish(null,null,0,false,20_000)));
        assertEquals(5, listSort.getSize());
    }

    @Test
    void getObject() {

    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }
}