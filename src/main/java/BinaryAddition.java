package main.java;

public class BinaryAddition {
    public static void main(String[] args) {
        String s1 = "1001";
        String s2 = "111";
        String s3 = addBinary(s1, s2);
        System.out.println(s3);
        char a = '0';
        char b = '1';
        int x = a;
        int y = b;
        int z = (b - a);
        System.out.println(a + "[" + x + "]"+ b + "[" +  y + "] =" + z  );

    }

    private static String addBinary(String s1, String s2) {
        char c1,c2;
        boolean carry = false;
        String sum = "";
        int min = Math.min(s1.length(), s2.length());
//        if(s1.length()>=s2.length()){
            int j=s1.length()-1;
            for(int i = min-1; i>=0;i--){
                c1 = s1.charAt(j);
                c2 = s2.charAt(i);
                if(c1=='1'&& c2== '1'){
                    if(carry)
                        sum = '1' + sum;
                    else
                        sum = '0' + sum;
                    carry = true;
                }
                else {
                    if (c1 == '1' || c2 == '1') {
                        if (carry) {
                            sum = '0' + sum;
                        } else {
                            sum = '1' + sum;
                        }
                    }
                    else{
                        if(carry){
                            sum = '1' + sum;
                        }
                        else{
                            sum = '0' + sum;
                        }
                        carry = false;
                    }
                }
                j--;
                System.out.println(carry+"["+c1+"]" + "["+c2+"]=" + sum);
            }
            String longer = s1.length() > s2.length() ? s1 : s2;

            for (int i = Math.abs(s2.length() - s1.length())-1 ;i>=0;i-- ){
                c1=longer.charAt(i);
                System.out.println(longer+"-->"+c1+"-->"+i);
                if(carry){
                    if(c1=='1'){
                        sum = '0' + sum;
                        carry = true;
                    }
                    else{
                        sum = '1' + sum;
                        carry = false;
                    }
                }
                else{
                    sum = c1 + sum;
                }
            }
            if(carry){
                sum = '1' + sum;
            }
//        }
        return sum;
    }



    public String addBinary2(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = bitA + bitB + carry;
            carry = sum / 2;
            result.append(sum % 2);
        }
        if(carry == 1){
            result.append('1');
        }
        return result.reverse().toString();
    }
}