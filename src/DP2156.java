import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP2156 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int i;
		int juice[] = new int[N+1];
		for(i=1; i<=N; i++) {
			juice[i] = Integer.parseInt(br.readLine());
		}
		
		int DP[][] = new int[N+1][3];
		
		//START
		
		DP[1][0] = 0;			// 안마시는 경우
		DP[1][1] = juice[1];	// 마시는 경우
		DP[1][2] = 0;			// 두잔 연속인 경우 (X)
		
		for(i=2; i<=N; i++) {
			DP[i][0] = Math.max(Math.max(DP[i-1][0], DP[i-1][1]), DP[i-1][2]);
			DP[i][1] = DP[i-1][0] + juice[i];
			DP[i][2] = DP[i-1][1] + juice[i];
		}
		
		System.out.println(Math.max(Math.max(DP[N][0], DP[N][1]), DP[N][2]));
	}

}
