import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int N; // 가로
    private static int M; // 세로
    private static int[][] paper; // 종이
    
    private static int dx[] = {0, 0, 1, -1}; // 상하
    private static int dy[] = {-1, 1, 0, 0}; // 좌우
    
    // ㅗ 모양 영역 탐색 지정
    private static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}}; // ㅜ ㅏ ㅗ ㅓ 상하 좌표
    private static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}}; // ㅜ ㅏ ㅗ ㅓ 좌우 좌표
    
    private static int maxCount = 0;
    
    private static boolean[][] visited;
	    
	public static void main(String[] args) throws IOException {
		/*
		 * 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.
		 * 정사각형은 서로 겹치면 안 된다.
		 * 도형은 모두 연결되어 있어야 한다.
		 * 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
		 * 정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
		 * 아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
		 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
		 * 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		
		// paper 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		// 전체 탐색
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				visited[i][j] = true; 
				dfs(i, j, 1, paper[i][j]); // ㅗ를 제외한 도형 깊이 탐색
				visited[i][j] = false; 
				
				// ㅗ 도형 탐색
				checkExshape(i, j);
			}
		}
		
		System.out.println(maxCount);

	}
	
	// 회전 대칭이 가능 == 깊이 우선 탐색 사용 가능
	// ㅣ ㄴ ㄹ ㅁ 형태는 깊이 우선 탐색으로 탐색 가능(상하 좌우 탐색)
	// ㅜ 는 상하좌우 탐색으로는 탐색할 수 없음
	// 깊이우선 탐색
	private static void dfs(int x, int y, int length, int sum) {
		
		if(length == 4) {
			maxCount = Math.max(maxCount, sum);
			return;
		}
		
		// 현 위치에서 상하좌우 탐색
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
	        int ny = y + dy[i];

	        // 종이 영역을 넘어가는 지 확인
            if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
            
            // 방문하지 않은 경우
            if(visited[nx][ny] == false) {
            	
            	//탐색했다고 체크
            	visited[nx][ny] = true;
            	
            	//ㅗ형태를 제외한 나머지 도형 탐색
            	dfs(nx, ny, length+1, sum + paper[nx][ny]);
            	
            	//탐색 완료 시 false
            	visited[nx][ny] = false;
            	
            }
	    }
	}
	
	// ㅗ 도형 탐색
	private static void checkExshape(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int sum = 0;
			boolean isOut = false;
			
			for(int j = 0; j < 4; j++) {
				int nx = x + ex[i][j];
				int ny = y + ey[i][j];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
					isOut = true;
					continue;
				}
				
				sum += paper[nx][ny];
			}
			
			if(!isOut) maxCount = Math.max(maxCount, sum);
		}
	}
}