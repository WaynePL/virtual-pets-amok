package virtualPetsAmok;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test

	public void shouldGetName() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "hungry");
		String actual = undertest.getPetName();

		Assert.assertEquals("Tommy", actual);
	}

	@Test

	public void shouldGetDescription() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		String actual = undertest.getPetDesc();

		Assert.assertEquals("Hungry", actual);
	}

	@Test
	public void shouldIncreaseThirst() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("tommy", "hungry");
		undertest.tick();
		int actual = undertest.getThirst("tommy");
		Assert.assertEquals(10, actual);
	}

	@Test
	public void shouldIncreaseHunger() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("tommy", "hungry");
		undertest.tick();
		int actual = undertest.getHunger("tommy");
		Assert.assertEquals(10, actual);
	}

	@Test
	public void shouldIncreaseBoredom() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("tommy", "hungry");
		undertest.tick();
		int actual = undertest.getBoredom("tommy");
		Assert.assertEquals(10, actual);
	}

	@Test
	public void shouldCreatePet() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("tommy", "hungry");
		int actual = undertest.getNumberOfPets();
		assertEquals(1, actual);
	}

	@Test
	public void shouldCreate2Pets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "Hungry");
		undertest.createPet("Charles", "Thirsty");
		int actual = undertest.getNumberOfPets();
		assertEquals(2, actual);
	}

	@Test
	public void shouldFeedAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "Hungry");
		undertest.createPet("Charles", "Thirsty");
		undertest.feedAllPets();

		for (VirtualPet pet : undertest.pets.values()) {
			assertEquals(-20, pet.hunger);
		}
	}

	@Test
	public void shouldHydrateAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "Hungry");
		undertest.createPet("Charles", "Thirsty");
		undertest.hydrateAllPets();

		for (VirtualPet pet : undertest.getPets()) {
			assertEquals(-20, pet.thirst);
		}
	}

	@Test
	public void shouldGetACollectionOfPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "Hungry");
		undertest.createPet("Charles", "Thirsty");
		VirtualPet expected = undertest.pets.get("Charles");
		Collection<VirtualPet> actual = undertest.getPets();

		assertThat(actual, hasItem(expected));
	}

	@Test
	public void shouldPlayWithPet() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		String name = "Tommy";
		undertest.createPet(name, "Hungry");
		undertest.play(name);
		assertEquals(0, undertest.getBoredom(name));
	}

	@Test
	public void shouldRemovePet() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "Hungry");
		undertest.createPet("Charles", "Thirsty");
		VirtualPet tommy = undertest.pets.get("Tommy");
		undertest.adoptPet("Tommy");

		Collection<VirtualPet> actual = undertest.getPets();
		assertThat(actual, not(hasItem(tommy)));
	}

	@Test
	public void shouldAddPetWithStatus() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createPet("Tommy", "Hungry");
		undertest.createPet("Charles", "Thirsty");
		undertest.createPet("Fred", "Ugly", 60, 40, 70);
		VirtualPet fred = undertest.pets.get("Fred");

		Collection<VirtualPet> actual = undertest.getPets();
		assertThat(actual, hasItem(fred));
		assertEquals(60, fred.hunger);
	}
}
