import java.util.*;
import java.math.*;

public class DP1520_solution {
    public static int mod = 1000000;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    
    public static int[][] dp;
    public static int[][] arr;
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        arr = new int[w][h];
        dp = new int[w][h];
        for (int i=0; i<w; i++) {
            for (int j=0; j<h; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }
    
    public static int dfs(int x, int y) {
        int n = arr.length;
        int m = arr[0].length;
        if (x == n-1 && y == m-1) {
            return 1;
        }
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (arr[x][y] > arr[nx][ny]) {
                    dp[x][y] += dfs(nx,ny);
                }
            }
        }
        return dp[x][y];
    }
   
}