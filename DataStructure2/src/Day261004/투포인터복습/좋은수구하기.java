package Day261004.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋은수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] s = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
	
		int count = 0;
		
		for (int k=0; k<n; k++) {
			int i = 0;
			int j = n-1;
			while (i<j) {
				if (s[i] + s[j] == s[k]) { // 둘 합이 k라면
					if (i !=k && j!=k) { // 만약 i와 j가 둘 다 k가 아니라면
						count++;
						break;
					}
					else if (i==k) {
						i++;
					}
					else if (j==k) {
						j--;
					}
				}
				else if(s[i] + s[j] < s[k]) {
					i++;
				}
				else if (s[i] + s[j] > s[k]) {
					j--;
				}
			}
		}
		
		System.out.println(count);
	}

}
