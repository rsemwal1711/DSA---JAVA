package BINARY_TREES;

public class _24ConstructUniqBT {
    public static boolean uniqueBT(int a, int b){
        if(a == b) return false;
        if(a == 2 || b == 2) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(uniqueBT(2,1));
    }
}
