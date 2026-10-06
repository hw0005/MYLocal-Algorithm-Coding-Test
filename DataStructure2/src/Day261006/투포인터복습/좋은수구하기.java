package Day261006.투포인터복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋은수구하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n  = Integer.parseInt(br.readLine());
		
		int[] d = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int k=0; k<n; k++) {
			int i = 0;
			int j = n-1;
			
			while (i<j) {
				if (d[i] + d[j] == d[k]) {
					if(i!=k && j!=k) {
						count++;
						break;
					}
					else if(i==k) {
						i++;
					}
					else if(j==k) {
						j--;
					}
				}
				else if (d[i] + d[j] > d[k]) {
					j--;
				}
				else {
					i++;
				}
			}
		}
		System.out.println(count);
	}

}
