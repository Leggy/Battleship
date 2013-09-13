package battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author User
 * 
 */
public class Matrix implements Iterable<Point> {

	private List<ArrayList<Point>> matrix;
	private int size;

	public Matrix(int size, double val) {

		this.matrix = new ArrayList<ArrayList<Point>>(size);
		this.size = size;

		for (int i = 0; i < size; i++) {
			matrix.add(row(size, val, i));
		}

	}

	private ArrayList<Point> row(int size, double val, int y) {
		ArrayList<Point> array = new ArrayList<Point>();

		for (int i = 0; i < size; i++) {
			array.add(new Point(val, i, y));
		}
		return array;

	}

	public Point get(int x, int y) {
		return matrix.get(y).get(x);
	}

	public void set(int x, int y, double value) {
		/*
		 * TODO: VALIDATE INPUT
		 */
		matrix.get(y).get(x).setValue(value);
	}

	public String toString() {
		String lineSep = System.getProperty("line.separator");
		String str = "";
		for (ArrayList<Point> array : matrix) {
			str += "[ ";
			for (Point p : array) {
				str += (String.format("%.4f", p.value()) + " ");
			}
			str = str + "]" + lineSep;
		}
		return str;

	}

	public String toHMString() {
		String lineSep = System.getProperty("line.separator");
		String str = "";
		for (ArrayList<Point> array : matrix) {
			str += "[ ";
			for (Point p : array) {
				if (p.isHit()) {
					str += "H ";
				} else if (p.isMiss()) {
					str += "M ";
				} else {
					str += "_ ";
				}
			}
			str = str + "]" + lineSep;
		}
		return str;

	}

	public int size() {
		return size;
	}

	private class MatrixIterator implements Iterator<Point> {
		private int x;
		private int y;

		public MatrixIterator() {
			x = 0;
			y = 0;
		}

		public boolean hasNext() {
			if (!(y < size && x <= size)) {
				return false;
			}
			if (!(y < size - 1) && !(x < size)) {
				return false;
			}
			return x < size || y < size;
		}

		public Point next() {
			/*
			 * If x is less the the row limit, then returns the current
			 * Point(x++, y), post incrementing x so that it is ready for the
			 * next execution.
			 * 
			 * Otherwise, as there is a next Point, the next point must be on
			 * the next row, and as such x is set to 0, and it returns the
			 * Point(x++, ++y). Note the pre-incrementing on y, and the post
			 * incrementing on x, so that we are both dealing with the correct
			 * row, and that its ready for the next execution.
			 * 
			 * Also note the cloning of the Points, to preserve immutability.
			 */
			if (x < size) {
				return get(x++, y).clone();
			}
			x = 0;
			return get(x++, ++y).clone();

		}

		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	public Iterator<Point> iterator() {
		return new MatrixIterator();
	}

	public String probabilityString() {
		String lineSep = System.getProperty("line.separator");
		String str = "";
		for (ArrayList<Point> array : matrix) {
			str += "[ ";
			for (Point p : array) {
				if (p.multiplier() > 1) {
					str += (String.format("%.2f", p.multiplier()) + " ");
				} else {
					str += "____ ";
				}
			}
			str = str + "]" + lineSep;
		}
		return str;
	}

}
