package Day260805.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙_우선순위큐_구하기 {

	public static void main(String[] args) throws IOException {
		// 배열에 정수 넣기 -> priorityQueue로 할 거임 정렬 할 거기 때문에
		// 1. 절댓값이 가장 작은 값 하나일 때 그 값 출력 후 배열 제거
		// 2. 절댓값이 가장 작은 값 여러 개일 때 그 중 작은 수 출력 후 배열 제거(1 vs -1 시 -1 출력) -> 정렬해야됨
		// 3. 0 입력시 배열이 있다면 절댓값 가장 작은 값 출력, 없다면 0 출력. 0말고 다른 값 입력시 저장
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 우선순위큐 정렬해야하니까 선언. 최소힙이다 그니까 작은 수가 앞으로 가는 거야
		PriorityQueue<Integer> myPQ = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			//절댓값 같다면
			if (first_abs == second_abs) {
				return o1 > o2 ? 1 : -1; // 1, -1 이라면 "1"=양수 -1 기준 뒤로 가라.
			}
			// 절댓값 다르면
			else {
				return first_abs - second_abs;
			}
		});
		
		for (int i = 0; i < n; i++) {
			// 값 넣어야지 이제
			int request = Integer.parseInt(br.readLine());
			
			// 0 입력 시
			if (request == 0) {
				// 배열 있다면
				if (!myPQ.isEmpty()) {
					System.out.println(myPQ.poll());
				}
				else {
					System.out.println("0");
				}
			}
			// 0 입력 아닐 시
			else {
				myPQ.add(request);
			}
		}
		
		
		
	}

}
