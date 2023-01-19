import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static int S, N;
	private static int[] arr;
	
	private static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// 부분 수열의 합
		/*
		 * N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오. */
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		// S가 0인경우 시작이 0이기 때문에 전체 index가 해당하지 않는 경우도 count를 증가시키기에 -1 해줌
		if(S==0) System.out.println(count - 1);
		else System.out.println(count);
	}
	
	private static void dfs(int index, int sum) {
		if(index == N) {
			if(sum == S) {
				count++;
			}
			return;
		}
		dfs(index+1, sum + arr[index]); // 더한 경우
		dfs(index+1, sum); // 더하지 않은 경우
	}

}
