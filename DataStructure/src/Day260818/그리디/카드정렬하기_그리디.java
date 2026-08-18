package Day260818.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_그리디 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 더한 값 계속 비교해야 함, 기본 오름차순
		
		for (int i = 0; i < n; i ++) {
			int data = Integer.parseInt(br.readLine());
			pq.add(data);
		}
		
		int sum = 0; // 묶음 더하는 값
		int data1 = 0; // 앞에 있는 수
		int data2 = 0; // 뒤에 있는 수
		
		while (pq.size() != 1) { // 우선순위큐 사이즈가 1이면 할 이유가 없으니까 그 외는 계속한다
			data1 = pq.remove();// 1번째 뽑기
			data2 = pq.remove(); // 1번째 바로 뒤 뽑기
			sum += data1 + data2; // 더한 값 sum에 저장
			pq.add(data1 + data2); // 그 더한 값을 다시 큐에 넣기
		}
		
		System.out.println(sum);
	}

}
