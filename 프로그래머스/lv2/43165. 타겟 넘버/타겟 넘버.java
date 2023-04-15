class Solution {
    private static int count = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return count;
    }
    
    public void dfs(int index, int num, int[] numbers,int target) {
        if(index == numbers.length) {
            if(num == target) count++;
            
            return;
        }
        
       
        dfs(index+1, num + numbers[index], numbers, target);
        dfs(index+1, num - numbers[index], numbers, target);
            
         
    }
}