package org.subtitle.dao;

import java.sql.Connection;

import org.subtitle.exception.ConnectorException;

public interface Connector {
	public abstract Connection mysqlConnect() throws ConnectorException;
	public abstract Connection oracleConnect() throws ConnectorException;
}
