package cordingTest.test2;

/*
2. 배열의 무게 중심

-핵심 알고리즘
죄우측 덧셈을 모두 매번 반복하는것은 비효율적입니다.
모든 수의 합을 우선 구해서
검사할때마다 그 차이만큼 한번씩만 빼주어 좌우 균형을 찾는것이 
더 효율적이라 생각하여 코드를 작성했습니다.

*/


import java.util.Scanner;


class ArrEqual {
	static String yesOrNo(int infoArr, int[] dataArr) {

		int leftSum = 0;
		int rightSum = 0;
		int total = 0;

		for (int i = 0; i < dataArr.length; i++) {
			total = total + dataArr[i];
		}

		if ((total - dataArr[0]) == 0 || (total - dataArr[dataArr.length-1]) == 0) {
			return "YES";
		}

		for (int i = 1; i < dataArr.length - 1; i++) {
			leftSum = leftSum + dataArr[i - 1];
			rightSum = total - dataArr[i] - leftSum;
			if (leftSum == rightSum) {
				return "YES";
			}
		}

		return "NO";
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

public class Test2 {

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
			System.out.println(ArrEqual.yesOrNo(infoArr[i], dataArr[i]));
		}
	}

}
