package org.leggy.battleship.grid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.leggy.battleship.client.ClientController;

public class PrimaryGrid {

	private int WIDTH = 150;
	private int HEIGHT = 150;
	
	private ClientController client;

	private List<ArrayList<JButton>> grid;

	/**
	 * Initialises the PrimaryGrid
	 * 
	 * @param size
	 *            The size of the PrimaryGrid
	 */
	public PrimaryGrid(int size, ClientController client) {
		this.client = client;
		grid = new ArrayList<ArrayList<JButton>>();
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
	private ArrayList<JButton> newGridColumn(int size) {
		ArrayList<JButton> temp = new ArrayList<JButton>();
		for (int i = 0; i < size; i++) {
			JButton button = new JButton();
			button.setSize(WIDTH, HEIGHT);
			button.addActionListener(new GridListener(3, 3));
			//TODO
			temp.add(button);
		}
		return temp;
	}
	
	//TODO:public
	
	
	private class GridListener implements ActionListener{
		private int x;
		private int y;

		public GridListener(int i, int j) {
			this.x = i;
			this.y = j;
			
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			client.fire(this.x, this.y);
			// TODO Auto-generated method stub
			
		}
		
	}

}
