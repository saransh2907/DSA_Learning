package main.java.collections;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListImpl {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();

        l1.add("Chhavi1");
        l1.add(1,"Chhavi");
        l1.add(1,"Chhavi3");
        l1.add(1,null);
        l1.add(1,"Chhavi4");
        remove0(l1);
        System.out.println(l1.toString());
        String[] ar = {"Chhavi", null};
        System.out.println(Arrays.toString(ar));

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        List<List<Integer>> l2 = filterEvenOdd(list);
        System.out.println(l2);
    }

    public static void remove0(List l1){
        Object o =l1.remove(0);
        System.out.println(o);
    }

    static List<List<Integer>> filterEvenOdd(List<Integer> l1) {
        List<Integer> lEven = new ArrayList<>();
        for (int i = l1.size() - 1; i >= 0; i--) {
            if (l1.get(i) % 2 == 0) {
                lEven.add(l1.remove(i));
            }
        }
        return List.of(l1, lEven);
    }
}
