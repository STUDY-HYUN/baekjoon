import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int n;
	private static int[] dp = new int[1001]; // 1~1000
	
	public static void main(String[] args) throws IOException {
		// 2*n 타일링2
		// 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
		// 아래 그림은 2×17 직사각형을 채운 한가지 예이다.\\
		// 입력 : 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
		// 출력 : 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
		
		n = Integer.parseInt(br.readLine());
		
		// n = 1 => 2 * 1 사각형 채우는 방법 1가지
		// n = 2 => 2 * 2 사각형 채우는 방법 3가지
		// n = 3 => 2 * 3 사각형 채우는 방법 5가지
		// n = 4 => 2 * 4 사각형 채우는 방법 11가지
		// n = 5 => 2 * 5 사각형 채우는 방법 21가지
		
		// dp[n] = dp[n-1] + dp[n-2]*2
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			// System.out.println(dp[n] % 10007);으로 출력시 int, long 오버플로우 되기 때문에 dp에 나머지 저장
			dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
		}
		
		System.out.println(dp[n]);

	}

}
