package clazz;

import java.sql.ResultSet;

public class MSSQLDriver implements DBDriver {

	@Override
	public void connect() {
		System.out.println("MS-SQL DB ������ ����");
	}

	@Override
	public void disconnect() {
		System.out.println("MS-SQL DB ������ ���� ���� ����");
	}

	@Override
	public ResultSet query(String sql) {
		System.out.println("MS-SQL DB �������� ������ ��ȸ");
		return null;
	}
	
	
	
}
