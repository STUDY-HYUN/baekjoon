import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
       	HashMap<String, Integer> runners = new HashMap<>();
       
        for(int i = 0; i < participant.length; i++) {
          runners.put(participant[i],runners.getOrDefault(participant[i],0) + 1);
        }
        
        for(int i = 0; i< completion.length; i++) {
            if(runners.containsKey(completion[i])) {
                runners.replace(completion[i], runners.get(completion[i])-1);
            }
        }
        
       for(int i = 0; i < runners.size(); i++) {
           if(runners.get(participant[i]) != 0) {
               answer = participant[i];
           }
       }
        
        return answer;
    }
}