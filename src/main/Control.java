package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Control {


	public void init() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//		System.out.println(screen.width + "," + screen.height);
		JFrame frame = new JFrame("캔버스");
		frame.setLocation(screen.width / 2 - 500, screen.height / 2 - 350);
		frame.setSize(1000, 700);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyCanvas can = new MyCanvas();
		can.setLocation(50, 50);
		can.setSize(900, 600);
		
		can.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) { // 키보드를 땔때 (← 37) 
				System.out.println("떼다 :"+ e.getKeyCode());
				
//				can.ball.keyDown=false;
//				can.ball.keyUp=false;
//				can.ball.keyLeft=false;
//				can.ball.keyRight=false;
				
				if(e.getKeyCode()==38) {
					can.ball.keyUp=false;
				}				
				if(e.getKeyCode()==40) {
					can.ball.keyDown=false;		
				}						
				if(e.getKeyCode()==39) {
					can.ball.keyRight=false;		
				}			
				if(e.getKeyCode()==37) {
					can.ball.keyLeft=false;			
				}		
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) { // 키보드를 눌렀을때
					System.out.println("누르다 :"+ e.getKeyCode());
				if(e.getKeyCode()==38) {
					can.ball.keyUp=true;
				}
//				can.ball.up();
				
				if(e.getKeyCode()==40) {
					can.ball.keyDown=true;		
				}
//				can.ball.down();
							
				if(e.getKeyCode()==39) {
					can.ball.keyRight=true;		
				}
//				can.ball.right();
				
				if(e.getKeyCode()==37) {
					can.ball.keyLeft=true;			
				}		
//				can.ball.left();
		
				if(e.getKeyCode()==32) {
					can.addFire();		
				}	
				
				
			}
		});
		
		frame.add(can);
		
		frame.setVisible(true);
	}


}
