package virtualPetsAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	public String getPetName() {
		return "Tommy";
	}

	public String getPetDesc() {
		return "Hungry";
	}

	public void tick() {
		for (VirtualPet pet : pets.values()) {
			pet.increaseHunger();
			pet.increaseThirst();
			pet.increaseBoredom();
		}
	}

	public int getThirst(String name) {
		return pets.get(name).thirst;
	}

	public int getHunger(String name) {
		return pets.get(name).hunger;
	}

	public int getBoredom(String name) {
		return pets.get(name).boredom;
	}

	public void createPet(String name, String desc) {
		pets.put(name, new VirtualPet(name, desc));
	}

	public void createPet(String name, String desc, int hunger, int thirst, int boredom) {
		pets.put(name, new VirtualPet(name, desc, hunger, thirst, boredom));

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

	public void play(String name) {
		pets.get(name).play();
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

}
