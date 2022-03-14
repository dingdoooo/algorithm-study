package week1_김진주;

import java.util.Scanner;

public class 숫자만추출 {

    public static int Solution1(String str){
        int answer;
        String removed = str.replaceAll("[^0-9]","");
        String removed2 = removed.replaceAll("^0+(?!$)","");

        answer = Integer.parseInt(removed2);
        return answer;
    }

    // 강사 : 아스키 코드 사용 48-57
    public static int Solution2(String str){
        int answer = 1;

        char[] charr = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for(char c : charr){
            if( (int)c >= 48 && (int)c <= 57 ){
                builder.append(c);
            }
        }
        answer = Integer.parseInt(builder.toString());
        return answer;
    }

    // Character.isDigit() 사용
    public static int Solution(String str){
        String answer ="";

        for(char x : str.toCharArray()){
            if(Character.isDigit(x)){
                answer += x;
            }
        }
        return Integer.parseInt(answer);

    }


    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        String input = in.next();

//        Solution(input);
        System.out.println(Solution(input));

    }

}
