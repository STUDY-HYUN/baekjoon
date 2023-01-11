import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int k;
	private static char[] sign;
	private static boolean[] visit = new boolean[10]; // 0 ~ 9까지의 수
	
	private static List<String> resultList = new ArrayList<>(); // 부등호에 해당하는 모든 숫자 
	
	public static void main(String[] args) throws IOException {
		// 부등호
		/*
		 *두 종류의 부등호 기호 ‘<’와 ‘>’가 k개 나열된 순서열 A가 있다. 우리는 이 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다. 
		 *예를 들어, 제시된 부등호 순서열 A가 다음과 같다고 하자.  
		 *A ⇒ < < < > < < > < >
		 *부등호 기호 앞뒤에 넣을 수 있는 숫자는 0부터 9까지의 정수이며 선택된 숫자는 모두 달라야 한다. 아래는 부등호 순서열 A를 만족시키는 한 예이다. 
		 * 3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0
		 *이 상황에서 부등호 기호를 제거한 뒤, 숫자를 모두 붙이면 하나의 수를 만들 수 있는데 이 수를 주어진 부등호 관계를 만족시키는 정수라고 한다. 
		 *그런데 주어진 부등호 관계를 만족하는 정수는 하나 이상 존재한다. 예를 들어 3456128790 뿐만 아니라 5689023174도 아래와 같이 부등호 관계 A를 만족시킨다. 
		 * 5 < 6 < 8 < 9 > 0 < 2 < 3 > 1 < 7 > 4
		 * 여러분은 제시된 k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값을 찾아야 한다. 
		 * 앞서 설명한 대로 각 부등호의 앞뒤에 들어가는 숫자는 { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }중에서 선택해야 하며 선택된 숫자는 모두 달라야 한다. 
		 **/
		
		k = Integer.parseInt(br.readLine()); // 부등호 개수
		sign = new char[k]; // 부등호
		
		st = new StringTokenizer(br.readLine());
		
		// 부등호 입력
		for(int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		// 해당되는 숫자순서를 넘겨주기 위해 ""로 숫자를 넣어줌
		dfs(0,"");
		
		resultList.sort(null); // 오름차순으로 정렬
		

		
		// 출력시 제일 첫번째 숫자가 제일 큰것, 제일 작은 것
		System.out.println(resultList.get(resultList.size()-1)); // 제일 큰 값으로 해당하는 것
		System.out.println(resultList.get(0)); // 제일 작은 값 출력
		
	}
	
	private static void dfs(int index, String numbers) {
		
		// 부등호 개수보다 숫자 개수가 1개 더 필요하기 때문
		if(index == k + 1) {
			resultList.add(numbers);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(visit[i]) continue;
			
			// or연산이기 때문에 check는 index가 0이 아닌 경우 검사
			// 부등호가 k개 존재시 0~k-1까지
			if(index == 0 || check(index-1, i, numbers)) { 
				visit[i] = true;
				dfs(index+1, numbers + Integer.toString(i)); // i를 추가
				visit[i] = false;
			}
			
		}
	}
	
	private static boolean check(int index, int number, String numbers) {
		
		char currentSign = sign[index];
		
		if(currentSign == '>') 
			return numbers.charAt(numbers.length() - 1) - '0' > number; // char -> int로 형변환
        return numbers.charAt(numbers.length() - 1) - '0' < number;
		
	}

}
