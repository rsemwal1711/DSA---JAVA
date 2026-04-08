package GREEDY_ALGOS;

public class _11Candy {
    public static int candy_I(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]) left[i] = left[i-1] + 1;
            else left[i] = 1;
        }
        int sum = Math.max(left[n-1], right[n-1]);

        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[i+1]) right[i] = right[i+1] + 1;
            else right[i] = 1;
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    public static int candyII(int[] arr){
        int candies = arr.length;
        int i = 1;
        while(i < arr.length){
            if(arr[i] == arr[i-1]){
                i++;
                continue;
            }
            int peak = 0;
            while(i < arr.length && arr[i] > arr[i-1]){
                peak++;
                candies += peak;
                i++;
            }
            int valley = 0;
            while(i < arr.length && arr[i] < arr[i-1]){
                valley++;
                candies += valley;
                i++;
            }
            candies -= Math.min(peak, valley);
        }
        return candies;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,5};
        System.out.println(candy_I(arr));
        System.out.println(candyII(arr));
    }
}
