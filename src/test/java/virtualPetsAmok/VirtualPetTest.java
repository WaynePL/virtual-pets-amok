package virtualPetsAmok;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldGetName() {
		Dog undertest = new Dog("tommy", "hungry");
		String actual = undertest.getName();
		Assert.assertEquals("tommy", actual);
	}

	@Test
	public void shouldGetDesc() {
		Dog undertest = new Dog("tommy", "hungry");
		String actual = undertest.getDescription();
		Assert.assertEquals("hungry", actual);
	}

	@Test
	public void shouldIncreaseHunger() {
		Dog undertest = new Dog("tommy", "hungry");
		undertest.increaseHunger();
		int actual = undertest.getHunger();
		Assert.assertEquals(10, actual);
	}

}
