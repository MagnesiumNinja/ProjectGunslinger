package gunslinger;

import java.awt.Graphics;

public class Player {

	private int centerX;
	private int centerY;
	private boolean alive = true;

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public boolean getStatus() {
		return alive;
	}

	public void kill() {
		alive = false;
	}

}
