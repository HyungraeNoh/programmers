package exercise.all.lvl2.lifeboat.parksohyun;

import java.util.Arrays;

public class Lifeboat {

	public static void main(String[] args) {
		int[] people = {10,20,30,40,50,60,100};
		int limit =100;
		
		int[] people2 = {40, 40, 40, 40, 40, 40};
		int limit2 = 240;
		
		System.out.println(solution(people2,limit2));
	}
 
	public static int solution2(int[] people, int limit) {
		int answer = 0;		
		Arrays.sort(people); //오름차순
		
		//20,30,50,80,90
		int i=0;
		for(int j=people.length-1;j>=i;j--) {
			if(people[j]+people[i]>limit) {
				answer++;
				System.out.println("i : "+people[i]+", j : "+people[j]);
			}else {
				answer++;
				System.out.println("i : "+people[i]+", j : "+people[j]);
				i++;
			}
		}

		return answer;
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people); //오름차순
		//20,30,50,80,90
		//10,20,30,40,50,60
		//29,49,11,23,55
		int jLen=people.length;
		for(int i=0;i<people.length;i++){
			for(int j=jLen-1;j>=i;j--) {
				if(people[j]+people[i]>limit) {
					System.out.println("i : "+people[i]+", j : "+people[j]);
					answer++;
				}else {
					System.out.println("i : "+people[i]+", j : "+people[j]);
					jLen=j;
					answer++;
					break;
				}
			}
		}
		return answer;
	}

}