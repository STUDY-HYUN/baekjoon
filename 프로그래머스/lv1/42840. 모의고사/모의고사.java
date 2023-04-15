import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] st1 = {1, 2, 3, 4, 5};
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            if(st1[i%st1.length] == answers[i]) correct[0]++;
            if(st2[i%st2.length] == answers[i]) correct[1]++;
            if(st3[i%st3.length] == answers[i]) correct[2]++;
        }
        
        int max = Math.max(correct[2], Math.max(correct[0], correct[1]));
        
        List<Integer> array = new ArrayList<>();
        
        for(int i = 0; i < correct.length; i++) {
            if(max == correct[i]) array.add(i+1);
        }
        
        answer = new int[array.size()]; // 맞춘 사람
        
        for(int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}