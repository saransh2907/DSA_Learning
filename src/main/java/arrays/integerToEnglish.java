package main.java.arrays;

public class integerToEnglish {

    public static void main(String[] args) {
        System.out.println(numberToWords(123456978));
//        System.out.println(getWordToHundred(132));
//        for(int i =0; i < 200; i++){
//            System.out.println(getWordToHundred(i));
//        }


    }
    /**
     * Convert a non-negative integer num to its English words representation.
     * Example 1:
     * Input: num = 123
     * Output: "One Hundred Twenty Three"
     * Example 2:
     * Input: num = 12345
     * Output: "Twelve Thousand Three Hundred Forty Five"
     * Example 3:
     * Input: num = 1234567
     * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * Constraints:
     * 0 <= num <= 231 - 1
     */
    public static String numberToWords(int num) {
        String ans = "";
        String[] illions = {"", "Thousand", "Million", "Billion", "Trillion"};
        int pos = 0;
        while(num > 0){
            ans = getWordToHundred(num) + " "+illions[pos]+" "+ ans;
            pos++;
            num/=1000;
        }
        return ans;
    }

    public static String getWordToHundred(int num){
        num = num % 1000;
        String[] ones = {"","one","two","three","four","five","six","seven","eight","nine"};
        String[] tens = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

        if(num == 0){
            return "zero";
        }

        if(num<20 && num >9){
            String[] aboveTen = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
                    "nineteen"};
            return aboveTen[num-10];
        }

        String word = "";
        int pos = 1;
        while(num>0){
            int x = (num)%10;
            if(pos==1){
                word += ones[x];
            } else if (pos == 2) {
                String ten = (x-2)>=0 ? tens[x-2] : "";
                word = ten + " " + word;
            }else if(pos == 3){
                word = ones[x] + " hundred "+word;
            }
            num /= 10;
            pos++;
        }
        return word;
    }
}
