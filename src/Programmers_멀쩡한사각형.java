
public class Programmers_멀쩡한사각형 {
	static class NormalSquare {
	    public long solution(int w, int h) {
	        long answer = 0;
	        long width = w;
	        long height = h;
	        for(int i = 0; i < width; i++){
	            answer += height*i/width;
	        }
	        return answer * 2;
	    }
	}
	public static void main(String[] args) {
		NormalSquare sol = new NormalSquare();
		int w = 8;
		int h = 12;
		sol.solution(w, h);
	}

}
