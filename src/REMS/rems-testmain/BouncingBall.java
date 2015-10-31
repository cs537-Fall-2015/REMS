
   import java.awt.*;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.awt.geom.*;
import java.applet.AudioClip;
import java.net.*;

public class BouncingBall extends JPanel implements Runnable, KeyListener {
	// Set up variables
	
	  Image ball;  
	  char key;
	  AudioClip slap;
	  boolean right = false;
	  boolean left = false;
	  int direction = 0;
	  int ballHeight = 30;
	  int ballWidth = 30;
	  int xPosition = 10;
	  int yPosition = 2;
	  int xMove = 1;
	  int yMove = 2;
	  float p1xPosition = 200;
	  float p1xMove = 0;
	  float compxPosition = 400;
	  float compxMove = 1;
	  int height;
	  Thread Ball;
	  boolean lol = false;
  
   //Contructer method, sets up Thread called Ball and image called ball.
  

	/** Creates a new instance of BouncingBall */
	public BouncingBall() {
		
		 Ball = new Thread(this);
		 Ball.start();

	}
	 public void keyTyped (KeyEvent e) {
	  
	  }
	   
	   public void keyPressed (KeyEvent evt) {
		 if (evt.getKeyCode() == KeyEvent.VK_LEFT)
			right = true;
		 if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
			left = true;
	  }
	   
	   public void keyReleased (KeyEvent evt) {
		 if (evt.getKeyCode() == KeyEvent.VK_LEFT)
			left = false;
		 if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
			right = false;
	  
	  }
		  
   // Paints the necessary graphics for the program.
  
	   public void paintComponent(Graphics comp) {
		 Graphics2D comp2D = (Graphics2D) comp;
		 comp2D.setColor(Color.white);
		 comp2D.fillRect(0, 0, getSize().width, getSize().height);
		 height = getSize().height - ballHeight;
		 comp2D.setColor(Color.black);
		 BasicStroke pen = new BasicStroke(12F);
		 comp2D.setStroke(pen);
		 Line2D.Float ln1 = new Line2D.Float(p1xPosition, (getSize().height - 20F), (p1xPosition + (getSize().width / 10F)), (getSize().height - 20F));
		 comp2D.draw(ln1);
		 Line2D.Float ln2 = new Line2D.Float(compxPosition, 20F, (compxPosition + (getSize().width / 10F)), 20F);
		 comp2D.draw(ln2);
		 if (yPosition == -1)
			yPosition = height - 20;
		 if (ball != null) {
			comp2D.drawImage(ball,
			   (int) xPosition,
			   (int) yPosition,
			   this);
		 }
	  
		 if ( right == true )
			direction = 2;
		 else  if ( left == true ) {
			direction = 1;
		 
			}
		  
		 
		 else {
			direction = 0; }
		   
		 switch(direction) {
			case 1: p1xPosition += 1;
			   break;
			case 2: p1xPosition -= 1;
			   break;
		 }
				  
		  
	  }
	   
	   //Thread creation
	   
	   public void run(){
		 Thread thisThread = Thread.currentThread();
		 while (Ball == thisThread) {
		
		 //Ball movement
			xPosition += xMove;
			if (xPosition > (getSize().width - ballWidth)) {
				
			   xMove *= -1;
			}
			if (xPosition < 1) {
				
			   xMove *= -1;
			}
			yPosition += yMove;
			if(yPosition < 1) {
				
			   yMove *= -1;
			}
				 
			if(yPosition > (getSize().height - ballHeight)) {
				
			   yMove *= -1;
			}
				 
			 //Computer Movement	
			compxPosition += compxMove;
			if (compxPosition < xPosition)
			   compxMove = 1;
			if (compxPosition < 1)
			   compxMove = 1;
				 
			if (compxPosition > xPosition)
			   compxMove = -1;
			if ((compxPosition + (getSize().width / 10)) > (getSize().width))
			   compxMove = -1;
				 
			 //Tests to see whether the ball is touching the pads.
			 
			 
				 
			 
			 //Attempted player movement
			 
			 
								
			p1xPosition += p1xMove;
			
			repaint();		//Repaints graphics
				 
			try {
			   Thread.sleep(16);		//frame pause 16 miliseconds
			}
				catch (InterruptedException e) { }
		 }
	  }

}

