import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int MAX_NUM = 1000000;
	private static boolean[] prime = new boolean[MAX_NUM + 1];
	
	public static void main(String[] args) throws IOException{
		/*
		 * 1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
		 * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
		 * 예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 
		 * 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
		 * 이 추측은 아직도 해결되지 않은 문제이다.
		 * 백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.*/
		
		initPrime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n;
		boolean isTrue = false;
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			for(int i = 0; i <= n/2; i++) {
				if(prime[i] && prime[n-i]) {
					sb.append(n)
					.append(" = ")
					.append(i)
					.append(" + ")
					.append(n-i)
					.append("\n");
					
					isTrue = true;
					
					break;
				}
			}
			
			if(!isTrue) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
		
		System.out.println(sb);

	}
	
	private static void initPrime() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false; // 소수는 true
		
		for(int i = 2; i <= MAX_NUM; i++) {
			for(int j = 2; i * j <= MAX_NUM; j++) {
				prime[i * j] = false;
			}
		}
	}
}
