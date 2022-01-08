package Kakao;
import java.util.*;
public class Programmers_수식최대화 {
	static class MaximizetheFormula {
	    static ArrayList<Long> numarr = new ArrayList<>();
	    static ArrayList<Character> operarr = new ArrayList<>();
	    static char[] pri_oper = {'+','-','*'};
	    static long answer;
	    static boolean[] check = new boolean[3];
	    public long solution(String expression) {
	        answer = 0;
	        divide(expression);
	        dfs(0,new char[3]);
	        return answer;
	    }
	    static void dfs(int depth, char[] p){
	        if(depth == 3){
	            ArrayList<Long> copy_num = new ArrayList<>(numarr);
	            ArrayList<Character> copy_oper = new ArrayList<>(operarr);
	            for(int i = 0; i < 3; i++){
	                for(int j = 0; j < copy_oper.size(); j++){
	                    if(p[i] == copy_oper.get(j)){
	                        long num1 = copy_num.remove(j);
	                        long num2 = copy_num.remove(j);
	                        long num = calc(num1,num2,p[i]);
	                        copy_oper.remove(j);
	                        copy_num.add(j, num);
	                        j--;
	                    }
	                }
	            }
	            long maxnum = Math.abs(copy_num.get(0));
	            answer = Math.max(maxnum, answer);
	            return;
	        }
	        for(int i = 0;i < 3; i++){
	            if(!check[i]){
	                check[i] = true;
	                p[depth] = pri_oper[i];
	                dfs(depth+1,p);
	                check[i] = false;
	            }
	        }
	    }
	    static void divide(String exp){
	        String num ="";
	        for(int i = 0; i<exp.length(); i++){
	            if(exp.charAt(i)>='0' || exp.charAt(i)<='9'){
	                num += exp.charAt(i);
	            }
	            else{
	                numarr.add(Long.parseLong(num));
	                num="";
	                operarr.add(exp.charAt(i));
	            }
	        }
	        numarr.add(Long.parseLong(num));
	    }
	    static long calc(long num1, long num2, char oper){
	        long num = 0;
	        switch(oper){
	            case '+' : {
	                return num1 + num2;
	            }
	            case '-' : {
	                return num1 - num2;
	            }
	            case '*' : {
	                return num1 * num2;
	            }      
	        }
	        return num;
	    }
	}
	public static void main(String[] args) {
		MaximizetheFormula sol = new MaximizetheFormula();
		String expression = "100-200*300-500+20";
		sol.solution(expression);
	}
}
