package main.java.arrays;

import java.util.Arrays;

public class Utils {

    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setAge(11);
        student1.setName("Chhavi");
        student1.toString();


        String a = "abc";
        setString(a, "xyz");
        System.out.println(a);

        Integer x = 5;
        Integer y = setValue(5,4);
        System.out.println(x);
        System.out.println(y);

    }

    public static void setString(String x, String y){
        x = y;
    }
    public static Integer setValue(Integer x, int y){
        x=y;
        return x;
    }

    public static void fill2DArrayValue(int[][] arr, int x){
        for(int[] y : arr){
            Arrays.fill(y, -1);
        }
        System.out.println("after filling");
        /*
        int[][] arr1 = new int[5][6];
        Integer[][] arr2=new Integer[5][6];
        System.out.println("->" + arr1[4][4] + "->" + arr2[4][4]);

        // fill all values in arr1 as -1
        // Approach 1
        System.out.println("initialized");
        print2DArray(arr1);
        for(int i =0; i<arr1.length; i++){
            for(int j=0; j < arr1[i].length; j++){
                arr1[i][j] = x;
            }
        }
        System.out.println("after filling");
        print2DArray(arr1);

        //Approach 2
        arr1 = new int[5][6];
        System.out.println("initialized");
        print2DArray(arr1);
        for(int[] x : arr1){
            for(int y : x) {
                y = -1;
            }
        }
        System.out.println("after filling");
        print2DArray(arr1);
        // Approach 3
        print2DArray(arr);
        for(int[] y : arr){
            Arrays.fill(y, -1);
        }
        System.out.println("after filling");
        print2DArray(arr);
         */
    }

    public static void print2DArray(int[][] arr){
        for(int[] x: arr){
            System.out.println(Arrays.toString(x));
        }
    }
}
class Student{
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

