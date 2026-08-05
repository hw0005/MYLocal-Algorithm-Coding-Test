package Day260805.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙_구하기 {

	public static void main(String[] args) throws IOException {
		// 배열에 정수 넣기
		// 1. 절댓값이 가장 작은 값 하나일 때 그 값 출력 후 배열 제거
		// 2. 절댓값이 가장 작은 값 여러 개일 때 그 중 작은 수 출력 후 배열 제거(1 vs -1 시 -1 출력) -> 정렬해야됨
		// 3. 0 입력시 배열이 있다면 절댓값 가장 작은 값 출력, 없다면 0 출력. 0말고 다른 값 입력시 저장
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 리스트(배열) 선언
		PriorityQueue<Integer> myPQ = new PriorityQueue<>((o1, o2) -> { // o1 새로들어온 값, o2 원래 있던 값
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			
			// o1이 양수이고, o2가 음수라는 기준
			// 둘이 절댓값 같다면
			if (first_abs == second_abs) {
				return o1 > o2 ? 1 : -1;
			}
			// 둘이 절댓값 다르다면
			else {
				return first_abs - second_abs; // 무조건 양수가 되는 거 아닌가?
			}
		});
		
		for (int i = 0; i < n; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) { // 0이면 
				if (myPQ.isEmpty()) { // 비어있으면
					System.out.println("0"); // 0출력
				}
				else { // 안 비어있으면
					System.out.println(myPQ.poll()); // 해당 값 출력
				}
			} // 0 아니면 저장
			else {
				myPQ.add(request);
			}
		}
		
		
	}

}
