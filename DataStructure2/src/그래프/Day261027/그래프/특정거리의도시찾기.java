package 그래프.Day261027.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {
	static boolean[] visited;
	static int n, m, k, x;
	static ArrayList<Integer>[] a;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 거리 수
		m = Integer.parseInt(st.nextToken()); // 도로 수
		k = Integer.parseInt(st.nextToken()); // 거리 정보
		x = Integer.parseInt(st.nextToken()); // 시작 번호

		a = new ArrayList[n];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 단방향
			a[s].add(e);
		}

		list = new ArrayList<>();
		visited = new boolean[n + 1];

		BFS(x);

		if (!list.isEmpty()) {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println(-1);
		}

	}

	private static void BFS(int now) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(now, 0));
		visited[now] = true;

		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();

			if (nowNode.count == k) {
				list.add(nowNode.start);
				continue;
			}

			for (int i : a[nowNode.start]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(new Node(i, nowNode.count + 1));
				}
			}
		}
	}

	private static class Node {
		int start;
		int count;

		Node(int start, int count) {
			this.start = start;
			this.count = count;
		}
	}

}
