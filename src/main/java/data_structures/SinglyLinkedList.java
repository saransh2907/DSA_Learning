package main.java.data_structures;

import java.util.ArrayList;

public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void reverseList(){
        Node a = head;
        Node b = head.getNext();
        head.setNext(null);
        while(b.getNext() != null){
            Node c = b.getNext();
            b.setNext(a);
            a = b;
            b = c;
        }
        b.setNext(a);
        setHead(b);
    }

    public int getSize(){
        Node current = head;
        int count=0;
        while(current!=null){
            count++;
            current=current.getNext();
        }
        return count;
    }
    public Node[] getNodeArray(){
        int l = getSize();
        Node current = head;
        Node[] arr = new Node[l];
        for (int i=0;i<l;i++){
            arr[i] = current;
            current=current.getNext();
        }
        return arr;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertNode(int index, Node n) throws Exception{
        Node current = head;
        Node prev = head;
        int count =0;
        boolean flag=false;
        while(current!=null){
            if(count == index){
                prev.setNext(n);
                n.setNext(current);
                flag=true;
                break;
            }
            prev=current;
            current=current.getNext();
            count++;
        }
        if(!flag)
            throw new Exception("Invalid Index");
    }

    public boolean detectCycle(){
        Node fast = head;
        Node slow = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
