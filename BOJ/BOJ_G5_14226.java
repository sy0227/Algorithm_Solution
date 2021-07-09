import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_G5_14226 {
    static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        System.out.println(BFS());
    }
    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[1001][1001];
        queue.offer(new int[] {1, 0}); // cnt, clipboard
        visited[1][0] = true;

        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int i = 0 ; i<size ; i++){
                int[] temp = queue.poll();
                int cnt = temp[0], clipboard = temp[1];
                int[] now = {cnt, cnt+clipboard, cnt-1};
                for(int j = 0 ; j<3 ; j++){
                    int next = now[j];
                    if(next == num) return time;
                    switch (j){
                        case 0 :
                            if(next == 0) continue;
                            queue.offer(new int[] {next, next});
                            break;
                        case 1 :
                            if(next>1000 || visited[next][clipboard] || clipboard == 0) continue;
                            visited[next][clipboard] = true;
                            queue.offer(new int[] {next, clipboard});
                            break;
                        case 2 :
                            if(visited[next][clipboard] || next == 0) continue;
                            visited[next][clipboard] = true;
                            queue.offer(new int[] {next, clipboard});
                            break;
                    }
                }
            }
        }
        return -1;
    }
}
