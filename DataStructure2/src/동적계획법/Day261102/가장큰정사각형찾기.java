package 동적계획법.Day261102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰정사각형찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // n
		int m = Integer.parseInt(st.nextToken()); // m

		int[][] d = new int[n + 1][m + 1];

		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++) {
				int val = line.charAt(j - 1) - '0';
				if (val == 1) {
					d[i][j] = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1])) + 1;
					if (max < d[i][j]) {
						max = d[i][j];
					}
				}
			}
		}

		// 넓이 출력 (한 변의 길이 * 한 변의 길이)
		System.out.println(max * max);

	}

}
