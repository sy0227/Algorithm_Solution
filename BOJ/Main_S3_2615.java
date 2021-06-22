package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_2615 {
	static int[][] map = new int[19][19];
    static int[] dr = {-1, 0, 1, 1}; // 우상, 우, 우하, 하
    static int[] dc = {1, 1, 1, 0};
    static int val;
    static int ans, ans_x, ans_y;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i<19 ; i++) {
            String str = br.readLine();
            for(int j = 0, k = 0 ; j<19 ; j++, k+=2) {
                map[i][j] = str.charAt(k)-'0';
            }
        }
        top:
        for(int i = 0 ; i<19 ; i++) {
            for(int j = 0 ; j<19 ; j++) {
                if(map[i][j] != 0) {
                    val = map[i][j];
                    for(int d = 0 ; d<4 ; d++) {
                        int nr = i+dr[d];
                        int nc = j+dc[d];
                        if(nr<0 || nr>=19 || nc<0 || nc>=19 || map[nr][nc] != val) continue;
                         
                        int six_r = i-dr[d];
                        int six_c = j-dc[d];
                        if(six_r>-1 && six_r<19 && six_c>-1 && six_c<19 && map[six_r][six_c] == val) continue;
                        int cnt = 1;
                        while(nr>-1 && nr<19 && nc>-1 && nc<19 && val == map[nr][nc] && cnt<=5) {
                            cnt++;
                            nr += dr[d];
                            nc += dc[d];
                        }
                        if(cnt == 5) {
                            ans = val;
                            ans_x = i+1;
                            ans_y = j+1;
                            break top;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        if(ans != 0) System.out.printf("%d %d\n", ans_x, ans_y);
         
    }

}
