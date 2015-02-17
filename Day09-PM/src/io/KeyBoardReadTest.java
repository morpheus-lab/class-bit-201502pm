package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardReadTest {
	
	public static void main(String[] args) {
		
		InputStream in = System.in;	// 키보드를 통해 입력되는 데이터를 읽어 들일 수 있는
									// 기본 InputStream (Byte Stream)
		
		InputStreamReader reader = new InputStreamReader(in);	// in 객체에 문자 단위 읽기 기능 추가
		
		BufferedReader bReader = new BufferedReader(reader);	// reader 객체에 버퍼를 추가해서 줄 단위로 문자 읽기 기능 추가
		
		try {
			while (true) {
				System.out.println("문자열을 입력하세요.");
				String s = bReader.readLine();
				System.out.println(s);
				
				if (s.equals("/quit")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {}
			}
		}
		
	}
	
}
