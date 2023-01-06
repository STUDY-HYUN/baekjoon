import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N, M, K;
	private static int[][] map;
	private static int[][] adjoin;
	private static int[] list;
	private static int maxResult = -40000; //격자판에 들어갈 수 있는 수 중 제일 작은 수는 -10000

	public static void main(String[] args) throws IOException {
		// 크기가 N×M인 격자판의 각 칸에 정수가 하나씩 들어있다. 이 격자판에서 칸 K개를 선택할 것이고, 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하려고 한다. 
		// 단, 선택한 두 칸이 인접하면 안된다. r행 c열에 있는 칸을 (r, c)라고 했을 때, (r-1, c), (r+1, c), (r, c-1), (r, c+1)에 있는 칸이 인접한 칸이다.
		/*
		 * 1 ≤ N, M ≤ 10
		 * 1 ≤ K ≤ min(4, N×M)
		 * 격자판에 들어있는 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
		 * 항상 K개의 칸을 선택할 수 있는 경우만 입력으로 주어진다.*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		adjoin = new int[N][M];
		list = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(maxResult);
		
	}
	
	private static void dfs(int index) {
		
		if(index == K) {
			int sum = 0;

			for(int value : list) {
				sum += value;
			}
			
			maxResult = Math.max(maxResult, sum);
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(adjoin[i][j] > 0) continue; // 인접하는 경우 넘어감
				
				adjoinCheck(i, j); // 인접하지 않은 경우 해당 좌표 인접하는 구간 체크
				
				list[index] = map[i][j];
				dfs(index+1); // 재귀 호출
				
				initAdjoinCheck(i, j); // 탈출 => 인접하는 곳 체크 해제
			}
		}
	}
	
	// 인접 체크
	private static void adjoinCheck(int i, int j) {
		
		adjoin[i][j]++;
		
		// 왼쪽이 있는 경우
		if(i - 1 >= 0) {
			adjoin[i-1][j]++;
		}
		
		// 오른쪽이 있는 경우
		if(i + 1 < N) {
			adjoin[i+1][j]++;
		}
		
		//위가 있는 경우
		if(j - 1 >= 0) {
			adjoin[i][j-1]++;
		}
		
		// 아래가 있는 경우
		if(j + 1 < M) {
			adjoin[i][j+1]++;
		}
	}
	
	// 인접 체크 해제 
	// boolean타입으로 하니 방문 중복된 곳을 해제하는 경우도 생겨서 문제 발생
	private static void initAdjoinCheck(int i, int j) {
		
		adjoin[i][j]--;
		
		if(i - 1 >= 0) {
			adjoin[i-1][j]--;
		}
		
		if(i + 1 < N) {
			adjoin[i+1][j]--;
		}
		
		if(j - 1 >= 0) {
			adjoin[i][j-1]--;
		}
		
		if(j + 1 < M) {
			adjoin[i][j+1]--;
		}
	}
	

}
