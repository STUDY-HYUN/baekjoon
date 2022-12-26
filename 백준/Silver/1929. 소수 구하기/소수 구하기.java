import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static boolean[] prime = new boolean[1000001];

	public static void main(String[] args) throws IOException{
		// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
		// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

		initPrime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer bs = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = M; i <=N; i++) {
			if(prime[i]) {
				bs.append(i + "\n");
			}
		}
		
		System.out.println(bs);
		
	}
	
	private static void initPrime() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false; // 0과 1은 소수가 아니기 때문에 false 소수 = true
	
		for(int i = 2; i <= 1000000; i++) {
			for(int j = 2; i * j <= 1000000; j++) {
				prime[i*j] = false;
			}
		}
	}
}
