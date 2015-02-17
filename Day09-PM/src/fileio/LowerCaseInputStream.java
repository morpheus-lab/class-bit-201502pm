package fileio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �о���� �����Ͱ� �ҹ����̸�, �빮�ڷ� ��ȯ�ؼ� �ǵ����ִ� �Է� ��Ʈ��
 */
public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	private int lowerToUpper(int b) {
		if (b >= 'a' && b <= 'z') {	// ASCII �ڵ� �� 'a':97, 'z': 122, 'A':65, 'Z':90
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
		int count = super.read(b, off, len);	// ���� ����Ʈ ��
		// �̹� ȸ���� ���� �����ʹ� b[off] ~ b[off + count - 1]
		for (int i = off; i < off + count; i++) {
			b[i] = (byte) lowerToUpper(b[i]);
		}
		return count;
	}

}
