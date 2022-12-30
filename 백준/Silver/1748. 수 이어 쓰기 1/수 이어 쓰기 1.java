import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		// 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
		// 1234567891011121314151617181920212223...
		// 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0; 
		
		while(N > 0) {
			int lenNum = N;
			
			while(lenNum != 0) {
				lenNum = lenNum / 10; // 자리수 만큼 반복
				cnt++;
			}
			
			N--;
		}
		
		bw.append(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
	}

}
