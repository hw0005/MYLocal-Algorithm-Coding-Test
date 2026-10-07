package Day261007.스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 수열크기
		
		int[] arr = new int[n];
		int[] answer = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for (int i=1; i<n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(answer[i] + " ");
		}

	}

}
