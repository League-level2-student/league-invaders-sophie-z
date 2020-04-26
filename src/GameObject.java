import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width; 
	int height;
	int speed = 0;
	boolean isActive = true;
	Rectangle collisionBox;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox = new Rectangle (collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
	void update() {
		collisionBox.setBounds(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
}