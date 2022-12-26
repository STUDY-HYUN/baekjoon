import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static boolean prime[] = new boolean[1001]; // N개의 수는 1000 이하의 자연수
	
	public static void main(String[] args) throws IOException {
		// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
		// 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
		initPrime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		while(N-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			if(prime[num]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	private static void initPrime() {
		Arrays.fill(prime, true);
		
		//소수는 true
		prime[0] = prime[1] = false;
		
		for(int i = 2; i <= 1000; i++) {
			for(int j = 2; j * i <= 1000; j++) {
				prime[i*j] = false;
			}
		}
	}

}
