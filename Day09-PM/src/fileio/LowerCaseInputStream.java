package fileio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 읽어들인 데이터가 소문자이면, 대문자로 변환해서 되돌려주는 입력 스트림
 */
public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	private int lowerToUpper(int b) {
		if (b >= 'a' && b <= 'z') {	// ASCII 코드 상 'a':97, 'z': 122, 'A':65, 'Z':90
			b -= ('a' - 'A');
		}
		return b;
	}
	
	@Override
	public int read() throws IOException {
		return lowerToUpper(super.read());
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int count = super.read(b, off, len);	// 읽은 바이트 수
		// 이번 회차에 읽은 데이터는 b[off] ~ b[off + count - 1]
		for (int i = off; i < off + count; i++) {
			b[i] = (byte) lowerToUpper(b[i]);
		}
		return count;
	}

}
