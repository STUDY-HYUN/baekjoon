import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int maxCase = 0;
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n > maxCase) {
					maxCase = n;
				}
			}
			
			bw.write("#"+i+" "+maxCase+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
