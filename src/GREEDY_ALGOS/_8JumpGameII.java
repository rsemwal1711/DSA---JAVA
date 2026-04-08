package GREEDY_ALGOS;

public class _8JumpGameII {
    public static int usinfRecursion(int[] arr, int position){
        if(position >= arr.length-1) return 0;
        if(arr[position] == 0) return Integer.MAX_VALUE;
        int minStop = Integer.MAX_VALUE;
        for(int i=1;i<=arr[position];i++){
            int subResult = usinfRecursion(arr, position + i);
            if(subResult!=Integer.MAX_VALUE) minStop = Math.min(minStop, subResult+1);
        }
        return minStop;
    }
    public static int jumpGame(int[] arr){
        int jumps = 0;
        int left = 0;
        int right = 0;
        while(right < arr.length-1){
            int farthest = 0;
            for(int i=left;i<=right;i++){
                farthest = Math.max(farthest, i+arr[i]);
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,1,1,1,2};
        System.out.println(jumpGame(arr));
        System.out.println(usinfRecursion(arr,0));

    }
}
