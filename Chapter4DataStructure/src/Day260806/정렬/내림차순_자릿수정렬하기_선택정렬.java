package Day260806.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내림차순_자릿수정렬하기_선택정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 값 받아오고 
		
		// 배열로 저장해야 함.
		int[] a = new int[str.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(str.substring(i, i + 1));
//			System.out.println(a[i]);
		}
		
		for (int i = 0; i < a.length; i++) {
			int max = i;
			
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[max]) {
					max = j;
				}
			}
			// swap, j for문에서 max가 갱신됐으면
			if (a[max] > a[i]) {
				int temp = a[i];
				a[i] = a[max];
				a[max] = temp;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		
		
	}
}
