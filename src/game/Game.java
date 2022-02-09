package game;

import utilities.GDV5;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Color;

public class Game extends GDV5 implements KeyListener {
	private ArrayList<Snake> snake = new ArrayList<Snake>();
	private int time = 0;
	public Game() {
		createSnake();
	}
	@Override
	public void update() {
		if(KeysPressed[KeyEvent.VK_W]) {
			moveSnake(2);
		}
		if(KeysPressed[KeyEvent.VK_D]) {
			moveSnake(0);
		}
		if(KeysPressed[KeyEvent.VK_A]) {
			moveSnake(1);
		}
		if(KeysPressed[KeyEvent.VK_S]) {
			moveSnake(3);
		}
		time++;
		if(time/15==1) {
			for(Snake s: snake) {
				s.move();
			}
			time=0;
		}
		
	}
	private void moveSnake(int direction) {
		int x = snake.get(snake.size()-1).returnXPos();
		int y = snake.get(snake.size()-1).returnYPos();
		for(Snake s: snake) {
			s.addCoord(new Coordinates(x,y,direction));
		}
	}
	private void createSnake() {
		int x=40;
		int y=40;
		for(int i=0;i<6;i++) {
			snake.add(new Snake(x,y));
			x+=40;
		}
	}
	@Override
	public void draw(Graphics2D win) {
		win.setColor(Color.WHITE);
		for(Snake s:snake) {
			win.fill(s);
			win.draw(s);
		}
		
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.start();
	}

}
