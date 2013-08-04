package org.leggy.battleship.grid;

import java.util.List;
import java.util.ArrayList;

public class TrackingGrid {

	/*
	 * Defining location values
	 */
	private final int VOID = 0;
	private final int SHIP = 1;
	private final int HIT = 2;
	private final int MISS = 3;

	private List<ArrayList<Integer>> grid;

	/**
	 * Initialises the TrackingGrid
	 * 
	 * @param size
	 *            The size of the TrackingGrid.
	 */
	public TrackingGrid(int size) {

		grid = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < size; i++) {
			grid.add(newGridColumn(size));
		}
	}

	/**
	 * Constructs a column of the TrackingGrid.
	 * 
	 * @param size
	 *            The size of the TrackingGrid.
	 * @return Returns a column of the TrackingGrid.
	 */
	private ArrayList<Integer> newGridColumn(int size) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			temp.add(VOID);
		}
		return temp;
	}

	/**
	 * Fires upon the supplied location, and returns status of position.
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 * @return Returns true if there is a ship on the supplied location, and
	 *         false otherwise.
	 * @require Location has not been fired upon before, that is the location is
	 *          neither hit nor miss.
	 */
	public boolean fire(int x, int y) {
		if (grid.get(x).get(y) == SHIP) {
			grid.get(x).set(y, HIT);
			// TODO Update view
			/*
			 * Perhaps update view after message has been passed to other
			 * player, that is:
			 * 
			 * Server:player1.....fire();
			 * message to player2 on success/failure of shot
			 * player1.update
			 * player2.update
			 */
			return true;
		}
		grid.get(x).set(y, MISS);
		// TODO Update view
		return false;
	}

}
