import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> numbers = new HashSet<>();
        
        for(String phone : phone_book) {
            numbers.add(phone);
            
        }
        
        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) { // i < phone.length여야 "123" "123"을 포함한다고 출력하지 않음
                 // System.out.println(phone.substring(0,i)); 
                if(numbers.contains(phone.substring(0, i))) {
                    return false;
                }
            }
            
        }
        
        // for(int i = 0; i < phone_book.length - 1; i++) {
        //     for(int j = i + 1; j < phone_book.length; j++) {
        //         if(phone_book[j].startsWith(phone_book[i])) {
        //             return false;
        //         }
        //     }
        // }
        
//         for(int i = 0; i < phone_book.length; i++) {
//             for(int j = i+1; j < phone_book.length; j++) {
//                 if(phone_book[i].length() > phone_book[j].length()) break;

//                 if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
//                     answer = false;
//                 }
                
//             }
//         }
        
        
        
        return true;
    }
}