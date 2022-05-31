import java.util.LinkedList;
import java.util.Queue;

public class Programmers_프린터 {
	static class Printer {
		static class printlist{
			int location;
			int priority;
			public printlist(int location, int priority) {
				this.location = location;
				this.priority = priority;
			}
		}
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<printlist> queue = new LinkedList<>();

	        for (int i = 0; i < priorities.length; i++) {
				queue.add(new printlist(i, priorities[i]));
			}

	        while(!queue.isEmpty()) {
	        	printlist now  = queue.poll();
	        	boolean check = false;
	        	for (printlist pl : queue) {
					if(pl.priority > now.priority) {
						check = true;
					}
				}
	        	if(check) {
	        		queue.add(now);
	        	}
	        	else {
	        		answer++;
	        		if(now.location == location) {
	        			break;
	        		}
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Printer sol = new Printer();
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(sol.solution(priorities, location));
	}
}