import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	GamePanel gp;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
		public LeagueInvaders() {
			this.frame = new JFrame();
			this.gp = new GamePanel();
		}
	
		void setup() {
			frame.add(gp);
			frame.addKeyListener(gp);
			frame.setSize(WIDTH, HEIGHT);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
public static void main(String[] args) {
	LeagueInvaders li = new LeagueInvaders();
	li.setup();
}
}
