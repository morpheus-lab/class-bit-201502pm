package clazz;

import java.sql.ResultSet;

public class OracleDriver implements DBDriver {

	@Override
	public void connect() {
		// Oracle DB�� �´� ���� ������� ����
		System.out.println("Oracle DB ������ �����մϴ�.");
	}

	@Override
	public void disconnect() {
		// Oracle DB�� ������� ���� ����
		System.out.println("Oracle DB ������ �����մϴ�.");
	}

	@Override
	public ResultSet query(String sql) {
		// Oracle DB�� ������� SELECT ������ ����
		System.out.println("Oracle DB���� ������ �����մϴ�.");
		return null;
	}

}
