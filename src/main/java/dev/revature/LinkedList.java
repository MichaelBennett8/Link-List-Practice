package dev.revature;

public class LinkedList <T>{

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void push(Node n){
        if (tail != null){
            tail.setNext(n);
            tail = n;
            size++;
        }
        if (head == null){
            head = n;
            tail = n;
            size++;
        }
    }

    public void stackPush(Node n){
        if (head == null){
            head = n;
            tail = n;
            size++;
        }
        else {
            n.setNext(head);
            head = n;
            size++;
        }
    }

    public Node pop () throws NotFound{
        if (isEmpty()) throw new NotFound("push before you pop");
        Node h = head;
        head = head.getNext();
        h.setNext(null);
        size--;
        return h;
    }

    public Node peek() throws NotFound{
        if (isEmpty()) throw new NotFound("push before you peek");
        return head;
    }

    public boolean contains(T data) throws NotFound{
        Node temp = head;
        if (temp == null){
            throw new NotFound("push before you peek");
        }
        else {
            while (temp != null) {
                //System.out.printf("head:%s, temp:%s\n", head.getData(), temp.getData());
                if (temp.getData().equals(data)){
                    return true;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
