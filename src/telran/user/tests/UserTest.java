package telran.user.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.user.model.User;

class UserTest {
	User user;
	String email = "winten2@gmail.com";
	String password = "vovavovA123@";

	@BeforeEach
	void setUp() throws Exception {
		user = new User(email, password);
	}

	@Test
	void testValidEmail() {
		String validEmail = "winten2@walla.com";
		user.setEmail(validEmail);
		assertEquals(validEmail, user.getEmail());
	}

	@Test
	void testEmailWithoutAt() {
		String inValidEmail = "winten2walla.co.il";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testEmailDoubleAt() {
		String inValidEmail = "winten@2@walla.co.il";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testEmailDotAfterAt() {
		String inValidEmail = "winten2@wallacoil";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testEmailLastDot() {
		String inValidEmail = "winten2@walla.co.il.";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
		inValidEmail = "winten2@walla.c.i";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testIncorrectSymbols() {
		String inValidEmail = "winten2!@wallacoil";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testValidPassword() {
		String validPassword = "qwertY1234@";
		user.setPassword(validPassword);
		assertEquals(validPassword, user.getPassword());

	}

	@Test
	void testMinimun8Characters() {
		String inValidPassword = "qweY@1";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneDigit() {
		String inValidPassword = "qwerty!qwe";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneUpperCase() {
		String inValidPassword = "qwerty123!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneLowerCase() {
		String inValidPassword = "QWERTY123!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneSpecialSymbols() {
		String inValidPassword = "QWERTY1234";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

}
