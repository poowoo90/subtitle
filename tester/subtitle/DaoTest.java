package subtitle;


import java.sql.Connection;

import org.junit.*;
import org.subtitle.dao.*;
import org.subtitle.exception.ConnectorException;

public class DaoTest {
	public ConnectorImpl connector;
	
	@Test
	public void testConnector(){
		/*
		 * 데잍터베이스에 연결하는 클래스 테스트
		 */
		Connection conn = null;
		
		String type = "mysql";
		String ip = "localhost";
		int port = 3306;
		String name = "subtitle";
		String id = "root";
		String pw = "1234";
		

		try {
			connector = new ConnectorImpl(type, ip, port, name, id, pw);
			conn = connector.mysqlConnect();
		} catch (ConnectorException e) {
			e.printStackTrace();
		}

		System.out.println(connector.toString());
		Assert.assertNotNull(conn);
	}

	
}
