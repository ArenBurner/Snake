package game;

public class Coordinates implements Cloneable {
	private int x,y,d;
	
	public Coordinates(int x, int y, int d) {
		this.x=x;
		this.y=y;
		this.d=d;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public int d() {
		return d;
	}
	
	public Coordinates clone() {
		try {
			return (Coordinates) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
