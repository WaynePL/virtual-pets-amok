package virtualPetsAmok;

public abstract class OrganicPet extends Pet {

	private int hunger;

	public OrganicPet(String name, String description) {
		super(name, description);
		this.hunger = 0;
	}

	public OrganicPet(String name, String description, int hunger) {
		super(name, description);
		this.hunger = hunger;
	}

	public int getHunger() {
		return hunger;
	}

	public int increaseHunger() {
		return hunger += 10;
	}

	public void feed() {
		hunger -= 20;
	}

}