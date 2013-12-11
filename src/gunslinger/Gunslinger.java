package gunslinger;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Gunslinger extends Applet implements Runnable, KeyListener {

	// Button constants
	private static final int PLAYER1_SHOOT = KeyEvent.VK_S;
	private static final int PLAYER2_SHOOT = KeyEvent.VK_K;

	private Player player1;
	private Player player2;
	private Image image, player1Image, player2Image;
	private String player1Skin = "images/defaultplayer1.png";
	private String player2Skin = "images/defaultplayer2.png";
	private Graphics second;
	private URL base;

	@Override
	public void init() {
		// Frame setup
		setSize(700, 500);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Project Gunslinger v0.0.1");
		addKeyListener(this);

		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO
		}

		// Image setup
		player1Image = getImage(base, player1Skin);
		player2Image = getImage(base, player2Skin);

		// Positions
		player1.setCenterX(200);
		player1.setCenterY(300);
		player2.setCenterX(500);
		player2.setCenterY(300);
	}

	@Override
	public void start() {
		player1 = new Player();
		player2 = new Player();
		
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO
	}

	@Override
	public void destroy() {
		// TODO
	}

	@Override
	public void run() {
		// infinite game loop
		while (true) {
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		case PLAYER1_SHOOT:
			System.out.println("Player 1 shoots!");
			break;

		case PLAYER2_SHOOT:
			System.out.println("Player 2 shoots!");
			break;

		default:
			System.out.println(e.getKeyCode() + " pressed");

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {

		case PLAYER1_SHOOT:
			System.out.println("Player 1 shot released.");
			break;

		case PLAYER2_SHOOT:
			System.out.println("Player 2 shot released.");
			break;

		default:
			System.out.println(e.getKeyCode() + " released");

		}
	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(player1Image, player1.getCenterX(), player1.getCenterY(), this);
		g.drawImage(player2Image, player2.getCenterX(), player2.getCenterY(), this);
	}
}
