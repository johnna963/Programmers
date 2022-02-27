import java.util.*;
public class Programmers_영어끝말잇기 {
	static class WordChainGameEnglish {
		public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        answer[0] = 0;
	        answer[1] = 0;
	        ArrayList<String> str = new ArrayList<>();
	        for(int i = 0; i < words.length; i++){
	           if(str.contains(words[i])) {
	               answer[0] = i % n + 1;
	               answer[1] = i / n + 1;
	               break;
		        }
	            str.add(words[i]);
	            if(i>0){
	                int prelen = words[i-1].length();
	                if(words[i-1].charAt(prelen-1) != words[i].charAt(0)){
	                    answer[0] = i % n + 1;
	                    answer[1] = i / n + 1;
	                    break;
	                }
	            }
	        }
	        System.out.println(answer[0]+" "+answer[1]);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		WordChainGameEnglish sol = new WordChainGameEnglish();
		int n = 3;
		String[] words = {"tank", "kick", "know", 
				"wheel", "land", "dream", 
				"mother", "robot", "tank"};
		sol.solution(n, words);
	}
}
