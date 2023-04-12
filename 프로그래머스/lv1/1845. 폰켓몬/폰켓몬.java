import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> pocketmon = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(pocketmon.size() >= nums.length/2) break;
            
            pocketmon.add(nums[i]);
            
        }
        
        answer = pocketmon.size();
        
        return answer;
    }
}