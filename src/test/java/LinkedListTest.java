import dev.revature.LinkedList;
import dev.revature.Node;
import dev.revature.NotFound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    /*
    add/push
    pop
    peek
    contains
    size
     */

    LinkedList<String> list;

    @BeforeEach
    void setup(){
        list = new LinkedList();

    }

    @Test
    void pushTest() {
        Node<String> n = new Node();
        list.push(n);

        Assertions.assertEquals(1, list.size());
    }

    @Test
    void popTest(){
        Node<String> n = new Node("testpop");
        list.push(n);
        list.push(new Node("1"));
        list.push(new Node("2"));
        list.push(new Node("3"));

        try {
            Assertions.assertEquals("testpop", list.pop().getData());
            Assertions.assertEquals("1", list.pop().getData());
            Assertions.assertEquals("2", list.pop().getData());
            Assertions.assertEquals("3", list.pop().getData());
            Assertions.assertEquals(0, list.size());
        }
        catch (NotFound e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void peekTest() throws NotFound{
        Node<String> n = new Node("testpeek");
        list.push(n);

        Assertions.assertEquals("testpeek", list.peek().getData());
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void containsTest() throws NotFound{
        Node<String> n = new Node("testcontains");
        list.push(new Node("not this one"));
        list.push(n);
        list.push(new Node("also not this one"));

        Assertions.assertTrue(list.contains("testcontains"));
        Assertions.assertFalse(list.contains("revapoints"));
    }

    @Test
    void sizeTest() {
        Node<String> n = new Node();
        list.push(n);
        list.push(n);
        list.push(n);
        list.push(n);
        list.push(n);

        Assertions.assertEquals(5, list.size());

        list.push(n);
        list.push(n);

        Assertions.assertEquals(7, list.size());
    }

    @Test
    void isEmptyTest() {
        Assertions.assertTrue(list.isEmpty());

        list.push(new Node());

        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void notFoundTest() {
        Assertions.assertThrows(NotFound.class, ()->list.pop());

        Assertions.assertThrows(NotFound.class, ()->list.peek());

        Assertions.assertThrows(NotFound.class, ()->list.contains("whatever"));
    }

    @Test
    void stackTest() throws NotFound{
        Node<String> n = new Node<>("stack");
        list.stackPush(new Node("1"));
        list.stackPush(new Node("2"));
        list.stackPush(new Node("3"));
        list.stackPush(n);

        Assertions.assertEquals("stack", list.pop().getData());
        Assertions.assertEquals("3", list.pop().getData());
        Assertions.assertEquals("2", list.pop().getData());
        Assertions.assertEquals("1", list.pop().getData());
    }
}
