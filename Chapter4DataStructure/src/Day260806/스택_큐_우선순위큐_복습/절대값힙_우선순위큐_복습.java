package Day260806.스택_큐_우선순위큐_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_우선순위큐_복습 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1. 절댓값 가장 작은 값 출력 후 배열 제거
		// 2. 절댓값 가장 작은 값 여러 개일 경우 가장 작은 수 출력, 배열에서 제거
		// 3. 입력에서 0이 주어진 횟수만큼 출력. 만약 빈 배열 아니라면 절댓값 가장 작은 값 출력. 빈배열이라면 0출력
		
		
		// n개 받기 연산 개수 n개 받기
		int n = Integer.parseInt(br.readLine());

		// 비교 로직 o1, o2 해서 작은 것 앞으로 보내기 큐 o1: 들어온 것, o2: 기존에 있던 것
		PriorityQueue<Integer> myPQ = new PriorityQueue<> ((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			
			// 절댓값 같다면 둘 중에 비교해서 작은 게 앞으로 가기
			if (first_abs == second_abs) {
				return o1 > o2 ? 1 : -1;
			}
			// 절댓값 다르다면, 들어온 것 기존에 있던 것 중 절댓값 큰 게 뒤로 가기 즉 들어온 것 - 기존에 있던 것 == 양수면 뒤 음수면 앞
			else {
				return first_abs - second_abs;
			}
		});
		
		for (int i = 0; i < n; i++) {
			int request = Integer.parseInt(br.readLine());
			
			if (request == 0) {
				if (myPQ.isEmpty()) {
					System.out.println("0");
				}
				else {
					System.out.println(myPQ.poll());
				}
			}
			else {
				myPQ.add(request);
			}
			
		}
		
		
		
		
	}

}
