package virtualPetsAmok;

public abstract class LandPet extends OrganicPet {

	private int thirst;

	public LandPet(String name, String description) {
		super(name, description);
		this.thirst = 0;
	}

	public LandPet(String name, String description, int hunger, int thirst) {
		super(name, description, hunger);
		this.thirst = thirst;
	}

	public LandPet(String name, String description, int hunger) {
		super(name, description, hunger);
		this.thirst = 0;
	}

	public int getThirst() {
		return thirst;
	}

	public int increaseThirst() {
		return thirst += 10;
	}

	public void hydrate() {
		thirst -= 20;

	}

}
