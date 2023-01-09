import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fact(n));
	
	}

	public static int fact(int n) {
		if(n <= 1) return 1;
		
		return fact(n-1) * n;  // stack에 쌓인 상태로 다음을 호출
	}
}