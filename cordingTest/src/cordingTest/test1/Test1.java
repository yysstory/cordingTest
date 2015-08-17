
package cordingTest.test1;

/*
	1. 정수쌍(Pairs)
	
	-핵심 알고리즘 설명
	퀵소트를 사용하면 시간 복잡도가 N log N 로 가까워지나
	자바에서 지원하는 Array.sort 를 사용했습니다.
	정렬된 배열의 기준 숫자에서 주어진 차이를 더해 만족하는 것이 있는지 for문을 통해 판단했습니다.
	만족하는 것이 있다면 카운트 올려 반환합니다.

*/

import java.util.Arrays;
import java.util.Scanner;


class Utils {
	static int [] strArrToIntArr(String [] strArr){
		int[] newIntArr = new int[strArr.length];
		for(int i = 0; i<strArr.length; i++){
			newIntArr[i] = Integer.parseInt(strArr[i]);
		}
		return newIntArr;
	}
}


class Pairs { 
	  static int pairsCount(int [] infoArr,int [] dataArr) {
		  int count = 0;
		  Arrays.sort(dataArr);
		  for(int i=0;i<dataArr.length; i++){
			  for(int j=i+1;j<dataArr.length;j++){
				  if(dataArr[j]==dataArr[i]+infoArr[1]){
					  count++;
					  break;
				  }else if(dataArr[j]>dataArr[i]+infoArr[1]){
					  break;
				  }
			  }
		  }
		  return count;
	  }
}

public class Test1 {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
	    String [] infoArray = in.nextLine().trim().split(" ");
	    String [] dataArray = in.nextLine().trim().split(" ");
		
	    System.out.println(Pairs.pairsCount(Utils.strArrToIntArr(infoArray),Utils.strArrToIntArr(dataArray)));
	}
}
