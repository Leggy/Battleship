package battleship;

public class Testing {

	public static void main(String[] args) {

		Board board = new Board(10, new Fleet(1, 1, 2, 3));

		System.out.println(board);

		System.out.println("Hits: " + board.numHits());
		System.out.println("Misses: " + board.numMisses());
		System.out.println("");
		System.out.println("Firing (Hit) : (2, 4)");
		board.hit(2, 4);
		System.out.println("Firing (Hit) : (5, 7)");
		board.hit(5, 7);
		System.out.println("Firing (Hit) : (3, 1)");
		board.hit(3, 3);
		System.out.println("");

		System.out.println("Hits: " + board.numHits());
		System.out.println("Misses: " + board.numMisses());
		System.out.println("");

		System.out.println(board);

		System.out.println(board.toHMString());

		System.out.println("Firing (Miss) : (8, 6)");
		board.miss(8, 6);
		System.out.println("Firing (Miss) : (7, 4)");
		board.miss(7, 4);
		System.out.println("Firing (Miss) : (3, 1)");
		board.miss(3, 1);
		System.out.println("");

		System.out.println("Hits: " + board.numHits());
		System.out.println("Misses: " + board.numMisses());
		System.out.println("");

		System.out.println(board);

		System.out.println(board.toHMString());

		System.out.println(board.probabilityString());

	}

}
