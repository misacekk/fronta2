public class Node {
    private Uchazec data;
    private Node next;

    public Node(Uchazec data) {
        this.data = data;
        this.next = null;
    }

    public Uchazec getData() {
        return data;
    }

    public void setData(Uchazec data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}