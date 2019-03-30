package bean;

import java.awt.image.BufferedImage;

/**
 * 子弹类:是飞行物
 */
public class Bullet  {
	private int speed = 3;  //移动的速度
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage image;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/** 初始化数据 */
	public Bullet(int x,int y,BufferedImage image){
		this.x = x;
		this.y = y;
		this.image = image;
	}


	public void step(){   
		x += speed;
	}

	/** 越界处理 */
	public boolean ShootMonster(Monster monster) {
		return this.getX() > monster.getX();
	}

}
