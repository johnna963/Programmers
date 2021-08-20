package GraphSearch;

public class TargetNumber {
	static class targetnumber {
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        
	        answer = search(numbers, target, numbers[0], 1) +
	        		search(numbers, target, -numbers[0], 1);
	        System.out.println(answer);
	        return answer;
	    }
	    static int search(int[] numbers, int target,int sum ,int i) {
	    	if(i==numbers.length) {
	    		if(sum == target) {
	    			return 1;// 맞을 떄 리턴 1
	    		}
	    		else {
	    			return 0;// 틀릴 떄 리턴0
	    			
	    		}
	    	}
	    	
	    	int res = 0;
	    	res += search(numbers, target, sum+numbers[i], i+1);
	    	res += search(numbers, target, sum-numbers[i], i+1);
	    	//주어진 예시에 의하면 4+1을 반환
	    	return res;//최종반환
	    }
	    
	}
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		targetnumber sol = new targetnumber();
		sol.solution(numbers, target);
	}

}
