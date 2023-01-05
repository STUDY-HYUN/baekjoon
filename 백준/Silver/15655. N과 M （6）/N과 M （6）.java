import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int MAX_NUM = 8;
	private static int N, M;
	private static int[] list = new int[MAX_NUM + 1];
	private static int[] nums;	
	
	public static void main(String[] args) throws IOException {
		//N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
		// N개의 자연수 중에서 M개를 고른 수열
		// 고른 수열은 오름차순이어야 한다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums); // 오름차순 정렬
		
		dfs(0,0);
		
		bw.flush();

	}
	
	// 재귀 함수를 활용한 dfs 
	private static void dfs(int start, int index) throws IOException {
		
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
		
		// 중복 고려, 같은 수 같은 라인 출력 X
		for(int i = start; i < N; i++) {

			list[index] = nums[i];
			dfs(i+1, index+1);
		}
	}

}