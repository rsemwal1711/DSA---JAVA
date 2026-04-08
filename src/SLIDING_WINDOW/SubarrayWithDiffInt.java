package SLIDING_WINDOW;

import java.util.*;

public class SubarrayWithDiffInt {
    public static int BRUTE(int[] arr, int k){
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            Map<Integer, Integer> mpp = new HashMap<>();
            for(int j=i;j<n;j++){
                mpp.put(arr[j], mpp.getOrDefault(arr[j],0) + 1);
                if(mpp.size() > k){
                    break;
                }
                if(mpp.size() == k) count++;
            }
        }
        return count;
    }

    public static int OPTIMAL(int[] arr, int k){
        int maxLen = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        int left = 0;
        int n = arr.length;
        int right = 0;
        while(right < n){
            mpp.put(arr[right], mpp.getOrDefault(arr[right],0) + 1);
            while(mpp.size() > k){
                mpp.put(arr[left], mpp.get(arr[left]) - 1);
                if(mpp.get(arr[left]) == 0){
                    mpp.remove(arr[left]);
                }
                left++;
            }
            maxLen += right-left+1;
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,1,2,3};
        int k1 = 2;

        int[] arr2 = {1,2,1,3,4};
        int k2 = 3;

        System.out.println("BRUTE CODE");
        System.out.println(BRUTE(arr1,k1));
        System.out.println(BRUTE(arr2,k2));

        System.out.println();

        System.out.println("OPTIMAL CODE");
        System.out.println(OPTIMAL(arr1,k1) - OPTIMAL(arr1, k1-1));
        System.out.println(OPTIMAL(arr2,k2) - OPTIMAL(arr2, k2-1));
    }
}
