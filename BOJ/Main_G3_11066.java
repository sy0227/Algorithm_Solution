import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test = 1 ; test<=T ; test++){
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];
            st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k<K ; k++){
                arr[k] = Integer.parseInt(st.nextToken());
            }
            int[][] DP = new int[K][K];
            int[] S = new int[K];
            S[0] = arr[0];
            for(int k = 1 ; k<K ; k++){
                S[k] = S[k-1]+arr[k];
            }
            for(int k = 0 ; k<K-1 ; k++){
                DP[k][k+1] = arr[k]+arr[k+1];
            }
            for(int gap=2;gap<K;gap++) {
                for(int i=0;i+gap<K;i++) {
                    int j=i+gap;
                    DP[i][j]=Integer.MAX_VALUE;

                    for(int k=i;k<j;k++) {
                        DP[i][j]=Math.min(DP[i][k]+DP[k+1][j]+((i==0)? S[j] : S[j]-S[i-1]), DP[i][j]);
                    }
                }
            }
            System.out.println(DP[0][K-1]);
        }
    }
}
