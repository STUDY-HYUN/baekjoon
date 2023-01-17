import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N;
	private static int[] A;
	private static boolean[] visit;
	
	private static int distance = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	
		// 이전 배열을 함께 넘겨주어야 함
		dfs(0,0,0);
		
		System.out.println(distance);
	}
	
	private static void dfs(int index, int bf ,int currentDis) {
		if(index == N) {
			distance = Math.max(distance, currentDis);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			
			// index가 0인경우 A[-1] - A[0] 이 존재하지 않기 때문에 0을 currentDis로 넘겨줌
			dfs(index+1, A[i], index == 0? 0 : currentDis + Math.abs(bf - A[i]));
			visit[i] = false;
		}
	}

}
