package gameStates;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameStateManager {
	
	private int currentState = 0;
	
	public static final int MENUSTATE = 0, LEVEL1STATE = 1, HELPSTATE = 2;
	private ArrayList<GameState> gameStates;
	
	
	
	public GameStateManager(){
		
		gameStates = new ArrayList<GameState>();
		
		currentState = MENUSTATE;
		
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this));
		gameStates.add(new HelpState(this));
		
	}
	
	public void setState(int state){
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	
	public void update(){
		gameStates.get(currentState).update();
	}
	
	public void render(Graphics g){
		gameStates.get(currentState).render(g);
	}
	
	public void keyPressed(int k){
		gameStates.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(int k){
		gameStates.get(currentState).keyReleased(k);
	}

}
