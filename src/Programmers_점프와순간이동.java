import java.util.*;
public class Programmers_점프와순간이동 {
	static public class JumpAndTeleport {
	    public int solution(int n) {
	        int ans = 0;
	        while(n!=0) {
	        	if(n % 2 == 0) {
	        		n = n/2;
	        	}
	        	else {
	        		n--;
	        		ans++;
	        	}
	        }

	        return ans;
	    }
	}
	public static void main(String[] args) {
		JumpAndTeleport sol = new JumpAndTeleport();
		int n = 5;
		sol.solution(n );
	}
}
