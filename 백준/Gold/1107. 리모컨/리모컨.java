import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int NOW_CHANNEL = 100;
	private static List<Integer> brokenButton = new ArrayList<>(); // 망가진 버튼
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		/*
		 * 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
		 * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
		 * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
		 * 수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 
		 * 수빈이가 지금 보고 있는 채널은 100번이다*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 변경하려는 채널
		M = Integer.parseInt(br.readLine()); // 망가진 리모컨 버튼 수
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(M-- > 0) {
				brokenButton.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int lowCount = Math.abs(N - NOW_CHANNEL); // + - 로만 이동한 버튼 수
		
		System.out.println(check(lowCount));
	}
	
	private static int check(int lowCount) {
		
		for(int i = 0; i < 1000000; i++) { // N이 500,000이기 때문
			String str = String.valueOf(i);
			int lengthCount = str.length(); //숫자 길이 만큼 버튼 입력수 
			
			boolean isBroken = false;
			
			for(int j = 0; j < str.length(); j++) {
				// char -> int 형변환을 위한 아스키코드 '0' = 48 뺄셈
				if(brokenButton.contains(str.charAt(j) - '0')) {
					isBroken = true;
					break;
				}
			}
			
			if(!isBroken) {
				lowCount = Math.min(lowCount, Math.abs(N-i) + lengthCount); // 비교
			}
		}
		
		return lowCount;
	}

}