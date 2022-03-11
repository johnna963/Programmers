import java.util.Arrays;
import java.util.Comparator;

public class Programmers_단속카메라 {
	static class ControlCamera {
	    public int solution(int[][] routes) {
	        int answer = 0;
	        Arrays.sort(routes, new Comparator<int []>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
	        int cam = Integer.MIN_VALUE;
	        for (int i = 0; i < routes.length; i++) {
				if(cam<routes[i][0]) {
					cam = routes[i][1];
					answer++;
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		ControlCamera sol = new ControlCamera();
		int[][] routes= {
				{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}	
		};
		System.out.println(sol.solution(routes));
	}
}
