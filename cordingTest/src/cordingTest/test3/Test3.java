package cordingTest.test3;


/*
	3. 9와 0
	
	-핵심 알고리즘 설명
	9와 0으로만 이루어진 수 중 임의값의 배수를 찾기 위해 1부터 카운트하는것은 비효율적입니다.
	9와 0으로만 이루어진 수는 0과 1로만 이루어진 2진수와 비슷한 형태 이므로
	2진수라 가정하고 치환하여 계산하면 더욱 효율적일것으로 생각해 코드를 작성했습니다.

 */

import java.math.BigInteger;
import java.util.Scanner;


class Multiple{
	static Long check (String su) {
		int i=1;
		while(true){
			String binStrArr[] = Integer.toBinaryString(i).split("");
			String numberStr ="";
			for(String bin : binStrArr){
				if(bin.endsWith("1")){
					numberStr = numberStr+"9";
				}else{
					numberStr = numberStr+"0";
				}
			}
			BigInteger b1= new BigInteger(numberStr);
			if(b1.remainder(new BigInteger(su)).equals(new BigInteger("0"))){
				return Long.parseLong(numberStr);	
			}
			i++;
		}
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

public class Test3 {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		int repeatCount = Integer.parseInt(in.nextLine().trim());
		String infoArr[] = new String[repeatCount];

		for (int i = 0; i < repeatCount; i++) {
			infoArr[i] = in.nextLine().trim();
		}
		for (int i = 0; i < repeatCount; i++) {
			System.out.println(Multiple.check(infoArr[i]));
		}
	}

}
