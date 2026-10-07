package Day261007.슬라이딩윈도우복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 숫자 수
		int l = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
		
		Deque<Node> deque = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while (!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			
			deque.addLast(new Node(i, now));
			
			if (deque.getFirst().node <= i-l) {
				deque.removeFirst();
			}
			bw.write(deque.getFirst().value + " ");
		}
		bw.flush();

	}
	public static class Node {
		int node;
		int value;
		
		Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}

}
