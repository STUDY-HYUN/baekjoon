import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int N;
	private static boolean[] visit;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		// 모든 순열
		// N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		arr = new int[N];
		
		dfs(0);
		bw.flush();
		bw.close();
		br.close();

	}
	
	private static void dfs(int index) throws IOException {
		if(index == N) {
			for(int value : arr) {
					bw.append(value + " ");	
			}
			bw.append("\n");
			return;
		}
		
		// 1 ~ N까지의 순열
		for(int i = 1; i <= N; i++) {
			if(visit[i-1]) continue;
			
			visit[i-1] = true; // 1 ~ N까지의 순열 -> 방문 여부 크기 N -> 0 ~ N-1까지 존재
			arr[index] = i;
			dfs(index + 1);
			visit[i-1] = false;
		}
	}

}
