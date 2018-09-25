import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DP1005 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int time[];	// 건설 시간
		boolean map[][];
		int cost[];
		
		int i,j, now;
		int max;
		
		int N, K, Dest;
		String str[];
		
		for(int t=1; t<=T; t++) {
			str = br.readLine().split(" ");
			
			N = Integer.parseInt(str[0]);	// 건물개수
			K = Integer.parseInt(str[1]);	// 규칙개수
			
			str = br.readLine().split(" ");
			time = new int[N+1];
			for(i=1; i<=N; i++) {
				time[i] = Integer.parseInt(str[i-1]);
			}
			
			map = new boolean[N+1][N+1];
			cost = new int[N+1];
			
			for(i=1; i<=K; i++) {
				str = br.readLine().split(" ");
				map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = true;
			}
			
			Dest = Integer.parseInt(br.readLine());

			/* START */	
			max = 0;
			LinkedList<Integer> q = new LinkedList<Integer>();
			q.add(Dest);
			cost[Dest] = time[Dest];
			
			while(!q.isEmpty()) {
				now = q.pop();
				
				for(i=1; i<=N; i++) {
					if(map[i][now]) {
						if(cost[i] < cost[now] + time[i]) {
							q.add(i);
							cost[i] = cost[now] + time[i];
							max = Math.max(max, cost[i]);
						}
					}
				}				
			}
			
			//Arrays.sort(cost);
			System.out.println(max);
		}

	}

}
