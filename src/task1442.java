import java.util.ArrayList;
import java.util.Scanner;
public class task1442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        merge(n);
    }
    private static void merge(int n){
        long ai = 1, bi= 1;
        int iC = 1;
        long resu = 0;
//        long[] res = new long[n+1];
//        ArrayList<Long> resl = new ArrayList<>(n+2);
        while (iC <= n) {
            long a = ai*ai;
            long b = bi*bi*bi;
            if (a < b) {
                if (resu == 1 || b != resu) {
//                    resl.add(iC, a);
                    iC++;
                    resu = a;
                }
                ai++;
            }
            else if (a > b){
                if (resu == 1 || b != resu) {
//                    resl.add(iC, b);
                    iC++;
                    resu = b;
                }
                bi++;
            }
            else  {
//                iC == 1 || b != res[iC-1]
                if (resu == 1 || b != resu) {
//                    resl.add(iC, a);
                    iC++;
                    resu = a;
                }
                ai++;
                bi++;
            }
        }
//        System.out.println(resl.get(n-1));
        System.out.println(resu);
    }
}
