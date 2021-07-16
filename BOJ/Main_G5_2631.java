import java.util.Scanner;

public class Main_G5_2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int n = 0 ; n <N ; n++){
            arr[n] = sc.nextInt();
        }

        int stay = 0;
        int[] DP = new int[N];
        for(int n = 0 ; n<N ; n++){
            DP[n] = 1;
            for(int j = 0 ; j<n ; j++){
                if(arr[j]<arr[n]) DP[n] = Math.max(DP[n], DP[j]+1);
            }
            stay = Math.max(stay, DP[n]);
        }
        System.out.println(N-stay);
    }
}
