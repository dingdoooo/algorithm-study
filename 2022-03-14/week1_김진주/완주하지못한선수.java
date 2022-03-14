package week1_김진주;

import java.util.HashMap;

class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hs = new HashMap();

        // hs.put()을 통해 데이터 추가, HashMap<String, Integer>이므로
        // key값은 string, value는 Integer 타입이 들어간다.
        // 참가자들의 이름을 key값으로 추가하고,
        // getOrDefault를 통해 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값이 반환됩니다.
        /// 동명이인인 경우는 value 값이 1이 아닐 것
        for(String player : participant){
            hs.put(player, hs.getOrDefault(player,0)+1);
        }

        for(String finishplayer : completion){
            hs.put(finishplayer, hs.get(finishplayer)-1);
        }

        for(String player : hs.keySet()){
            if(hs.get(player)!=0){
                answer = player;
            }
        }
        return answer;
    }
}
