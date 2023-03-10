import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	private static List<Integer> dwarfList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		/*
		 * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
		 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
		 * 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
		 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.*/
		
		// 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 
		//주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int total = 0;
		for(int i = 0; i < 9; i++) {
			dwarfList.add(Integer.parseInt(br.readLine()));
			total += dwarfList.get(i);
		}
		
		Collections.sort(dwarfList); // 오름차순 정렬
		
		//브루트포스 알고리즘 -> 완전 탐색
		loop : for(int i = 0; i < dwarfList.size() - 1; i++) {
			for(int j = i+1; j < dwarfList.size(); j++) {
				if(total - dwarfList.get(i) - dwarfList.get(j) == 100) {
					for(int k = 0; k < dwarfList.size(); k++) {
						if(k != i && k != j) {
							sb.append(dwarfList.get(k)).append("\n");
							
						}
					}
					
					break loop;
				}
			}
		}
		
		System.out.print(sb);
	}

}
