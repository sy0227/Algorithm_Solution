import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_G5_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1 ; test<=T ; test++){
            Deque<Integer> deque = new ArrayDeque<Integer>();
            String P = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length()-1);
            st = new StringTokenizer(input, ",");
            for(int n = 0 ; n<N ; n++){
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            int dir = 0;
            boolean isError = false;
            for(int i = 0 ; i<P.length() ; i++){
                char op = P.charAt(i);
                if(op == 'R'){
                    dir = (dir+1)%2;
                } else if(op == 'D'){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(dir == 0) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if(isError) sb.append("error\n");
            else{
                sb.append("[");
                while(deque.size()>1){
                    if(dir == 0) sb.append(deque.pollFirst());
                    else sb.append(deque.pollLast());
                    sb.append(",");
                }

                if(deque.size() == 0) sb.append("]\n");
                else sb.append(deque.pollFirst()).append("]\n");
            }
        }
        System.out.print(sb);
    }
}
