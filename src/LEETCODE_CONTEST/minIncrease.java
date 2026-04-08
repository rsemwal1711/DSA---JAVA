package LEETCODE_CONTEST;

public class minIncrease {
    public int MinIncrease(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int left = (i > 0) ? arr[i - 1] : Integer.MIN_VALUE;
            int right = (i < n - 1) ? arr[i + 1] : Integer.MIN_VALUE;

            int required = Math.max(left, right) + 1;

            int increase = 0;
            if (arr[i] <= Math.max(left, right)) {
                increase = required - arr[i];
            }

            ans = Math.min(ans, increase);
        }

        return ans;
    }
}
