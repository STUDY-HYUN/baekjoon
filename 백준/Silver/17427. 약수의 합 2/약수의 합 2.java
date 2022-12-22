import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다. 
		// 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다. 
		// 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다. x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
		// 자연수 N이 주어졌을 때, g(N)을 구해보자.
		
		/* ex)
		 * g(4) = f(1) + f(2) + f(3) + f(4)*/
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long gN = 0;
		
		for(int i = 1; i <= N; i++) {
			// 배수의 성질을 이용한 약수구하기 => N/i -> 약수의 개수를 알 수 있음 
			// (N / i) * i를 이용해 개수 만큼 i의 수 곱해야 g(N)에 포함하는 i의 합을 구함
			gN += (N/i) * i;  
			
		}
		
		System.out.println(gN);
	}
	
}