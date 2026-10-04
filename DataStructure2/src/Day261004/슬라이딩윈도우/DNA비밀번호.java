package Day261004.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호 {
	static int[] checkArr;
	static int[] myArr;
	static int checkS;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken()); // 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 부분문자열 길이
		char[] a = new char[s];
		
		a = br.readLine().toCharArray();
		checkArr = new int[4];
		myArr = new int[4];
		checkS = 0;
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			
			if (checkArr[i] == 0) {
				checkS++;
			}
		}
		
		for (int i=0; i<p; i++) {
			Add(a[i]);
		}
		
		if (checkS == 4) {
			count++;
		}
		
		for (int i=p; i<s; i++) {
			Add(a[i]);
			
			int j = i-p;
			Remove(a[j]);
			
			if (checkS == 4) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void Remove(char c) {
		switch(c) {
		case 'A':
			if (myArr[0] == checkArr[0]) {
				checkS--;
			}
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) {
				checkS--;
			}
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) {
				checkS--;
			}
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) {
				checkS--;
			}
			myArr[3]--;
			break;
		}
	}
	
	private static void Add(char c) {
		switch (c) {
		case 'A': 
			myArr[0]++;
			if (myArr[0] == checkArr[0]) {
				checkS++;
			}
			break;
		case 'C': 
			myArr[1]++;
			if (myArr[1] == checkArr[1]) {
				checkS++;
			}
			break;
		case 'G': 
			myArr[2]++;
			if (myArr[2] == checkArr[2]) {
				checkS++;
			}
			break;
		case 'T': 
			myArr[3]++;
			if (myArr[3] == checkArr[3]) {
				checkS++;
			}
			break;
		}
	}
	
}
