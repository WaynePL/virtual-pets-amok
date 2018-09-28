package virtualPetsAmok;

public class Cat extends VirtualPet {

	public Cat(String name, String description) {
		super(name, description);
	}

	public Cat(String name, String description, int hunger, int thirst) {
		super(name, description, hunger, thirst);
	}

	@Override
	public String toString() {
		return "Cat " + this.getName();
	}

}
