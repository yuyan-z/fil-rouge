package util;
public class PetriException extends Exception {
	private String msg;

	public PetriException(String s) {
		msg = s;
	}

	@Override
    public String getMessage() {
		return msg;
	}
}
