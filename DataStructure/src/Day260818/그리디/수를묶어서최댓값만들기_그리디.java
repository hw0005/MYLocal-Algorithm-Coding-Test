package Day260818.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수를묶어서최댓값만들기_그리디 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 4가지 대분류. 1보다 클 때 / 1개수 / 0개수 / 음수
		// 값넣기
		PriorityQueue<Integer> plusPQ = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순 Collections.reverseOrder()해도 되긴 하지만,,
		PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
		int zero = 0;
		int one = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			int data = Integer.parseInt(br.readLine());
			
			if (data > 1) {
				plusPQ.offer(data);
			}
			else if (data == 1) {
				one++;
			}
			else if (data == 0) {
				zero++;
			}
			else {
				minusPQ.offer(data);
			}
		}
		
		// 양수처리
		while (plusPQ.size() > 1) {
			int first = plusPQ.poll();
			int second = plusPQ.poll();
			sum += first * second;
		}
		if (!plusPQ.isEmpty()) { // 비어있지 않으면 더해
			sum += plusPQ.poll();
		}
		
		// 양수처리
		while (minusPQ.size() > 1) {
			int first = minusPQ.poll();
			int second = minusPQ.poll();
			sum += first * second;
		}
		if (!minusPQ.isEmpty()) {
			// 0이 없으면 그냥 더해
			if (zero == 0) {
				sum += minusPQ.poll();
			}
			// 0이 있으면 곱해 근데 연산하면 결국 0이라 굳이 필요없음
			else {
//				sum += minusPQ.poll() * 0;
//				zero--;
			}
		}
		// 1처리
		sum += one;
		System.out.println(sum);
		
	}

}
