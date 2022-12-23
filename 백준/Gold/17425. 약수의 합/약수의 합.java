import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int MAX_NUM = 1000001; // 조건 1 ~ 1000000
	private static long[] fn = new long[MAX_NUM];
	private static long[] gn = new long[MAX_NUM];
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException{
		
		// 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다. 
		// 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다. 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다. 
		// x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
		// 자연수 N이 주어졌을 때, g(N)을 구해보자.
		
		// 100000까지의 최악의 경우까지 계산 
		getGN();
		printGN();
		
	}
	
	private static void getGN() {
	
		Arrays.fill(fn, 1L); //1은 모든 수가 갖는 약수
		gn[0] = 0L;
		gn[1] = 1L;
		
		// 2 ~ n까지 약수를 갖는 모든 수
		for(int i = 2; i < MAX_NUM; i++) {
			//j는 i * j만큼 반복 -> 배수의 성질을 이용하기 때문
			for(int j = 1; i * j < MAX_NUM; j++) {
				fn[i*j] += i; //배수의 성질을 이용해 모든 약수를 더해줌
			}
			
			gn[i] = gn[i-1] + fn[i]; // g(n) = g(n-1) + f(n) -> g(2) = g(1) + f(2)
		}
	}
	
	private static void printGN() throws IOException {
		int T = Integer.parseInt(br.readLine()); // 입력 조건 횟수 T
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(gn[N] + "\n");
		}
		
		System.out.println(sb);
	}
	
	
}