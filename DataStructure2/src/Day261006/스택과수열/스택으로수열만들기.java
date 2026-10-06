package Day261006.스택과수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택으로수열만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] a = new int[N];
		

		for (int i=0; i<N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		
		for (int i=0; i<a.length; i++) {
			int su = a[i];
			
			if (su >= num) {
				while (su >= num) {
					stack.push(num++);
					bw.append("+\n");
				}
				stack.pop();
				bw.append("-\n");
			}
			else {
				int n = stack.pop();
				if (n > su) {
					System.out.println("NO");
					result = false;
					break;
				}
				bw.append("-\n");
			}
		}
		
		if (result) {
			bw.flush();
			bw.close();
		}
		
		
		
	}

}
