package Day261022.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		
		while (pq.size() > 1) {
			int data1 = pq.poll();
			int data2 = pq.poll();
			
			sum += data1 + data2;
			
			pq.add(data1 + data2);
		}
		System.out.println(sum);

	}

}
