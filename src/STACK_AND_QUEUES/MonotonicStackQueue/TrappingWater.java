package STACK_AND_QUEUES.MonotonicStackQueue;

public class TrappingWater {
    public static int trap_brute(int[] arr){
        int n = arr.length;
        int waterTrapped = 0;
        for(int i=0;i<n;i++){
            int j = i;
            int leftMax=0, rightMax=0;
            while(j>=0){
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j=i;
            while(j<n){
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax,rightMax) - arr[i];
        }
        return waterTrapped;
    }

    public static int trap_optimalI(int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int waterTrapped = 0;
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }
        suffix[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }
        for(int i=0;i<n;i++){
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }

    public static int trap_optimalII(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(arr[left] > leftMax){
                    leftMax = arr[left];
                }
                else{
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            }
            else{
                if(arr[right] > rightMax){
                    rightMax = arr[right];
                }
                else{
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap_brute(arr));
        System.out.println(trap_optimalI(arr));
        System.out.println(trap_optimalII(arr));
    }
}