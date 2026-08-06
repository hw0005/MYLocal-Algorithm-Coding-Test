package Day260806.스택_큐_우선순위큐_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택으로수열만들기_복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 개수 받을 n생성
		int n = Integer.parseInt(br.readLine());
		// 배열 생성 및 저장
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			// 수 받기
			a[i] = Integer.parseInt(br.readLine());
		}
		
		// 스택 선언
		Stack<Integer> stack = new Stack<>();
		//오름차순 용 num
		int num = 1;
		// 출력 용 boolean
		boolean result = true;
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < n; i++) {
			// 받은 수
			
			// 1. 만약 a[i] >= num
				// a[i] < num 까지 계속 push 후 num++ "+" 저장
				// a[i] >=num 되는 순간 깨고, pop하고 "-" 저장
			if (a[i] >= num) {
				while (a[i] >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			
			// 2. a[i] < num 
				// 위의 조건에 의해서 num보다 작은 건 무조건 push 돼있음 그래서 pop
				// 근데 말이야 그 pop한 게(top)가 top > a[i]면 false, break, NO출력
				// 아니라면 pop했으니까 "-"출력
			else {
				int top = stack.pop(); // pop했어
				if (top > a[i]) {
					System.out.println("NO");
					result = false;
					break;
				}
				sb.append("-\n");
			}
		}
		if (result) {
			System.out.println(sb.toString());
		}
		
		
	}

}
