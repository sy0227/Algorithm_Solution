import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_5014 {
    static int F, S, G, U, D, ans = 0;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        flag = true;
        if(S>G){
            while(S>G){
                down();
                if(!flag) break;
            }
            while(S<G){
                up();
                if(!flag) break;
            }
            if(S != G) flag = false;
        }
        else if(S<G){
            while(S<G){
                up();
                if(!flag) break;
            }
            while(S>G){
                down();
                if(!flag) break;
            }
            if(S != G) flag = false;
        }
        if(flag) System.out.println(ans);
        else System.out.println("use the stairs");
    }

    private static void up() {
        if(U == 0){
            flag = false;
            return;
        }
        S += U;
        ans++;
    }
    private static void down() {
        if(D == 0){
            flag = false;
            return;
        }
        S -= D;
        ans++;
    }
}
