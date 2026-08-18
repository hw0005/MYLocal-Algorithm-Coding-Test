package Day260806.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오름차순_수정렬하기1_버블정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//배열 생성 및 넣기
		int[] nArr = new int[n];
		for (int i = 0; i < nArr.length; i++) {
			int request = Integer.parseInt(br.readLine());
			
			nArr[i] = request;
		}
		
		// 정렬 하자
		for (int i = 0; i < nArr.length - 1; i++) {
			for (int j = 0; j < nArr.length - 1 - i; j++) {
				if (nArr[j] > nArr[j + 1]) {
					int temp = nArr[j + 1];
					nArr[j + 1] = nArr[j];
					nArr[j] = temp;
				}
				
				
			}
		}
		
		// 차례대로 출력
		for (int i = 0; i < nArr.length; i++) {
			System.out.println(nArr[i]);
		}
		
		
	}

}
