
public class Fish extends WaterCreature {

	public Fish() {
		super();
		this.setSpeed(1);
		this.setHeight(1);
		this.setLength(3);
	}

	@Override
	public String toString() {
		if (this.isHeadToRight()) {
			return "><>";
		} else {
			return "<><";
		}
	}
}
