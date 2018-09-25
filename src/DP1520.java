import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP1520 {
	public static int W;
	public static int H;
	public static int memo[][];
	public static int arr[][];
	public static int result = 0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[];
		str = br.readLine().split(" ");
		
		W = Integer.parseInt(str[0]);
		H = Integer.parseInt(str[1]);
		
		arr = new int[W][H];
		memo = new int[W][H];
		
		
		int i,j;
		for(i=0; i<W; i++) {
			str = br.readLine().split(" ");
			for(j=0; j<H; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				memo[i][j] = -1;
			}
		}
		
		
		System.out.println(dfs(0,0));
		
	}
	
	public static int dfs(int x, int y) {
		
		// �ַ��
		if(x==W-1 && y==H-1) {
			return 1;
		}
		
		// �޸������̼� ���
		if(memo[x][y] >= 0) {
			return memo[x][y];
		}
		
		// dfs
		memo[x][y] = 0;
		
		// ��
		if(x-1 >= 0 && arr[x-1][y] < arr[x][y]) {
			memo[x][y] += dfs(x-1, y);
		}
		// ��
		if(x+1 < W && arr[x+1][y] < arr[x][y]) {
			memo[x][y] += dfs(x+1, y);
		}
		// ��
		if(y-1 >= 0 && arr[x][y-1] < arr[x][y]) {
			memo[x][y] += dfs(x, y-1);
		}
		// ��
		if(y+1 < H && arr[x][y+1] < arr[x][y]) {
			memo[x][y] += dfs(x, y+1);
		}
		
		return memo[x][y];
	}

}
