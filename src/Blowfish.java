
public class Blowfish extends WaterCreature {

	public Blowfish() {
		super();
		this.setChangeDepthProbability(1.0/10.0);
		this.setSpeed(1);
		this.setHeight(1);
		this.setLength(5);
	}

	@Override
	public String toString() {
		if (this.isHeadToRight()) {
			return "><()>";
		} else {
			return "<()><";
		}
	}
}
