import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1로 만들기
        /*
         * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
         * X가 3으로 나누어 떨어지면, 3으로 나눈다.
         * X가 2로 나누어 떨어지면, 2로 나눈다.
         * 1을 뺀다.
         * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
         * 연산을 사용하는 횟수의 최솟값을 출력하시오
         */
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N + 1];
        
        //1인 경우 0을 리턴해주기 위해
        dp[0] = dp[1] = 0;

        //bottom-up 방식 사용
        for (int i = 2; i <= N; i++) {
        	// 큰수부터 나누는 경우부터 시작할 경우 오히려 더 많은 횟수를 사용하기도 함
        	// 예) 10 = 10/2 => 5 - 1 => 4 / 2 => 2 / 2 = 1 (횟수 4)
        	//    10 = 10 - 1 => 9 / 3 => 3 / 3 = 1 (횟수 3)
            // -1 연산이 가장 적은 횟수다 라는 가정
            dp[i] = dp[i - 1] + 1; // 먼저 1을 빼줌
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1을 뺀 값과 2로 나눈 값 중 최솟값을 dp[i]에 저장
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 1을 뺀 값과 2로 나눈 값 중 최소값인 dp[i] 와 3으로 나눈 값 중 최솟값을 dp[i]에 저장
        }

        System.out.println(dp[N]);
    }
}