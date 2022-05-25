
public class Programmers_징검다리건너기 {
	static class CrossingSteppingStone {
	    public int solution(int[] stones, int k) {
	        int answer = 0;
	        int min = 1;
	        int max = 200000000;
	        while(min <= max) {
	        	int mid = (min + max)/2;
	        	
	        	if (CrossFriends(stones, k, mid)) {
					min = mid + 1;
					answer = Math.max(answer, mid);
				}
	        	else {
	        		max = mid - 1;
	        	}
	        }
	        return answer;
	    }
	    static boolean CrossFriends(int[] stones, int k, int friend) {
	    	int skip = 0;
	    	for (int stone : stones) {
				if(stone - friend < 0) {
					skip++;
				}
				else {
					skip = 0;
				}
				if (skip == k) {
					return false;
				}
			}
	    	return true;
	    }
	}
	public static void main(String[] args) {
		CrossingSteppingStone sol = new CrossingSteppingStone();
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(sol.solution(stones, k));
	}
}
