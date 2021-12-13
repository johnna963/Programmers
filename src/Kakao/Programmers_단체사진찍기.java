package Kakao;
import java.util.*;
public class Programmers_단체사진찍기 {
	static class TakingGrouPhoto {
	    static int[] pos;
	    static HashMap<Character, Integer> map;
	    static boolean[] visit;
	    static int cnt;
	    public int solution(int n, String[] data) {
	        int answer = 0;
	        pos = new int[8];
	        visit = new boolean[8];
	        cnt = 0;
	        map = new HashMap<>();
	        map.put('A', 0);
	        map.put('C', 1);
	        map.put('F', 2);
	        map.put('J', 3);
	        map.put('M', 4);
	        map.put('N', 5);
	        map.put('R', 6);
	        map.put('T', 7);
	        perm(0,data,n);
	        answer = cnt;
//	        System.out.println(answer);
	        return answer;
	    }
	    static void perm(int idx, String[] data, int n){
	        if(idx == 8){
	            if(check(data, n)){
	                cnt++;
	            }
	            return;
	        }
	        for(int i = 0; i < 8; i++){
	            if(!visit[i]){
	                visit[i] = true;
	                pos[idx] = i;
	                perm(idx + 1, data, n);
	                visit[i] = false;
	            }
	        }
	    }
	    static boolean check(String[] data, int n){
	        for(int i = 0; i < n; i++){
	            int c1 = map.get(data[i].charAt(0));
	            int c2 = map.get(data[i].charAt(2));
	            char oper = data[i].charAt(3);
	            int dist = data[i].charAt(4)-'0';
	            int c1pos = pos[c1];
	            int c2pos = pos[c2];
	            if(oper == '='){
	                if(Math.abs(c1pos - c2pos) - 1 != dist){
	                    return false;
	                }
	            }
	            else if(oper == '<'){
	                if(Math.abs(c1pos - c2pos) - 1 >= dist){
	                    return false;
	                }
	            }
	            else{
	                if(Math.abs(c1pos - c2pos) - 1 <= dist){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}
	public static void main(String[] args) {
		TakingGrouPhoto sol = new TakingGrouPhoto();
		int n = 2;
		String[] data= {"N~F=0", "R~T>2"};
		sol.solution(n, data);
	}

}
