package telran.user.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.user.model.User;

class UserTest {
	User user;
	String email = "winten2@gmail.com";
	String password = "vovavovA123@";
	String firstAndLastName = "Vladimir Rogalev";

	@BeforeEach
	void setUp() throws Exception {
		user = new User(email, password, firstAndLastName);
	}

	@Test
	void testValidFirstAndLastName() {
		String validFirstAndLastName = "Sam-Malikin";
		user.setFirstAndLastName(validFirstAndLastName);
		assertEquals(validFirstAndLastName, user.getFirstAndLastName());
	}

	@Test
	void testFirstAndLastNameMinMaxChar() {
		String invalidFirstAndLastName = "S";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "Anna-Maria-Fedorova-Dmitrieva-Vasileva";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
	}

//
	@Test
	void testFirstAndLastNameContainsOnlyLetters() {
		String invalidFirstAndLastName = "Vlad1mir";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "Vl@dimir Rogalev";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());

	}

	@Test
	void testFirstAndLastNameStartAndEndSymbols() {
		String invalidFirstAndLastName = " Vladimir Rogalev";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "-Vladimir Rogalev";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "'Vladimir Rogalev";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "Vladimir Rogalev ";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "Vladimir Rogalev-";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());
		invalidFirstAndLastName = "Vladimir Rogalev'";
		user.setFirstAndLastName(invalidFirstAndLastName);
		assertEquals(firstAndLastName, user.getFirstAndLastName());

	}

	@Test
	void testValidEmail() {
		String validEmail = "winten2@walla.com";
		user.setEmail(validEmail);
		assertEquals(validEmail, user.getEmail());
	}

	@Test
	void testEmailWithoutAt() {
		System.out.print("Dont't contain @ in email: ");
		String inValidEmail = "winten2walla.co.il";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testEmailDoubleAt() {
		System.out.print("Contain double @  in email: ");
		String inValidEmail = "winten@2@walla.co.il";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testEmailDotAfterAt() {
		System.out.print("Dont't contain dot after @ in email: ");
		String inValidEmail = "winten2@wallacoil";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testEmailLastDot() {
		System.out.print("Incorrect dot in email: ");
		String inValidEmail = "winten2@walla.co.il.";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
		System.out.print("Contain incorrect length symbol after dot in email: ");
		inValidEmail = "winten2@walla.c.i";
		user.setEmail(inValidEmail);
		assertEquals(email, user.getEmail());
	}

	@Test
	void testIncorrectSymbols() {
		System.out.print("Contain incorrect symbol in email: ");
		String inValidEmail = "w!nten2@walla.co.il";
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
		System.out.print("Minimal length password: ");
		String inValidPassword = "qweY@1";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneDigit() {
		System.out.print("Minimum one digit in password: ");
		String inValidPassword = "qwerty!qwe";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneUpperCase() {
		System.out.print("Minimum one character uppercase in password: ");
		String inValidPassword = "qwerty123!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneLowerCase() {
		System.out.print("Minimum one character lowercase in password: ");
		String inValidPassword = "QWERTY123!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}

	@Test
	void testMinimumOneSpecialSymbols() {
		System.out.print("Minimum one special symbol in password: ");
		String inValidPassword = "QWERTy1234";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());

	}

}
