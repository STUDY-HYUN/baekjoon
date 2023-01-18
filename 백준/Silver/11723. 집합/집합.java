import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringTokenizer st;
	
	private static Set<Integer> S = new HashSet<>();
	
	private static int M;
	public static void main(String[] args) throws IOException {
		// 집합
		/*비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
		 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다
		 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
		 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
		 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
		 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
		 * empty: S를 공집합으로 바꾼다. 
		 * */
		
		M = Integer.parseInt(br.readLine());
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			String operators = st.nextToken();
			
			if(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				operation(operators, x);
			} else {
				operation(operators);
			}
		
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void operation(String operators, int x) throws IOException {
		
		switch(operators) {
			case "add" : 
				S.add(x);
				break;
			case "remove" : 
				S.remove(x);
				break;
			case "check" :
				if(S.contains(x)) {
					bw.append(1 + "\n");
				} else {
					bw.append(0 + "\n");
				}
				break;
			case "toggle" :
				if(S.contains(x)) {
					S.remove(x);
				} else { 
					S.add(x);
				}
				break;
			default :
				break;
		}
	}
	
	private static void operation(String operators) {
		
		switch(operators) {
			case "all" : 
				for(int i = 1; i <= 20; i++) {
					S.add(i);
				}
				break;
			case "empty" :
				S.clear();
				break;
			}
	}

}
