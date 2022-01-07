import java.util.Stack;

public class Programmers_짝지어제거하기 {
	static class GetRidofPairs
	{
		static public int solution(String s)
	    {
	        int len = s.length();
	        int answer = -1;
	        Stack<Character> stack = new Stack<>();
	        for(int i = 0; i < len; i++){
	            char c = s.charAt(i);
	            if(stack.isEmpty()){
	                stack.add(c);
	            }
	            else{
	                if(c == stack.peek()){
	                    stack.pop();
	                }
	                else{
	                    stack.add(c);
	                }
	            }
	        }
	        if(stack.isEmpty()){
	            answer = 1;
	        }
	        else{
	            answer = 0;
	        }

	        return answer;
	    }
	}
	public static void main(String[] args) {
		GetRidofPairs sol = new GetRidofPairs();
		String s = "baabaa";
		sol.solution(s);
	}

}
