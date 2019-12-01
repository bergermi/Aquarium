import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aquarium {
	private int innerWidth;
	private int innerHeight;
	private HashSet<WaterCreature> waterCreatures;

	public Aquarium(int innerWidth, int innerHeight) {
		super();
		this.innerWidth = innerWidth;
		this.innerHeight = innerHeight;
		this.waterCreatures = new HashSet<>();
	}

	public int getInnerWidth() {
		return innerWidth;
	}

	public int getInnerHeight() {
		return innerHeight;
	}

	public void add(WaterCreature waterCreature) {
		waterCreatures.add(waterCreature);
	}
	
	public void remove(WaterCreature waterCreature) {
		waterCreatures.remove(waterCreature);
	}

	@Override
	public String toString() {
		List<StringBuilder> aquariumLines = new ArrayList<>();
		
		// Create lines filled with spaces of the size of the aquarium 
		for (int i = 0; i < this.getInnerHeight(); i++) {
			aquariumLines.add(new StringBuilder(String.join("", Collections.nCopies(this.getInnerWidth(), " "))));
		}
	
		// Add fishes to the empty aquarium
		for (WaterCreature waterCreature : this.waterCreatures) {
			aquariumLines.get(waterCreature.getSpaceToTop()).replace(this.getSpaceToLeftOfFish(waterCreature), this.getSpaceToLeftOfFish(waterCreature) + waterCreature.getLength(), waterCreature.toString());
		}
		
		// Add walls to aquarium
		for (StringBuilder aquariumLine : aquariumLines) {
			aquariumLine.insert(0, '|').append('|');
		}
		
		// Add bottom to aquarium
		aquariumLines.add(new StringBuilder(String.join("", Collections.nCopies(this.getInnerWidth(), "-"))).insert(0, '+').append('+'));
	
		// Join list of lines to single string
		StringBuilder aquariumString = new StringBuilder();
		
		for (StringBuilder aquariumLine : aquariumLines) {
			aquariumString.append(aquariumLine).append("\n");
		}
				
		return aquariumString.toString();
	}

	public void moveCreatures() {
		for (WaterCreature waterCreature : this.waterCreatures) {
			waterCreature.move();
		}
	}
	
	private int getSpaceToLeftOfFish(WaterCreature fish) {
		if (fish.isHeadToRight()) {
			return this.getInnerWidth() - fish.getSpaceToFront() - fish.getLength();
		} else {
			return fish.getSpaceToFront();
		}
	}
}
