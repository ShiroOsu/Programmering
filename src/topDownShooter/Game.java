package topDownShooter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import gameStates.GameStateManager;

/**
 * 
 * @author Niklas
 *
 */
public class Game extends Canvas implements KeyListener {

    private JFrame frame;
    private String fps, tps, score, bulletCount;
    private Player player;
    private BulletManager bulletManager;
    private int mobCountKilled = 0;
    private GameStateManager gsm;



    public static final int WIDTH = 600, HEIGHT = 700;
    
    public Game(){
    	
    	player = new Player(WIDTH/2 - 40, 600, loadImage("/topDownShooter/lmao/SpaceShip.png"), 80, 80, 4.69);
    	bulletManager = new BulletManager(player);
    	bulletManager.setImage(loadImage("/topDownShooter/lmao/bullet.png"));
    	
    	gsm = new GameStateManager();
    	gsm.setState(0);
    	
    	addKeyListener(this);
        frame = new JFrame("Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        super.setSize(new Dimension(WIDTH, HEIGHT));
        frame.add(this);
        frame.pack();
        frame.addKeyListener(player);
        setFocusable(true);
         
        frame.setVisible(true);
        
        loop();
    }
    
    private void loop(){
    	int frames = 0, ticks = 0;
    	long lastTime = System.nanoTime();
    	double ns = 1000000000.0D/60.0D, delta = 0.0D;
    	long timer = System.currentTimeMillis();
    	
        createBufferStrategy(3);
    
        requestFocus();
        
        
      
        //game loop
        while(true){
        	
        	
        	long now = System.nanoTime();
        	delta += (now - lastTime) / ns;
        	lastTime = now;
        	while(delta >= 1){
        		delta--;
        		ticks++;
        		update();
        	}
        	
        	
        	frames++;
        	render();
        	
        	
        	
        	try{
        		Thread.sleep(5);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	
        	
        	
        	if(System.currentTimeMillis() - timer >= 1000){
        		fps = String.valueOf(frames);
        		tps = String.valueOf(ticks);
        		ticks = frames = 0;
        		timer += 1000;
        		
        	}
        	
        	score = String.valueOf(mobCountKilled);
        	bulletCount = String.valueOf(bulletManager.getBullets());
        	
    
        }
    }
    
    private void update(){
        player.update();
        bulletManager.update();
        gsm.update();
     

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        
        gsm.render(g);
        

        g.dispose();
        bs.show();
        
    }
    
	public void keyPressed(KeyEvent k) {
		gsm.keyPressed(k.getKeyCode());
	}

	
	public void keyReleased(KeyEvent k) {
		gsm.keyReleased(k.getKeyCode());
	}

	
	public void keyTyped(KeyEvent k) {}
   
    private BufferedImage loadImage(String path){
        try{
            return ImageIO.read(getClass().getResourceAsStream(path));
        }catch (IOException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public static void main(String[]args){
    	new Game();
    }
}



