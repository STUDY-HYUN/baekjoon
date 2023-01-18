import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringTokenizer st;
	
	private static int k;
	private static int[] S;
	private static boolean[] visit;
	
	private static int[] lotto = new int[6];

	public static void main(String[] args) throws IOException {
		/*
		 * 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
		 * 로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
		 * 예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다. 
		 * ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
		 * 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.*/
		
		while(true) {
			String testCase = br.readLine();
			
			if(testCase.equals("0")) break;
			
			st = new StringTokenizer(testCase);
			k = Integer.parseInt(st.nextToken());
			S = new int[k];
			visit = new boolean[k];
			
			for(int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	private static void dfs(int start, int index) throws IOException {
		if(index == 6) {
			for(int value : lotto) {
				bw.append(value + " ");
			} 
			bw.append("\n");
			return;
		}
		// 중복을 고려하고 i = start로 순열이 아닌 조합을 만듦
		for(int i = start; i < k; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			lotto[index] = S[i];
			dfs(i, index+1);
			visit[i] = false;
		}
	}

}
