import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_12904 {
    static String S, T;
    static Queue<StringBuilder> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(T);
        System.out.println((BFS(sb)? 1 : 0));
    }

    private static boolean BFS(StringBuilder sb) {
        queue.offer(sb);
        while(!queue.isEmpty()){
            StringBuilder now = queue.poll();
            if(now.toString().equals(S)) return true;
            if(now.length()>S.length()){
                StringBuilder next = null;
                if(now.charAt(now.length()-1) == 'A'){
                    next = new StringBuilder(now.substring(0, now.length()-1));
                    queue.offer(next);
                }
                if(now.charAt(now.length()-1) == 'B'){
                    next = new StringBuilder(now.subSequence(0, now.length()-1));
                    next.reverse();
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}
