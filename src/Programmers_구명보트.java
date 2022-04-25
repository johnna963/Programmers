import java.util.Arrays;

public class Programmers_구명보트 {
	static class Lifeboat {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int index = 0;
	        for (int i = people.length - 1; i >= index; i--) {
				if (people[i] + people[index] <=limit) {
					index++;
					answer++;
				}
				else {
					answer++;
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Lifeboat sol = new Lifeboat();
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(sol.solution(people, limit));
	}
}
