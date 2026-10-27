package 그래프.Day261027.그리디복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수를묶어서최댓값만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 수의 개수
		
		PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
		
		int zero = 0;
		int one = 0;
		
		for (int i=0; i<n; i++) {
			int r = Integer.parseInt(br.readLine());
			
			if(r==0) {
				zero++;
			}
			else if(r==1) {
				one++;
			}
			else if(r>1) {
				plusPQ.offer(r);
			}
			else {
				minusPQ.offer(r);
			}
		}
		
		int sum = 0;
		
		while (plusPQ.size() > 1) {
			int data1 = plusPQ.poll();
			int data2 = plusPQ.poll();
			
			sum += data1 * data2;
		}
		
		if(!plusPQ.isEmpty()) {
			sum += plusPQ.poll();
		}
		
		while (minusPQ.size() > 1) {
			int data1 = minusPQ.poll();
			int data2 = minusPQ.poll();
			
			sum += data1 * data2;
		}
		if(!minusPQ.isEmpty()) {
			if(zero==0) {
				sum += minusPQ.poll();
			}
		}
		
		sum += one;
		
		System.out.println(sum);

	}

}
