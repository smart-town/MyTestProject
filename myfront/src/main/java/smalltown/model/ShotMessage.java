package smalltown.model;

public class ShotMessage {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ShotMessage [message=" + message + "]";
	}
}
