import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(sc.hasNextInt()) {
			int input = sc.nextInt();
			
			System.out.println(calculateMethod(input));
		}
		
		sc.close();
	}
	
	private static int calculateMethod(int input) {
		
		int onlyOneNumber = 1; //1로만 이루어진 n의 배수
		
		for(int digit = 1;; digit++) {
			
			if(onlyOneNumber % input == 0) {
				return digit;
			}
			
			onlyOneNumber = (onlyOneNumber * 10 + 1) % input; // 1로 이루어진 n을 위한 연산
		}
		
	}

}
 