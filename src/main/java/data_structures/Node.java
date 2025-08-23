package main.java.data_structures;

public class Node {

    private String data;
    private Node next;
//    private Node prev;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
//    public Node getPrev() {
//        return prev;
//    }
//    public void setPrev(Node prev) {
//        this.prev = prev;
//    }

    @Override
    public String toString() {
        return "<"+data+'>';
    }
}

