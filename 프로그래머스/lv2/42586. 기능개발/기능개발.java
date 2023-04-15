import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> finishJob = new ArrayList<>();
        
        int count = 1;
        int temp = (int)Math.ceil((100.0 - progresses[0])/ speeds[0]);
        
        for(int i = 1; i < progresses.length; i++) {
            
            int taken = (int)Math.ceil((100.0 - progresses[i])/ speeds[i]);
         
            if(taken <= temp) {
                count++;
               
                if(i == progresses.length - 1) finishJob.add(count);
                
            } else {
                finishJob.add(count);
                count = 1;
                temp = taken;
              
                if(i == progresses.length - 1) finishJob.add(count);
            }
            
        }
        
        answer = new int[finishJob.size()];
        
        for(int i = 0; i < finishJob.size(); i++) {
            answer[i] = finishJob.get(i);
        }
        
        return answer;
    }
}