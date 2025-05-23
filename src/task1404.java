import java.util.Scanner;
public class task1404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), start = 0, start1 = 0;
        String[][] arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.next();
            }
        }

        qSortClassnum(arr, 0, n - 1);

        for (int i = 1; i < n; i++) {
            if (Integer.parseInt(arr[i][2].substring(0, arr[i][2].length()-1)) != Integer.parseInt(arr[i-1][2].substring(0, arr[i-1][2].length()-1))) {
                qSortClass(arr, start, i-1);
                start = i;
            }
            else if (i == n - 1) {
                qSortClass(arr, start, i);
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr[i][2].compareTo(arr[i-1][2]) != 0) {
                qSortLastname(arr, start1, i-1);
                start1 = i;
            }
            else if (i == n-1 ) qSortLastname(arr, start1, i);
        }

        for (int i = 0; i < n; i++) {
            String tmp = arr[i][0];
            arr[i][0] = arr[i][2];
            arr[i][2] = tmp;
            String temp = arr[i][1];
            arr[i][1] = arr[i][2];
            arr[i][2] = temp;
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void qSortClassnum(String[][] a, int left, int right) {
        int i = left;
        int j = right;
        String c = a[(left + right)/2][2];
        while (i <= j) {
            String ai = a[i][2], ci = c, aj = a[j][2];
            ai = ai.substring(0, ai.length() - 1);
            aj = aj.substring(0, aj.length() - 1);
            ci = ci.substring(0, ci.length() - 1);
            while (Integer.parseInt(ai) < Integer.parseInt(ci)) {
                i++;
                ai = a[i][2];
                ai = ai.substring(0, ai.length() - 1);
            }
            while (Integer.parseInt(aj) > Integer.parseInt(ci)) {
                j--;
                aj = a[j][2];
                aj = aj.substring(0, aj.length() - 1);
            }
            if (i <= j) {
                String[] temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) qSortClassnum(a, left, j);
        if (i < right) qSortClassnum(a, i, right);
    }
    private static void qSortClass(String[][] a, int left, int right) {
        int i = left;
        int j = right;
        String c = a[(left + right)/2][2];
        while (i <= j) {
            while (a[i][2].charAt(a[i][2].length()-1) < c.charAt(c.length()-1)) i++;
            while (a[j][2].charAt(a[j][2].length()-1) > c.charAt(c.length()-1)) j--;
            if (i <= j) {
                String[] temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) qSortClass(a, left, j);
        if (i < right) qSortClass(a, i, right);
    }
    private static void qSortLastname(String[][] a, int left, int right) {
        int i = left;
        int j = right;
        String c = a[(left + right)/2][0];
        while (i <= j) {
            while (a[i][0].compareTo(c) < 0) i++;
            while (a[j][0].compareTo(c) > 0) j--;
            if (i <= j) {
                String[] temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) qSortLastname(a, left, j);
        if (i < right) qSortLastname(a, i, right);
    }
}