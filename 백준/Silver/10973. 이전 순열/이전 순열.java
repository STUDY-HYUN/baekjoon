import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N;
	private static int[] permutation;
	
	public static void main(String[] args) throws IOException {
		// 이전 순열
		/*
		 * 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
		 * 사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
		 * N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.*/
		
		N = Integer.parseInt(br.readLine());
		permutation = new int[N];
		
		st = new StringTokenizer(br.readLine());
	
		for(int i = 0; i < N; i++) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation(permutation)) {
			for(int value :  permutation) {
				System.out.print(value + " ");
			}
		} else {
			System.out.println("-1");
		}
	
	}
	
	private static boolean nextPermutation(int[] arr) {
		
		int i = arr.length - 1;
		
		// arr[i-1] <= arr[i]를 만족하는 가장 큰 i를 찾음
		// 뒤에서부터 찾음
		// 12453 --> i = 4 -> arr[4]  
		while(i > 0 && arr[i-1] <= arr[i]) {
			i -= 1;
		}
		
		// i가 0이면 첫번째 오름차순을 의미
		if(i <= 0) {
			return false;
		}
		
		int j = arr.length - 1;
		
		// j가 i보다 크거나 같아야 하며 arr[j] >= arr[i-1]을 만족하는 만족하는 가장 큰 j를 찾음
		// 12453 -> i = 4 , j = 4 arr[4-1] < arr[4] -> 해당X -> 탈출
		// i = 4, j = 4
		while(arr[j] >= arr[i-1]) {
			j -= 1;
		}
		
		// j와 i-1 swap
		// arr[i-1] arr[j] swap
		// i = 4 j = 4
		// 12435
		swap(j, i-1);
		
		int start = i;
		int end = arr.length - 1;
        // 현재 swap을 수 이후의 수를 오름차순으로 변경
		while(start < end){
            swap(start,end);
            start++;
            end--;
        }
		return true;
		
	}
	
	// swap
	private static void swap(int num1, int num2) {
		int temp = permutation[num1];
		permutation[num1] = permutation[num2];
		permutation[num2] = temp;
	}

}
