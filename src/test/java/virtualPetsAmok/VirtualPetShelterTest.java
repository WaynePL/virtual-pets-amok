package virtualPetsAmok;

import static org.hamcrest.Matchers.equalTo;
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

		for (Pet pet : undertest.getPets()) {
			assertEquals(-20, ((OrganicPet) pet).getHunger());
		}
	}

	@Test
	public void shouldHydrateAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.hydrateAllPets();

		for (Pet pet : undertest.getPets()) {
			assertEquals(-20, ((LandPet) pet).getThirst());
		}
	}

	@Test
	public void shouldGetACollectionOfPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		Pet expected = undertest.getPet("Charles");
		Collection<Pet> actual = undertest.getPets();

		assertThat(actual, hasItem(expected));
	}

	@Test
	public void shouldRemovePet() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		Pet tommy = undertest.getPet("Tommy");
		undertest.adoptPet("Tommy");

		Collection<Pet> actual = undertest.getPets();
		assertThat(actual, not(hasItem(tommy)));
	}

	@Test
	public void shouldAddPetWithStatus() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.createDog("Fred", "Ugly", 60, 40);
		Pet fred = undertest.getPet("Fred");

		Collection<Pet> actual = undertest.getPets();
		assertThat(actual, hasItem(fred));
		assertEquals(60, ((OrganicPet) fred).getHunger());
	}

	@Test
	public void shouldWalkAllPets() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createDog("Charles", "Thirsty");
		undertest.createDog("Fred", "Ugly", 60, 40);
		undertest.walkDogs();
		for (Pet pet : undertest.getPets()) {
			if (pet instanceof Dog) {
				assertThat(((Dog) pet).getBoredom(), is(0));
			}
		}
	}

	@Test
	public void shouldOilAllRobots() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty", "dog");
		undertest.createRobot("Fred", "Ugly", "dog");
		undertest.tick();
		undertest.oilRobots();
		for (Pet pet : undertest.getPets()) {
			if (pet instanceof Robot) {
				assertThat(((Robot) pet).getOilState(), is(true));
			}
		}
	}

	@Test
	public void shouldMakeWasteInLitterBox() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty", "dog");
		undertest.createCat("Fred", "Ugly", 60, 40);
		undertest.tick();
		int result = undertest.getLitterBoxWaste();
		assertThat(result, is(1));

	}

	@Test
	public void shouldMakeWasteInDogCage() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty", "dog");
		undertest.createCat("Fred", "Ugly", 60, 40);
		undertest.tick();
		int actual = undertest.getdogCageWaste();
		assertThat(actual, is(equalTo(1)));
	}

	@Test
	public void shouldReduceDogWaste() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty", "dog");
		undertest.createCat("Fred", "Ugly", 60, 40);
		undertest.tick();
		undertest.cleanDogWaste();
		int actual = undertest.getdogCageWaste();
		assertThat(actual, is(equalTo(0)));
	}

	@Test
	public void shouldReduceCatWaste() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty", "dog");
		undertest.createCat("Fred", "Ugly", 60, 40);
		undertest.tick();
		undertest.cleanCatWaste();
		int actual = undertest.getLitterBoxWaste();
		assertThat(actual, is(equalTo(0)));
	}

	@Test
	public void shouldMakeRobotCatsNeedOil() {
		VirtualPetShelter undertest = new VirtualPetShelter();
		undertest.createDog("Tommy", "Hungry");
		undertest.createRobot("Charles", "Thirsty", "cat");
		undertest.createCat("Fred", "Ugly", 60, 40);
		undertest.oilRobots();
		undertest.tick();
		undertest.tick();
		undertest.tick();
		undertest.tick();
		undertest.tick();
		undertest.tick();
		undertest.tick();
		boolean actual = undertest.getOilState("Charles");
		assertThat(actual, is(equalTo(false)));
	}

}
