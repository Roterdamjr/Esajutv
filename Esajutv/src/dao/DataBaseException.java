package dao;

public class DataBaseException extends Exception {
	public DataBaseException(String message,Throwable err) {
		super(message,err);
	}
}
