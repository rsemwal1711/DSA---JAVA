package SORTING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4SUM {
    public static List<List<Integer>> fourSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); // Step 1: sort

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;

                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,2,-4,-1,4};
        List<List<Integer>> result = fourSum(arr);
        System.out.println(result);
    }
}
