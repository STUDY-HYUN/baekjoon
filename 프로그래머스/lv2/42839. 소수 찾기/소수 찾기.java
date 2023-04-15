import java.util.*;

class Solution {
    private static HashSet<Integer> set = new HashSet<>();
    private static char[] arr;
    private static boolean[] visit;
    
    public int solution(String numbers) {
        
        arr = new char[numbers.length()];
       
        visit = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i); 
        }
       
        dfs("", 0);
        
        
        return set.size();
    }
    
    public void dfs(String number, int index){

        if(number != "") {
            int num = Integer.parseInt(number);
           
            if(isPrime(num)) set.add(num);
            
        }
        
        // 모든 종이조각을 다 사용한 경우 return
        if(index == arr.length) return;
        
        for(int i = 0; i < arr.length; i++) {
            if(visit[i]) continue;
            
            visit[i] = true;
            dfs(number+arr[i], index+1);  
            visit[i] = false;
        }
        
    }
    
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}