package clazz;

import java.sql.ResultSet;

public class MSSQLDriver implements DBDriver {

	@Override
	public void connect() {
		System.out.println("MS-SQL DB 서버에 접속");
	}

	@Override
	public void disconnect() {
		System.out.println("MS-SQL DB 서버로 부터 접속 해제");
	}

	@Override
	public ResultSet query(String sql) {
		System.out.println("MS-SQL DB 서버에서 데이터 조회");
		return null;
	}
	
	
	
}
