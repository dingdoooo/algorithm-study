package week1_김진주;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {

    public static String Solution1(String s1, String s2) {
        String answer = "YES";

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> map1 : hm1.entrySet()) {
            for (Map.Entry<Character, Integer> map2 : hm2.entrySet()) {
                if (map1.getKey().equals(map2.getKey()) && map1.getValue() != map2.getValue()) {
                        answer = "NO";
                        break;
                }
            }
        }
        return answer;
    }

    // value를 줄이는 방식,runtime error 처리
    public static String Solution2(String s1, String s2){
        String answer = "YES";
        HashMap<Character, Integer> hm = new HashMap<>();

        for(Character ch : s1.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        // 방법1) s2과 s1이 다르면 value값을 추가하지 못한다.
//        for(Character ch : s2.toCharArray()){
//            if(!hm.containsKey(ch)){
//                answer = "NO";
//                break;
//            }
//            hm.put(ch, hm.get(ch)-1);
//        }

        // 방법2) s2과 s1이 다르면 value값을 추가하지 못한다.
        for(Character ch : s2.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch,0)-1);
        }

        for(Integer i : hm.values()){
            if(i!=0){
                answer = "NO";
                break;
            }
        }
        return answer;
    }

    public static String Solution(String s1, String s2){
        String answer = "YES";
        HashMap<Character,Integer> map = new HashMap<>();

        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(char x : s2.toCharArray()){
            // s2.toCharArray()했을 때, key값이 map에 없거나,
            // key값이 있는데 value가 0일수가 없으니까
            if(!map.containsKey(x) || map.get(x)==0){
                return "NO";
            }else{
                map.put(x, map.get(x)-1);
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();

        System.out.println(Solution(input1, input2));

    }
}