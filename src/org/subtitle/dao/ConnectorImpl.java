package org.subtitle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.subtitle.exception.ConnectorException;

public class ConnectorImpl implements Connector {
	private Connection connection;
	
	private String type;
	private String ip;
	private String port;
	private String name;
	private String id;
	private String pw;

	// ������
	public ConnectorImpl(String _type, String _ip, int _port, String _name,
			String _id, String _pw) throws ConnectorException {

		String Driver = "";
		type = _type;
		ip = _ip;
		port = Integer.toString(_port);
		name = _name;
		id = _id;
		pw = _pw;

		if (type.equals("mysql")) {
			Driver = "com.mysql.jdbc.Driver";
		} else if (type.equals("oracle")) {
			Driver = "oracle.jdbc.driver.OracleDriver";
		}

		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			throw new ConnectorException("DB ������ ������ �߻��߽��ϴ�. \n"
				+ "Connectorimpl�����ڿ� ù��° ���ڷ� mysql �Ǵ� oracle���� Ȯ���ϼ���.");
		}
	}

	public Connection mysqlConnect() throws ConnectorException {

		if(!type.equals("mysql")){
			throw new ConnectorException("mysql Driver�� ���ǵ��� �ʾҽ��ϴ�.");
		}
		
		String str = "jdbc:mysql://" + ip + ":" + port + "/" + name;
		
		try {
			connection = DriverManager.getConnection(str, id, pw);
		} catch (SQLException e) {
			throw new ConnectorException("DriverManager���� Connection�� �������� ���� ������ �߻��߽��ϴ�.");
		}
		
		return connection;
	}

	public Connection oracleConnect() throws ConnectorException{
		
		if(!type.equals("oracle")){
			throw new ConnectorException("oracle Driver�� ���ǵ��� �ʾҽ��ϴ�.");
		}
		
		String str = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + name;
		
		try {
			connection = DriverManager.getConnection(str, id, pw);
		} catch (SQLException e) {
			throw new ConnectorException("DriverManager���� Connection�� �������� ���� ������ �߻��߽��ϴ�.");
		}
		
		return connection;
	}

	public String toString() {
		return "Connector [ip=" + ip + ", port=" + port + ", name=" + name
				+ ", id=" + id + ", pw=" + pw + "]";
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
