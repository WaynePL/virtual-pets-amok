package virtualPetsAmok;

public class Robot extends VirtualPet {

	private int oilLevel;

	public Robot(String name, String description) {
		super(name, description);
		oilLevel = 100;
	}

	public Robot(String name, String description, int hunger, int thirst) {
		super(name, description, hunger, thirst);
	}

	public int getOilLevel() {
		return oilLevel;
	}

	public void decreaseOil() {
		oilLevel -= 20;
	}

	public void fillOil() {
		oilLevel = 100;
	}

}
