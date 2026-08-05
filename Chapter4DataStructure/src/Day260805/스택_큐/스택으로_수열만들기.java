package Day260805.스택_큐;

import java.util.Scanner;
import java.util.Stack;

public class 스택으로_수열만들기 {
	public static void main (String[] args) {
		// 문제: 스택에 PUSH 하는 순서는 오름차순 지킨다.
		// 1. 변수: 스택 배열개수 입력받기, 그에 따른 배열 만들기, 오름차순, 예외처리용 boolean -> int, int[], num, boolean
		// 2. 스택 배열 값 넣기 -> 배열 길이만큼
		// 3. 한값씩 꺼내서 검사하기 -> 배열 길이만큼
			// 3 - 1 
				// if(배열 꺼낸 값 >= 오름차순 값) while(배열 꺼낸 값 >= 오름차순 값) push() + "+"붙이기. 
				//  pop() + "-"붙이기
			// 3 - 2
				// else(배열 꺼낸 값 < 오름차순 값) pop() + "-" 붙이기
				// 예외처리 근데 만약 (배열 꺼낸 값
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 받을 수
		int[] a = new int[n]; // 받은 수 b배열크기로 생성
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();;
		}
		
		// 스택 자료구조, 오름차순, 출력값 판별 boolean, 값담을 StringBuffer
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= num) { // 원소 값 >= 오름차순 값
				while (a[i] >= num) { // 원소 값 >= 오름차순 값일 때는 stack에 push, +하기
					stack.push(num++);
					sb.append("+\n");
				}
				// a[i] >= num 일 때 push 했고, a[i] < num 이라면 pop을 할 차례임 즉 배열값 < 오름차순 시 pop, -하기
				stack.pop();
				sb.append("-\n");
			}
			else { // 배열 값 < 오름차순 값
				int top = stack.pop(); // 
				if (top > a[i]) { // pop한 top값이 a[i]보다 큰 건 말이 안됨 a[i] 꺼내야 하는데 pop값 먼저 됨
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					sb.append("-\n");
				}
			}
		}
		if (result) {
			System.out.println(sb.toString());
		}
		
		
		
		
	}

}
