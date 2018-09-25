import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP2579_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int STEP_1 = 0;
		final int STEP_2 = 1;
		
		int N = Integer.parseInt(br.readLine());
		int steps[] = new int[N+1];
		int dp[][] = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0][STEP_1] = 0;
		dp[0][STEP_2] = 0;
		
		dp[1][STEP_1] = steps[1];
		dp[1][STEP_2] = 0;
		
		for(int i=2; i<=N; i++) {
			dp[i][STEP_1] = Math.max(dp[i-2][STEP_1], dp[i-2][STEP_2]) + steps[i];
			dp[i][STEP_2] = dp[i-1][STEP_1] + steps[i];
		}
		
		System.out.println(Math.max(dp[N][STEP_1], dp[N][STEP_2]));
	}

}
