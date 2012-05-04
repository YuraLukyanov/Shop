package ua.edu.ChaliyLukyanov.laba3.model;

public class NoSuchDeviceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoSuchDeviceException() {
		super();
	}

	public NoSuchDeviceException(String message) {
		super(message);
	}

	public NoSuchDeviceException(Throwable cause) {
		super(cause);
	}

	public NoSuchDeviceException(String message, Throwable cause) {
		super(message, cause);
	}
}
