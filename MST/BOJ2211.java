import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2211 {
	
	static int N, E;
	static ArrayList<Node>[] list;
	
	static int START = 1;
	static int d[];
	
	static class Node{
		int v;
		int w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	
	static Comparator minHeap = new Comparator<Node>() {
		@Override
		public int compare(Node a, Node b) {
			return a.w - b.w;
		}
	};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		/* INPUT */
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		int v1, v2, w;
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			// 양방향 노선
			list[v1].add(new Node(v2, w));
			list[v2].add(new Node(v1, w));
		}
		
		/* 다익스트라 */
		dijkstra();  
		System.out.println(Arrays.toString(d));
		
		
		/* 프림 알고리즘 */
		Queue<Integer> q = new LinkedList<Integer>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(minHeap);
		
		
		
		
	}
	
	
	// 목적 : 최단거리를 저장하고 있는 d 배열 값 구하기
	public static void dijkstra() {
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[START] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(minHeap);
		
		pq.add(new Node(START, d[START]));
		
		Node n;
		while( !pq.isEmpty() ) {
			n = pq.poll();
			
			if( n.w != d[n.v] ) {
				continue;
			}
			
			for( Node nxt : list[n.v] ) {
				if( nxt.w + d[n.v] < d[nxt.v] ) {
					d[nxt.v] = nxt.w + d[n.v];
					pq.add(new Node(nxt.v, d[nxt.v]));
				}
			}
			
		}
	}
}
