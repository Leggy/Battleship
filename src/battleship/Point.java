package battleship;

public class Point {

	private double value;
	private double multiplier;
	private boolean hit;
	private boolean miss;
	public final int x;
	public final int y;

	public Point(double value, int x, int y) {
		this.value = value;
		this.multiplier = 1;
		this.x = x;
		this.y = y;
		this.hit = false;
		this.miss = false;
	}

	private Point(double value, boolean hit, boolean miss, int x, int y) {
		this.value = value;
		this.hit = hit;
		this.miss = miss;
		this.x = x;
		this.y = y;
	}

	public boolean isHit() {
		return this.hit;
	}

	public boolean isMiss() {
		return this.miss;
	}

	public double value() {
		return this.value;
	}

	public double multiplier() {
		return this.multiplier;
	}

	public void incrementValue(double factor) {
		// TODO: Check input validity.
		this.value *= factor;
	}
	
	public void incrementMultiplier(double mult) {
		// TODO: Check input validity.
		this.multiplier *= (mult + 1);
	}
	
	public void resetMultiplier() {
		this.multiplier  = (double) 1;
	}

	public void hit() {
		this.value = 1;
		this.hit = true;
	}

	public void miss() {
		this.value = 0;
		this.miss = true;
	}

	public void setValue(double value) {
		/*
		 * TODO: VALIDATE INPUT
		 */
		this.value = value;
	}

	public String toString() {
		/*
		 * Have to format the value for displaying
		 */
		return "" + this.value;
	}

	public Point clone() {
		return new Point(this.value, this.hit, this.miss, this.x, this.y);
	}

}
