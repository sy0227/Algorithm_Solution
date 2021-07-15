import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_11559 {
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static ArrayList<int[]> list;
    static Queue<int[]> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for(int i = 0 ; i<12 ; i++){
            map[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        while(true){
            boolean flag = false;
            for(int r = 0 ; r<12 ; r++){
                for(int c = 0 ; c<6 ; c++){
                    if(map[r][c] != '.' && canBoom(r, c, map[r][c])) flag = true;
                }
            }
            if(!flag){
                System.out.println(ans);
                return;
            }
            setGravity();
            ans++;
        }
    }

    private static boolean canBoom(int r, int c, char color) {
        list = new ArrayList<int[]>();
        queue = new LinkedList<int[]>();
        visited = new boolean[12][6];

        list.add(new int[] {r, c});
        queue.offer(new int[] {r, c});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int d = 0 ; d<4 ; d++){
                int nr = temp[0]+dr[d];
                int nc = temp[1]+dc[d];
                if(nr>-1 && nr<12 && nc>-1 && nc<6 && !visited[nr][nc]){
                    if(map[nr][nc] == color){
                        list.add(new int[] {nr, nc});
                        queue.offer(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        if(list.size()>=4){
            for (int[] temp : list) {
                map[temp[0]][temp[1]] = '.';
            }
            return true;
        } else return false;
    }

    private static void setGravity() {
        for(int c = 0 ; c<6 ; c++){
            int emptyR = -1;
            for(int r = 11 ; r>=0 ; r--){
                if(map[r][c] != '.' && emptyR == -1) continue;
                else if(map[r][c] == '.' && emptyR == -1) emptyR = r;
                else if(map[r][c] != '.' && emptyR != -1){
                    map[emptyR][c] = map[r][c];
                    map[r][c] = '.';
                    emptyR--;
                }
            }
        }
    }

}
