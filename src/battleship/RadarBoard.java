package battleship;

public class RadarBoard {
	private int value;
	private StatusBoard sb;
	
	public RadarBoard(int n, int t){
		this.value = n;
		this.sb = new StatusBoard(t);
	}
	
	public String toString(){
		return "" + value + "    SB " + sb.toString();
	}
	
	public StatusBoard getSB(){
		return sb;
	}
}
