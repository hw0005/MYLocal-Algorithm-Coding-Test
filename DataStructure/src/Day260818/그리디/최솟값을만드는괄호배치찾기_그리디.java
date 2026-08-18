package Day260818.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최솟값을만드는괄호배치찾기_그리디 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String example = br.readLine();
		String[] str = example.split("-");
		int answer = 0;
		
		for (int i = 0; i < str.length; i++) {
			int tempValue = mySum(str[i]);
			if (i == 0) {
				answer += tempValue;
			}
			else {
				answer -= tempValue;
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
