package virtualPetsAmok;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldGetName() {
		VirtualPet undertest = new VirtualPet("tommy", "hungry");
		String actual = undertest.name;
		Assert.assertEquals("tommy", actual);
	}

	@Test
	public void shouldGetDesc() {
		VirtualPet undertest = new VirtualPet("tommy", "hungry");
		String actual = undertest.description;
		Assert.assertEquals("hungry", actual);
	}

	@Test
	public void shouldIncreaseHunger() {
		VirtualPet undertest = new VirtualPet("tommy", "hungry");
		undertest.increaseHunger();
		int actual = undertest.hunger;
		Assert.assertEquals(10, actual);
	}

}
