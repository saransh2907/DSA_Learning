package main.java.data_structures;

import java.util.ArrayList;
import java.util.Arrays;

public class SLLClient {

    public static void main (String[] args){
        Node n1 = new Node("First");
        Node n2 = new Node("Second");
        Node n3 = new Node("Third");
        Node n4 = new Node("Fourth");
        Node n5 = new Node("Fifth");
        Node n6 = new Node("Sixth");

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
//        n6.setNext(n3);

        SinglyLinkedList list = new SinglyLinkedList(n1);
//        if(!list.detectCycle()){
//            list.printList();
//        }else {
//            System.out.println("Cyclic List Cant be printed");
//        }
        try {
            list.insertNode(44,new Node("66"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("**********************");
//        SinglyLinkedList list2 = new SinglyLinkedList(n2);
        list.printList();
//        System.out.println("**********************");
////        list.reverseList();
////        list.printList();
//        System.out.println("**********************");
//        System.out.println(Arrays.toString(list.getNodeArray()));
    }
}
