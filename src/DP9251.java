import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DP9251 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		char tmp1[] = s1.toCharArray();
		char tmp2[] = s2.toCharArray();

		int len1 = tmp1.length;
		int len2 = tmp2.length;
		
		char str1[] = new char[len1+1];
		char str2[] = new char[len2+1];
		
		System.arraycopy(tmp1, 0, str1, 1, tmp1.length);
		System.arraycopy(tmp2, 0, str2, 1, tmp2.length);
		
		int i,j;
		int DP[][] = new int[len1+1][len2+1];

		for(i=1; i<=len1; i++) {
			for(j=1; j<=len2; j++) {
				if(str1[i] == str2[j]) {
					DP[i][j] = DP[i-1][j-1]+1;
				}else {
					DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
				}
			}
		}
		
		System.out.println(DP[len1][len2]);
	}

}
