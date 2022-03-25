

public class DartGame {
	static class dartgame {
	    public int solution(String dartResult) {
	        int answer = 0;
	        int n=0;
	        int[] arr = new int[3];
	        int index = 0;
	        String str="";
	        for (int i = 0; i < dartResult.length(); i++) {
	        	char c = dartResult.charAt(i);
				switch (c) {
				case '*':
					int k = index;
					arr[k-1] = arr[k-1]*2;
					if(k>1) {
						arr[k-2] = arr[k-2]*2;
					}
					break;
				case '#':
					arr[index - 1] = arr[index - 1] * -1;
					break;
				case 'S':
					n = Integer.parseInt(str);
					arr[index] = (int) Math.pow(n, 1);
					index++;
					str="";
					break;
				case 'D':
					n = Integer.parseInt(str);
					arr[index] = (int) Math.pow(n, 2);
					index++;
					str="";
					break;
				case 'T':
					n = Integer.parseInt(str);
					arr[index] = (int) Math.pow(n, 3);
					index++;
					str="";
					break;
				default:
					str += c;
					break;
				}
			}
	        for (int i = 0; i < 3; i++) {
				answer += arr[i];
			}
	        System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		dartgame sol = new dartgame();
		String dartResult = "1S2D*3T";
		sol.solution(dartResult);
	}

}
