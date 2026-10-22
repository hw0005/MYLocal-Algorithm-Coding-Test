package Day261022.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최솟값을만드는괄호배치찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		String[] str = input.split("-");
		int sum =0;
		
		for (int i=0; i<str.length; i++) {
			int temp = SumStr(str[i]);
			
			if (i==0) {
				sum += temp;
			}
			else {
				sum -= temp;
			}
		}
		System.out.println(sum);
		

	}
	
	private static int SumStr(String a) {
		String[] temp = a.split("[+]");
		int tempSum = 0;
		
		for (int i=0; i<temp.length; i++) {
			tempSum += Integer.parseInt(temp[i]);
		}
		
		return tempSum;
	}

}
