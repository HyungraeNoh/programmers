package exercise.all.lvl2.coloringBook.nohhyungrae;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * 입력형식
 * 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는  m X n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.
 * - 1 <= m, n <= 100
 * - picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
 * - picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
 * 
 * 출력형식
 * 리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.
 * 
 */
public class ColoringBook {
	
	private int m,n = 0;
	private int[][] picture;
	private int numberOfArea;
	private int maxSizeOfOneArea;
	private PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
	
	public ColoringBook(int m, int n, int[][] picture) {
		this.m = m;
		this.n = n;
		this.picture = makePicture(picture);
	}

	public static void main(String[] args) {
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
//		System.out.println("solution : "+solution2(m, n, picture));
		
		int m = 6; 
		int n = 4;
		int[][] picture = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//picture[i][j] = (int) Math.round(1 + Math.random()*1);
				picture[i][j] = (int) Math.round(Math.random()*3);
			}
		}
		ColoringBook coloringBook = new ColoringBook(m,n,picture);
		System.out.println("coloringBook : "+coloringBook.solution());
		
	}
	
	public int[] solution() {
		int[] answer = new int[2];
		printPicture();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(picture[i][j] !=0) {
					
					int number = picture[i][j];
					picture[i][j] = 0;
					findNumber(i, j,number);
					que.add(maxSizeOfOneArea);
					maxSizeOfOneArea = 0;
				}
			}
		}
		
		printPicture();
		
		answer[0] = numberOfArea;
        answer[1] = que.peek();
        System.out.println("answer : [ "+numberOfArea+" , "+maxSizeOfOneArea+" ]");
		return answer;
	}
	
	public void findNumber(int m, int n, int num) {
		printPicture();
		
		int[] origin = {m,n};
		Stack<int[]> coordinateStack = new Stack<>();
		
		
		coordinateStack.add(origin);
		
		includeCoordinates(origin, coordinateStack);

//		if(m-1 >= 0 && picture[n][m-1] == num) {
//			maxSizeOfOneArea++;
//			picture[n][m-1] = 0;
//			findNumber(m-1,n,num);
//		}else if(n-1 >= 0 && picture[n-1][m] == num) {
//			maxSizeOfOneArea++;
//			picture[n-1][m] = 0;
//			findNumber(m,n-1,num);
//		}else if(n+1 < picture.length && picture[n+1][m] == num) {
//			maxSizeOfOneArea++;
//			picture[n+1][m] = 0;
//			findNumber(m,n+1,num);
//		}else if(m+1 < picture[n].length && picture[n][m+1] == num) {
//			maxSizeOfOneArea++;
//			picture[n][m+1] = 0;
//			findNumber(m+1,n,num);
//		}else{
//			return;
//		}
		
	}
	
	private int[][] makePicture(int[][] picture){
		int[][] cpPicture = picture;
		
		for (int i = 0; i < cpPicture.length; i++) {
			for (int j = 0; j < cpPicture[i].length; j++) {
				cpPicture[i][j] = picture[i][j];
			}
		}
		
		return cpPicture;
	}
	
	private void printPicture() {
		for(int i : picture[0]) { System.out.print("="); }
		System.out.println();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(picture[i][j]);
			}
			System.out.println();
		}
		
		for(int i : picture[0]) { System.out.print("="); }
		System.out.println();
	}
	
	private Stack<int[]> includeCoordinates(int[] origin, Stack<int[]> coordinateStack){
		coordinateStack.add(new int[]{origin[0]+1, origin[0]});
		coordinateStack.add(new int[]{origin[0]-1, origin[0]});
		coordinateStack.add(new int[]{origin[0], origin[0]+1});
		coordinateStack.add(new int[]{origin[0], origin[0]-1});
		return coordinateStack;
	}
	
	static Map<Integer,Integer> numMap = new LinkedHashMap<>();
	static List<Integer> numList = new ArrayList<Integer>();
	
	public static int[] solution3(int m, int n, int[][] picture) {
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
	
	//map이용
	public static int[] solution2(int m, int n, int[][] picture) {
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
	


}