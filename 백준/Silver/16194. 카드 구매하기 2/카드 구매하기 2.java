import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N;
	private static int[] P;
	private static int[] dp; // n개의 카드팩을 사기 위한 최소 비용

	public static void main(String[] args) throws IOException {
		// 카드 구매하기2
		/*
		 * 카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.
		 * 민규는 지난주에 너무 많은 돈을 써 버렸다. 그래서 오늘은 돈을 최소로 지불해서 카드 N개를 구매하려고 한다. 카드가 i개 포함된 카드팩의 가격은 Pi원이다.
		 * 예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최솟값은 4원이다. 
		 * 1개 들어있는 카드팩을 4번 사면 된다.
		 * P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 카드가 2개 들어있는 카드팩을 2번 사면 4원이고, 이 경우가 민규가 지불해야 하는 금액의 최솟값이다.
		 * 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최솟값을 구하는 프로그램을 작성하시오. 
		 * N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다. 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.*/
		
		N = Integer.parseInt(br.readLine());
		P = new int[N+1];
		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		// 카드 1개 카드팩 구매 => 카드 i-1개 구매
		// 카드 2개 카드팩 구매 => 카드 i-2개 구매
		// 카드 3개 카드팩 구매 => 카드 i-3개 구매
		// 장수가 줄어듦
		// dp[i] = P[n] + dp[i-n] 
		for(int i = 1; i <= N; i++) {
			dp[i] = P[i]; // 초기화
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + P[j]); // 최댓값 연산
			}
		}
		
		System.out.println(dp[N]);
		
	}

}