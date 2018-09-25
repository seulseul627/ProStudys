import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP1463_2 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] DP;
		if(N <= 3) {
			DP = new int[4];
		}else {
			DP = new int[N+1];
		}
		DP[1] = 0;
		DP[2] = 1;
		DP[3] = 1;
		
		for(int i=4; i<=N; i++) {
			DP[i] = DP[i-1] + 1;
			if(i % 3 == 0) {
				DP[i] = Math.min(DP[i], DP[i/3]+1);
			}
			if(i % 2 == 0) {
				DP[i] = Math.min(DP[i], DP[i/2]+1);
			}
		}
		
		System.out.println(DP[N]);
		
	}

}
