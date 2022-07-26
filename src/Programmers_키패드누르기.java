
public class Programmers_키패드누르기 {
	static class PressingKeypad {
	    public String solution(int[] numbers, String hand) {
	        StringBuilder sb = new StringBuilder();
	        int leftidx = 10;
	        int rightidx = 12;
	        
	        for (int number : numbers) {
				if(number ==1 || number == 4 || number ==7) {
					sb.append("L");
					leftidx = number;
				}
				else if(number == 3 || number == 6 || number == 9) {
					sb.append("R");
					rightidx = number;
				}
				else {
					int leftlen = getLen(leftidx, number);
					int rightlen = getLen(rightidx, number);
					
					if(leftlen > rightlen) {
						sb.append("R");
						rightidx = number;
					}
					else if(leftlen < rightlen) {
						sb.append("L");
						leftidx = number;
					}
					else {
						if(hand.equals("right")) {
							sb.append("R");
							rightidx = number;
						}
						else {
							sb.append("L");
							leftidx = number;
						}
					}
				}
			}
	        return sb.toString();
	    }
	    public static int getLen(int idx, int number) {
	    	idx = (idx == 0) ? 11 : idx;
	    	number = (number == 0) ? 11 : number;
	    	
	    	int x = (idx - 1) / 3;
	    	int y = (idx - 1) % 3;
	    	int numX = number / 3;
	    	int numY = 1;
	    	
	    	return Math.abs(x-numX) + Math.abs(y - numY);
	    }
	    
	}
	public static void main(String[] args) {
		PressingKeypad sol = new PressingKeypad();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(sol.solution(numbers, hand));
	}

}
