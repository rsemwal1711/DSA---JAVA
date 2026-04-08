package BIT_MANUPULATION;

public class XorInRange {
    public static int from1ToN(int n){
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        if(n%4 == 3) return 0;
        return n;
    }
    public static void main(String[] args) {
        int a = 4;
        int b = 10;
        int xor =  0;
        for(int i=a;i<=b;i++){
            xor ^= i;
        }
        System.out.println(xor);
        System.out.println(from1ToN(10));

        System.out.println(from1ToN(a-1) ^ from1ToN(b));
    }
}
