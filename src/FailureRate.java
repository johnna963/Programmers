

import java.util.ArrayList;
import java.util.Collections;

public class FailureRate {
	static class Node implements Comparable<Node>{
		int index;
		double f_rate;
		public Node(int index, double f_rate) {
			this.index = index;
			this.f_rate = f_rate;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(o.f_rate, this.f_rate);
		}
		
	}
	static int[] s_person;
	static ArrayList<Node> arr = new ArrayList<Node>();
	static class failurerate {
		
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        s_person = new int[N+2];
	        int person = stages.length;
	        for (int i = 0; i < stages.length; i++) {
	        	s_person[stages[i]]++;
			}
	        
	        for (int i = 1; i < N + 1; i++) {
				if(person!=0) {
					arr.add(new Node(i,(double)s_person[i]/person));
					person -= s_person[i];
				}
				else {
					arr.add(new Node(i,0));
				}
			}
	       Collections.sort(arr);
	       for (int i = 0; i < N; i++) {
	    	   answer[i] = arr.get(i).index;
	    	   System.out.println(arr.get(i).index);
	       } 
	        return answer;
	    }
	}
	public static void main(String[] args) {
		failurerate sol = new failurerate();
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		sol.solution(N, stages);
	}

}
