package virtualPetsAmok;

public abstract class VirtualPet {

	private String name;
	private String description;
	private int hunger;
	private int thirst;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = 0;
		this.thirst = 0;

	}

	public VirtualPet(String name, String description, int hunger, int thirst) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
	}

	public int increaseHunger() {
		return hunger += 10;
	}

	public int increaseThirst() {
		return thirst += 10;
	}

	public void feed() {
		hunger -= 20;
	}

	public void hydrate() {
		thirst -= 20;

	}

}
