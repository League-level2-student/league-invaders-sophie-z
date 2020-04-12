import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
	void up() {
		if(y>=15) {
		y-=speed;
		}
	}
	void down() {
		if(y<=600) {
		y+=speed;
		}
	}
	
	void left() {
		if(x>=15) {
		x-=speed;
		}
	}
	
	void right() {
		if(x<=485) {
		x+=speed;
		}
	}
}