package telran.user.model;

public class User {

	private String email;
	private String password;
	private String firstAndLastName;

	public User(String email, String password, String firstAndLastName) {
		setEmail(email);
		setPassword(password);
		setFirstAndLastName(firstAndLastName);

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (isValidEmail(email)) {
			this.email = email;
		} else {
			System.out.println(email + " is not valid");
		}

	}

	/*
	 * 1. @ exists and only one 2. dot after @ 3. after last dot minimum 2 symbols
	 * 4. alphabetic, digits, _, - , ., @
	 */

	private boolean isValidEmail(String email) {
		int indexAt = email.indexOf('@');

		if (indexAt == -1 || indexAt != email.lastIndexOf('@')) {
			return false;
		}

		if (email.indexOf('.', indexAt) == -1) {
			return false;
		}

		if (email.lastIndexOf('.') > email.length() - 3) {
			return false;
		}

		for (int i = 0; i < email.length() - 1; i++) {
			char c = email.charAt(i);
			if (!(c == '@' || c == '.' || c == '-' || c == '_' || Character.isDigit(c) || Character.isAlphabetic(c))) {
				return false;
			}
		}
		return true;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (isValidPassword(password)) {
			this.password = password;
		} else {
			System.out.println(password + " is not valid");
		}

	}

	/*
	 * Qwerty1@
	 * 
	 * The password must be at least 8 characters long. (done) The password must
	 * contain at least one digit. The password must contain at least one uppercase
	 * letter. The password must contain at least one lowercase letter. The password
	 * must contain at least one special symbol from the set: !%@$&.
	 */

	private boolean isValidPassword(String password) {

		if (password.length() < 8) {
			return false;
		}

		boolean digit = false;
		boolean lowerCase = false;
		boolean upperCase = false;
		boolean symbols = false;
		// String symbolString = "!%@$&";
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);

			if (Character.isDigit(c)) {
				digit = true;
			}
			if (Character.isLowerCase(c)) {
				lowerCase = true;
			}
			if (Character.isUpperCase(c)) {
				upperCase = true;
			}
			if (c == '!' || c == '%' || c == '@' || c == '$' || c == '&') {
				symbols = true;
			}
		}
		return digit & lowerCase & upperCase & symbols;

	}

	public String getFirstAndLastName() {
		return firstAndLastName;
	}

	public void setFirstAndLastName(String firstAndLastName) {
		if (isValidFirstAndLastName(firstAndLastName)) {
			this.firstAndLastName = firstAndLastName;
		} else {
			System.out.println(firstAndLastName + " is not valid!");
		}

	}

	private boolean isValidFirstAndLastName(String firstAndLastName) {

		if (firstAndLastName.length() <= 1 || firstAndLastName.length() > 37) {
			return false;
		}
		char a = firstAndLastName.charAt(0);
		char b = firstAndLastName.charAt(firstAndLastName.length() - 1);
		if (!(Character.isAlphabetic(a) && Character.isAlphabetic(b))) {
			return false;
		}
		for (int i = 0; i < firstAndLastName.length() - 1; i++) {
			char c = firstAndLastName.charAt(i);
			if ((c == '@' || c == '.' || c == '_' || Character.isDigit(c))) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + " firstAndLastName = " + firstAndLastName + "]";
	}

}
