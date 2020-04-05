import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Timer frameDraw;
    Rocketship r = new Rocketship(250, 600, 50, 50);
    
    public GamePanel() {
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	frameDraw = new Timer(1000/60, this);
        frameDraw.start();
    }
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
    
    void updateMenuState() {	
    }
    
    void updateGameState() {	
    }

    void updateEndState() {	
    }
    
    void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.WHITE);
    	g.drawString("LEAGUE INVADERS", 20, 150);
    	g.setFont(getFont());
    	g.drawString("Press ENTER to start", 185, 325);
    	g.drawString("Press SPACE for instructions", 165, 425);
    }
    
    void drawGameState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	r.draw(g);
    }
    
    void drawEndState(Graphics g) {	
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.WHITE);
    	g.drawString("GAME OVER", 105, 150);
    	g.setFont(getFont());
    	g.drawString("You killed enemies", 200, 325);
    	g.drawString("Press ENTER to restart", 190, 425);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (arg0.getKeyCode()==KeyEvent.VK_UP) {
		    if(r.y>=15) {
			r.up();
			}
		}
		else if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		    if(r.y<=600) {
		    r.down();
		    }
		else if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
		    if(r.x<=485) {
			r.right();
			}
		}
		else if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			if(r.x>=15) {
			r.left();
			}
		}
	}
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
