package Day260805.스택_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드게임_큐 {

	public static void main(String[] args) {
		//변수: 카드 개수 받을 것 N, 1~N 차례대로 받을 Queue 생성 myQueue, Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 큐 선언
		Queue<Integer> myQueue = new LinkedList<>();
		// 큐에 원소 넣기
		for (int i = 1; i <= n; i++) {
			myQueue.add(i);
		}
		
		// 큐의 사이즈가 0기 직전 즉 큐 사이즈 > 1까지 반복: 삭제 -> 그 다음 거 삭제 후 삽입
		while (myQueue.size() > 1) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
		}
		System.out.println(myQueue.peek()); // 출력
		
		
		
		
	}

}
