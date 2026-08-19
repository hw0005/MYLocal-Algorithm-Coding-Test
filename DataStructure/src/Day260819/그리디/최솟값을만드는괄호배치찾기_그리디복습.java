package Day260819.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최솟값을만드는괄호배치찾기_그리디복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		int answer = 0; // 합
		
		for (int i = 0; i < str.length; i++) {
			int tempSum = mySum(str[i]);
			if (i == 0) {
				answer += tempSum;
			}
			else {
				answer -= tempSum;
			}
		}
		
		
		
		System.out.println(answer);
	}
	private static int mySum(String a) {
		int tempSum = 0;
		String[] tempStr = a.split("[+]");
		for (int i = 0; i < tempStr.length; i++) {
			tempSum += Integer.parseInt(tempStr[i]);
		}
		return tempSum;
		
	}

}
