package main.java.collections;

import java.util.*;

public class MapImpl {
    public static void main(String[] args) {
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"Chhavi");
        map.put(2,"Saransh");
        map.put(3,"Srivastava");
        map.put(4,"Gupta");
        System.out.println(map);
        List<String> leven = new ArrayList<>();
        List<String> lOdd = new ArrayList<>();
        for(int x : map.keySet()) {
            boolean res = x % 2 == 0 ? leven.add(map.get(x)) : lOdd.add(map.get(x));
        }

        for(Map.Entry<Integer, String> x:map.entrySet()){
            boolean res = (x.getKey()%2 ==0) ? leven.add(x.getValue()):lOdd.add(x.getValue());
        }
        List s1 = new ArrayList<>();
        List s2 = new ArrayList<>();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(leven);
        System.out.println(lOdd);

        s1 = null;
        boolean a = s1 == null;
//        boolean b = s1.equals(null);
        System.out.println(a +" - ");
    }

    //  == vs .equals()




}
