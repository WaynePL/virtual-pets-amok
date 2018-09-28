package virtualPetsAmok;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
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
		undertest.createDog("Tommy", "hungry");
		String actual = undertest.getPet("Tommy").getName();

		Assert.assertEquals("Tommy", actual);
	}

	@Test

	public void shouldGetDescription() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		String actual = undertest.getPet("Tommy").getDescription();

		Assert.assertEquals("Hungry", actual);
	}

	@Test
	public void shouldIncreaseThirst() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("tommy", "hungry");
		undertest.tick();
		int actual = undertest.getThirst("tommy");
		Assert.assertEquals(10, actual);
	}

	@Test
	public void shouldIncreaseHunger() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("tommy", "hungry");
		undertest.tick();
		int actual = undertest.getHunger("tommy");
		Assert.assertEquals(10, actual);
	}

	@Test
	public void shouldIncreaseBoredom() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("tommy", "hungry");
		undertest.tick();
		int actual = undertest.getBoredom("tommy");
		Assert.assertEquals(10, actual);
	}

	@Test
	public void shouldCreatePet() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("tommy", "hungry");
		int actual = undertest.getNumberOfPets();
		assertEquals(1, actual);
	}

	@Test
	public void shouldCreate2Pets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		int actual = undertest.getNumberOfPets();
		assertEquals(2, actual);
	}

	@Test
	public void shouldFeedAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.feedAllPets();

		for (VirtualPet pet : undertest.getPets()) {
			assertEquals(-20, pet.getHunger());
		}
	}

	@Test
	public void shouldHydrateAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.hydrateAllPets();

		for (VirtualPet pet : undertest.getPets()) {
			assertEquals(-20, pet.getThirst());
		}
	}

	@Test
	public void shouldGetACollectionOfPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		VirtualPet expected = undertest.getPet("Charles");
		Collection<VirtualPet> actual = undertest.getPets();

		assertThat(actual, hasItem(expected));
	}

	@Test
	public void shouldRemovePet() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		VirtualPet tommy = undertest.getPet("Tommy");
		undertest.adoptPet("Tommy");

		Collection<VirtualPet> actual = undertest.getPets();
		assertThat(actual, not(hasItem(tommy)));
	}

	@Test
	public void shouldAddPetWithStatus() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.createDog("Fred", "Ugly", 60, 40);
		VirtualPet fred = undertest.getPet("Fred");

		Collection<VirtualPet> actual = undertest.getPets();
		assertThat(actual, hasItem(fred));
		assertEquals(60, fred.getHunger());
	}

	@Test
	public void shouldWalkAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.createDog("Fred", "Ugly", 60, 40);
		undertest.walkDogs();
		for (VirtualPet pet : undertest.getPets()) {
			if (pet instanceof Dog) {
				assertThat(((Dog) pet).getBoredom(), is(0));
			}
		}
	}

	@Test
	public void shouldOilAllRobots() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty");
		undertest.createRobot("Fred", "Ugly", 60, 40);
		undertest.tick();
		undertest.oilRobots();
		for (VirtualPet pet : undertest.getPets()) {
			if (pet instanceof Robot) {
				assertThat(((Robot) pet).getOilLevel(), is(100));
			}
		}
	}

	@Test
	public void shouldMakeWasteInLitterBox() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty");
		undertest.createCat("Fred", "Ugly", 60, 40);
		undertest.tick();
		int result = undertest.getLitterBoxWaste();
		assertThat(result, is(1));

	}
}
