package CrazyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

public class CrazyBird extends JFrame implements MouseListener, KeyListener {
	public static void main(String[] args) {
		new CrazyBird();
	}

	int pressed = 0;
	int pressed2 = 0;
	int highestScore = 0;
	int key;
	int w = 1000;
	int h = 700;
	double v = 1;
	double vb = 0;
	int n = 100;
	public Column c[] = new Column[n];
	public Bird b = new Bird();
	public double y = b.y;
	BufferedImage bufImg;
	Graphics g;
	Column co = new Column();

	public CrazyBird() {
		this.setTitle("Crazy Bird");
		this.setSize(w, h);
		this.setDefaultCloseOperation(3);
		b = new Bird(h/2, vb, this);
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			double temp = rand.nextInt(200) + 50;
			c[i] = new Column(w + i * 300, temp, v, this);
		}
		bufImg = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		g = bufImg.getGraphics();

		this.setVisible(true);
		this.addMouseListener(this);
		this.addKeyListener(this);
	}

	@SuppressWarnings("deprecation")
	public void paint(Graphics g1) {
		//paint screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(176, 226, 255));
		g.fillRect(0, 138, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.drawLine(0, 138, this.getWidth(),138);
		g.drawLine(0, 589, this.getWidth(), 589);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Your Score      : " + co.getScore(), 350, 70);
		g.drawString("Highest Score : " + highestScore, 350, 110);
		g.setColor(new Color(205, 198, 115));
		g.fillRect(0, 588, this.getWidth(), 112);
		g.setColor(new Color(0, 139, 69));
		g.fillRect(0, 588, this.getWidth(), 15);
		//paint bird
		g.setColor(Color.RED);
		g.fillRect(400, (int) b.y, 30, 30);
		g.setColor(Color.WHITE);
		g.fillOval(419, (int) b.y + 1, 10, 10);
		g.setColor(Color.BLACK);
		g.fillOval(424, (int) b.y + 5, 5, 5);
		g.drawLine(400, (int) b.y + 15, 392, (int) b.y + 10);
		g.drawLine(400, (int) b.y + 15, 389, (int) b.y + 15);
		g.drawLine(400, (int) b.y + 15, 392, (int) b.y + 20);
		g.fillRect(424, (int) b.y + 20, 10, 3);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Press 'space' to play", 360, 300);
		if(pressed==1) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(new Color(176, 226, 255));
			g.fillRect(0, 139, this.getWidth(), this.getHeight());
			g.setColor(Color.BLACK);
			g.drawLine(0, 138, this.getWidth(), 138);
			g.drawLine(0, 589, this.getWidth(), 589);
			g.setColor(Color.BLUE);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Your Score      : " + co.getScore(), 425, 70);
			g.drawString("Highest Score : " + highestScore, 425, 110);
			g.setColor(new Color(205, 198, 115));
			g.fillRect(0, 588, this.getWidth(), 150);
			g.setColor(new Color(0, 139, 69));
			g.fillRect(0, 588, this.getWidth(), 15);
			//paint column
			for (Column c : c) {
				g.setColor(new Color(0, 205, 0));
				g.fillRect((int) c.x, 138, 70, (int) c.d);
				g.fillRect((int) c.x, (int) c.d + 288, 70, h - 400 - (int) c.d);
			}
			g.setColor(Color.RED);
			g.fillRect(400, (int) b.y, 30, 30);
			g.setColor(Color.WHITE);
			g.fillOval(419, (int) b.y + 1, 10, 10);
			g.setColor(Color.BLACK);
			g.fillOval(424, (int) b.y + 5, 5, 5);
			g.drawLine(400, (int) b.y + 15, 392, (int) b.y + 10);
			g.drawLine(400, (int) b.y + 15, 389, (int) b.y + 15);
			g.drawLine(400, (int) b.y + 15, 392, (int) b.y + 20);
			g.fillRect(424, (int) b.y + 20, 10, 3);
			if(b.dead==1 || b.dead==2|| b.dead==3) {
				if(co.dem>highestScore)
					highestScore=co.dem;
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("You lose", 400, 400);
			}
			if(key==114) {
				key=0;
				this.hide();
				new CrazyBird().highestScore=highestScore;
				co.dem=0;
			}
		}
		if(b.dead==1 || b.dead==2 || b.dead==3) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Press 'r' to play again", 340, 300);
		}
		g1.drawImage(bufImg, 0, 0, w, h, null);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
		if (b.y - 45 > 139 && b.y + 30 < h - 115 && b.dead != 1 && b.dead != 2 && b.dead != 3) {
			b.y -= 60;
			b.v = 0;
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		key=e.getKeyChar();
		if(key==32) {
			pressed = 1;
			b.start();
			for (int i = 0; i < n; i++) {
				c[i].start();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
