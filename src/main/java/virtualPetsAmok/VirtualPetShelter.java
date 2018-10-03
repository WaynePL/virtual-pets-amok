package virtualPetsAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, Pet> pets = new HashMap<String, Pet>();
	private int litterBoxWaste;
	private int dogCageWaste;

	public void tick() {
		for (Pet pet : pets.values()) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).increaseHunger();
			}
			if (pet instanceof LandPet) {
				((LandPet) pet).increaseThirst();
			}
			if (pet instanceof Dog) {
				((Dog) pet).increaseBoredom();
			}
			if (pet instanceof Robot) {
				if (pet.getHappiness() < 50 && ((Robot) pet).isCat()) {
					((Robot) pet).needsOil();
				}
			}
			if (pet instanceof Cat) {
				if (getLitterBoxWaste() > 5) {
					pet.decreaseHealth();
				}
			}
		}
		litterBoxWaste += numberOfCats();
		dogCageWaste += numberOfDogs();
	}

	private int numberOfCats() {
		int cats = 0;
		for (Pet pet : getPets()) {
			if (pet instanceof Cat) {
				cats++;
			}
		}
		return cats;
	}

	private int numberOfDogs() {
		int dogs = 0;
		for (Pet pet : getPets()) {
			if (pet instanceof Dog) {
				dogs++;
			}
		}
		return dogs;
	}

	public int getThirst(String name) {
		return ((LandPet) pets.get(name)).getThirst();
	}

	public int getHunger(String name) {
		return ((OrganicPet) pets.get(name)).getHunger();
	}

	public int getBoredom(String name) {
		return ((Dog) pets.get(name)).getBoredom();
	}

	public void createDog(String name, String desc) {
		pets.put(name, new Dog(name, desc));
	}

	public void createDog(String name, String desc, int hunger, int thirst) {
		pets.put(name, new Dog(name, desc, hunger, thirst));
	}

	public void createCat(String name, String desc) {
		pets.put(name, new Cat(name, desc));
	}

	public void createCat(String name, String desc, int hunger, int thirst) {
		pets.put(name, new Cat(name, desc, hunger, thirst));
	}

	public void createRobot(String name, String desc, String type) {
		pets.put(name, new Robot(name, desc, type));
	}

	public void createFish(String name, String desc, int hunger) {
		pets.put(name, new Fish(name, desc, hunger));
	}

	public void createFish(String name, String desc) {
		pets.put(name, new Fish(name, desc));
	}

	public int getNumberOfPets() {
		return pets.size();
	}

	public void feedAllPets() {
		for (Pet pet : pets.values()) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).feed();
			}
		}
	}

	public void hydrateAllPets() {
		for (Pet pet : pets.values()) {
			if (pet instanceof LandPet) {
				((LandPet) pet).hydrate();
			}
		}
	}

	public Collection<Pet> getPets() {
		return pets.values();
	}

	public void adoptPet(String name) {
		pets.remove(name);
	}

	public Pet getPet(String name) {
		return pets.get(name);
	}

	public void walkDogs() {
		for (Pet pet : getPets()) {
			if (pet instanceof Walks) {
				if (pet instanceof Robot) {
					if (((Robot) pet).isDog()) {
						((Robot) pet).needsOil();
					}
				}
				((Walks) pet).walk();
			}
		}
	}

	public void oilRobots() {
		for (Pet pet : getPets()) {
			if (pet instanceof Robot) {
				((Robot) pet).oilChange();
			}
		}
	}

	public int getLitterBoxWaste() {
		return litterBoxWaste;
	}

	public int getdogCageWaste() {
		return dogCageWaste;
	}

	public void cleanDogWaste() {
		dogCageWaste = 0;
	}

	public void cleanCatWaste() {
		litterBoxWaste = 0;
	}

	public boolean getOilState(String name) {
		return ((Robot) pets.get(name)).getOilState();
	}

}
