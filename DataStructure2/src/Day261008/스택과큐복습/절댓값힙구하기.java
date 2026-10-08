package Day261008.스택과큐복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 절댓값힙구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int fa = Math.abs(o1);
			int sa = Math.abs(o2);
			
			if (fa==sa) {
				return o1 > o2 ? 1 : -1;
			}
			else {
				return fa > sa ? 1 : -1;
			}
		});
		
		for (int i=0; i<n; i++) {
			int now = Integer.parseInt(br.readLine());
			
			if (now == 0) {
				if (pq.isEmpty()) {
					bw.append("0\n");
				}
				else {
					bw.append(pq.poll() + "\n");
				}
			}
			else {
				pq.add(now);
			}
			
		}
		
		bw.flush();
		
	}

}
