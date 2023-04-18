import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
         PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int i=0; i<scoville.length; i++) {
            heap.add(scoville[i]);
        }
        
        while(heap.peek()<K){
            
             if(heap.size()==1) {answer=-1; break;}
            
            int min1=heap.poll();
            int min2=heap.poll();
            
            int scov = min1+min2*2;
            heap.add(scov);
            answer++;
            
           
        }
        
        return answer;
    }
}