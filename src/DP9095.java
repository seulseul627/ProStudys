import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP9095 {

	static int cacheN = 0;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int cache[] = new int[12];
		int N;
		
		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 4;
		
		cacheN = 3;
				
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			int i;
			
			if(N > cacheN) {
				for(i=cacheN+1; i<=N; i++) {
					cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
					cacheN++;
				}
			}
			
			System.out.println(cache[N]);
		}
	}

}
