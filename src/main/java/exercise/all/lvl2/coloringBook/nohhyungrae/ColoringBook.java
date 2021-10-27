package exercise.all.lvl2.coloringBook.nohhyungrae;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ColoringBook {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
//		int m = 100; int n = 100;
//		int[][] picture = new int[100][100];
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				picture[i][j] = (int) Math.round(1 + Math.random()*1);
//				System.out.print(picture[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println("solution : "+solution2(m, n, picture));
		
	}
	
	static Map<String,Integer> numMap2 = new LinkedHashMap<>();

	
	public static int[] solution(int m, int n, int[][] picture) {
        //그림에 몇 개의 영역
		int numberOfArea = 0;
		//가장 큰 영역은 몇 칸
        int maxSizeOfOneArea = 0;
        int top = 0, before = 0;
        int index = 1;
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(i >0 ) top = picture[i-1][j];
        		
        		if(before != 0 ) {
        			if(before == picture[i][j]) {
            			numList.add(index++);
            		}else {
            			index = 1;
            			numList.add(index++);
            		}
        		}
        		
        		before = picture[i][j];
        	}
        }
        
        System.out.println("numList : "+numList);
        
        int[] answer = new int[2];
        answer[0] = numberOfArea = numList.size();
        answer[1] = maxSizeOfOneArea = Collections.max(numList);
        System.out.println("answer : [ "+numberOfArea+" , "+maxSizeOfOneArea+" ]");
        return answer;
    }
	
	
	public static int[] solution3(int m, int n, int[][] picture) {
		//그림에 몇 개의 영역
		int numberOfArea = 0;
		//가장 큰 영역은 몇 칸
		int maxSizeOfOneArea = 0;
		int top = -1, before = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i > 0) top = picture[i-1][j];
				
				if(picture[i][j] != 0) {
					if(top != 0) {
						if(picture[i][j] == before) {
							numMap.put(picture[i][j], numMap.get(picture[i][j])+1);	
						}else {
							if(top == picture[i][j]) 
								numMap.put(picture[i][j], numMap.get(picture[i][j])+1);	
							else
								numMap.put(picture[i][j], 1);
						}
					}else{
						if(numMap.containsKey(picture[i][j])) {
							numList.add(numMap.get(picture[i][j]));
							numMap.remove(picture[i][j]);
							numMap.put(picture[i][j], 1);
						}
					}
				}
				
				before = picture[i][j];
				
			}
		}
		
		for(int key : numMap.keySet()) {
			numList.add(numMap.get(key));
		}
		
		
		int[] answer = new int[2];
		answer[0] = numberOfArea = numList.size();
		answer[1] = maxSizeOfOneArea = Collections.max(numList);
		System.out.println("answer : [ "+numberOfArea+" , "+maxSizeOfOneArea+" ]");
		return answer;
	}
	
	static Map<Integer,Integer> numMap = new LinkedHashMap<>();
	static List<Integer> numList = new ArrayList<Integer>();
	
	public static int[] solution2(int m, int n, int[][] picture) {
		
		// m = 6, n = 4
		//그림에 몇 개의 영역
		int numberOfArea = 0;
		//가장 큰 영역은 몇 칸
		int maxSizeOfOneArea = 0;
		int top = -1;
		
		for(int i=0; i<m; i++) {
			recursion(i, 0, picture, n, 0, top ,0);
		}
		
		for(int key : numMap.keySet()) {
			numList.add(numMap.get(key));
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea = numList.size();
		answer[1] = maxSizeOfOneArea = Collections.max(numList);
		System.out.println("answer : [ "+numberOfArea+" , "+maxSizeOfOneArea+" ]");
		return answer;
	}
	
	public static int recursion(int i, int j, int[][] picture, int len, int before, int top, int result) {

		if(len == j)
			return 0;
		
		if(i > 0) 
			top = picture[i-1][j];
		
		
		if(picture[i][j] != 0) {
			if(top != 0) {
				if(picture[i][j] == before) {
					numMap.put(picture[i][j], numMap.get(picture[i][j])+1);	
				}else {
					if(top == picture[i][j]) 
						numMap.put(picture[i][j], numMap.get(picture[i][j])+1);	
					else 
						numMap.put(picture[i][j], 1);
				}
			}else{
				if(numMap.containsKey(picture[i][j])) {
					numList.add(numMap.get(picture[i][j]));
					numMap.remove(picture[i][j]);
					numMap.put(picture[i][j], 1);
				}
			}
		}
		
		return recursion(i, j+1, picture, len, picture[i][j], top, result);
	}

}