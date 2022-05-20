package lab5;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ellipse {
	protected int x = 0, y = 0;
	protected double a = 0.0, b = 0.0;
	
	public Ellipse(int x, int y, double a, double b) {
		this.x = x; this.y = y;
		this.a = a; this.b = b;
	}
	public Ellipse(double a, double b) {
		this.a = a; this.b = b;
	}
	public Ellipse () {};
	
	public void Ellipse_print() {
		System.out.println(String.format("x = %d; y = %d; a = %f; b = %f", x, y, a, b));
	}
	
	public void move (int dx, int dy) {
		x += dx; y += dy;
	}
	
	public Ellipse Union(int a, int b) {
		return new Ellipse(x, y, Math.min(a, this.a), Math.min(b, this.b));
	}
}

class DrawableEllipse extends Ellipse {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel(true) {
		private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }
	};
	
	protected Color outColor = Color.green;
	protected int sizeX = 250, sizeY = 250;
	
	public DrawableEllipse(int x, int y, double a, double b) {
		super(x, y, a, b);
	}
	public DrawableEllipse(double a, double b) {
		super(a, b);
	}
	public DrawableEllipse () {
		super();
	};
	
	public void show() {
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setSize(sizeX, sizeY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setOutlineColor(Color outColor) {
		this.outColor = outColor;
	}
	
	public void draw(Graphics g) {
		int posX = (sizeX - (int)a)/2;
		int posY = (sizeY - (int)b)/2;

		g.setColor(outColor);
        g.drawOval(posX, posY, (int)a, (int)b);
	}
}

class ColoredEllipse extends DrawableEllipse {
	protected Color inColor = Color.yellow;
	
	public ColoredEllipse(int x, int y, double a, double b) {
		super(x, y, a, b);
	}
	public ColoredEllipse(double a, double b) {
		super(a, b);
	}
	public ColoredEllipse () {
		super();
	};
	
	public void setInlineColor(Color inColor) {
		this.inColor = inColor;
	}
	
	public void draw(Graphics g) {
		int posX = (sizeX - (int)a)/2;
		int posY = (sizeY - (int)b)/2;
		
		g.setColor(inColor);
		g.fillOval(posX, posY, (int)a, (int)b);
		super.draw(g);
	}
}

