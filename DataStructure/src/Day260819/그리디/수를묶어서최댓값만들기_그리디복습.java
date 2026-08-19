package Day260819.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수를묶어서최댓값만들기_그리디복습 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 음수일 때, 0일 때, 1일 때, 1이상인 양수일 때를 구분
		int zero = 0;
		int one = 0;
		PriorityQueue<Integer> plusPQ = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순
		PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
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
		
		// 양수처리하기
		while (plusPQ.size() > 1) {
			int data1 = plusPQ.poll();
			int data2 = plusPQ.poll();
			
			sum += data1 * data2;
		}
		if (!plusPQ.isEmpty()) {
			sum += plusPQ.poll();
		}
		
		// 음수 처리하기
		while (minusPQ.size() > 1) {
			int data1 = minusPQ.poll();
			int data2 = minusPQ.poll();
			
			sum += data1 * data2;
		}
		
		if (!minusPQ.isEmpty()) {
			if (zero == 0) {
				sum += minusPQ.poll();
			}
		}
		
		// 1 처리
		sum += one;
		
		
		
		System.out.println(sum);
	}

}
