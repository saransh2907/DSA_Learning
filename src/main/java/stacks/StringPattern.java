package main.java.stacks;
import java.util.Stack;

public class StringPattern {
    

    public static void main(String[] args) {
        String input1 = "a2[c]3[b]";
        String input2 = "3[a2[b]]";
        System.out.println( input1 +" => "+ decodeString(input1));
        System.out.println( input2 +" => "+decodeString(input2));
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');  // for multi-digit numbers
            } else if (ch == '[') {
                countStack.push(k);
                stack.push(currentStr.toString());
                currentStr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = new StringBuilder(stack.pop());
                int repeatTimes = countStack.pop();
                decoded.append(String.valueOf(currentStr).repeat(Math.max(0, repeatTimes)));
                currentStr = decoded;
            } else {
                currentStr.append(ch);
            }
        }

        return currentStr.toString();
    }

    /*
     System.out.println("index=" + index);
        if(index == arr.length){
            return 0;
        }
        if(buy == 1){
            int ifBuy =   - arr[index] + getMaxProfitMultiple(arr,index+1, 0);;
            int ifNotBuy = getMaxProfitMultiple(arr, index+1, 1);
            return Math.max(ifNotBuy,ifBuy);
        }else{
            int ifBuy = arr[index] + getMaxProfitMultiple(arr, index + 1, 1);
            int ifNotBuy = getMaxProfitMultiple(arr, index+1, 0);
            return Math.max(ifNotBuy,ifBuy);
        }

     */

}