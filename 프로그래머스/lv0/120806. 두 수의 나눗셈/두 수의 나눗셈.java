class Solution {
    public int solution(int num1, int num2) {
        double number = (double)num1/num2;
        int answer = (int)(number * 1000);
        
        return answer;
    }
}