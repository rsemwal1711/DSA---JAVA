package GREEDY_ALGOS;

public class _4Lemonade {
    public static boolean lemonade(int[] bills){
        int five = 0;
        int ten = 0;
        for(int bill : bills){
            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                if(five>0) five--;
                else return false;
                ten++;
            }
            else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {5,5,5,10,20};
        System.out.println(lemonade(arr));
    }
}
