package virtualPetsAmok;

public class Dog extends LandPet implements Walks {
	private int boredom;

	public Dog(String name, String description) {
		super(name, description);
		boredom = 0;
	}

	public Dog(String name, String description, int hunger, int thirst) {
		super(name, description, hunger, thirst);
		boredom = 0;
	}

	public void walk() {
		boredom = 0;
	}

	public int increaseBoredom() {
		return boredom += 10;
	}

	public int getBoredom() {
		return boredom;
	}
}
