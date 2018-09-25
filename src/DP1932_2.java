import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP1932_2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int dp[][] = new int[K+1][K+1];
		String str[];
		
		for(int i=1; i<=K; i++) {
			str = br.readLine().split(" ");
			for(int j=1; j<=i; j++) {
				dp[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		
		
		for(int i=2; i<=K; i++) {
			for(int j=1; j<=i; j++) {
				if(j==1) {
					dp[i][j] += dp[i-1][j];
				}else if(j==i) {
					dp[i][j] += dp[i-1][j-1];
				}else {
					dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}
		
		int max=0;
		for(int i=1; i<=K; i++) {
			if( max < dp[K][i] ) {
				max = dp[K][i];
			}
		}
		
		System.out.println(max);
	}

}
