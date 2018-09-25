import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP10844 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		final int DIV=1000000000;
		
		long DP[][] = new long[N+1][10];
		DP[1][0] = 0;
		DP[1][1] = 1;
		DP[1][2] = 1;
		DP[1][3] = 1;
		DP[1][4] = 1;
		DP[1][5] = 1;
		DP[1][6] = 1;
		DP[1][7] = 1;
		DP[1][8] = 1;
		DP[1][9] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0) {
					DP[i][0] = DP[i-1][1];
				}else if(j==9) {
					DP[i][9] = DP[i-1][8];
				}else {
					DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1])%DIV;
				}
			}
		}
		
		int count=0;
		
		for(int j=0; j<=9; j++) {
			count += (DP[N][j]);
			count = count%DIV;
		}
		
		System.out.println(count%DIV);
	}

}
