import java.util.HashMap;
import java.util.HashSet;

public class Programmers_보석쇼핑 {
	static class JewelryShopping {
	    public int[] solution(String[] gems) {
	        int[] answer = new int[2];
	        HashSet<String> gemlist = new HashSet<>();
	        for (int i = 0; i < gems.length; i++) {
				gemlist.add(gems[i]);
			}
	        int len = gems.length;
	        int dist = Integer.MAX_VALUE;
	        
	        int left = 0;
	        int right = 0;
	        
	        int start = 0;
	        int end = 0;
	        
	        HashMap<String, Integer> gemdisplay = new HashMap<>();
	        
	        while(true) {
	        	if(gemlist.size() == gemdisplay.size() ) {
	        		gemdisplay.put(gems[left], gemdisplay.get(gems[left]) - 1);
	        		if(gemdisplay.get(gems[left]) == 0) {
	        			gemdisplay.remove(gems[left]);
	        		}
	        		left++;
	        	}
	        	else if(right == len) {
	        		break;
	        	}
	        	else {
	        		gemdisplay.put(gems[right], gemdisplay.getOrDefault(gems[right], 0)+1);
	        		right++;
	        		
	        	}
	        	if(gemdisplay.size() == gemlist.size()) {
	        		
	        		if(right-left < dist) {
	        			dist = right - left;
	        			start = left+1;
	        			end = right;
	        		}
	        	}
	        }
	        answer[0] = start;
	        answer[1] = end;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		JewelryShopping sol = new JewelryShopping();
		String[] gems= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		sol.solution(gems);
	}

}
