

public class Programmers_비밀지도 {
	static class SecretMap {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        for (int i = 0; i < n; i++) {
				answer[i] = Integer.toBinaryString(arr1[i]|arr2[i]);
				
			} 
	        
	        for (int i = 0; i < n; i++) {
				answer[i] = String.format("%"+n+"s",answer[i]);
				answer[i] = answer[i].replaceAll("1", "#");
				answer[i] = answer[i].replaceAll("0", " ");
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		SecretMap sol = new SecretMap();
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		sol.solution(n, arr1, arr2);
	}

}
