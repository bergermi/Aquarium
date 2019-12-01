
public class Shark extends WaterCreature {

	public Shark() {
		super();
		this.setChangeDepthProbability(1.0/4.0);
		this.setSpeed(2);
		this.setHeight(1);
		this.setLength(10);
	}

	@Override
	public String toString() {
		if (this.isHeadToRight()) {
			return "><====\\\\\\>";
		} else {
			return "<///====><";
		}
	}
}
