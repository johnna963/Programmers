import java.util.*;
public class Programmers_줄서는방법 {
	static class HowToLineup {
		
	    public int[] solution(int n, long k) {
	    	int[] ret = new int[n];
			List<Integer> list = new ArrayList<>();
	        long num=1;
	        int idx=0;
			for(int x=1 ; x<=n ; x++) {
				list.add(x);
				num *= x;
			}
	        k--;
	        while(idx<ret.length) {
	        	num /= (n--);
	        	int i = (int)(k/num);
	        	ret[idx++] = list.get(i);
	        	list.remove(i);
	        	k %= num;
	        }
	        return ret;
	    }

		
	}
	public static void main(String[] args) {
		HowToLineup sol = new  HowToLineup();
		
		int n = 3;
		long k = 5;
//		sol.solution(n, k);
		System.out.println(Arrays.toString(sol.solution(n, k)));
	}

}
