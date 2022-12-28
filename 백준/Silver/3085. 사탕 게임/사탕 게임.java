import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static char[][] bomboni;
	private static int N;
	public static void main(String[] args) throws IOException {
		/*
		 * 상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
		 * 가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 
		 * 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
		 *  이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
		 *  사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.*/
		
		/*
		 * 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
		 * 다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
		 * 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.*/
		
		
		// 가로 세로만 해당 대각선은 해당X

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		bomboni = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			bomboni[i] = br.readLine().toCharArray();
		}
		
		solution();
		
		
	}
	
	
	private static int check() {
		
		int maxCnt = 0;
		
		//가로 체크
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N-1; j++) {
				if(bomboni[i][j] == bomboni[i][j+1]) {
					cnt++;
				}else {
					cnt = 1;
				}
				
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		
		//세로 체크
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			for(int j = 0; j < N-1; j++) {
				if(bomboni[j][i] == bomboni[j+1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		return maxCnt;
	}
	
	private static void solution() {
		
		int max = 0;
		
		//가로 swap check
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) {
				char temp = bomboni[i][j];
				bomboni[i][j] = bomboni[i][j+1];
				bomboni[i][j+1] = temp;
				
				max = Math.max(max, check());
				
				bomboni[i][j+1] = bomboni[i][j];
				bomboni[i][j] = temp;
			}
		}
		
		//세로 swap check;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) {
				char temp = bomboni[j][i];
				bomboni[j][i] = bomboni[j+1][i];
				bomboni[j+1][i] = temp;
				
				max = Math.max(max, check());
				
				bomboni[j+1][i] = bomboni[j][i];
				bomboni[j][i] = temp;
			}
		}
		
		System.out.println(max);
	}

}
