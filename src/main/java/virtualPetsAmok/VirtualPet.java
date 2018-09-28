package virtualPetsAmok;

public class VirtualPet {
	@Override
	public String toString() {
		return "VirtualPet [name=" + name + ", description=" + description + ", hunger=" + hunger + ", thirst=" + thirst
				+ ", boredom=" + boredom + "]";
	}

	String name;
	String description;
	int hunger;
	int thirst;
	int boredom;

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = 0;
		this.thirst = 0;
		this.boredom = 0;

	}

	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public int increaseHunger() {
		return hunger += 10;
	}

	public int increaseThirst() {
		return thirst += 10;
	}

	public int increaseBoredom() {
		return boredom += 10;
	}

	public void feed() {
		hunger -= 20;
	}

	public void hydrate() {
		thirst -= 20;

	}

	public void play() {
		boredom = 0;
	}

}
