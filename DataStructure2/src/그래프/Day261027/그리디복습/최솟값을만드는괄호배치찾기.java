package 그래프.Day261027.그리디복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최솟값을만드는괄호배치찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split("-");
		
		int sum =0;
		for (int i=0; i<a.length; i++) {
			int tempSum = partSum(a[i]);
			
			if (i==0) {
				sum += tempSum;
			}
			else {
				sum -= tempSum;
			}
			
		}
		
		System.out.println(sum);
	}
	
	private static int partSum (String now) {
		int tempSum = 0;
		String[] nowStr = now.split("[+]");
		
		for (int i=0; i<nowStr.length; i++) {
			tempSum += Integer.parseInt(nowStr[i]);
		}
		return tempSum;
	}
}
