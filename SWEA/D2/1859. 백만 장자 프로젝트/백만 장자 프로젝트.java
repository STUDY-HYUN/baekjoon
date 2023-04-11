import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int[] price = new int[N];
			
			for(int j = 0; j < N; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			
			bw.write("#"+i+" "+calculatePrice(price)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static long calculatePrice(int[] price) {
		long maxPrice = price[price.length-1];
		long sum = 0;
		
		for(int i = price.length - 1; i >= 0; i--) {
			if(price[i] < maxPrice) {
				sum += (maxPrice-price[i]);
			} else {
				maxPrice = price[i];
			}
		}
		
		return sum;
	}

}
