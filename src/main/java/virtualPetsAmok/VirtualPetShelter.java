package virtualPetsAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	private int litterBoxWaste;

	public void tick() {
		for (VirtualPet pet : pets.values()) {
			pet.increaseHunger();
			pet.increaseThirst();
			if (pet instanceof Dog) {
				((Dog) pet).increaseBoredom();
			}
			if (pet instanceof Robot) {
				((Robot) pet).decreaseOil();
			}

		}
		litterBoxWaste += numberOfCats();
	}

	private int numberOfCats() {
		int cats = 0;
		for (VirtualPet pet : getPets()) {
			if (pet instanceof Cat) {
				cats++;
			}
		}
		return cats;
	}

	public int getThirst(String name) {
		return pets.get(name).getThirst();
	}

	public int getHunger(String name) {
		return pets.get(name).getHunger();
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

	public void createRobot(String name, String desc, int hunger, int thirst) {
		pets.put(name, new Robot(name, desc, hunger, thirst));

	}

	public void createRobot(String name, String desc) {
		pets.put(name, new Robot(name, desc));

	}

	public int getNumberOfPets() {

		// TODO Auto-generated method stub
		return pets.size();
	}

	public void feedAllPets() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : pets.values()) {
			pet.feed();
		}
	}

	public void hydrateAllPets() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : pets.values()) {
			pet.hydrate();
		}
	}

	public Collection<VirtualPet> getPets() {
		// TODO Auto-generated method stub
		return pets.values();
	}

	public void adoptPet(String name) {

		pets.remove(name);
	}

	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	public void walkDogs() {
		for (VirtualPet pet : getPets()) {
			if (pet instanceof Walks) {
				((Walks) pet).walk();
			}
		}
	}

	public void oilRobots() {
		for (VirtualPet pet : getPets()) {
			if (pet instanceof Robot) {
				((Robot) pet).fillOil();
			}
		}
	}

	public int getLitterBoxWaste() {

		return litterBoxWaste;
	}

}
