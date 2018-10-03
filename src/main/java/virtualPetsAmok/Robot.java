package virtualPetsAmok;

public class Robot extends Pet {

	private boolean oiled;
	private boolean cat;
	private boolean dog;

	public Robot(String name, String description, String type) {
		super(name, description);
		oiled = false;
		if (type.equalsIgnoreCase("dog")) {
			this.dog = true;
		} else if (type.equalsIgnoreCase("cat")) {
			this.cat = true;
		}
	}

	public boolean isCat() {
		return cat;
	}

	public boolean isDog() {
		return dog;
	}

	public void needsOil() {
		oiled = false;
	}

	public void oilChange() {
		oiled = true;
	}

	public boolean getOilState() {
		return oiled;
	}

}
