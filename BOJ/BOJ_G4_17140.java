import java.util.*;

public class BOJ_G4_17140 {
    static int row, col;
    static int[][] a;
    static class Node implements Comparable<Node>{
        int num;
        int cnt;

        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            if(this.cnt == n.cnt) {
                if(this.num > n.num) return 1;
                else return -1;
            }
            else if(this.cnt > n.cnt) return 1;
            else return -1;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int k = sc.nextInt();
        a = new int[100][100];
        int result = -1;
        row = 3;
        col = 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 100; i++) {
            if(a[r][c] == k) {
                result = i;
                break;
            }
            a = (row>=col)? funcR() : funcC();
        }
        System.out.println(result);
    }

    private static int[][] funcR() {
        int[][] b = new int[100][100];
        int max = 0;
        for(int i = 0; i < row; i++) {
            ArrayList <Node> l = new ArrayList<>();
            for(int j = 0; j < col; j++) {
                int num = a[i][j];
                if(num == 0) continue;
                int flag = 0;
                for(int k = 0; k < l.size(); k++) {
                    if(l.get(k).num == num) {
                        flag = 1;
                        l.get(k).cnt++;
                        break;
                    }
                }
                if(flag == 0) l.add(new Node(num, 1));
            }
            Collections.sort(l);
            int cnt = 0;
            for(int j = 0; j < l.size(); j++) {
                if(cnt > 99) break;
                b[i][cnt++] = l.get(j).num;
                b[i][cnt++] = l.get(j).cnt;
            }
            max = Math.max(max, 2 * l.size());
        }
        col = max;
        return b;
    }

    private static int[][] funcC() {
        int[][] b = new int[100][100];
        int max = 0;

        for(int i = 0; i < col; i++) {
            ArrayList <Node> l = new ArrayList<>();
            for(int j = 0; j < row; j++) {
                int num = a[j][i];
                if(num == 0) continue;
                int flag = 0;
                for(int k = 0; k < l.size(); k++) {
                    if(l.get(k).num == num) {
                        flag = 1;
                        l.get(k).cnt++;
                        break;
                    }
                }
                if(flag == 0) l.add(new Node(num, 1));
            }
            Collections.sort(l);
            int cnt = 0;
            for(int j = 0; j < l.size(); j++) {
                if(cnt > 99) break;
                b[cnt++][i] = l.get(j).num;
                b[cnt++][i] = l.get(j).cnt;
            }
            max = Math.max(max, 2 * l.size());
        }
        row = max;
        return b;
    }
}
