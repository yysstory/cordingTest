package cordingTest.test4;


/*
4. 주식 투자
우선 이 문제를 출제해주신분께 감사드립니다. 가장 재미있게 풀었던 문제였습니다.

-핵심 알고리즘 설명
주식 투자에서 가장 중요한것은 미래가치 입니다. 
미래가치가 불분명해서 손해를 보는데 이같은 경우는 미래가치를 알고 있습니다. 
때문에 가장 고점을 알고 매일 1주씩 살수있다면 주가의 상관없이 최고점 전까지 매일 사서 최고점에서 팔면 됩니다.
그리고 최고점에서 판다음 나머지 시간의 최고점을 다시 찾아 그 고점보다 아래올때 부터 고점이 올때까지 다시 매입하여 
고점이 왔을때 팔면됩니다.
이것을 끝까지 계속 반복하다보면 최고의 이윤을 낼 수 있습니다.
이를 표현한 코드는 다음과 같습니다.
*/


import java.util.Scanner;

class Samsung {
	static int resultMoney(int infoArr, int[] dataArr) {
	
		int topNum=0;
		int total=0;
		int i=0;
		int [] newArr;
		int count=0;
		
		while(true){
			topNum = max(dataArr);
			if(topNum>dataArr[i]){
				total = total+(topNum-dataArr[i]);
			}else if(topNum==dataArr[i]){
				newArr = new int[dataArr.length-i-1]; 
				for(int j=0;j<dataArr.length-i-1;j++){
					newArr[j]=dataArr[i+j+1];
				}
				dataArr = newArr;
				if(count == (infoArr-1)){
					break;
				}
				i=0;
				count++;
				continue;
			}
			if(count == (infoArr-1)){
				break;
			}
			i++;
			count++;
		}
		return total;
	}

	
	
	static int max(int[] dataArr) {
		int max = dataArr[0];
		for (int i = 1; i < dataArr.length; i++) {
			if (dataArr[i] > max) {
				max = dataArr[i];
			}
		}
		return max;
	}
}

class Utils {

	static int[] strArrToIntArr(String[] strArr) {
		int[] newIntArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			newIntArr[i] = Integer.parseInt(strArr[i]);
		}
		return newIntArr;
	}
}

public class Test4 {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		int repeatCount = Integer.parseInt(in.nextLine().trim());
		int infoArr[] = new int[repeatCount];
		int dataArr[][] = new int[repeatCount][];

		for (int i = 0; i < repeatCount; i++) {
			infoArr[i] = Integer.parseInt(in.nextLine().trim());
			dataArr[i] = Utils.strArrToIntArr(in.nextLine().trim().split(" "));
		}

		for (int i = 0; i < repeatCount; i++) {
			System.out.println(Samsung.resultMoney(infoArr[i], dataArr[i]));
		}
	}

}
