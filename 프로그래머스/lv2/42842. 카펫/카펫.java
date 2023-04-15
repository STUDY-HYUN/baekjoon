import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i = 1; i <= sum; i++) {
            int row = i;
            int col = sum / row;
            
            if(row < col) continue; // 다음 반복문으로 넘어감
            
            if((row-2)*(col-2) == yellow) {
                answer[0] = row;
                answer[1] = col;
            }
        }
        
        return answer;
    }
}