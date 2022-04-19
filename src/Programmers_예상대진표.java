
public class Programmers_예상대진표 {
	static class TableofExpected
	{
	    public int solution(int n, int a, int b)
	    {
	        int answer = 1;
	        int left = 0;
	        int right = 0;
	        if(a>b) {
	        	left = b;
	        	right = a;
	        }
	        else {
	        	left = a;
	        	right = b;
	        }
	        while(true) {
	        	if(left % 2 != 0 && right - left == 1) {
	        		break;
	        	}
	        	left = (left + 1) / 2;
	        	right = (right + 1) / 2;
	        	answer++;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		TableofExpected sol = new TableofExpected();
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println(sol.solution(n, a, b));
	}

}
