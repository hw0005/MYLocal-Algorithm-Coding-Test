package Day261022.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수를묶어서최댓값만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> mPQ = new PriorityQueue<>();
		PriorityQueue<Integer> pPQ = new PriorityQueue<>(Collections.reverseOrder());
		int zero = 0;
		int one = 0;
		int sum = 0;
		
		for (int i=0 ;i<n; i++) {
			int r = Integer.parseInt(br.readLine());
			if (r > 1) {
				pPQ.add(r);
			}
			else if(r == 1) {
				one++;
			}
			else if(r == 0) {
				zero++;
			}
			else {
				mPQ.add(r);
			}
			
		}
		
		
		while (pPQ.size() > 1) {
			int data1 = pPQ.poll();
			int data2 = pPQ.poll();
			
			sum += data1 * data2;
		}
		if (!pPQ.isEmpty()) {
			sum += pPQ.poll();
		}
		
		while (mPQ.size() > 1) {
			int data1 = mPQ.poll();
			int data2 = mPQ.poll();
			
			sum += data1 * data2;
		}
		if (!mPQ.isEmpty()) {
			if(zero == 0) {
				sum += mPQ.poll();
			}
		}
		
		sum += one;
		
		System.out.println(sum);
	}

}
