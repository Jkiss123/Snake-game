/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake_game;

import java.awt.Color;
import java.awt.*;

import java.awt.event.*;

import java.util.Random;
import javax.swing.*;
import static snake_game.GamePanels.UNIT_SIZE;


/**
 *
 * @author Cloudy
 */
public class GamePanel extends JPanel implements ActionListener {
    
    static final int screenWidth = 1500;
    static final int screenHeight = 750;
    static final int unitSize = 50;
    static final int gameUnit = (screenWidth/unitSize)*(screenHeight/unitSize);
    static final int delay = 175;
    final int x[] = new int[gameUnit];
    final int y[] = new int[gameUnit];
    
    private int bodyPart = 6;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'D';
    private boolean running = false;
    private Timer timer;
    Random random;
    
   
    
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    
    public void startGame(){
        
        running = true;
        newApple();
        timer = new Timer(delay,this);
        timer.start();
        
    }
    public void draw(Graphics g){
    
            for(int i=0;i<screenWidth/unitSize;i++) {
				g.drawLine(i*unitSize, 0, i*unitSize, screenHeight);
				g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
                                
    }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitSize, unitSize);
            
            for(int i=0;i<bodyPart;i++){
                if(i==0){
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }else{
                    g.setColor(new Color(45,180,0));
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], unitSize,unitSize);
                }
            }
   
	}
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
    }
    
 public void move(){
		for(int i = bodyPart;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
    
    public void checkAppleEaten(){
    
    }
    
    public void checkCollisions(){
    }
    
    public void gameOver(){
    
    }

    private void newApple() {
        appleX = random.nextInt(screenWidth/unitSize)*unitSize;
        appleY = random.nextInt(screenHeight/unitSize)*unitSize;
    }
    
    public class MyKeyAdapter extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(running){
                move();
                checkAppleEaten();
                checkCollisions();
            }
    }
    
}
