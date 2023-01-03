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
	
	public static void main(String[] args) throws IOException {
		// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
		// 1부터 N까지 자연수 중에서 M개를 고른 수열
		// 같은 수를 여러 번 골라도 된다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(0); // dfs 시작
		bw.flush();

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
			return;
		}
	
		// 중복을 고려하지 않기 때문에 15649와 달리 visited 방문여부를 확인하지 않아도 됨
		for(int i = 1; i <= N; i++) {
			
			list[index] = i;
			dfs(index + 1);
		
		}
		
	}

}
