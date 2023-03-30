import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int n;
	
	public static void main(String[] args) throws IOException {
		/* 2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오. */
		String input;
		// 정수 입력
		while ((input = br.readLine()) != null) {
			n = Integer.parseInt(input);
			
			int digit = 1;
			long num = 1;
			
			while(num % n != 0) {
				num = ((num * 10) + 1)%n;
				digit++;
			}
		
			System.out.println(digit);
		}
		
		br.close();
	}

}