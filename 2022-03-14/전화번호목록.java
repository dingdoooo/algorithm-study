package week1_김진주;

import java.util.*;

public class 전화번호목록 {
        // 효율성 x
        public static boolean solution1(String[] phone_book) {
            boolean answer = true;

            int start = phone_book[0].length();
            String keystart = phone_book[0];

            for(int j = 1; j < phone_book.length; j++){
                if(phone_book[j].substring(0,start).equals(keystart)){
                    answer = false;
                }
            }
            return answer;
        }

    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        HashMap<String,Integer> hm = new HashMap<>();

        for(String str : phone_book){
            hm.put(str,1);
        }

        for(String str : hm.keySet()){
            for(int i = 0; i < str.length(); i++){
                if(hm.containsKey(str.substring(0,i))){
                    answer = false;
                }
            }
        }

        return answer;
    }

    // startsWith으로 시작하는지 유무
    public static boolean solution(String[] phone_book){
        boolean answer = true;

        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length -1 ; i ++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] str1 = {"119", "97674223", "1195524421"};
        String[] str2 = {"123","456","789"};
        String[] str3 = {"12","123","1235","567","88"};

        System.out.println(solution(str1));
        System.out.println(solution(str2));
        System.out.println(solution(str3));
    }
}