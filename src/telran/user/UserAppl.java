package telran.user;

import telran.user.model.User;

public class UserAppl {
	public static void main(String[] args) {
		
		User peter = new User("peter@gmail.com", "1234Peter!!", "Vladimir Rogalev");
		System.out.println(peter);
		peter.setEmail("Alex@gma@il.com");
		peter.setPassword("asdfdgewq123");
		System.out.println(peter);
		peter.setEmail("012456gmail.cer");
		peter.setPassword("sdfgssee");
		System.out.println(peter);
	}

}
