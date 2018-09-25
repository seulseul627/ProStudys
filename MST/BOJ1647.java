import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1647 {

	static int[] parents;
	
	static class Edge{
		int v1;
		int v2;
		int w;
		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
	
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		Edge[] eList = new Edge[E];
		int v1, v2, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			eList[i] = new Edge(v1, v2, w);
		}
		
		//- �غ�
		// ������ ����ġ �������� �������� �����Ѵ�.
		Arrays.sort(eList, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.w - e2.w;
			}
		});
		
		// ��� ���� �ϳ��� Ʈ���� �����Ѵ�. (Union & Find ��� ���)
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		//- ����
		int selectedEdge = 0;
		int cost = 0;
		
		// ����ġ�� ���� �������� �ϳ��� ����.
		for(Edge e : eList) {
			if( !isCycle(e) ) {
				// �ش� ������ �׷����� �߰��� �� ����Ŭ�� ������ �ʴ´ٸ� �ش� ������ �׷����� �߰��Ѵ�.
				addEdge(e);
				cost += e.w;
				selectedEdge++;
			}
			
			if( selectedEdge == N-2) {
				break;
			}
		}
		
		System.out.println(cost);
	}
	
	public static void addEdge(Edge e) {
		int v1Root = findRoot(e.v1);
		int v2Root = findRoot(e.v2);
		
		parents[v1Root] = v2Root;
	}
	
	public static boolean isCycle(Edge e) {
		return findRoot(e.v1) == findRoot(e.v2) ? true : false;
	}
	
	public static int findRoot(int v) {
		if( parents[v] == v ) return v;
		
		parents[v] = findRoot(parents[v]);
		return parents[v];
	}

}
