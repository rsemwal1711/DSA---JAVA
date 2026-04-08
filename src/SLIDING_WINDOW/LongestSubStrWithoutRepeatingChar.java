package SLIDING_WINDOW;

import java.util.Arrays;

public class LongestSubStrWithoutRepeatingChar {
    public static int longestNonRepeatingSubstring_BRUTE(String str){
        int n = str.length();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            Arrays.fill(hash,0);
            for(int j=i;j<n;j++){
                if(hash[str.charAt(j)] == 1){
                    break;
                }
                hash[str.charAt(j)] = 1;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    public static int longestNonRepeatingSubstring_OPTIMAL(String str){
        int left = 0, right = 0, maxLen = 0;
        int n = str.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        while(right < n){
            if(hash[str.charAt(right)] >= left){
                left = Math.max(left, hash[str.charAt(right)] + 1);
            }
            maxLen = Math.max(maxLen, right-left+1);
            hash[str.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "cadbzabcd";
        System.out.println(longestNonRepeatingSubstring_BRUTE(str));
        System.out.println(longestNonRepeatingSubstring_OPTIMAL(str));
    }
}
