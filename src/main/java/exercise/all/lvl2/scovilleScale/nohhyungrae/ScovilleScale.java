package exercise.all.lvl2.scovilleScale.nohhyungrae;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
	K보다 스코빌 지수가 낮은 음식이 없는 경우도 있다. -> answer=0
	모든 음식을 섞어도 스코빌 지수가 K보다 낮은 경우도 있다. -> answer=-1
	K보다 스코빌 지수가 낮은 음식의 개수(C)가 1개 이상(짝수)일 경우 최솟값 -> C/2
	K보다 스코빌 지수가 낮은 음식의 개수(C)가 1개 이상(홀수)일 경우 최솟값 -> C/2+1
	K보다 스코빌 지수가 낮은 음식의 개수(C)가 1개 이상일 경우 최댓값 -> C
	K보다 스코빌 지수가 높은 음식도 섞을 수 있다.
*/
public class ScovilleScale {
	
	private int[] scoville;
	private int K = 0;
	private int scovilleLate = 0;
	private PriorityQueue<Integer> que = new PriorityQueue<Integer>();

	public ScovilleScale(int[] scoville, int K) {
		this.K = K;
		this.scoville = scoville; 
	}
	
	public int solution() {
		int answer = 0;
        
        for(int s : scoville) { que.add(s); }
        
        while(true) {
        	
        	if(que.peek() >= K) {
        		return answer;
        	} else if(que.size() <= 1) {
        		answer = -1;
        		break;
        	}else {
        		scovilleLate = que.poll()+(que.poll()*2);
            	que.add(scovilleLate);
            	answer++;
        	}
        	
        }
        
        return answer;
    }
	
/*********************************************************************/	
	
	public static void main(String[] args) {
		
		int[] scovilleArr = {0, 1, 2, 3};
		int[] scovilleArr2 = {1, 2, 3, 9, 10, 12, 13, 2,100000, 3, 9, 10, 12,100,300,400};
		int[] scovilleArr3 = {1, 2, 3};
		int[] scovilleArr4 = {0,0,5,5,5};
		int[] scovilleArr5 = {1,2,3,4,5,6,7,8,9,10};
		int K = 11;
		int K4 = 2;
		int K5 = 7;
		
		System.out.println(solution3(scovilleArr2,K));
		
//		ScovilleScale scoville = new ScovilleScale(scovilleArr2,K);
//		System.out.println(scoville.solution());
	}
	

	
    public static int solution3(int[] scoville, int K) {
    	int answer = 0;
        int scovilleLate = 0;
        int first = 0, second = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int a : scoville) { queue.add(a); }
        
        while(true) {

        	if(queue.peek() >= K) {
        		return answer;
        	} else if(queue.size() <= 1) {
        		answer = -1;
        		break;
        	}else{
        		first = queue.poll();
        		second = queue.poll()*2;
                scovilleLate = first+ second;
                queue.add(scovilleLate);
                answer++;
            }
        }
        
        
        return answer;
    }
/*********************************************************************/    
    public static int solution2(int[] scoville, int K) {
    	int answer = 0;
    	int scovilleLate = 0;
    	
    	Arrays.sort(scoville);
    	
    	while(scovilleLate <= K) {
    		if(answer > scoville.length*2) {
    			answer = -1;
    			break;
    		}
    		scovilleLate = scoville[0]+(scoville[1]*2);
    		scoville = minusArr(scoville);
    		scoville[0] = scovilleLate;
    		Arrays.sort(scoville);
    		answer++;
    	}
    	
    	return answer;
    }
    
    public static int[] minusArr(int[] arr) {
    	int [] arr2 = new int[arr.length - 1];
        for(int j = 0; j < arr.length - 1; j++){ arr2[j] = arr[j+1]; }
    	return arr2;
    }
    
/*********************************************************************/   
	

	
	public List<Integer> sortValue(List<Integer> list) {
		Collections.sort(list);
		return list;
	}

}