package GREEDY_ALGOS;

public class _7JumpGameI {
    public static boolean jumpPossible(int[] arr){
        int maxIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i+arr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,1,1,0,2,5};
        System.out.println(jumpPossible(arr));
    }
}
