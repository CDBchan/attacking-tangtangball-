package main;

public class Ball {
	int posX;
	int posY;
	int speedX;
	int speedY;
	int width;
	int height;

	boolean keyDown;
	boolean keyUp;
	boolean keyLeft;
	boolean keyRight;

	public Ball(int posX, int posY, int speedX, int speedY, int width, int height) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.speedX = speedX;
		this.speedY = speedY;
		this.width = width;
		this.height = height;
	}
	
//	public void up() {
//		if (keyUp == true) {
//			posY -= 5;
//		}
//	}
//	
//	public void down() {
//		if (keyDown == true) {
//			posY += 5;
//		}
//	}
//
//	public void right() {
//		if (keyRight == true) {
//			posX += 5;
//		}
//	}
//	
//	public void left() {
//		if (keyLeft == true) {
//			posX -= 5;
//		}
//	}

}
