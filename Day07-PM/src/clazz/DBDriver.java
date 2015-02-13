package clazz;

import java.sql.ResultSet;

public interface DBDriver {
	
	void connect();		// DB俊 立加
	void disconnect();	// DB肺何磐 立加 秦力
	
	ResultSet query(String sql);	// SELECT(炼雀) 孽府甫 贸府
	
}
