import java.util.Arrays;

public class Programmers_체육복 {
	static class WorkoutClothes {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = n - lost.length;
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        int llen = lost.length;
	        int rlen = reserve.length;
	        for (int i = 0; i < llen; i++) {
				for (int j = 0; j < rlen; j++) {
					if(lost[i] == reserve[j]) {
						answer++;
						reserve[j] = -1;
						lost[i] = -1;
						break;
					}
				}
			}
	        for (int i = 0; i < llen; i++) {
				for (int j = 0; j < rlen; j++) {
					if((lost[i]-1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
						answer++;
						reserve[j] = -1;
						break;
					}
				}
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		WorkoutClothes sol = new WorkoutClothes();
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.println(sol.solution(n, lost, reserve));
	}
}
