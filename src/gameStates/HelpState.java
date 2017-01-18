package gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import backGrounds.Background;
import topDownShooter.Game;

public class HelpState extends GameState {
	private Color helpColor, textColor;
	private Font font;
	private String[] options = {"Quit", "Back"};
	private int currentChoice = 1;
	private Background bg;
	
	public HelpState(GameStateManager gsm){
		bg = new Background("/topDownShooter/lmao/helpbg.png", 1);
		init();
	}

	public void init() {
	
		//something 
	}


	public void update() {
		bg.update();
		
	}


	public void render(Graphics g) {
		bg.render(g);
		textColor = new Color(255, 255, 255);
		font = new Font("Arial", Font.PLAIN, 20);
	
		g.setFont(font);
		g.setColor(textColor);
		g.drawString("Welcome to the game 'Shooter'. ", 50, 50);
		g.drawString("You're a space captain. ", 50, 75);
		g.drawString("Your job as a space captain is to kill all the alien spaceships.", 50, 105);
		g.drawString("W A S D to move your spaceship.", 50, 135);
		g.drawString("F to fire your cannonballs for tons of damage.", 50, 165);
		
		
		g.drawString("[0x7FFA73005110] ANOMALY: meaningless REX prefix used.", 50, 500);
		g.drawString("White is the option you select.", 50, 530);
		
		for(int i = 0; i < options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], Game.WIDTH/2 - 30, 200 + i * 30);
		}
	
		
	}
	
	private void select(){
		if(currentChoice == 0){
			System.exit(0);
		}
		if(currentChoice == 1){
			gsm.setState(gsm.MENUSTATE);
		}
	}


	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		
		if(k == KeyEvent.VK_UP){
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = options.length -1;
			}
		}
		
		if(k == KeyEvent.VK_DOWN){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice = 0;
			}
		}
	}


	public void keyReleased(int k) {
	
	}

}
