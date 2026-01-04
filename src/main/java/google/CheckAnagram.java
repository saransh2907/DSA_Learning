package main.java.google;

public class CheckAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("cat", "act"));
        System.out.println(isAnagram("cat", "rat"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] freq = new int[256];
        for (char ch : s.toCharArray()) freq[ch]++;
        for (char ch : t.toCharArray()) freq[ch]--;

        for (int i : freq) if (i != 0) return false;
        return true;
    }
}
