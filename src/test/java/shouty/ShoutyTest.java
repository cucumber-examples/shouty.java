package shouty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoutyTest {

	private Shouty shouty;

	@Test
	public void testNewPerson() {
		assertNotNull(shouty.findPerson("unknown"));
	}
	
	@Test
	public void testExistingPerson() {
		Person createdPerson = shouty.findPerson("Ted");
		Person foundPerson = shouty.findPerson("Ted");
		assertSame(foundPerson, createdPerson);
	}

	@Before
	public void setUp() {
		shouty = new Shouty();
	}

}
