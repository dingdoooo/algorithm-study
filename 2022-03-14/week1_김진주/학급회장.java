package week1_김진주;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {

    public static void Solution1(int i, String str){

        HashMap<Character, Integer> hs = new HashMap();

        for(char c : str.toCharArray()){
            hs.put(c,hs.getOrDefault(c,0)+1);
        }

        int max = 0;
        char who = 0;

        for(Map.Entry<Character,Integer> s : hs.entrySet()){
            if(s.getValue() > max){
                max = s.getValue();
                who = s.getKey();
            }
        }
        System.out.println(who);
    }

    // 강사 방법
    public static Character Solution(int i, String str){
        char answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : str.toCharArray()){
// map.put(x, map.get(x)) 이 아닌 이유 : key값은 있지만 value는 없을 수도 있다.
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        String str = in.next();

        System.out.println(Solution(num,str));
//        Solution(num, str);
    }
}