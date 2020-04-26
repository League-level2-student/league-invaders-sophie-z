import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("Rocketship.png");
		}
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, x-30, y, width, height, null);
        } 
        else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
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
		if(x<=410) {
		x+=speed;
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 
}