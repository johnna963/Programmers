import java.util.*;
public class Programmers_전화번호목록 {
	static class PhoneNumberList {
	    static boolean answer = true;
	    static class TrieNode{
	        Map<Character, TrieNode> node = new HashMap<>();
	        Map<Character, TrieNode> reverseNode = new HashMap<>();
	        boolean lastChar;
	        public TrieNode() {   
	        }
	        public void insert(String str){
	            TrieNode trieNode = this;
	            int len = str.length();
	            for(int i = 0; i < len; i++){
	                char c = str.charAt(i);
	                trieNode.node.putIfAbsent(c, new TrieNode());
	                trieNode = trieNode.node.get(c);
	                if(trieNode.lastChar){
	                    answer = false;
	                    return;
	                }
	                if(i == len - 1){
	                    trieNode.lastChar = true;
	                    return;
	                }
	            }
	        }
	    }
	    static class RTrieNode{
	        Map<Character, RTrieNode> RNode = new HashMap<>();
	        boolean lastChar;
	        public RTrieNode(){
	        }
	        public void insert(String str){
	            RTrieNode rtrieNode = this;
	            int len = str.length();
	            for(int i = len - 1; i >= 0; i--){
	                char c = str.charAt(i);
	                rtrieNode.RNode.putIfAbsent(c, new RTrieNode());
	                rtrieNode = rtrieNode.RNode.get(c);
	                if(rtrieNode.lastChar){
	                    answer = false;
	                }
	                if(i == 0){
	                    rtrieNode.lastChar = true;
	                    return;
	                }
	            }
	        }
	    }
	    public boolean solution(String[] phone_book) {
	        int arrlen = phone_book.length;
	        TrieNode trieNode = new TrieNode();
	        RTrieNode rtrieNode = new RTrieNode();
	        for(int i = 0; i < arrlen; i++) {
	            String str = phone_book[i];
	            trieNode.insert(str);
	            if(!answer){
	                break;
	            }
	        }
	        for(int i = 0; i < arrlen; i++) {
	            String str = phone_book[i];
	            rtrieNode.insert(str);
	            if(!answer){
	                break;
	            }
	        }
	        System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		PhoneNumberList sol = new PhoneNumberList();
		String[] phone_book = {"987987","87"};
		sol.solution(phone_book);

	}

}
