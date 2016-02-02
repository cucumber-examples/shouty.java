package shouty;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void createANewUserIfNotFound() {
		User user = User.findUserByName("Fred");
		assertEquals("Fred", user.getName());
	}

	@Test
	public void findExistingUser() {
		User fred = new User("Fred");
		User user = User.findUserByName("Fred");
		assertSame(fred, user);
	}

}
