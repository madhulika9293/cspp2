import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		fitbyte person = new fitbyte();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] inputs = line.split(" ");
			switch (inputs[0]) {
			case "Food":
				person.addFood(new foodlog(inputs[1].split(",")));
				break;
			case "Water":
				person.addWater(new waterlog(inputs[1].split(",")));
				break;
			case "PhysicalActivity":
				person.addActivity(new activitylog(inputs[1].split(",")));
				break;
			case "Weight":
				person.addWeight(new weightlog(inputs[1].split(",")));
				break;
			case "Sleep":
				person.addSleep(new sleeplog(inputs[1].split(",")));
				break;
			case "Foodlog":
				person.foodSumm();
				System.out.print("\n");
				break;
			case "Waterlog":
				person.waterSumm();
				// System.out.println("\n");
				break;
			case "PhysicalActivitylog":
				person.activitySumm();
				// System.out.println("\n");
				break;
			case "Weightlog":
				person.weightSumm();
				// System.out.println("\n");
				break;
			case "Sleeplog":
				person.sleepSumm();
				// System.out.println("\n");
				break;
			case "Summary":
				if (inputs.length == 1) {
					person.summary();
				} else {
					person.summary(inputs[1]);
				}
				break;
			default:
				break;
			}

		}
	}
}


