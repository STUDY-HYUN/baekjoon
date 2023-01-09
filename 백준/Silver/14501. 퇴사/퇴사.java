import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N; // 퇴사 남은 기간
	private static int maxRevenue = 0; // 최대 수익
	
	private static int[] T; // 걸리는 일수
	private static int[] P; // 금액

	public static void main(String[] args) throws IOException {
		/*
		 * 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
		 * 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
		 * 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
		 * 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
		 * N = 7인 경우에 다음과 같은 상담 일정표를 보자.
		 * 1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
		 * 상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 
		 * 예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
		 * 또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
		 * 퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
		 * 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.*/ 
		
		N = Integer.parseInt(br.readLine()); //퇴사 남은 일수 입력
		
		T = new int[N];
		P = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0); // 상담 최대 수익 확인
		
		System.out.println(maxRevenue);
		
	}
	
	private static void dfs(int index, int pay) {
		
		// N보다 크거나 같은 경우 pay와 최대수익을 비교
		if(index >= N) {
			maxRevenue = Math.max(maxRevenue, pay);
			return;
		}
		
		if(index + T[index] <= N) {
			// 상담 진행
			dfs(index + T[index], pay + P[index]); // 소요일 합산 시 N보다 작거나 같은 경우 pay를 합산해줌
		} 
		
		dfs(index+1, pay); // 당일 상담 안함
	}

}
