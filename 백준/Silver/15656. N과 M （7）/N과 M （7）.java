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
		// TODO Auto-generated method stub
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums); // 오름차순 정렬
		
		dfs(0);
		
		bw.flush();

	}
	
	// 재귀 함수를 활용한 dfs 
	private static void dfs(int index) throws IOException {
		
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
		
		// 중복 고려X
		for(int i = 0; i < N; i++) {

			list[index] = nums[i];
			dfs(index+1);
		}
	}

}
