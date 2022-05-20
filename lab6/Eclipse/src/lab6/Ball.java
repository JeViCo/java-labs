package lab6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball {
	private double x = 0, y = 0;
	private double width = 25, height = 25;
	private double step = 2.5;
	
	private double dx = x, dy = y;
	private double dwidth = width, dheight = height;

	private double dirX = Math.pow(-1,  random(2)) * Math.min(0.5 + Math.random(), 1);
	private double dirY = Math.pow(-1,  random(2)) * Math.min(0.5 + Math.random(), 1);
	
	public Color color = new Color(random(255), random(255), random(255));
	
	public double getX() {
		return dx;
	}
	public double getY() {
		return dy;
	}
	public double getWidth() {
		return dwidth;
	}
	public double getHeight() {
		return dheight;
	}
	
	public static int random(int maxRange) {
		return (int) Math.round(Math.random() * maxRange);
	}
	
	public void update(Dimension size) {
		double gap = width/2;
		// Для оси X
		if ((x < 0) || x > (size.width - width)) {
			if (x < 0) {
				dwidth = width + x;
				dx = x + (width - dwidth);
			} else {
				dx = x;
				dwidth = width - (x - size.width + width);
			}
		} else {
			dx = x;
			dwidth = width;
		}
		
		// Для оси Y
		if ((y < 0) || y > (size.height - height)) {
			if (y < 0) {
				dheight = height + y;
				dy = y + (height - dheight);
			} else {
				dy = y;
				dheight = height - (y - size.height + height);
			}
		} else {
			dy = y;
			dheight = height;
		}

		
		// Координаты
		x += step*dirX;
		if ((x < -gap) || x > (size.width - width + gap)) {
			dirX *= -1;
			x = Math.min(x, size.width - width + gap);
		}
		
		y += step*dirY;
		if ((y < -gap) || y > (size.height - height + gap)) {
			dirY *= -1;
			y = Math.min(y, size.height - height + gap);
		}
	}
}

class BouncingBallsPlane extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame();
	public static int sizeX = 250, sizeY = 250;
	
	private ArrayList<Ball> Balls = new ArrayList<Ball>();
	
	public void add(Ball b) {
		Balls.add(b);
	}
	
	public BouncingBallsPlane() {
		frame.setLocationRelativeTo(null);
		frame.setSize(sizeX, sizeY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < Balls.size(); i++) {
			Ball b = Balls.get(i);
			int x = (int)b.getX(), y = (int)b.getY();
			int w = (int)b.getWidth(), h = (int)b.getHeight();
			g.setColor(b.color);
			g.fillOval(x, y, w, h);
		}
	}
	
	public void show() {
		frame.setVisible(true);
		
		Timer timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dimension size = frame.getContentPane().getSize();
				for (int i = 0; i < Balls.size(); i++) {
					Balls.get(i).update(size);
				}
				frame.repaint();
			}
		});
		timer.start();
	}
}