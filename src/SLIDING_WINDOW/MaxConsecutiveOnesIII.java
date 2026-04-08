package SLIDING_WINDOW;

public class MaxConsecutiveOnesIII {
    public static int longestOnes_BRUTE(int[] arr, int k){
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            int zeroes = 0;
            for(int j=i;j<arr.length;j++){
                if(arr[j] == 0){
                    zeroes++;
                }
                if(zeroes > k) break;

                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    public static int longestOnes_BETTER(int[] arr, int k){
        int n = arr.length;
        int left = 0;
        int maxLen = 0, zeroes = 0;
        for(int right=0;right<n;right++){
            if(arr[right] == 0){
                zeroes++;
            }
            while (zeroes > k){
                if(arr[left] == 0){
                    zeroes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

    public static int longestOnes_OPTIMAL(int[] arr, int k){
        int n = arr.length;
        int left = 0;
        int maxLen = 0, zeroes = 0;
        for(int right=0;right<n;right++){
            if(arr[right] == 0){
                zeroes++;
            }
            if (zeroes > k){
                if(arr[left] == 0){
                    zeroes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,1,0,1,1,1,0,0};
        System.out.println(longestOnes_BRUTE(arr, 3));
        System.out.println(longestOnes_BETTER(arr, 3));
        System.out.println(longestOnes_OPTIMAL(arr, 3));
    }
}
