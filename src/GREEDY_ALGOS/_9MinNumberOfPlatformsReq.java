package GREEDY_ALGOS;

import java.util.*;

public class _9MinNumberOfPlatformsReq {
    public static int countPlatforms(int n, int[] arr, int[] dep){
        int ans = 1;
        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=i+1;j<n;j++){
                if((dep[i] >= arr[j] && arr[i] <= arr[j]) || (dep[j] <= arr[i] && arr[j] >= arr[i])) count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public static int countOPTIMAL(int n, int[] arr, int[] dept){
        Arrays.sort(arr);
        Arrays.sort(dept);
        int platform = 1;
        int i=1; int j=0;
        int ans = 1;
        while(i < n && j < n){
            if(arr[i] <= dept[j]){
                platform++;
                i++;
            }
            else{
                platform--;
                j++;
            }
            ans = Math.max(ans, platform);
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;

        System.out.println("Minimum number of Platforms required " + countPlatforms(n, arr, dep));

        System.out.println("Minimum number of Platforms required " + countOPTIMAL(n, arr, dep));

    }
}
