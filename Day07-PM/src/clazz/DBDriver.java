package clazz;

import java.sql.ResultSet;

public interface DBDriver {
	
	void connect();		// DB�� ����
	void disconnect();	// DB�κ��� ���� ����
	
	ResultSet query(String sql);	// SELECT(��ȸ) ������ ó��
	
}
