package battleship;

import java.util.Iterator;

public class Board implements Iterable<Point> {

	private Matrix board;
	private Fleet fleet;
	private int hits;
	private int misses;
	private int ships;
	private int area;

	public Board(int size, Fleet fleet) {
		hits = 0;
		misses = 0;
		ships = fleet.weight();
		area = size * size;

		this.fleet = fleet;

		board = new Matrix(size, (double) ships / area);
	}

	private void update() {
		for (Point p : board) {
			if (!(p.isHit() || p.isMiss())) {
				board.set(p.x, p.y, (double) (ships - hits)
						/ (area - (hits + misses)));
			}
		}
		
	}

	private void cascadeProbabilities(int x, int y) {

		/*
		 * Horizontal cascade
		 */


		for (int xCoord = Math.max(0, x - 4); xCoord <= Math.min(
				board.size() - 1, x + 4); xCoord++) {

			if (xCoord != x) {
				//board.get(xCoord, y).miss();
				board.get(xCoord, y).incrementMultiplier(
						fleet.probabilityModifier(x - xCoord));

			}
		}

		/*
		 * Vertical cascade
		 */

		for (int yCoord = Math.max(0, y - 4); yCoord <= Math.min(
				board.size() - 1, y + 4); yCoord++) {
			if (yCoord != y) {
				//board.get(x, yCoord).miss();
				board.get(x, yCoord).incrementMultiplier(
						fleet.probabilityModifier(y - yCoord));
			}
		}
	}

	private void normaliseProbabilities() {
		
		double sumProbabilities = 0;
		
		/*
		 * Calculating current total probability
		 */
		for(Point p : board){
			if (!(p.isHit() || p.isMiss())){
				sumProbabilities += (p.value() * board.get(p.x, p.y).multiplier());
			}		
		}
		
		/*
		 * Refactoring probabilities
		 */
		for(Point p : board){
			if (!(p.isHit() && p.isMiss())){
				p.incrementValue((fleet.weight() - (numHits() + numMisses()))/sumProbabilities);

			}		
		}
		

	}

	public int numHits() {
		int sum = 0;
		for (Point p : board) {
			if (p.isHit()) {
				sum++;
			}
		}
		return sum;
	}

	public int numMisses() {
		int sum = 0;
		for (Point p : board) {
			if (p.isMiss()) {
				sum++;
			}
		}
		return sum;
	}

	public void hit(int x, int y) {
		/*
		 * TODO: VALIDATE INPUTS AND THROW EXCEPTIONS
		 */
		board.get(x, y).hit();
		board.get(x, y).resetMultiplier();
		hits++;
		update();
		//System.out.println("Cascading now:");
		cascadeProbabilities(x, y);
		normaliseProbabilities();
	}

	public void miss(int x, int y) {
		/*
		 * TODO: VALIDATE INPUTS AND THROW EXCEPTIONS
		 */
		board.get(x, y).miss();
		board.get(x, y).resetMultiplier();
		misses++;
		update();
		normaliseProbabilities();
	}

	@Override
	public Iterator<Point> iterator() {
		return board.iterator();
	}

	public String toString() {
		return board.toString();
	}

	public String toHMString() {
		return board.toHMString();

	}

	public String probabilityString() {
		return board.probabilityString();

	}

}
