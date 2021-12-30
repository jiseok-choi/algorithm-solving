package programmers.algorithm;

public class 조합 {

    public static int combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        } else {
            return combination(n-1, r-1) + combination(n-1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(combination(5, 2));
    }
}
