import java.util.Stack;

public class Programmers_주식가격 {
	static class StockPrice {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Integer> st = new Stack<>();
	        for (int i = 0; i < prices.length; i++) {
				while(!st.isEmpty() && prices[i] < prices[st.peek()]) {
					answer[st.peek()] = i - st.peek();
					st.pop();
				}
				st.push(i);
			}
	        while(!st.isEmpty()) {
	        	answer[st.peek()] = prices.length - st.peek() - 1;
	        	st.pop();
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		StockPrice sol = new StockPrice();
		int[] prices= {1,2,3,2,3};
		System.out.println(sol.solution(prices));
	}

}
