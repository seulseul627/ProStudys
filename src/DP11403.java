import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DP11403 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int i,j, start;
		int map[][] = new int[N+1][N+1];
		int result[][] = new int[N+1][N+1];
		
		String str[];
		for(i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			for(j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(str[j-1]); 
			}
		}
		
		
		
		LinkedList<Integer> lst;
		int now;
		int visited[];
		
		// START
		for(start=1; start<=N; start++) {
			lst  = new LinkedList<Integer>();
			visited = new int[N+1];
			lst.add(start);
			
			while(!lst.isEmpty()) {
				now = lst.pop();
				
				for(i=1; i<=N; i++) {
					if(map[now][i] == 1 && visited[i] == 0){
						lst.add(i);
						result[start][i] = 1;
						visited[i] = 1;
					}
				}
			}
		}
		
		for(i=1; i<=N; i++) {
			for(j=1; j<=N; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
