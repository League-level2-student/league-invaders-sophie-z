import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship r;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random rand = new Random();
	int score = 0;
	
	int getScore() {
		return score;
		
	}
	
	public ObjectManager(Rocketship r) {
		this.r = r;
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for(int i = 0; i<aliens.size(); i ++) {
			aliens.get(i).update();			
			if(aliens.get(i).y>LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
	}
		for(int i = 0; i<projectiles.size(); i ++) {
			projectiles.get(i).update();
			if(projectiles.get(i).y>LeagueInvaders.HEIGHT) {
				projectiles.get(i).isActive = false;
			}
	}
		r.update(); 
		checkCollision();
		purgeObjects();
	}
	
	void draw(Graphics g) {
		r.draw(g);
	for(int i = 0; i<aliens.size(); i ++) {
		aliens.get(i).draw(g);
	}
	for(int i = 0; i<projectiles.size(); i ++) {
		projectiles.get(i).draw(g);
	}
	}
	
	void purgeObjects() {
		for(int i = aliens.size()-1; i>=0; i--) {
			if(aliens.get(i).isActive == false){
				aliens.remove(i);
			}
		}
		for(int i = projectiles.size()-1; i>=0; i--) {
			if(projectiles.get(i).isActive == false){
				projectiles.remove(i);
			}
		}
	}
	
	void checkCollision() {
		for(int i = 0; i< aliens.size(); i++) {
			if(r.collisionBox.intersects(aliens.get(i).collisionBox)) {
				r.isActive = false;
				aliens.get(i).isActive = false;
				System.out.println("hi");
			}
			for(int j = 0; j< projectiles.size(); j++) {
			if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
				projectiles.get(j).isActive = false;
				aliens.get(i).isActive = false;
				score = score + 1;
			}
			}
		}
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}