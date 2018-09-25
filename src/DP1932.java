import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str[];
		
		int arr[][] = new int[N+1][N+1];
		//int calc[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			
			for(int j=1; j<=i; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		for(int row=2; row<=N; row++) {
			for(int j=1; j<=row; j++) {

				// 첫번째 값 일때
				if(j==1) {
					arr[row][j] += arr[row-1][j];
				}
				// 마지막 값 일때
				else if(j==row) {
					arr[row][j] += arr[row-1][j-1];
				}else {
					arr[row][j] += Math.max(arr[row-1][j-1], arr[row-1][j]);
				}
			}
		}
		
		int max = arr[N][1];
		for(int i=2; i<=N; i++) {
			max = Math.max(max, arr[N][i]);
		}
		
		System.out.println(max);
		
	}

}
