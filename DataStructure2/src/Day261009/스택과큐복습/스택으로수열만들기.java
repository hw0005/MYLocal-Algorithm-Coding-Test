package Day261009.스택과큐복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택으로수열만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		boolean result = true;
		int number = 1;
		
		for (int i=0; i<n; i++) {
			int su = a[i];
			
			if (su >=number) {
				while (su>= number) {
					stack.push(number++);
					bw.append("+\n");
				}
				
				stack.pop();
				bw.append("-\n");
			}
			else {
				int now = stack.pop();
				
				if (now > su) {
					System.out.println("NO");
					result = false;
					break;
				}
				
				bw.append("-\n");
			}
		}
		
		if(result) {
			bw.flush();
			bw.close();
		}
		
	}

}
