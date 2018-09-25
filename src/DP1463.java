import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP1463 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cost[][] = new int[N+1][2];
		
		int i,j, idx;
		boolean chk = true;
		int now;
		
		for(i=1; i<=N; i++){
			cost[i][1] = -1;
		}
		cost[N][0] = 0;
		cost[N][1] = 1;
		
		now = N;
		idx = N;
		
		//print(cost, N);
		
		if(now == 1){
			System.out.println("0");
		}
		
		while(chk){
			// 나누기 3
			if(now % 3 == 0 && now / 3 >= 1){
				if(now/3 == 1){
					System.out.println(cost[now][0]+1);
					break;
				}
				
				cost[now/3][0] = cost[now][0] + 1;
				cost[now/3][1] = 0;
 			}
			// 나누기 2
			if(now % 2 == 0 && now / 2 >= 1){
				if(now/2 == 1){
					System.out.println(cost[now][0]+1);
					break;
				}
				cost[now/2][0] = cost[now][0] + 1;
				cost[now/2][1] = 0;
			}
			// 마이너스 1
			if(now - 1 >= 1){
				if(now == 2){
					System.out.println(cost[now][0]+1);
					break;
				}
				cost[now-1][0] = cost[now][0] + 1;
				cost[now-1][1] = 0;
			}
			
			//print(cost, N);
			
			if(now == N){
				now = 0;
			}
			
			chk=false;
			for(i=now+1; i!=now; i++,i=i%N){
				if(cost[i][1] == 0){
					now = i;
					cost[now][1] = 1;
					//System.out.println(now+"선택");
					chk = true;
					break;
				}
			}
		}
	}
	
	public static void print(int arr[][], int n){
		for(int i=1; i<=n; i++){
			System.out.print(arr[i][0]+" ");
		}
		System.out.println();
		for(int i=1; i<=n; i++){
			System.out.print(arr[i][1]+" ");
		}
		System.out.println();
	}

}
