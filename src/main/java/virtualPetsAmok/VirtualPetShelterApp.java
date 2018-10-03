package virtualPetsAmok;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		VirtualPetShelter petShelter = new VirtualPetShelter();
		petShelter.createCat("Tommy", "Calico cat. Constantly purring.", 30, 10);
		petShelter.createRobot("Charles", "Looks a lot like a Beagle. Howls a lot.", "dog");
		petShelter.createDog("Minnie", "Chocolat lab. Will do anything for attention.", 40, 60);
		petShelter.createFish("Freddie", "Coy fish. Follows your movements.", 50);
		petShelter.createRobot("Pizza", "Definitely not a robot", "cat");

		System.out.println("Welcome to back to the shelter.");
		System.out.println();
		while (!quit) {

			displayStatusAndOptions(petShelter);
			String choiceString = input.nextLine();
			int choice = 0;
			try {
				choice = Integer.parseInt(choiceString);
			} catch (Exception e) {
				System.out.println("You did not enter a number, please try again");
				continue;
			}

			switch (choice) {
			case 1:
				petShelter.feedAllPets();
				break;
			case 2:
				petShelter.hydrateAllPets();
				break;
			case 3:
				walkDogs(petShelter);
				break;
			case 4:
				petShelter.cleanDogWaste();
				break;
			case 5:
				petShelter.cleanCatWaste();
				break;
			case 6:
				petShelter.oilRobots();
				break;
			case 7:
				adopt(input, petShelter);
				break;
			case 8:
				admitPet(input, petShelter);
				break;
			case 9:
				quit = true;
				continue;
			}
			petShelter.tick();
		}
		input.close();
		System.out.println("Thanks for volunteering!");
	}

	private static void walkDogs(VirtualPetShelter petShelter) {
		System.out.println("You walk all dogs");
		petShelter.walkDogs();
	}

	private static void adopt(Scanner input, VirtualPetShelter petShelter) {
		System.out.println("Choose which pet you would like to adopt.");
		System.out.println();
		displayPetNamesAndDescriptions(petShelter);
		System.out.println("Enter the name of the pet you would like to adopt.");
		String name = input.nextLine();
		System.out.println();
		System.out.println("You adopt " + name + ". Have fun!");
		petShelter.adoptPet(name);
	}

	private static void displayPetNamesAndDescriptions(VirtualPetShelter petShelter) {
		for (Pet pet : petShelter.getPets()) {
			System.out.println(pet.toString());
			System.out.println("[" + pet.getName() + "] " + pet.getDescription());
		}
	}

	private static void admitPet(Scanner input, VirtualPetShelter petShelter) {
		System.out.println("Thank you for bringing your pet.");
		System.out.println();
		System.out.println("What kind of pet are you bringing in?");
		System.out.println("1. Fish");
		System.out.println("2. Cat");
		System.out.println("3. Dog");
		System.out.println("4. Robot Cat");
		System.out.println("5. Robot Dog");
		String choiceString = input.nextLine();
		int choice = 0;
		try {
			choice = Integer.parseInt(choiceString);
		} catch (Exception e) {
			System.out.println("You did not enter a number, please try again");
			admitPet(input, petShelter);
		}
		System.out.println("What is your pet's name?");
		String name = input.nextLine();
		System.out.println("Please describe your pet.");
		String desc = input.nextLine();
		switch (choice) {
		case 1:
			petShelter.createFish(name, desc);
			break;
		case 2:
			petShelter.createCat(name, desc);
			break;
		case 3:
			petShelter.createDog(name, desc);
			break;
		case 4:
			petShelter.createRobot(name, desc, "cat");
			break;
		case 5:
			petShelter.createRobot(name, desc, "dog");
		}
		System.out.println("We will take good care of " + name + ".");
	}

	private static void displayStatusAndOptions(VirtualPetShelter petShelter) {
		System.out.println("Here is the status of our guests:");
		System.out.println();
		System.out.println("Name\t|Hunger\t\t|Thirst\t\t|Boredom\t|Oil Status\t|Happiness\t|Health");
		System.out.println(
				"-----------------------------------------------------------------------------------------------");
		for (Pet pet : petShelter.getPets()) {
			if (pet instanceof Dog) {
				System.out.println(pet.getName() + "\t|" + ((LandPet) pet).getHunger() + "\t\t|"
						+ ((LandPet) pet).getThirst() + "\t\t|" + ((Dog) pet).getBoredom() + "\t\t|" + "No Oil\t\t|"
						+ pet.getHappiness() + "\t\t|" + pet.getHealth());
			} else if (pet instanceof LandPet) {
				System.out.println(pet.getName() + "\t|" + ((LandPet) pet).getHunger() + "\t\t|"
						+ ((LandPet) pet).getThirst() + "\t\t|" + "Never Bored\t|" + "No Oil\t\t|" + pet.getHappiness()
						+ "\t\t|" + pet.getHealth());
			} else if (pet instanceof OrganicPet) {
				System.out.println(pet.getName() + "\t|" + ((OrganicPet) pet).getHunger() + "\t\t|" + "Never Thirsty\t|"
						+ "Never Bored\t|" + "No Oil\t\t|" + pet.getHappiness() + "\t\t|" + pet.getHealth());
			} else if (pet instanceof Robot) {
				System.out.println(pet.getName() + "\t|" + "Never Hungry\t|" + "Never Thirsty\t|" + "Never Bored\t|"
						+ ((Robot) pet).getOilState() + "\t\t|" + pet.getHappiness() + "\t\t|" + pet.getHealth());
			}
		}

		System.out.println("Dog Cages with a mess: " + petShelter.getdogCageWaste());
		System.out.println("Waste in the litter box: " + petShelter.getLitterBoxWaste());
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("1. Feed the pets");
		System.out.println("2. Hydrate the pets");
		System.out.println("3. Walk the dogs");
		System.out.println("4. Clean the dog cages");
		System.out.println("5. Clean the litter box");
		System.out.println("6. Change the oil for the robots");
		System.out.println("7. Adopt a pet");
		System.out.println("8. Admit a pet");
		System.out.println("9. Quit");
		System.out.println();
	}
}
