import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N;
	private static int[][] stats;
	private static boolean[] match;

	private static int minStat = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// 링크와 스타트
		/*
		 * 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 
		 * 축구를 하기 위해 모인 사람은 총 N명이다. 이제 스타트 팀과 링크 팀으로 사람들을 나눠야 한다. 두 팀의 인원수는 같지 않아도 되지만, 한 명 이상이어야 한다.
		 * BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 
		 * 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
		 * Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
		 * N=4이고, S가 아래와 같은 경우를 살펴보자.*/
		
		N = Integer.parseInt(br.readLine());
		stats = new int[N][N];
		match = new boolean[N]; // 팀 매칭 여부
		
		// 능력치 입력
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				stats[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		matchTeam(0,0);
		System.out.println(minStat);
		
	}
	
	private static void matchTeam(int index, int count) {
		
		// 한팀에 한명이라도 존재해야하기 때문
		if(count == N-1) {
			return;
		}
		
		for(int i = index; i < N; i++) {

			match[i] = true; // 스타트팀에 매칭
			calculateStat(); // 계산
			matchTeam(i + 1, count + 1); // 재귀
			match[i] = false;
		}
		
	}
	
	private static void calculateStat() {
		int sumStartStat = 0;
		int sumLinkStat = 0;
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(match[i] && match[j]) {
					sumStartStat += stats[i][j] + stats[j][i];
				} 
				
				if((!match[i]) && (!match[j])) {
					sumLinkStat += stats[i][j] + stats[j][i];
				}
			}
		}
		
		minStat = Math.min(minStat, Math.abs(sumStartStat - sumLinkStat)); // 최소 능력치 차이 구하기

	}
}
