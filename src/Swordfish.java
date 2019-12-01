
public class Swordfish extends WaterCreature {

	public Swordfish() {
		super();
		this.setChangeDepthProbability(1.0/5.0);
		this.setSpeed(1);
		this.setHeight(1);
		this.setLength(4);
	}

	@Override
	public String toString() {
		if (this.isHeadToRight()) {
			return "><>-";
		} else {
			return "-<><";
		}
	}
}
