public class Node {

    private int value;
    private Node prev;
    private Node next;


    public Node(int value) {
        this.value = value;
    }


    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "node{" +
                "value=" + value +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}

