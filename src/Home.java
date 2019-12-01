
public class Home {

	public static void main(String[] args) throws InterruptedException {
		Aquarium aquarium = new Aquarium(100, 20);

		for (int i = 0; i < 5; i++) {
			new Fish().moveTo(aquarium);
		}

		for (int i = 0; i < 10; i++) {
			new Krill().moveTo(aquarium);
		}
		
		for (int i = 0; i < 3; i++) {
			new Shark().moveTo(aquarium);
		}
		
		for (int i = 0; i < 3; i++) {
			new Swordfish().moveTo(aquarium);
		}

		for (int i = 0; i < 3; i++) {
			new Blowfish().moveTo(aquarium);
		}

		for (int i = 0; i < 1000; i++) {
			System.out.println(aquarium.toString());
			aquarium.moveCreatures();
			Thread.sleep(200);
		}
	}

}
