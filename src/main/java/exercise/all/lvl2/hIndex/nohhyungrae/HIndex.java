package exercise.all.lvl2.hIndex.nohhyungrae;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
	
	public static void main(String[] args) {
		int [] citations = {3, 0, 6, 1, 5};
		int [] citations2 = {0,1,2,3,3,3,3,3,3,4,10,20,30,40};
		int [] citations3 = {22,42};
		
		System.out.println("solution : "+solution(citations3));
		
	}
	
	public static int solution(int[] citations) {
        int answer = 0;
        int[] total = new int[citations.length];
        //내림차순 - 인용수
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print("논문수 : ");
        for(int i=1; i< citations.length+1; i++) {
        	System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("피 인용수 : ");
        for(int a : arr) {
        	System.out.print(a+" ");
        }
        System.out.println();
        
        //if(citations.length == 1 && citations[0] != 0) return citations.length;
        
        for(int i=0; i< arr.length; i++) {
        	if(arr[i] <= (i+1))
        		return i;
        	else
                answer = i+1;
        }
        
//        for(int i=0; i<arr.length; i++) {
//        	if(arr[i] > 0 ) {
//        		answer += arr[i];
//        	}else {
//        		break;
//        	}
//        }
        
//        for(int i=0; i<arr.length; i++) {
//        	for(int j=0;j<arr.length; j++) {
//        		if(arr[i] >= arr[j]) {
//        			total[i]++;
//        		}
//        	}
//
//        }
//        
//        Arrays.sort(total);
//        for(int a : total) {
//        	System.out.print(a);
//        }
//        System.out.println();
//        for(int i=0; i<total.length; i++) {
//        	if(arr[i] == i+1) {
//        		return total[i];
//        	}
//        }
        
        return answer;
    }

}