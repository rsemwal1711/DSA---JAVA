package SORTING;

import java.util.*;

public class _2SUM {
    public static List<List<Integer>> twoSum(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        int left = 0, right = arr.length-1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == 0){
                res.add(Arrays.asList(arr[left], arr[right]));
                while(left < right && arr[left] == arr[left+1]) left++;
                while(left < right && arr[right] == arr[right-1]) right--;
                left++;
                right--;
            }
            else if(sum < 0){
                left++;
            }
            else{
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,2,-4,-1,4};
        List<List<Integer>> result = twoSum(arr);
        System.out.println(result);
    }
}
