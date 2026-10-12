package Day261012.스택과큐복습;

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
		int n = Integer.parseInt(br.readLine()); // 수열의 개수
		
		Stack<Integer> stack = new Stack<>();
		boolean result = true;
		int number = 1;
		
		for (int i=0; i<n; i++) {
			int request = Integer.parseInt(br.readLine());
			
			if (request >= number) {
				while (request>=number) {
					stack.push(number++);
					bw.append("+\n");
				}
				stack.pop();
				bw.append("-\n");
			}
			
			else {
				int now = stack.pop();
				
				if (now > request) {
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
