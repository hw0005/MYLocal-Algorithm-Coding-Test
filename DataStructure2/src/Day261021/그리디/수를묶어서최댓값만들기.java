package Day261021.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수를묶어서최댓값만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
		int one = 0;
		int zero = 0;
		
		for (int i=0; i<n; i++) {
			int data = Integer.parseInt(br.readLine());
			
			if (data > 1) {
				plusPQ.add(data);
			}
			else if(data ==1) {
				one++;
			}
			else if(data == 0) {
				zero++;
			}
			else {
				minusPQ.add(data);
			}
		}
		
		int sum = 0;
		
		while (plusPQ.size() > 1) {
			int f = plusPQ.poll();
			int s = plusPQ.poll();
			sum += f * s;
		}
		
		if (!plusPQ.isEmpty()) {
			sum += plusPQ.poll();
		}
		
		while (minusPQ.size() > 1) {
			int f = minusPQ.poll();
			int s = minusPQ.poll();
			
			sum += f * s;
		}
		
		if (!minusPQ.isEmpty()) {
			if(zero == 0) {
				sum += zero * minusPQ.poll();
			}
		}
		
		sum += one;
		
		System.out.println(sum);

	}

}
