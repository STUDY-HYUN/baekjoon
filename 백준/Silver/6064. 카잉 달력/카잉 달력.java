import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		/*
		 * 최근에 ICPC 탐사대는 남아메리카의 잉카 제국이 놀라운 문명을 지닌 카잉 제국을 토대로 하여 세워졌다는 사실을 발견했다. 
		 * 카잉 제국의 백성들은 특이한 달력을 사용한 것으로 알려져 있다. 
		 * 그들은 M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현하였다. 
		 * 그들은 이 세상의 시초에 해당하는 첫 번째 해를 <1:1>로 표현하고, 두 번째 해를 <2:2>로 표현하였다.
		 * <x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자. 
		 * 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다. 
		 * 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다. 
		 * <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다. 
		 * 예를 들어, M = 10 이고 N = 12라고 하자. 
		 * 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다. <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다. 
		 * 네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라. */

		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			sb.append(getYear()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static int getYear() throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()) - 1; // 나머지가 0이 되는 경우 방지
		int y = Integer.parseInt(st.nextToken()) - 1; // 나머지가 0이 되는 경우 방지
		
		
		// 최소 공배수를 이용해 종말의 해 구하기
		// 종말의 해 == 최소 공배수(반복문 조건)
		int lastYear = (N * M) / gcd(Math.max(M, N),Math.min(M, N));
		
//		for(int i = 0; i < lastYear; i++) {
//			// year % M = x && year % N = y 여야 함
//			if(i % M == x && i % N == y) return i;
//		}
//		
		for(int i = x; i < lastYear; i += M) { //x를 고정시켜둔 상태로 M만큼 증가시킴
			// year % M = x && year % N = y 여야 함
			if(i % N == y) return i + 1;
			
		}
				
		return -1;
	}
	
	private static int gcd(int num1, int num2) {
		if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
	}

}