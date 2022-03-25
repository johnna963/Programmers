import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_줄서는방법 {
	static class HowToLineup {
		static int[] person;
		static int[] answer;
		static boolean[] visited;
		static int[] out;
		static ArrayList<int[]> list = new ArrayList<>();
	    public int[] solution(int n, long k) {
	    	answer = new int[n];
	        
	        person = new int[n];
	        for (int i = 0; i < n; i++) {
				person[i] = i+1;
			}
	        out = new int[n];
	        visited = new boolean[n];
	        perm(n, 0);
	        answer = list.get(Integer.parseInt(String.valueOf(k-1)));
	        
	        return answer;
	    }

		void perm(int n, int depth) {
			if(depth == n) {
				int[] arr = new int[n];
				for (int i = 0; i < answer.length; i++) {
					arr[i] = out[i];
				}
				list.add(arr);
				return;
			}
			for (int i = 0; i <n ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					out[depth] = person[i];
					perm(n, depth+1);
					visited[i]=false;
				}
			}
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
