import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DP1463_3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cost[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		int now;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(N);
		cost[N] = 0;
		
		while(!q.isEmpty()){
			now = q.pop();
			
			// 종료
			if(now == 3 || now == 2) {
				System.out.println(cost[now]+1);
				return;
			}else if(now == 1) {
				System.out.println("0");
				return;
			}
			
			// 나누기 3
			if(now % 3 == 0 && !visited[now/3]){
				cost[now/3] = cost[now] + 1;
				q.add(now/3);
				visited[now/3] = true;
 			}
			
			// 나누기 2
			if(now % 2 == 0 && !visited[now/2]){
				cost[now/2] = cost[now] + 1;
				q.add(now/2);
				visited[now/2] = true;
			}
			// 마이너스 1
			if(!visited[now-1]) {
				cost[now-1] = cost[now] + 1;
				q.add(now-1);
				visited[now-1] = true;
			}
			
		}
	}
}
