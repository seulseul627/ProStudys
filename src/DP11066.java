import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP11066 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N, file[], DP[][], fileSum[][];
		String str[];
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(N);
			file = new int[N+1];
			
			str = br.readLine().split(" ");
			for(int i=1; i<=N; i++) {
				file[i] = Integer.parseInt(str[i-1]);
				System.out.print(file[i] +" ");
			}
			System.out.println();
			
			DP = new int[N+1][N+1];
			fileSum = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				DP[i][i] = 0;
				fileSum[i][i] = file[i];
			}
			
			for(int i=1; i<=N-1; i++) {
				DP[i][i+1] = fileSum[i][i] + fileSum[i+1][i+1];
				fileSum[i][i+1] = fileSum[i][i] + fileSum[i+1][i+1];
				System.out.println("DP["+i+"]["+(i+1)+"] = "+DP[i][i+1]);
			}
			
		}
	}

}
