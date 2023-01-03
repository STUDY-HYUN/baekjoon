import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int MAX_NUM = 8;
	private static int N, M;
	private static int[] list = new int[MAX_NUM + 1];
	private static boolean[] visited = new boolean[MAX_NUM + 1];
	
	public static void main(String[] args) throws IOException {
		// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
		// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(0); // dfs 시작

	}
	
	// 재귀 함수를 활용한 dfs 
	private static void dfs(int index) throws IOException{
		
		// 인덱스가 M과 동일하면 return
		if(index == M) {
			for(int value : list) {
				if(value != 0) {
					bw.append(value + " ");
				}
			}
			bw.append("\n");
			bw.flush();
			
			return;
		}
	
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true; // 방문했다고 체크 후 들어감
			list[index] = i;
			dfs(index + 1);
			visited[i] = false; // 탈출 후 false
		}
		
	}

}
