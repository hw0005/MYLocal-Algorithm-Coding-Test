package Day260806.스택_큐_우선순위큐_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드게임_큐_복습 {

	public static void main(String[] args) throws IOException{
		// N 개 받으면 1~N 저장 후 가장 위에 있는 카드 버리고, 그 다음 카드를 맨 아래로
		// 큐로 풀어야돼. 가장front 삭제(poll), 그 다음 front는 삭제(poll) 후 rear(add)로 가
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//담을 큐 선언 및 추가
		Queue<Integer> myQueue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			myQueue.add(i);
		}
		
		// 삭제 및 추가 로직 크기 0되는 순간 종료
		while (myQueue.size() > 1) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
		}
		System.out.println(myQueue.peek());
	}

}
