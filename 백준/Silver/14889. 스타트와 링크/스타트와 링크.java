import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N;
	private static int[][] stats;
	private static boolean[] match;
	private static List<Integer> start = new ArrayList<>(); // 스타트팀
	private static List<Integer> link = new ArrayList<>(); //링크 팀
	
	private static int minStat = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// 스타트와 링크
		/*
		 * 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 
		 * 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
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
		
		if(count == N/2) {
			for(int i = 0; i < N; i++) {
				// 스타트팀에 매칭되지 않은 인원 링크팀에 매칭
				if(!start.contains(i)) {
					link.add(i);
				}
			}
			
			calculateStat();
			
			return;
		}
		
		for(int i = index; i < N; i++) {
			if(match[i]) continue; // 매치 되었는지 확인
			
			match[i] = true; // 스타트팀에 매칭
			start.add(i); // 스타트팀에 매칭
			
			matchTeam(i, count + 1); // 재귀
			
			start.remove(start.size()-1); // start팀에서 삭제
			match[i] = false;
		}
		
	}
	
	private static void calculateStat() {
		int sumStartStat = 0;
		int sumLinkStat = 0;
		
		for(int i = 0; i < start.size() - 1; i++) {
			for(int j = i + 1; j < start.size(); j++) {
				int member1 = start.get(i); // 스타트팀 멤버1
				int member2 = start.get(j); // 스타트팀 멤버2
				
				sumStartStat += stats[member1][member2] + stats[member2][member1];
			}
		}
		
		for(int i = 0; i < link.size() - 1; i++) {
			for(int j = i + 1; j < link.size(); j++) {
				int member1 = link.get(i); // 링크팀 멤버1
				int member2 = link.get(j); // 링크팀 멤버2
				sumLinkStat += stats[member1][member2] + stats[member2][member1];
			}
		}
		
		minStat = Math.min(minStat, Math.abs(sumStartStat - sumLinkStat)); // 최소 능력치 차이 구하기
		
		link.clear(); // 링크팀 삭제
	}
}
