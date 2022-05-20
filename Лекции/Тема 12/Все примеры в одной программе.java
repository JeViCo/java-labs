/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.awt.*;

class FrameWithPanel {
	private Frame f;
	private Panel pan;

	public FrameWithPanel(String title) {
		f = new Frame(title);
		pan = new Panel();
	}

	public void launchFrame() {
		f.setSize(200,200);
		f.setBackground(Color.blue);
		f.setLayout(null); // Попробуйте закомментировать эту сроку
		pan.setSize(100,100);
		pan.setBackground(Color.red);
		f.add(pan);
		f.setVisible(true);
	}
}        

class LayoutExample {
	private Frame f;
	private Button b1;
	private Button b2;

	public LayoutExample() {
		f = new Frame("GUI example");
		b1 = new Button("Press Me");
		b2 = new Button("Don’t press Me");
	}

	public void launchFrame() {
		f.setLayout(new FlowLayout());
		f.add(b1);
		f.add(b2);
		f.pack(); // Попробуйте закомментировать эту сроку
		f.setVisible(true);
	}
}

class BorderExample {
	private Frame f;
	private Button bn, bs, bw, be, bc;
	public BorderExample() {
		f = new Frame("Border Layout");
		bn = new Button("North");
		bs = new Button("South");
		bw = new Button("West");
		be = new Button("East");
		bc = new Button("Center");
	}
	public void launchFrame() {
		f.add(bn, BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.EAST);
		f.add(bc, BorderLayout.CENTER);
		f.setSize(200,200); // Попробуйте заменить на f.pack();
                //f.pack();
		f.setVisible(true);
	}
}

class GridExample {
	private Frame f;
	private Button b1, b2, b3, b4, b5, b6;
	public GridExample() {
		f = new Frame("Grid Example");
		b1 = new Button("1"); b2 = new Button("2");
		b3 = new Button("3"); b4 = new Button("4");
		b5 = new Button("5"); b6 = new Button("6");
	}
	public void launchFrame() {
		f.setLayout (new GridLayout(3,2));
		f.add(b1);	f.add(b2);
		f.add(b3);	f.add(b4);
		f.add(b5);	f.add(b6);
		f.pack();
		f.setVisible(true);
	}
}       

class ComplexLayoutExample {
	private Frame f;
	private Panel p;
	private Button bw, bc, bfile, bhelp;
	public ComplexLayoutExample() {
		f = new Frame("ComplexLayout");
		bw = new Button("West"); bc = new Button("Work space region");
		bfile = new Button("File"); bhelp = new Button("Help");
	}
	public void launchFrame() {
		f.add(bw, BorderLayout.WEST);
		f.add(bc, BorderLayout.CENTER);
		p = new Panel();
			p.add(bfile);
			p.add(bhelp);
		f.add(p, BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);
	}
}

class TestCanvas extends Canvas {
public void paint(Graphics g) {
g.drawLine(0, 0, getWidth(), getHeight());
g.drawLine(0, getHeight(),getWidth(), 0);
}
}
public class JavaApplication19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//	FrameWithPanel guiWindow = new FrameWithPanel("Frame with Panel");guiWindow.launchFrame(); 
//      LayoutExample guiWindow1 = new LayoutExample();  guiWindow1.launchFrame();
//      BorderExample guiWindow2 = new BorderExample();	guiWindow2.launchFrame();
//      GridExample grid = new GridExample(); grid.launchFrame();
//      ComplexLayoutExample gui = new ComplexLayoutExample();	gui.launchFrame();
Frame f = new Frame("Test frame");
f.setSize(400, 300);
f.add(new TestCanvas());
f.setVisible(true);
    }
}



