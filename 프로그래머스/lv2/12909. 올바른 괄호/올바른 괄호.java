import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i)==')') return false;
            
            if(!stack.isEmpty() && s.charAt(i) == ')') stack.pop();
            else stack.push(s.charAt(i));
            
        }
        
        if(!stack.isEmpty()) return false;

        return answer;
    }
}