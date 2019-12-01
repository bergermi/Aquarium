
public abstract class WaterCreature {
	private double changeDepthProbability;
	private int speed;
	private int height;
	private int length;
	private boolean headToRight;
	private int spaceToFront = 0;
	private int spaceToTop = 0;
	private Aquarium aquarium;

	public WaterCreature() {
		this.changeDepthProbability = 0;
		this.speed = 1;
		this.height = 1;
		this.length = 1;
		this.headToRight = true;
		this.spaceToFront = 0;
		this.spaceToTop = 0;
		this.aquarium = null;
	}

	protected void setChangeDepthProbability(double changeDepthProbability) {
		this.changeDepthProbability = changeDepthProbability;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHeight() {
		return this.height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return this.length;
	}

	protected void setLength(int length) {
		this.length = length;
	}

	public boolean isHeadToRight() {
		return headToRight;
	}

	public int getSpaceToFront() {
		return this.spaceToFront;
	}

	public int getSpaceToTop() {
		return this.spaceToTop;
	}

	public int getSpaceToBottom() {
		if (this.aquarium == null) {
			return 0;
		} else {
			return this.aquarium.getInnerHeight() - this.getHeight() - this.getSpaceToTop();
		}
	}

	public void moveTo(Aquarium aquarium) {
		if (aquarium == null) {
			throw new IllegalArgumentException("Aquarium is null");
		}
		if (aquarium.getInnerWidth() < this.getLength() || aquarium.getInnerHeight() < this.getHeight()) {
			throw new IllegalArgumentException("Aquarium is too small");
		}

		if (this.aquarium != null) {
			this.aquarium.remove(this);
		}

		this.aquarium = aquarium;
		aquarium.add(this);

		this.spaceToFront = (int) ((aquarium.getInnerWidth() - this.getLength() + 1) * Math.random());
		this.spaceToTop = (int) ((aquarium.getInnerHeight() - this.getHeight() + 1) * Math.random());
	}

	private void turn() {
		if (this.aquarium == null) {
			return;
		}

		this.headToRight ^= true;
		this.spaceToFront = this.aquarium.getInnerWidth() - this.getLength() - this.spaceToFront;
	}

	public void move() {
		if (this.aquarium == null) {
			return;
		}

		int remainingStepsToMove = this.speed;

		while (remainingStepsToMove > 0) {
			// Move forward until next wall is hit
			int stepsToMoveWithoutTurn = Math.min(this.getSpaceToFront(), remainingStepsToMove);

			this.spaceToFront -= stepsToMoveWithoutTurn;
			remainingStepsToMove -= stepsToMoveWithoutTurn;

			// If steps are left turn around
			if (remainingStepsToMove > 0) {
				this.turn();
				remainingStepsToMove -= 1;
			}
		}

		// Dive or climb with defined probability
		if (Math.random() < this.changeDepthProbability) {

			// Decide to dive or climb
			if (Math.random() < 0.5) {
				this.dive();
			} else {
				this.climb();
			}
		}
	}

	private void dive() {
		if (this.aquarium == null) {
			return;
		}

		if (this.getSpaceToBottom() > 1) {
			this.spaceToTop++;
		}
	}

	private void climb() {
		if (this.aquarium == null) {
			return;
		}

		if (this.getSpaceToTop() > 1) {
			this.spaceToTop--;
		}
	}
}
