package Kakao;

import java.util.*;
public class Programmers_메뉴리뉴얼 {
	static class MenuRenewal {
	    public String[] solution(String[] orders, int[] course) {
	    	ArrayList<String> answer = new ArrayList<>();
	        
	        for(int i = 0; i < course.length; i++){
	            Map<String, Integer> map = new HashMap<>();
	            
	            for(int j = 0; j < orders.length; j++){
	                map = dfs(orders[j],"",course[i],0,0,map);
	            }
	            int max = Integer.MIN_VALUE;
	            for(String key : map.keySet()){
	                max = Math.max(max, map.get(key));
	            }
	            for(String key : map.keySet()){
	                if(map.get(key) >= 2){
	                    if(max == map.get(key)){
	                        answer.add(key);
	                    }
	                }
	            }
	        }
	        answer.sort(Comparator.naturalOrder());
	        return answer.toArray(new String[answer.size()]);
	    }
	}
	static public Map<String, Integer> dfs(String order, String temp, int max, int level, int start, Map<String,Integer> map){
        if(level == max){
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            temp =  String.valueOf(arr);
            map.put(temp, map.getOrDefault(temp, Integer.valueOf(0)) + 1);
        }
        else {
            for(int i = start; i < order.length(); i++){
                dfs(order, temp + String.valueOf(order.charAt(i)), max, level + 1, i + 1, map);
            }
        }
        return map;
    }
	public static void main(String[] args) {
		MenuRenewal sol = new MenuRenewal();
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		sol.solution(orders, course);
	}

}
