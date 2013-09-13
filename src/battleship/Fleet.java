package battleship;

public class Fleet {

	public final int CARRIER_NUM;
	public final int BATTLESHIP_NUM;
	public final int CRUISER_NUM;
	public final int FRIGATE_NUM;

	public final int CARRIER_SIZE = 5;
	public final int BATTLESHIP_SIZE = 4;
	public final int CRUISER_SIZE = 3;
	public final int FRIGATE_SIZE = 2;

	public final int CARRIER_WEIGHT;
	public final int BATTLESHIP_WEIGHT;
	public final int CRUISER_WEIGHT;
	public final int FRIGATE_WEIGHT;

	public final double CARRIER_RATIO;
	public final double BATTLESHIP_RATIO;
	public final double CRUISER_RATIO;
	public final double FRIGATE_RATIO;

	/**
	 * Creates a fleet composing of the specified numbers of each ship class.
	 * 
	 * @param carrier
	 *            The number of carriers composing the fleet.
	 * @param battleship
	 *            The number of battleships composing the fleet.
	 * @param cruiser
	 *            The number of cruisers composing the fleet.
	 * @param frigate
	 *            The number of frigates composing the fleet.
	 */
	public Fleet(int carrier, int battleship, int cruiser, int frigate) {
		this.CARRIER_NUM = carrier;
		this.BATTLESHIP_NUM = battleship;
		this.CRUISER_NUM = cruiser;
		this.FRIGATE_NUM = frigate;

		this.CARRIER_WEIGHT = CARRIER_NUM * CARRIER_SIZE;
		this.BATTLESHIP_WEIGHT = BATTLESHIP_NUM * BATTLESHIP_SIZE;
		this.CRUISER_WEIGHT = CRUISER_NUM * CRUISER_SIZE;
		this.FRIGATE_WEIGHT = FRIGATE_NUM * FRIGATE_SIZE;

		this.CARRIER_RATIO = (double) CARRIER_WEIGHT / weight();
		this.BATTLESHIP_RATIO = (double) BATTLESHIP_WEIGHT / weight();
		this.CRUISER_RATIO = (double) CRUISER_WEIGHT / weight();
		this.FRIGATE_RATIO = (double) FRIGATE_WEIGHT / weight();

		System.out.println(FRIGATE_RATIO + "   " + (double) 6 / 84);
		System.out.println(FRIGATE_RATIO / ((double) 6 / 84));
	}

	public int size() {
		return CARRIER_NUM + BATTLESHIP_NUM + CRUISER_NUM + FRIGATE_NUM;
	}

	public int weight() {
		return CARRIER_WEIGHT + BATTLESHIP_WEIGHT + CRUISER_WEIGHT
				+ FRIGATE_WEIGHT;
	}

	public double probabilityModifier(int distance) {
		double modifier = 0;
		distance = Math.abs(distance);

		if (FRIGATE_SIZE > distance) {
			modifier += FRIGATE_RATIO * (double) (FRIGATE_SIZE - distance)
					/ (4 * sumTo(FRIGATE_SIZE - 1));
			
			//TODO: Remove debugs
//			
//			System.out.println("Modifier (Frig)  " + modifier);
//			System.out.println("Frig Ratio: " + FRIGATE_RATIO);
//			System.out.println("Fuction: " + (double) (FRIGATE_SIZE - distance)
//					/ (4 * sumTo(FRIGATE_SIZE - 1)));

		}

		if (CRUISER_SIZE > distance) {
			modifier += CRUISER_RATIO * (double) (CRUISER_SIZE - distance)
					/ (4 * sumTo(CRUISER_SIZE - 1));

//			System.out.println("Modifier (Crui)  " + modifier);
//			System.out.println("Cruiser Ratio: " + CRUISER_RATIO);
//			System.out.println("Fuction: " + (double) (CRUISER_SIZE - distance)
//					/ (4 * sumTo(CRUISER_SIZE - 1)));
		}

		if (BATTLESHIP_SIZE > distance) {
			modifier += BATTLESHIP_RATIO
					* (double) (BATTLESHIP_SIZE - distance)
					/ (4 * sumTo(BATTLESHIP_SIZE - 1));

//			System.out.println("Modifier (Batt)  " + modifier);
//			System.out.println("Battleship Ratio: " + BATTLESHIP_RATIO);
//			System.out.println("Fuction: "
//					+ (double) (BATTLESHIP_SIZE - distance)
//					/ (4 * sumTo(BATTLESHIP_SIZE - 1)));
		}

		if (CARRIER_SIZE > distance) {
			modifier += CARRIER_RATIO * (double) (CARRIER_SIZE - distance)
					/ (4 * sumTo(CARRIER_SIZE - 1));
//			System.out.println("Modifier (Carr)  " + modifier);
//			System.out.println("Carrier Ratio: " + CARRIER_RATIO);
//			System.out.println("Fuction: " + (double) (CARRIER_SIZE - distance)
//					/ (4 * sumTo(CARRIER_SIZE - 1)));
		}

		return modifier;
	}

	private int sumTo(int i) {
		// TODO VAlidate input

		int sum = 0;
		for (int j = 1; j <= i; j++) {
			sum += j;
		}
		return sum;
	}

}
