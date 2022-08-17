package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class MyCanvas extends Canvas {

	/*
	 * 객체지향 설계는 속성은 필드 움직임은 메소드로 표현 Ball 클래스를 추가하여 객체지향적으로 만들자 키보드 방향키로 움직이도록 스페이스바를
	 * 통해 총알을 쏠수있도록
	 */

	Image buffImage;
	Graphics buffg;
	Graphics buffg2;
	Ball ball;
	Fire fire;
	Enemy enemy;

	ArrayList<Fire> fireArr = new ArrayList<Fire>();
	// 누를때마다 ArrayList의 사이즈가 늘어남 따라서 적당량에서 컷

//	ArrayList<Ball> ballarr = new ArrayList<Ball>();

	public MyCanvas() {
		enemy = new Enemy(200, 50, 200, 50);
		ball = new Ball(0, 0, 5, 5, 50, 50);

		repaint();
		new MyThread().start();
	}

	@Override
	public void paint(Graphics g) {
		if (buffg == null) {
			buffImage = createImage(getWidth(), getHeight());
			if (buffImage == null) {
				System.out.println("오프 스크린 생성 실패");
			} else {
				buffg = buffImage.getGraphics();
			}
		}
		update(g);
	}

	@Override
	public void update(Graphics g) {
		if (buffg != null) {
			buffg.setColor(Color.BLUE);
			buffg.fillRect(0, 0, getWidth(), getHeight()); // 이두줄이 주석처리되면 원이 겹쳐지면서 그려짐 (원이 삭제가 안되서)

			buffg.setColor(Color.red);
//			buffg.drawOval(100, 100, 100, 100);

			// 나

			buffg.fillOval(ball.posX, ball.posY, ball.width, ball.height);

//			for (int i = 0; i < ballarr.size(); i++) {
//				
//				Ball ball = ballarr.get(i);
//
//				buffg.fillOval(ball.posX, ball.posY, ball.width, ball.height);
//			}

			// 총알
			for (int i = 0; i < fireArr.size(); i++) {
				Fire fire = fireArr.get(i);
				buffg.fillRect(fire.posX, fire.posY, 10, 10);
			}

			// 적 어떻게 buffg가 나인지 적인지 구별하면서 그려주는거지?

			buffg.setColor(Color.white);
			buffg.fillRect(100, 50, 100, 100);

			g.drawImage(buffImage, 0, 0, this);
		}
	}

	public void addFire() {
		int posX = ball.posX;
		int posY = ball.posY;
		fireArr.add(new Fire(posX, posY - 20, 5, 20));

	}

	class MyThread extends Thread {
		@Override
		public void run() {
			while (true) {

//				ball.move(getWidth(), getHeight());
//				for (int i = 0; i < ballarr.size(); i++) {
//					ballarr.get(i).move(getWidth(), getHeight());
//				}

				for (int i = 0; i < fireArr.size(); i++) {
					Fire fire = fireArr.get(i);
					fire.move();

					if (fire.posY < -100) {
						fireArr.remove(i);
						i--; // -- 해주는 이유 생각하기
					}

				}

				// 충돌확인

				for (int i = 0; i < fireArr.size(); i++) {
					Fire fire = fireArr.get(i);
					Rectangle rectA = new Rectangle(fire.posX, fire.posY, fire.width, fire.height);
					Rectangle rectB = new Rectangle(enemy.posX, enemy.posY, enemy.width, enemy.height);
					
					if (rectA.intersects(rectB)) {// intersects 겹치는게 있는지
						fireArr.remove(i);
						i--;
						if(enemy.life ==0) {
							enemy.posX =-1000;
						}
					}
				}

				/** 이렇게 Thread에 넣어주는게 훨씬 부드럽게 움직인다 **/

				if (ball.keyUp) {
					ball.posY -= 5;
				}
				if (ball.keyDown) {
					ball.posY += 5;
				}
				if (ball.keyRight) {
					ball.posX += 5;
				}
				if (ball.keyLeft) {
					ball.posX -= 5;
				}

				repaint();

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
