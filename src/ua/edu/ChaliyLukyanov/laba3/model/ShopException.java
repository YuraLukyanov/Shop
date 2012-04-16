package ua.edu.ChaliyLukyanov.laba3.model;

public class ShopException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShopException() {
		super();
	}

	public ShopException(String message) {
		super(message);
	}

	public ShopException(Throwable cause) {
		super(cause);
	}

	public ShopException(String message, Throwable cause) {
		super(message, cause);
	}
}
