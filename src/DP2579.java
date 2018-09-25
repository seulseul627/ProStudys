import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP2579 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int score[] = new int[N+1];
		int DP[][] = new int[N+1][2];
		
		int i;
		for(i=1; i<=N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		/* START */
		
		if(N>=2) {
			DP[1][0] = score[1];
			DP[1][1] = 0;
			
			DP[2][0] = score[2];
			DP[2][1] = score[1]+score[2];
		}
		
		
		for(i = 3; i<=N; i++) {	
			DP[i][1] = DP[i-1][0] + score[i];
			DP[i][0] = Math.max(DP[i-2][0], DP[i-2][1]) + score[i];
		}
		
		System.out.println(Math.max(DP[N][0], DP[N][1]));
	}

}
