import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		int count = 1; // 자기 자신 포함
		int start = 1; // 1부터 포인터 시작
		int end = 1; // 1부터 포인터 시작
		
		int sum = 1;
		
		while(end != N) {
			if(sum == N) {
				count++;
				end++;
				sum += end;
			} else if(sum > N) {
				sum -= start; // sum이 N보다 크면 start포인터 한칸 이동
				start++;
			} else {
				end++;
				sum += end;
			}
		}
		
		System.out.println(count);
		

	}

}
