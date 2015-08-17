

package cordingTest.test5;

/*

5. 더 큰 문자열
 
-핵심 알고리즘 설명
문자열을 입력받아 char형 배열로 만들었습니다. 이와 같이하면 비교하기가 가능해지기 때문입니다.
이렇게 만들어진 char배열은 뒤에서부터 비교하여 뒤 문자보다 앞문자가 작다면 이벤트를 발생하게하여
이벤트가 발생한 부분부터 마지막까지 새로운 배열에 복사 했습니다.
복사된 배열을 주어진 조건에 맞춰 정렬하여 기존 배열에 그 부분을 덮어쓰는 방식으로 구현했습니다.

*/

import java.util.Arrays;
import java.util.Scanner;


class CharSort {
	static String sortStart(String str) {
		char imsiChar;
		char [] ch = str.toCharArray();
		for(int i=ch.length-1;i>=0;i--){
			if(i==0){
				return "no answer";
			}
			if(ch[i-1] < ch[i]){
				char [] newCharArr = new char[ch.length-i];
				for(int j=0;j<ch.length-i;j++){
					newCharArr[j]=ch[i+j];
				}
				Arrays.sort(newCharArr);
				for(int j=0;j<newCharArr.length;j++){
					if(ch[i-1]<newCharArr[j]){
						imsiChar = ch[i-1];
						ch[i-1] = newCharArr[j];
						newCharArr[j] = imsiChar;
						break;
					}
				}
				Arrays.sort(newCharArr);
				for(int j=0;j<ch.length-i;j++){
					ch[i+j]=newCharArr[j];
				}
				break;
			}
		}
		return new String(ch,0,ch.length);
	}
}

public class Test5 {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		int repeatCount = Integer.parseInt(in.nextLine().trim());
		String infoArr[] = new String[repeatCount];

		for (int i = 0; i < repeatCount; i++) {
			infoArr[i] = in.nextLine().trim();
		}
		for (int i = 0; i < repeatCount; i++) {
			System.out.println(CharSort.sortStart(infoArr[i]));
		}
	}

}
