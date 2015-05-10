package org.subtitle.exception;

public class ConnectorException extends ClassNotFoundException{
	
	private String message;
	
	public ConnectorException(String _message){
		message = _message;
	}
	
	@Override
	public void printStackTrace(){
		System.out.println(message);
	}
	
	public String getMessage(){
		return message;
	}
}
