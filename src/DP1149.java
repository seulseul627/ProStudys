import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP1149 {
	static final int R=0;
	static final int G=1;
	static final int B=2;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N+1][3];	// [집 넘버][RGB]
		int[][] DP = new int[N+1][3];
		
		int i;
		String[] str;
		for(i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			RGB[i][R] = Integer.parseInt(str[0]);
			RGB[i][G] = Integer.parseInt(str[1]);
			RGB[i][B] = Integer.parseInt(str[2]);
		}
		
		// 시작
		DP[1][R] = RGB[1][R];
		DP[1][G] = RGB[1][G];
		DP[1][B] = RGB[1][B];
		
		for(i=2; i<=N; i++) {
			DP[i][R] = Math.min(DP[i-1][G], DP[i-1][B]) + RGB[i][R];
			DP[i][G] = Math.min(DP[i-1][R], DP[i-1][B]) + RGB[i][G];
			DP[i][B] = Math.min(DP[i-1][R], DP[i-1][G]) + RGB[i][B];
		}
		
		System.out.println(Math.min(Math.min(DP[N][R], DP[N][G]), DP[N][B]));
	}

}
