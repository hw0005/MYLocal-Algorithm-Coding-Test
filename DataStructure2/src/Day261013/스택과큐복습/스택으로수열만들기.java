package Day261013.스택과큐복습;

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
		
		int n = Integer.parseInt(br.readLine()); // 수열의 수
		
		Stack<Integer> stack = new Stack<>();
		int number = 1;
		boolean result = true;
		
		for (int i=1; i<=n; i++) {
			int r = Integer.parseInt(br.readLine());
			
			if (r >= number) {
				while (r>=number) {
					stack.push(number++);
					bw.append("+\n");
				}
				stack.pop();
				bw.append("-\n");
			}
			else {
				int now = stack.pop();
				
				if (now > r) {
					System.out.println("NO");
					result  = false;
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
