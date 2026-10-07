package Day261007.스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 스택으로수열만들기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int[] a = new int[n];
		
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		boolean result = true;
		int number = 1;
		
		for (int i=0; i<a.length; i++) {
			int su = a[i];
			
			
			if(su >= number) { // 입력받은 수가 number보다 크다면
				while (su>=number) {
					stack.push(number++);
					bw.append("+\n");
				}
				stack.pop();
				bw.append("-\n");
			}
			else {
				int popNum = stack.pop();
				
				if (popNum > su) {
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					bw.append("-\n");
				}
			}
			
		}
		if (result) {
			bw.flush();
			bw.close();
			
		}

	}

}
