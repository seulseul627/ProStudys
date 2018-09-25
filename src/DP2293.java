import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP2293 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		int DP[][] = new int[N+1][K+1];
		
		int i,j;
		int cost[] = new int[N+1];
		for(i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}

		// INIT
		for(i=1; i<=N; i++) {
			DP[i][0] = 1;
		}
		
		//START
		int coinCost;
		for(i=1; i<=N; i++) {
			coinCost = cost[i]; // 동전 가치
			for(j=1; j<=K; j++) {
				if( (j-coinCost) < 0 ) {
					DP[i][j] = DP[i-1][j];
				}else {
					DP[i][j] = DP[i-1][j] + DP[i][j-coinCost];
				}
			}
		}
		
		System.out.println(DP[N][K]);
	}

}
