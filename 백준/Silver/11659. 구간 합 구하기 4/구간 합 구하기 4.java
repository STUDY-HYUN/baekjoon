import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수
		
		int[] A = new int[N+1];
		int[] S = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			
			if(i == 1) S[i] = A[i];
			else S[i] = S[i-1] + A[i];
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			bw.write((S[j] - S[i-1]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
