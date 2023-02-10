package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackNodeTest {

    @Test
    void isEmpty() {
        StackNode<String> st = new StackNode<>( (obj1,obj2) -> obj1.compareTo(obj2));
        assertTrue( st.isEmpty());
        st.push("Hola");
        assertFalse( st.isEmpty());
    }

    @Test
    void push() {

    }

    @Test
    void pop() {
        StackNode<String> st = new StackNode<>( (obj1,obj2) -> obj1.compareTo(obj2));
        st.push("uno");
        st.push("dos");
        st.push("tres");
        st.push("cuatro");
        st.push("cinco");

        assertEquals("cinco",st.pop());
        assertEquals("cuatro",st.pop());
        assertEquals("tres",st.pop());
        assertEquals("dos",st.pop());
        assertEquals("uno",st.pop());

        assertNull(st.pop());
        assertTrue( st.isEmpty());
    }
}