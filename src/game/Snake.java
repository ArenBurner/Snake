package game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake extends Rectangle {
	private int mX,mY;
	private ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
	public Snake(int x, int y) {
		super(x,y,40,40);
		mX=40;
		mY=0;
	}
	public Snake(int x, int y, ArrayList<Coordinates> coords) {
		super(x,y,40,40);
		mX=40;
		mY=0;
		this.coords=coords;
	}
	public void addCoord(Coordinates c) {
		coords.add(c);
	}
	public ArrayList<Coordinates> getCoords(){
		ArrayList<Coordinates> cloned = new ArrayList<Coordinates>(coords.size());
		for(Coordinates c: coords) {
			cloned.add(c.clone());
		}
		return cloned;  //DO NOT EXPOSE ENTIRE ArrayList object
	}

	private void changeDirection(int direction) {
		switch(direction) {
		case 0:
			mX=40;
			mY=0;
			break;
		case 1:
			mX=-40;
			mY=0;
			break;
		case 3:
			mX=0;
			mY=40;
			break;
		case 2:
			mX=0;
			mY=-40;
			break;
		}
	}
	private void adjustDirection() {
		for(int i=0;i<coords.size();i++) {
			Coordinates c=coords.get(i);
			if(this.x==c.x() && this.y==c.y()) {
				changeDirection(c.d());
				coords.remove(c);
				i--;
			}
		}
	}
	
	public void move() {
		adjustDirection();
		x+=mX;
		y+=mY;
	}

	public int returnXPos() {
		return this.x;
	}
	public int returnYPos() {
		return this.y;
	}
	
	public int xSpeed() { return mX; }
	
	public int ySpeed() {return mY; }
	
	public void setSpeeds(int x, int y) {
		this.mX = x;
		this.mY = y;
	}
}
