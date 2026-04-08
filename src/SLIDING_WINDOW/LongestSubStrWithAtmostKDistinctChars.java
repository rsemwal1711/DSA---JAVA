package SLIDING_WINDOW;

import java.util.*;

public class LongestSubStrWithAtmostKDistinctChars {
    public static  int BRUTE(String str, int k){
        if(k == 0 || str.length() == 0) return 0;
        int n = str.length();
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            Map<Character, Integer> mpp = new HashMap<>();
            for(int j=i;j<n;j++){
                char c = str.charAt(j);
                mpp.put(c,mpp.getOrDefault(c,0) + 1);
                if(mpp.size() > k){
                    break;
                }
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    public static int OPTIMAL(String str, int k){
        if(k == 0 || str.length() == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> mpp =  new HashMap<>();
        int n = str.length();
        int left = 0;
        for(int right=0;right<n;right++){
            char c = str.charAt(right);
            mpp.put(c, mpp.getOrDefault(c,0) + 1);
            while(mpp.size() > k){
                char c1 = str.charAt(left);
                mpp.put(c1, mpp.get(c1) - 1);
                if(mpp.get(c1) == 0){
                    mpp.remove(c1);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println("BRUTE CODE");
        System.out.println(BRUTE("aababbcaacc", 2));
        System.out.println(BRUTE("abcddefg",3));
        System.out.println();
        System.out.println("OPTIMAL CODE");
        System.out.println(BRUTE("aababbcaacc", 2));
        System.out.println(BRUTE("abcddefg",3));
    }
}
