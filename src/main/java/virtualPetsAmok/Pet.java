package virtualPetsAmok;

public abstract class Pet {

	private String name;
	private String description;
	private int happiness;
	private int health;

	public Pet(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getHappiness() {
		return happiness;
	}

	public void decreaseHappiness() {
		if (happiness > 10) {
			happiness -= 10;
		} else {
			happiness = 0;
		}
	}

	public void increaseHappiness() {
		happiness = 100;
	}

	public int getHealth() {
		return health;
	}

	public void decreaseHealth() {
		health -= 10;
	}

}
