package SLIDING_WINDOW;

public class FruitsInTheBasket {
    public static int fruitsInBasket(int[] arr){
        int n = arr.length;
        int count = 1;
        for(int i=1;i<n;i++){
            if(arr[i] != arr[i-1]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2};
        System.out.println(fruitsInBasket(arr));
    }
}
