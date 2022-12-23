import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
		// 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
		// 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
		
		// 최대 공약수(gcd) 최소 공배수(lcm)
		// 최대 공약수는 두 자연수의 공통된 약수를 의미
		// 최소 공배수는 두 자연수의 공통된 배수 중 가장 작은 수를 의미
		// 최소 공배수 구하기 = 자연수1 * 자연수2 / 최대 공약수
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt(); // 입력받는 자연수1
		int num2 = sc.nextInt(); // 입력받는 자연수2
		
		if(num1 < 0 || num2 < 0) {
			throw new IOException();
		}
			
		
		// 최소 공배수 구하기 위해 앞에 나오는 자연수가 뒤에 나오는 자연수보다 커야함
		int gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2)); 
		
		System.out.println(gcd); // 최대 공약수
		System.out.println((num1 * num2)/gcd); //최소 공배수

	}
	
	//최소 공배수 구하는 방법
	private static int getGCD(int num1, int num2) {
		
		while(num2 != 0) {
			int temp = num1;
			num1 = num2;
			
			num2 = temp % num2;
		}
		
		return num1;
	}

}