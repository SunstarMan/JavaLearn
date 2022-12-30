import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int hit = 2, ans = 0, index = 0;
        while (index < m) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == hit) {
                    hit += 1;
                }
                arr[i] = arr[i] - hit;
            }
            ans += hit;
            index += 1;
        }
        System.out.println(ans);
    }
}