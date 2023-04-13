import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for(int[] command : commands) {
            int[] temp = new int[command[1]-command[0]+1];
            int index2 = 0;
            
            for(int i = command[0]-1; i < command[1]; i++) {
                temp[index2] = array[i];
                index2++;
            }
            
            Arrays.sort(temp);
            
            answer[index] = temp[command[2] - 1];
            
            index++;
        }
        
        return answer;
    }
} 