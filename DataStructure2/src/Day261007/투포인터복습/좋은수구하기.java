package Day261007.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 수 갯수
		
		int[] a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		int count=0;
		for (int k=0; k<n; k++) {
			int i=0;
			int j=n-1;
			
			while (i<j) {
				if(a[i] + a[j] == a[k]) {
					if (i!=k && j!=k) {
						count++;
						break;
					}
					else if(i==k) {
						i++;
					}
					else if (j==k) {
						j--;
					}
				}
				else if (a[i] + a[j] < a[k]) {
					i++;
				}
				else {
					j--;
				}
			}
		}
		System.out.println(count);
		
	}

}
