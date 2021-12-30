import java.util.HashMap;
import java.util.Set;

public class Programmers_위장 {
	static class Camouflage {
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        HashMap<String,Integer> map = new HashMap<>();
	        for(int i =0; i< clothes.length; i++){
	        	map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 0) + 1);
	        }
	        Set<String> keyset = map.keySet();
	        for(String key : keyset){
	            answer *= map.get(key) + 1;
	        }
	        return answer - 1;
	    }
	}
	public static void main(String[] args) {
		Camouflage sol = new Camouflage();
		String[][] clothes = {
				{"yellowhat", "headgear"},
				{"bluesunglasses", "eyewear"},
				{"green_turban", "headgear"}
				};
		sol.solution(clothes);
	}

}
