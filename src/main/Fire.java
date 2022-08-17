package main;

public class Fire {
	int posX;
	int posY;
	int width;
	int height;
	
	public Fire(int posX, int posY, int width, int height) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}
	
	public void move() {
		posY -=10;
	}

}
