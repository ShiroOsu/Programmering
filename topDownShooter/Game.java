package topDownShooter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 
 * @author Niklas Hörnqvist Granskog
 *
 */
public class Game extends Canvas{

    private JFrame frame;
    private String fps, tps, score;
    private Player player;
    private BulletManager bulletManager;
    private Enemy lmao;
    public static Level level1;
    private int mobCount = 10;
    private String mobCounts;

    

    public static final int WIDTH = 600, HEIGHT = 700;
    
    public Game(){
    	
    	player = new Player(WIDTH/2 - 40, 600, loadImage("/topDownShooter/lmao/SpaceShip.png"), 80, 80, 4.69);
    	bulletManager = new BulletManager(player);
    	
    	bulletManager.setImage(loadImage("/topDownShooter/lmao/bullet.png"));

    	//lmao = new Enemy(loadImage("/topDownShooter/lmao/blaue.png"), WIDTH/2 - 50, 100, 100, 100, 0.01);
    	level1 = new Level(bulletManager);
    	level1.setImage(loadImage("/topDownShooter/lmao/red.jpg"));
    	
    	addKeyListener(player);
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
        	
        	score = String.valueOf(mobCount);
        	mobCounts = String.valueOf(level1.getMobCount());
            
            
        
            
            //TODO logik och skit
            //TODO sleeptime
            //TODO tömma minnet innan man stänger ner applikationen
        }
    }
    
    private void update(){
        player.update();
        bulletManager.update();
        level1.update();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);  
        g.fillRect(0, 0, WIDTH, HEIGHT); //Clear screen
        
        
  

        bulletManager.render(g);
        player.render(g);
        level1.render(g);
        
        

        g.setColor(Color.BLACK);


        g.drawString("Fps :", 5, 20);
        g.drawString("Tps :", 5, 40);
        g.drawString("Score :", 5, 60);
        g.drawString("Mob Count:", 5, 80);
        if(fps != null){
        	g.drawString(mobCounts, 80, 80);
            g.drawString(score, 50, 60);
        	g.setColor(Color.RED);
        	g.drawString(fps, 40, 20);
        	g.setColor(Color.GREEN);
        	g.drawString(tps, 40,  40);
        }

        g.dispose();
        bs.show();
    }

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



