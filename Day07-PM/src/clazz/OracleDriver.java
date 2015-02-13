package clazz;

import java.sql.ResultSet;

public class OracleDriver implements DBDriver {

	@Override
	public void connect() {
		// Oracle DB에 맞는 접속 방법으로 접속
		System.out.println("Oracle DB 서버에 접속합니다.");
	}

	@Override
	public void disconnect() {
		// Oracle DB의 방법으로 접속 해제
		System.out.println("Oracle DB 서버에 접속합니다.");
	}

	@Override
	public ResultSet query(String sql) {
		// Oracle DB의 방법으로 SELECT 쿼리를 수행
		System.out.println("Oracle DB에서 쿼리를 실행합니다.");
		return null;
	}

}
