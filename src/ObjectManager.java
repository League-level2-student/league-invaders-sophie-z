import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship r;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random rand = new Random();
	
	public ObjectManager(Rocketship r) {
		this.r = new Rocketship(0, 0, 0, 0);
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
}