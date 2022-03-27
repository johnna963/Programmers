
public class Programmers_거스름돈 {
	static class Change {
	    public int solution(int n, int[] money) {
	        int[][] answer = new int[money.length + 1][n+1];      
	        for (int i = 1; i < money.length+1; i++) {
	        	
				for (int j = 0; j < n+1; j++) {
					if(j==0) {
						answer[i][j] = 1;
					}
					else {
						if(j<money[i-1]) {
							answer[i][j] = answer[i-1][j];
						}
						else {
							answer[i][j] = (answer[i-1][j] + answer[i][j-money[i-1]]) % 1000000007;
						}
					}
				}
			}
	        return answer[money.length][n];
	    }
	}
	public static void main(String[] args) {
		Change sol = new Change();
		int n = 5;
		int[] money = {1,2,5};
		sol.solution(n, money);
	}	
}
