package Day261001.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균구하기 {
	static int n, sum, max;
	static int[] score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		score = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = 0;
		max = 0;
		for (int i=1; i<=n; i++) {
			max = Math.max(max, score[i]);
			sum += score[i];
		}
		
		System.out.println((double)sum / max * 100 / n);
		
	}

}
