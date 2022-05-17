
public class Programmers_금과은운반하기 {
	static class CarryingGoldandSilver {
	    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
	        
	    	long max = (long)(1e9 * 2 * 1e5* 2);
	        long l = 0;
	        long r = max; 
	        long T;
	        long answer = max;
	        int n = s.length;
	        long gm, sm, gsm, gc, sc, wc, tc, rc, wt, ab = a+b, gsc;
	        while(l<=r) {
	        	T = (l+r) / 2;
	        	gm = sm = gsm = 0;
	        	for (int i = 0; i < n; i++) {
					gc = g[i];
					sc = s[i];
					wc = w[i];
					tc = t[i];
					gsc = gc + sc; 
					rc = (long)Math.ceil((double)(T/tc)/2);
					wt = rc * wc;
					gm += Math.min(gc, wt);
					sm += Math.min(sc, wt);
					gsm += Math.min(gsc, wt);
	        	}
	        	if(a<= gm && b <= sm && ab <=gsm) {
	        		r = T - 1;
	        		answer = T;
	        	}
	        	else {
	        		l = T + 1;
	        	}
	        }
	        return answer;
	    }
	}

	public static void main(String[] args) {
		CarryingGoldandSilver sol = new CarryingGoldandSilver();
		int a = 10;
		int b = 10;;
		int[] g = {100};
		int[] s = {100};
		int[] w = {7};
		int[] t = {10};
		System.out.println(sol.solution(a, b, g, s, w, t));
	}
}
