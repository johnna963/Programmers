import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_디스크컨트롤러 {
	static class DiskController {
	    public int solution(int[][] jobs) {
	        int answer = 0;
	        int count = 0;
	        int index = 0;
	        int endTime = 0;
	        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1] - o2[1]);
	        Arrays.sort(jobs,(o1, o2) -> o1[0] - o2[0]);
	        while(count < jobs.length) {
	        	while(index < jobs.length && jobs[index][0] <= endTime) {
	        		queue.add(jobs[index++]);
	        	}
	        	if(queue.isEmpty()) {
	        		endTime = jobs[index][0];
	        	}
	        	else {
	        		int[] temp = queue.poll();
	        		answer +=temp[1] + endTime - temp[0];
	        		endTime +=temp[1];
	        		count++;
	        	}
	        }
	        return (int) Math.floor(answer / jobs.length);
	    }
	}
	public static void main(String[] args) {
		DiskController sol = new DiskController();
		int[][] jobs = {
				{0,3}, {1,9}, {2,6}
		};
		System.out.println(sol.solution(jobs));
	}

}
