import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int MAX_NUM = 10; // n은 양수이고 11보다 작음
	private static int[] dp = new int[MAX_NUM + 1]; // 0부터 시작
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		// 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
		// 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
		
		int T = Integer.parseInt(br.readLine()); // test case 개수
		
		dp[1] = 1; // n이 1일 때 경우의 수 1
		dp[2] = 2; // n이 2일 때 경우의 수 2
		dp[3] = 4; // n이 3일 때 경우의 수 4
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			solution(n);
		}
		
		System.out.println(sb);
	}
	
	// n = 1
	// 1
	
	// n = 2
	// 1 + 1
	// 2
	
	// n = 3
	// 1 + 1 + 1
	// 1 + 2
	// 2 + 1
	// 3
	
	// n = 4
	// 1 + 1 + 1 + 1
	// 1 + 2 + 1
	// 2 + 1 + 1
	// 3 + 1
	// 1 + 1 + 2
	// 2 + 2
	// 1 + 3
	
	// 다이나믹 프로그래밍 사용
	private static void solution(int n) {
		
		for(int i = 4; i <= n; i++) {
			//  1 2 3으로만 이루어지기 때문에 3번째 전까지의 경우의 수를 합산한 결과와 동일
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		
		sb.append(dp[n] + "\n");
	}

}
